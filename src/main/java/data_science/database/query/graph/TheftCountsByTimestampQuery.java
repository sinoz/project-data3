package data_science.database.query.graph;

import data_science.database.HikariDbService;
import data_science.model.TheftTimestamp;
import io.reactivex.Observable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * A query to compute the amount of bicycle thefts per timestamp.
 * @author I.A
 */
public final class TheftCountsByTimestampQuery {
	/**
	 * The query to execute.
	 */
	// TODO read from sql file
	private static final String QUERY = "SELECT COUNT(*) AS count, begintijd FROM bicycle_thefts GROUP BY begintijd ORDER BY count DESC;";

	/**
	 * Returns an {@link Observable} that computes the collection of the amounts of bicycle thefts per timestamp.
	 */
	public static Observable<TheftTimestamp> compute() {
		Observable<TheftTimestamp> stream = Observable.create(emitter -> {
			try (Connection connection = HikariDbService.obtainConnection()) {
				try (PreparedStatement statement = connection.prepareStatement(QUERY)) {
					ResultSet resultSet = statement.executeQuery();
					while (resultSet.next()) {
						String timestamp = resultSet.getString("begintijd");
						int count = resultSet.getInt("count");

						emitter.onNext(new TheftTimestamp(count, timestamp));
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
