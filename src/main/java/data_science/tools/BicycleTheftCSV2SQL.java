package data_science.tools;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Parses all bicycle theft data from a CSV file and translates it to suitable SQL data.
 * @author I.A
 */
public final class BicycleTheftCSV2SQL {
  private static final String EMPTY = "";

  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(Paths.get("data/raw/fietsdiefstallen.csv"))) {
      computeEntries(scanner).stream().map(BicycleTheftCSV2SQL::toInsertQuery).forEach(System.out::println);
    }
  }

  private static List<String> columns = new ArrayList<>();

  private static String toInsertQuery(Entry entry) {
    StringBuilder bldr = new StringBuilder();

    bldr.append("INSERT INTO bicycle_thefts (");
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
      bldr.append("\"").append(entry.voorvalNummer).append("\"").append(", ");
      bldr.append("\"").append(entry.kennisname).append("\"").append(", ");
      bldr.append("\"").append(entry.mk).append("\"").append(", ");
      bldr.append("\"").append(entry.mkDescription).append("\"").append(", ");
      bldr.append("\"").append(entry.attempt).append("\"").append(", ");
      bldr.append("\"").append(entry.district).append("\"").append(", ");
      bldr.append("\"").append(entry.workingSpace).append("\"").append(", ");
      bldr.append("\"").append(entry.livingSpace).append("\"").append(", ");
      bldr.append("\"").append(entry.neighbourhood).append("\"").append(", ");
      bldr.append("\"").append(entry.street).append("\"").append(", ");
      bldr.append("\"").append(entry.dayType).append("\"").append(", ");
      bldr.append("\"").append(entry.startDate).append("\"").append(", ");
      bldr.append("\"").append(entry.startTime).append("\"").append(", ");
      bldr.append("\"").append(entry.endDayType).append("\"").append(", ");
      bldr.append("\"").append(entry.endDate).append("\"").append(", ");
      bldr.append("\"").append(entry.endTime).append("\"").append(", ");
      bldr.append("\"").append(entry.averageYear).append("\"").append(", ");
      bldr.append("\"").append(entry.averageMonth).append("\"").append(", ");
      bldr.append("\"").append(entry.averageDayType).append("\"").append(", ");
      bldr.append("\"").append(entry.averageDayPeriod).append("\"").append(", ");
      bldr.append("\"").append(entry.keyword).append("\"").append(", ");
      bldr.append("\"").append(entry.object).append("\"").append(", ");
      bldr.append("\"").append(entry.brand).append("\"").append(", ");
      bldr.append("\"").append(entry.type).append("\"").append(", ");
      bldr.append("\"").append(entry.color).append("\"").append(" );");
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

      // WARNING ugly code below
      entry.voorvalNummer = getOrEmpty(values, 0);
      entry.kennisname = getOrEmpty(values, 1);
      entry.mk = getOrEmpty(values, 2);
      entry.mkDescription = getOrEmpty(values, 3);
      entry.attempt = getOrEmpty(values, 4);
      entry.district = getOrEmpty(values, 5);
      entry.workingSpace = getOrEmpty(values, 6);
      entry.livingSpace = getOrEmpty(values, 7);
      entry.neighbourhood = getOrEmpty(values, 8);
      entry.street = getOrEmpty(values, 9);
      entry.dayType = getOrEmpty(values, 10);
      entry.startDate = getOrEmpty(values, 11);
      entry.startTime = getOrEmpty(values, 12);
      entry.endDayType = getOrEmpty(values, 13);
      entry.endDate = getOrEmpty(values, 14);
      entry.endTime = getOrEmpty(values, 15);
      entry.averageYear = getOrEmpty(values, 16);
      entry.averageMonth = getOrEmpty(values, 17);
      entry.averageDayType = getOrEmpty(values, 18);
      entry.averageDayPeriod = getOrEmpty(values, 19);
      entry.keyword = getOrEmpty(values, 20);
      entry.object = getOrEmpty(values, 21);
      entry.brand = getOrEmpty(values, 22);
      entry.type = getOrEmpty(values, 22);
      entry.color = getOrEmpty(values, 23);

      entries.add(entry);
    }

    return entries;
  }

  private static class Entry {
    private String voorvalNummer;
    private String kennisname;
    private String mk;
    private String mkDescription;
    private String attempt;
    private String district;
    private String workingSpace;
    private String livingSpace;
    private String neighbourhood;
    private String street;
    private String dayType;
    private String startDate;
    private String startTime;
    private String endDayType;
    private String endDate;
    private String endTime;
    private String averageYear;
    private String averageMonth;
    private String averageDayType;
    private String averageDayPeriod;
    private String keyword;
    private String object;
    private String brand;
    private String type;
    private String color;
  }

  private static String getOrEmpty(String[] values, int elementIdx) {
    if (elementIdx >= values.length) {
      return EMPTY;
    }

    String value = values[elementIdx];
    if (value.length() == 0) {
      return EMPTY;
    }

    return value.replaceAll("'", "").replaceAll("\"", "");
  }
}
