package data_science.database.query;

import data_science.database.HikariDbService;
import data_science.model.BicycleStall;
import io.reactivex.Observable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * A query to compute a collection of {@link BicycleStall}s.
 * @author I.A
 */
public final class AllBicycleStallsQuery {
	/**
	 * The query to write.
	 */
	// TODO read from sql file
	private static final String QUERY = "SELECT bs.street, bs.area, bs.latitude, bs.longitude FROM bicycle_stalls AS bs;";

	/**
	 * Returns an {@link Observable} that computes the collection of bicycle stalls.
	 */
	public static Observable<BicycleStall> compute() {
		Observable<BicycleStall> stream = Observable.create(emitter -> {
			try (Connection connection = HikariDbService.obtainConnection()) {
				try (PreparedStatement statement = connection.prepareStatement(QUERY)) {
					ResultSet resultSet = statement.executeQuery();
					while (resultSet.next()) {
						String streetName = resultSet.getString("street");
						String area = resultSet.getString("area");

						float latitude = resultSet.getFloat("latitude");
						float longitude = resultSet.getFloat("longitude");

						emitter.onNext(new BicycleStall(streetName, area, latitude, longitude));
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
