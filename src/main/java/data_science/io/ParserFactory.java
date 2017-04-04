package data_science.io;

import java.nio.file.Path;

/**
 * A Guice factory for the {@link CSVDataSetParser}.
 *
 * @author I.A
 */
public interface ParserFactory {
  /**
   * Creates a new {@link CSVDataSetParser}.
   */
  CSVDataSetParser create(Path path);
}
