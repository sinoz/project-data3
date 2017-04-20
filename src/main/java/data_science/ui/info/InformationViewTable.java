package data_science.ui.info;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import java.util.Arrays;
import java.util.List;
import javafx.beans.property.ReadOnlyStringWrapper;

/**
 * @author Jasper Wijnhoven
 */
public final class InformationViewTable extends VBox {

  private TableView infoTable = new TableView();

  /*
   * Creates a new {@link InformationViewTable}.
   */
  InformationViewTable() {
    setTable();
  }

  /*
   * Specify infoTable specs, create and fill columns
   * TODO Clean up code
   */
  private void setTable() {
    infoTable.setEditable(true);
    infoTable.setMaxWidth(1202);
    infoTable.setMaxHeight(168);

    /*
     * Create Lists with data that will be placed into the table
     */
    List<String> names = Arrays.asList("Ilyas Baas", "Jasper Wijnhoven", "Xin Hao Xia", "Dino Becker", "Johan Bastinck");
    List<String> css = Arrays.asList("", "", "", "X", "");
    List<String> sample = Arrays.asList("", "X", "X", "", "X");
    List<String> sql = Arrays.asList("X", "", "", "", "");
    List<String> maps = Arrays.asList("X", "", "", "", "");
    List<String> pane = Arrays.asList("X", "X", "", "", "");
    List<String> tabs = Arrays.asList("X", "X", "", "", "");
    List<String> graph = Arrays.asList("X", "X", "", "", "X");
    List<String> pres = Arrays.asList("X", "X", "X", "", "");
    List<String> astah = Arrays.asList("", "X", "", "", "");

    /*
     * Create Columns for the table, specify their minimum width and set text alignment
     */
    TableColumn<Integer, String> nameCol = new TableColumn<>("Name");
    TableColumn<Integer, String> cssCol = new TableColumn<>("CSS");
    TableColumn<Integer, String> sampleCol = new TableColumn<>("Samples");
    TableColumn<Integer, String> sqlCol = new TableColumn<>("SQL");
    TableColumn<Integer, String> mapsCol = new TableColumn<>("Google Maps");
    TableColumn<Integer, String> paneCol = new TableColumn<>("Panes");
    TableColumn<Integer, String> tabsCol = new TableColumn<>("Tabs");
    TableColumn<Integer, String> graphCol = new TableColumn<>("Graphs");
    TableColumn<Integer, String> presCol = new TableColumn<>("Presentation");
    TableColumn<Integer, String> astahCol = new TableColumn<>("ERD's");

    nameCol.setMinWidth(300);
    cssCol.setMinWidth(100);
    sampleCol.setMinWidth(100);
    sqlCol.setMinWidth(100);
    mapsCol.setMinWidth(100);
    paneCol.setMinWidth(100);
    tabsCol.setMinWidth(100);
    graphCol.setMinWidth(100);
    presCol.setMinWidth(100);
    astahCol.setMinWidth(100);

    nameCol.setStyle( "-fx-alignment: CENTER;");
    cssCol.setStyle( "-fx-alignment: CENTER;");
    sampleCol.setStyle( "-fx-alignment: CENTER;");
    sqlCol.setStyle( "-fx-alignment: CENTER;");
    mapsCol.setStyle( "-fx-alignment: CENTER;");
    paneCol.setStyle( "-fx-alignment: CENTER;");
    tabsCol.setStyle( "-fx-alignment: CENTER;");
    graphCol.setStyle( "-fx-alignment: CENTER;");
    presCol.setStyle( "-fx-alignment: CENTER;");
    astahCol.setStyle( "-fx-alignment: CENTER;");

    /*
     * Create cells for the Columns
     */
    nameCol.setCellValueFactory(cellData -> {
      Integer rowIndex = cellData.getValue();
      return new ReadOnlyStringWrapper(names.get(rowIndex));
    });
    cssCol.setCellValueFactory(cellData -> {
      Integer rowIndex = cellData.getValue();
      return new ReadOnlyStringWrapper(css.get(rowIndex));
    });
    sampleCol.setCellValueFactory(cellData -> {
      Integer rowIndex = cellData.getValue();
      return new ReadOnlyStringWrapper(sample.get(rowIndex));
    });
    sqlCol.setCellValueFactory(cellData -> {
      Integer rowIndex = cellData.getValue();
      return new ReadOnlyStringWrapper(sql.get(rowIndex));
    });
    mapsCol.setCellValueFactory(cellData -> {
      Integer rowIndex = cellData.getValue();
      return new ReadOnlyStringWrapper(maps.get(rowIndex));
    });
    paneCol.setCellValueFactory(cellData -> {
      Integer rowIndex = cellData.getValue();
      return new ReadOnlyStringWrapper(pane.get(rowIndex));
    });
    tabsCol.setCellValueFactory(cellData -> {
      Integer rowIndex = cellData.getValue();
      return new ReadOnlyStringWrapper(tabs.get(rowIndex));
    });
    graphCol.setCellValueFactory(cellData -> {
      Integer rowIndex = cellData.getValue();
      return new ReadOnlyStringWrapper(graph.get(rowIndex));
    });
    presCol.setCellValueFactory(cellData -> {
      Integer rowIndex = cellData.getValue();
      return new ReadOnlyStringWrapper(pres.get(rowIndex));
    });
    astahCol.setCellValueFactory(cellData -> {
      Integer rowIndex = cellData.getValue();
      return new ReadOnlyStringWrapper(astah.get(rowIndex));
    });

    /*
     * Fill the Columns
     */
    for (int i = 0; i < names.size() && i < css.size() && i < sample.size() && i < sql.size() && i < maps.size() && i < pane.size() && i < tabs.size() && i < graph.size() && i < pres.size()&& i < astah.size(); i++) {
      infoTable.getItems().add(i);
    }

    infoTable.getColumns().add(nameCol);
    infoTable.getColumns().add(cssCol);
    infoTable.getColumns().add(sampleCol);
    infoTable.getColumns().add(sqlCol);
    infoTable.getColumns().add(mapsCol);
    infoTable.getColumns().add(paneCol);
    infoTable.getColumns().add(tabsCol);
    infoTable.getColumns().add(graphCol);
    infoTable.getColumns().add(presCol);
    infoTable.getColumns().add(astahCol);

    getChildren().add(infoTable);
  }
}
