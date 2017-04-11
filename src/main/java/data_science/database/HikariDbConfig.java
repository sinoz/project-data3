package data_science.database;

import com.zaxxer.hikari.HikariConfig;

/**
 * Describes the configuration of Hikari data sources.
 * @author I.A
 */
final class HikariDbConfig extends HikariConfig {
	/**
	 * The account credentials of the DBMS to access.
	 */
	private static final String USERNAME = "postgres", PASSWORD = "root";

	/**
	 * The database to access.
	 */
	private static final String DATABASE = "bicycles";

	/**
	 * The port.
	 */
	private static final int PORT = 5432;

	/**
	 * The initial capacity of the prepared statements' cache.
	 */
	private static final int STATEMENTS_CACHE_SIZE = 1 << 8;

	/**
	 * Creates a new {@link HikariDbConfig}.
	 */
	HikariDbConfig() {
		configureConnectionDetails();
		configureDataSourceProperties();
	}

	/**
	 * Configures database connection details.
	 */
	private void configureConnectionDetails() {
		setJdbcUrl("jdbc:postgresql://localhost:" + PORT + "/" + DATABASE);
		setUsername(USERNAME);
		setPassword(PASSWORD);
	}

	/**
	 * Configures details about the data source.
	 */
	private void configureDataSourceProperties() {
		addDataSourceProperty("cachePrepStmts", "true");
		addDataSourceProperty("prepStmtCacheSize", "" + STATEMENTS_CACHE_SIZE);
	}
}
