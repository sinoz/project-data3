package data_science.database;

import com.google.gson.Gson;
import com.zaxxer.hikari.HikariConfig;

import java.io.FileReader;
import java.nio.file.Paths;

/**
 * Describes the configuration of Hikari data sources.
 * @author I.A
 */
final class HikariDbConfig extends HikariConfig {
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
		try {
			try (FileReader reader = new FileReader(Paths.get("data/db_details.json").toString())) {
				Gson gson = new Gson();
				DbConfigJson config = gson.fromJson(reader, DbConfigJson.class);

				setJdbcUrl("jdbc:postgresql://" + config.address + ":" + config.port + "/" + config.database);

				setUsername(config.username);
				setPassword(config.password);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0); // just fail the program, useless without a database
		}
	}

	/**
	 * Configures details about the data source.
	 */
	private void configureDataSourceProperties() {
		addDataSourceProperty("cachePrepStmts", "true");
		addDataSourceProperty("prepStmtCacheSize", "" + STATEMENTS_CACHE_SIZE);
	}

	/**
	 * A data blue print of the 'db_details.json' file.
	 * @author I.A
	 */
	static class DbConfigJson {
		private String username;
		private String password;
		private int port;
		private String address;
		private String database;
	}
}
