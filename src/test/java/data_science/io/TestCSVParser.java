package data_science.io;

import org.junit.Test;

import java.nio.file.Paths;

/**
 * A unit test to test the {@link CSVDataSetParser}.
 * @author I.A
 */
public final class TestCSVParser {
  /**
   * Tests the {@link CSVDataSetParser}.
   */
  @Test
  public void testDataSetParser() throws Exception {
    DataSetParser parser = new CSVDataSetParser(Paths.get("data/raw/cijfersetje-prins-alexander.csv"));
    parser.parseDataSets();
  }
}
