package data_science.tools;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Parses all bicycle theft data from a CSV file and translates it to suitable SQL data.
 * @author I.A
 */
public final class BicycleDrumsCSV2SQL {
  private static final String EMPTY = "";

  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(Paths.get("data/raw/fietstrommels.csv"))) {
      computeEntries(scanner).stream().map(BicycleDrumsCSV2SQL::toInsertQuery).forEach(System.out::println);
    }
  }

  private static List<String> columns = new ArrayList<>();

  private static String toInsertQuery(Entry entry) {
    StringBuilder bldr = new StringBuilder();

    bldr.append("INSERT INTO bicycle_drums (");
    for (int colId = 0; colId < columns.size(); colId++) {
      bldr.append(columns.get(colId));
      if (colId != (columns.size() - 1)) {
        bldr.append(", ");
      }
    }
    bldr.append(") ");
    bldr.append("VALUES (");

    // NOTE: terrible code below
    {
      // TODO bldr.append("\"").append(entry.voorvalNummer).append("\"").append(", ");
    }

    return bldr.toString();
  }

  private static List<Entry> computeEntries(Scanner scanner) {
    List<Entry> entries = new ArrayList<>();

    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      if (line == null || line.length() == 0) {
        continue;
      }

      String[] values = line.split(",");
      if (values.length == 0) {
        continue;
      }

      if (line.startsWith("#")) {
        for (int i = 0; i < values.length; i++) {
          columns.add(values[i].replaceAll(" ", "_").replaceAll("#", "").toLowerCase());
        }

        continue;
      }

      Entry entry = new Entry();

      // TODO entry.voorvalNummer = getOrEmpty(values, 0);

      entries.add(entry);
    }

    return entries;
  }

  private static class Entry {
    private String inventoryId;
  }

  private static String getOrEmpty(String[] values, int elementIdx) {
    if (elementIdx >= values.length) {
      return EMPTY;
    }

    String value = values[elementIdx];
    if (value.length() == 0) {
      return EMPTY;
    }

    return value;
  }
}
