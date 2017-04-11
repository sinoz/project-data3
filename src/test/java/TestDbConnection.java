import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * A test Hikari based database connection setup.
 * @author I.A
 */
public final class TestDbConnection {
  /**
   * Establishes and tests the database connection.
   */
  @Test
  public void testHikariDbConnection() throws Exception {
    Class.forName("org.postgresql.Driver");

    HikariConfig config = new HikariConfig();

    config.setJdbcUrl("jdbc:postgresql://localhost:5432/bicycles");
    config.setUsername("postgres");
    config.setPassword("root");

    config.addDataSourceProperty("cachePrepStmts", "true");
    config.addDataSourceProperty("prepStmtCacheSize", "" + (1 << 8));

    HikariDataSource dataSource = new HikariDataSource(config);
    Connection connection = dataSource.getConnection();

    Assert.assertNotNull(connection);
  }
}
