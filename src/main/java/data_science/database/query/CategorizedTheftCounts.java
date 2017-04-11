package data_science.database.query;

import com.google.common.collect.ImmutableList;
import data_science.database.HikariDbService;
import data_science.model.TheftCategory;
import io.reactivex.Observable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * A query to compute a categorized count of bicycle thefts.
 * @author I.A
 */
public final class CategorizedTheftCounts {
	/**
	 * The query to execute.
	 */
	private static final String QUERY = "SELECT COUNT(*), mk_omschrijving FROM bicycle_thefts WHERE plaats = 'ROTTERDAM' GROUP BY mk_omschrijving";

	/**
	 * Returns an {@link Observable} that computes the collection of categorized counts of bicycle thefts.
	 */
	public static Observable<ImmutableList<TheftCategory>> compute() {
		return HikariDbService.obtainConnection().map(CategorizedTheftCounts::compute);
	}

	/**
	 * Transforms the given {@link Connection} to the computed collection of bicycle theft count.
	 */
	// TODO find a cleaner way to close the db connection through functional composition
	private static ImmutableList<TheftCategory> compute(Connection connection) throws Exception {
		ImmutableList.Builder<TheftCategory> bldr = ImmutableList.builder();

		try (PreparedStatement statement = connection.prepareStatement(QUERY)) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("mk_omschrijving");
				int count = resultSet.getInt("count");

				bldr.add(new TheftCategory(name, count));
			}
		}

		connection.close();

		return bldr.build();
	}
}
