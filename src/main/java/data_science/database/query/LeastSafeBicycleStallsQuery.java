package data_science.database.query;

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
public final class LeastSafeBicycleStallsQuery {
    /**
     * The query to write.
     */
    // TODO read from sql file
    private static final String QUERY =
            "SELECT COUNT(*) AS count, bs.street, bs.latitude, bs.longitude " +
                    "FROM bicycle_thefts AS bt " +
                    "INNER JOIN bicycle_stalls AS bs " +
                    "ON bs.street = bt.straat AND bt.plaats = 'ROTTERDAM' AND bs.latitude <> 0.0 AND bs.longitude <> 0.0 " +
                    "GROUP BY bs.street, bs.latitude, bs.longitude " +
                    "ORDER BY count DESC;";

    /**
     * Returns an {@link Observable} that computes the collection of safest bicycle stalls.
     */
    public static Observable<BicycleStall> compute() {
        Observable<BicycleStall> stream = Observable.create(emitter -> {
            try (Connection connection = HikariDbService.obtainConnection()) {
                try (PreparedStatement statement = connection.prepareStatement(QUERY)) {
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        String streetName = resultSet.getString("street");

                        float latitude = resultSet.getFloat("latitude");
                        float longitude = resultSet.getFloat("longitude");

                        emitter.onNext(new BicycleStall(streetName, latitude, longitude));
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
