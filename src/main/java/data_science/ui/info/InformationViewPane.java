package data_science.ui.info;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Arrays;
import java.util.List;
import javafx.beans.property.ReadOnlyStringWrapper;

/**
 * @author Jasper Wijnhoven
 */
public final class InformationViewPane extends BorderPane {

  private TableView infoTable = new TableView();

  private ObservableList<InformationViewPerson> personData =
      FXCollections.observableArrayList(
          new InformationViewPerson("Ilyas", "Baas", "TODO"),
          new InformationViewPerson("Jasper", "Wijnhoven", "Checkboxes, Comboboxes, Linechart, Tabs"),
          new InformationViewPerson("Xin Hao", "Xia", "Samples"),
          new InformationViewPerson("Dino", "Becker", "CSS"),
          new InformationViewPerson("Johan", "Bastinck", "Samples"));

  /**
   * Creates a new {@link InformationViewPane}.
   */
  InformationViewPane() {
    setTable();
    setStyle();
  }

  /*
   * Specify infoTable specs and create columns
   */
  private void setTable() {
    infoTable.setEditable(true);
    infoTable.setMaxWidth(1802);

    List<String> fNames = Arrays.asList("Ilyas", "Jasper", "Xin Hao", "Dino", "Johan");
    List<String> lNames = Arrays.asList("Baas", "Wijnhoven", "Xia", "Becker", "Bastinck");
    List<String> done = Arrays.asList("TODO", "Checkboxes, Comboboxes, Linechart, Tabs", "Samples", "CSS", "Samples");

    TableColumn<Integer, String> fNameCol = new TableColumn<>("Voornaam");
    fNameCol.setMinWidth(300);
    TableColumn<Integer, String> lNameCol = new TableColumn<>("Achternaam");
    lNameCol.setMinWidth(300);
    TableColumn<Integer, String> doneCol = new TableColumn<>("Gedaan");
    doneCol.setMinWidth(1200);

    fNameCol.setCellValueFactory(cellData -> {
      Integer rowIndex = cellData.getValue();
      return new ReadOnlyStringWrapper(fNames.get(rowIndex));
    });
    lNameCol.setCellValueFactory(cellData -> {
      Integer rowIndex = cellData.getValue();
      return new ReadOnlyStringWrapper(lNames.get(rowIndex));
    });
    doneCol.setCellValueFactory(cellData -> {
      Integer rowIndex = cellData.getValue();
      return new ReadOnlyStringWrapper(done.get(rowIndex));
    });

    for (int i = 0; i < fNames.size() && i < lNames.size() && i < done.size(); i++) {
      infoTable.getItems().add(i);
    }

    infoTable.getColumns().add(fNameCol);
    infoTable.getColumns().add(lNameCol);
    infoTable.getColumns().add(doneCol);
    setCenter(infoTable);
  }
//  private void setTable() {
//    infoTable.setEditable(true);
//    infoTable.setMaxWidth(1802);
//
//    TableColumn fNameCol = new TableColumn("Voornaam");
//    fNameCol.setCellValueFactory(
//        new PropertyValueFactory<InformationViewPerson, String>("Voornaam"));
//    fNameCol.setMinWidth(300);
//
//    TableColumn lNameCol = new TableColumn("Achternaam");
//    lNameCol.setCellValueFactory(
//        new PropertyValueFactory<InformationViewPerson, String>("Achternaam"));
//    lNameCol.setMinWidth(300);
//
//    TableColumn doneCol = new TableColumn("Gedaan");
//    doneCol.setCellValueFactory(
//        new PropertyValueFactory<InformationViewPerson, String>("Gedaan"));
//    doneCol.setMinWidth(1200);
//
//    infoTable.setItems(personData);
//    infoTable.getItems().add(personData);
//    infoTable.getColumns().addAll(fNameCol, lNameCol, doneCol);
//    setCenter(infoTable);
//  }

  /*
   * Set the style for the Pane.
   */
 private void setStyle() {
    setStyle("-fx-font: normal 15px 'Segoe UI'");
    setPadding(new Insets(10, 10, 10, 10));
  }
}
