package data_science.database.query;

import com.google.common.collect.ImmutableList;
import com.lynden.gmapsfx.javascript.object.LatLong;
import data_science.database.HikariDbService;
import data_science.model.BicycleStall;
import io.reactivex.Observable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * A query to compute a collection of {@link BicycleStall}s that have been identified
 * as the safest.
 * @author I.A
 */
public final class SafestBicycleStalls {
	/**
	 * The query to write.
	 */
	private static final String QUERY =
			"SELECT COUNT(*) AS count, bs.street, bs.latitude, bs.longitude" +
			"FROM bicycle_thefts AS bt" +
			"INNER JOIN bicycle_stalls AS bs" +
			"ON bs.street = bt.straat AND bt.plaats = 'ROTTERDAM' AND bs.latitude <> 0.0 AND bs.longitude <> 0.0" +
			"GROUP BY bs.street, bs.latitude, bs.longitude" +
			"ORDER BY count ASC;";

	/**
	 * Returns an {@link Observable} that computes the collection of safest bicycle stalls.
	 */
	public static Observable<ImmutableList<BicycleStall>> compute() {
		return HikariDbService.obtainConnection().map(SafestBicycleStalls::transform);
	}

	/**
	 * Transforms the given {@link Connection} to a collection of safest bicycle stalls.
	 */
	// TODO find a cleaner way to close the db connection through functional composition
	private static ImmutableList<BicycleStall> transform(Connection connection) throws Exception {
		ImmutableList.Builder<BicycleStall> bldr = ImmutableList.builder();

		try (PreparedStatement statement = connection.prepareStatement(QUERY)) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String streetName = resultSet.getString("street");

				float latitude = resultSet.getFloat("latitude");
				float longitude = resultSet.getFloat("latitude");

				LatLong coordinates = new LatLong(latitude, longitude);
				bldr.add(new BicycleStall(streetName, coordinates));
			}
		}

		connection.close();

		return bldr.build();
	}
}
