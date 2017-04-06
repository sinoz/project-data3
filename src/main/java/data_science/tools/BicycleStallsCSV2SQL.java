package data_science.tools;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Parses all bicycle theft data from a CSV file and translates it to suitable SQL data.
 * @author I.A
 */
public final class BicycleStallsCSV2SQL {
  private static final String EMPTY = "";

  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(Paths.get("data/raw/fietstrommels.csv"))) {
      computeEntries(scanner).stream().map(BicycleStallsCSV2SQL::toInsertQuery).forEach(System.out::println);
    }
  }

  private static List<String> columns = new ArrayList<>();

  private static String toInsertQuery(Entry entry) {
    StringBuilder bldr = new StringBuilder();

    bldr.append("INSERT INTO bicycle_stalls (street, latitude, longitude, area) ");
    bldr.append("VALUES (");

    // NOTE: terrible code below
    {
      bldr.append("\'").append(entry.street).append("\'").append(", ");
      bldr.append("\'").append(entry.latitude).append("\'").append(", ");
      bldr.append("\'").append(entry.longitude).append("\'").append(", ");
      bldr.append("\'").append(entry.area).append("\'");
    }

    bldr.append(");");

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
          if (values[i].length() == 0) {
            continue;
          }

          columns.add(values[i]
                 .replaceAll(" ", "_")
                 .replaceAll("#", "")
                 .replaceAll("\\.", "")
                 .toLowerCase().trim());
        }

        continue;
      }

      Entry entry = new Entry();

      entry.street = getOrEmpty(values, 9);
      entry.latitude = getOrEmpty(values, 18);
      entry.longitude = getOrEmpty(values, 19);
      entry.area = getOrEmpty(values, 28);

      entries.add(entry);
    }

    return entries;
  }

  private static class Entry {
    private String street;
    private String latitude;
    private String longitude;
    private String area;
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
