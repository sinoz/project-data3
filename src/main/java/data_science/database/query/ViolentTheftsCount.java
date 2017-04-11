package data_science.database.query;

import data_science.database.HikariDbService;
import io.reactivex.Observable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * A query to compute the count of amount of violent thefts.
 * @author I.A
 */
public final class ViolentTheftsCount {
	/**
	 * The query to execute.
	 */
	private static final String QUERY = "SELECT COUNT(*) AS count FROM bicycle_thefts WHERE mk_omschrijving LIKE 'DIEFSTAL MET GEWELD%';";

	/**
	 * Returns an {@link Observable} that computes the amount of violent bicycle thefts.
	 */
	public static Observable<Integer> compute() {
		Observable<Integer> stream = Observable.create(emitter -> {
			Connection connection = HikariDbService.obtainConnection();

			try {
				try (PreparedStatement stmt = connection.prepareStatement(QUERY)) {
					ResultSet results = stmt.executeQuery();

					if (results.next()) {
						emitter.onNext(results.getInt("count"));
					}
				}

				connection.close(); // returns the connection to the pool so it can be re-used.
			} catch (Exception e) {
				emitter.onError(e);
			}

			emitter.onComplete();
		});

		return stream.subscribeOn(HikariDbService.scheduler());
	}
}
