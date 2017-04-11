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
		return HikariDbService.obtainConnection().map(ViolentTheftsCount::transform);
	}

	/**
	 * Transforms the given {@link Connection} to the amount of bicycle thefts.
	 */
	// TODO find a cleaner way to close the db connection through functional composition
	private static Integer transform(Connection connection) throws Exception {
		int result = 0;

		try (PreparedStatement stmt = connection.prepareStatement(QUERY)) {
			ResultSet results = stmt.executeQuery();

			if (results.next()) {
				result = results.getInt("count");
			}
		}

		connection.close(); // returns the connection to the pool so it can be re-used.
		return result;
	}
}
