package data_science.database.query;

import data_science.database.HikariDbService;
import data_science.model.BicycleTheft;
import io.reactivex.Observable;

import java.sql.Connection;

/**
 * TODO
 * @author I.A
 */
public final class MostBicycleThefts {
	/**
	 * TODO
	 */
	public static Observable<BicycleTheft> compute() {
		Observable<BicycleTheft> thefts = Observable.create(emitter -> {
			try (Connection connection = HikariDbService.obtainConnection()) {
				// TODO
			} catch (Exception e) {
				emitter.onError(e);
			}

			emitter.onComplete();
		});

		return thefts.subscribeOn(HikariDbService.scheduler());
	}
}
