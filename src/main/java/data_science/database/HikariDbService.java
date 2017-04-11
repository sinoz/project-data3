package data_science.database;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.zaxxer.hikari.HikariDataSource;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Executors;

/**
 * A service that provides clients with pooled database connections.
 * @author Whis
 */
public final class HikariDbService {
  /**
   * The amount of dedicated workers.
   */
  private static final int AMT_WORKERS = Runtime.getRuntime().availableProcessors() << 1;

  /**
   * The service to submit database connection requests to.
   */
  private static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(AMT_WORKERS));

  /**
   * The {@link Scheduler} to wrap around the {@link HikariDbService#service}.
   */
  private static Scheduler scheduler = Schedulers.from(service);

  /**
   * The data source to fetch connections from.
   */
  private static HikariDataSource source;

  /**
   * Initializes this service. Throws an {@link IllegalStateException} if this service is
   * already initialized.
   */
  public static void initialize() {
    if (source != null) {
      throw new IllegalStateException();
    }

    source = new HikariDataSource(new HikariDbConfig());
  }

  /**
   * Creates a new {@link Observable} that asynchronously computes a connection from the pool
   * on the {@link HikariDbService#service}.
   */
  public static Observable<Connection> obtainConnection() {
    return Observable.create((ObservableOnSubscribe<Connection>) emitter -> {
			try {
				emitter.onNext(source.getConnection());
			} catch (SQLException e) {
				emitter.onError(e);
			}
		}).subscribeOn(scheduler);
  }
}
