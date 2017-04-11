import data_science.database.HikariDbService;
import io.reactivex.schedulers.Schedulers;
import org.junit.Test;

import java.sql.Connection;

/**
 * A test for the {@link HikariDbService}.
 * @author I.A
 */
public final class TestDbService {
	@Test
	public void testHikariDbService() throws Exception {
		// initialize the service!
		HikariDbService.initialize();

		// obtains a database connection from the pool, assigns a scheduler to observe on
		// and then subscribe a listener to
		HikariDbService.obtainConnection()
				.observeOn(Schedulers.computation())
				.subscribe((Connection c) -> System.out.println("HELLO: " + Thread.currentThread()));

		// let's just sleep so we can wait for results to come out
		Thread.sleep(6000);
	}
}
