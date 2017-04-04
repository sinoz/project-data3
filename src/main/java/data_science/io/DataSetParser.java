package data_science.io;

import com.google.common.collect.ImmutableMap;

/**
 * Parses sets of data from a source.
 * @author I.A
 */
public interface DataSetParser {
  /**
   * Parses a collection of {@link DataSet}s.
   */
  ImmutableMap<String, DataSet> parseDataSets() throws Exception;
}
