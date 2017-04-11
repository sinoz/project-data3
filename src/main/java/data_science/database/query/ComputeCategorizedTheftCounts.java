package data_science.database.query;

import com.google.common.collect.ImmutableList;
import data_science.database.HikariDbService;
import io.reactivex.Observable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * A query to compute a categorized count of bicycle thefts.
 * @author I.A
 */
public final class ComputeCategorizedTheftCounts {
	/**
	 * The query to execute.
	 */
	private static final String QUERY = "SELECT COUNT(*), mk_omschrijving FROM bicycle_thefts WHERE plaats = 'ROTTERDAM' GROUP BY mk_omschrijving";

	/**
	 * Returns an {@link Observable} that computes the collection of categorized counts of bicycle thefts.
	 */
	public static Observable<ImmutableList<Category>> create() {
		return HikariDbService.obtainConnection().map(ComputeCategorizedTheftCounts::compute);
	}

	/**
	 * Transforms the given {@link Connection} to the computed collection of bicycle theft count.
	 */
	private static ImmutableList<Category> compute(Connection connection) throws Exception {
		ImmutableList.Builder<Category> bldr = ImmutableList.builder();

		try (PreparedStatement statement = connection.prepareStatement(QUERY)) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("mk_omschrijving");
				int count = resultSet.getInt("count");

				bldr.add(new Category(name, count));
			}
		}

		connection.close();

		return bldr.build();
	}

	/**
	 * A single category with its corresponding theft count.
	 */
	public static class Category {
		/**
		 * The name of the category.
		 */
		private final String name;

		/**
		 * The theft count.
		 */
		private final int count;

		/**
		 * Creates a new category.
		 */
		Category(String name, int count) {
			this.name = name;
			this.count = count;
		}

		public String getName() {
			return name;
		}

		public int getCount() {
			return count;
		}

		@Override
		public String toString() {
			return "Category(" + name + ", " + count + ")";
		}
	}
}
