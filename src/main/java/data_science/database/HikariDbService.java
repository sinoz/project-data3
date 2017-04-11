package data_science.database;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * A service that provides clients with pooled database connections.
 * @author Whis
 */
public final class HikariDbService {
  /**
   * The amount of database connection workers to establish in the pool of threads.
   */
  private static int AMT_WORKERS = Runtime.getRuntime().availableProcessors() << 1;

  /**
   * The pool of threads.
   */
  private static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(AMT_WORKERS));

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
   * Submits a request to the {@link HikariDbService#service} to obtain a connection from the pool.
   */
  public static void obtain(Consumer<Connection> c) {
    service.submit(() -> {
      try {
        c.accept(source.getConnection());
      } catch (SQLException e) {
        e.printStackTrace();
      }
    });
  }
}
