import data_science.database.HikariDbService;
import org.junit.Assert;
import org.junit.Test;

/**
 * A test for the {@link HikariDbService}.
 * @author I.A
 */
public final class TestDbService {
	@Test
	public void testHikariDbService() {
		HikariDbService.obtain(Assert::assertNotNull);
	}
}
