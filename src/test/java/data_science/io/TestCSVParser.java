package data_science.io;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import data_science.GuiceTest;
import org.junit.Test;

import javax.inject.Inject;
import java.nio.file.Paths;

/**
 * A {@link GuiceTest} to test the {@link CSVDataSetParser}.
 * @author I.A
 */
public final class TestCSVParser extends GuiceTest {
  /**
   * The parser factory to obtain {@link DataSetParser} implementations from.
   */
  @Inject
  ParserFactory factory;

  /**
   * Tests the {@link CSVDataSetParser}.
   */
  @Test
  public void testDataSetParser() throws Exception {
    CSVDataSetParser parser = factory.create(Paths.get("data/raw/combined/cijfersetje-prins-alexander.csv"));
    parser.parseDataSets();
  }

  @Override
  public AbstractModule testModule() {
    return new AbstractModule() {
      @Override
      protected void configure() {
        install(new FactoryModuleBuilder().build(ParserFactory.class));
      }
    };
  }
}
