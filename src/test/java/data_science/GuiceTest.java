package data_science;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;

/**
 * TODO
 * @author I.A
 */
public abstract class GuiceTest {
  /**
   * TODO
   */
  private final Injector injector = Guice.createInjector(testModule());

  @Before
  public void setupGuice() {
    injector.injectMembers(this);
  }

  public abstract AbstractModule testModule();
}
