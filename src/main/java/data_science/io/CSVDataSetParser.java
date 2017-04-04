package data_science.io;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.nio.file.Path;
import java.util.*;

/**
 * Parses data from a CSV based data set as a collection of {@link DataSet}s.
 * @author I.A
 */
public final class CSVDataSetParser implements DataSetParser {
  /**
   * The initial size to assign to a new collection of {@link DataSet}s.
   */
  private static final int INITIAL_CAPACITY = 32;

  /**
   * The {@link Path} to the data set file to parse data from.
   */
  private final Path sourcePath;

  /**
   * Creates a new {@link CSVDataSetParser} that parses data from the given {@link Path}.
   */
  public CSVDataSetParser(Path sourcePath) throws Exception {
    this.sourcePath = sourcePath;
  }

  @Override
  public ImmutableMap<String, DataSet> parseDataSets() throws Exception {
    try (Scanner scanner = new Scanner(sourcePath)) {
      ImmutableList<String> trimmedDown = trimAwaySemicolons(scanner);

      Map<String, DataSet> dataSets = new HashMap<>(INITIAL_CAPACITY);
      for (String line : trimmedDown) {
        System.out.println(line);
      }

      return ImmutableMap.copyOf(dataSets);
    }
  }

  /**
   * Reads per-line from the given {@link Scanner} to trim away the semicolons, returning a
   * collection of trimmed down lines.
   */
  private ImmutableList<String> trimAwaySemicolons(Scanner scanner) {
    List<String> trimmedDown = new ArrayList<>();
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      if (line == null) {
        continue;
      }

      String trimmed = line.toLowerCase().replaceAll(";;", "").replaceAll(" ", "_").replaceAll("overig", "");
      if (trimmed.equals(";") || trimmed.startsWith("%")) {
        continue;
      }

      if (trimmed.contains("absoluut")) {
        continue;
      }

      trimmedDown.add(trimmed);
    }

    return ImmutableList.copyOf(trimmedDown);
  }
}
