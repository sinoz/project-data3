package data_science.database.query.graph;

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
	// TODO read from sql file
	private static final String QUERY = "SELECT COUNT(*), mk_omschrijving FROM bicycle_thefts WHERE plaats = 'ROTTERDAM' GROUP BY mk_omschrijving";

	/**
	 * Returns an {@link Observable} that computes the collection of categorized counts of bicycle thefts.
	 */
	public static Observable<TheftCategory> compute() {
		Observable<TheftCategory> stream = Observable.create(emitter -> {
			try (Connection connection = HikariDbService.obtainConnection()) {
				try (PreparedStatement statement = connection.prepareStatement(QUERY)) {
					ResultSet resultSet = statement.executeQuery();
					while (resultSet.next()) {
						String name = resultSet.getString("mk_omschrijving");
						int count = resultSet.getInt("count");

						emitter.onNext(new TheftCategory(name, count));
					}
				}
			} catch (Exception e) {
				emitter.onError(e);
			}

			emitter.onComplete();
		});

		return stream.subscribeOn(HikariDbService.scheduler());
	}
}
