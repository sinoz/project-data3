package data_science.ui.info;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

/**
 * @author Jasper Wijnhoven
 */
public final class InformationViewPane extends VBox {

  private TableView infoTable = new TableView();
  /**
   * Creates a new {@link InformationViewPane}.
   */
  InformationViewPane() {
    setTable();
    setStyle();
    setContent();
  }

  /*
   * Set the content for the Pane. Every second row is empty for a prettier result.
   */
  private void setTable() {
    infoTable.setEditable(true);

    TableColumn fNameCol = new TableColumn("Voornaam");
    fNameCol.setMinWidth(200);


    TableColumn lNameCol = new TableColumn("Achternaam");
    lNameCol.setMinWidth(200);

    TableColumn doneCol= new TableColumn("Gedaan");
    doneCol.setMinWidth(800);

    infoTable.getColumns().addAll(fNameCol,lNameCol,doneCol);

    getChildren().add(infoTable);
  }

  /*
   * Create content for InformationViewPane
   */
  private void setContent() {
    ObservableList<InformationViewPerson> personData =
        FXCollections.observableArrayList(
      new InformationViewPerson("Ilyas", "Baas", "TODO"),
      new InformationViewPerson("Jasper", "Wijnhoven", "Checkboxes, Comboboxes, Linechart, Tabs"),
      new InformationViewPerson("Xin Hao", "Xia", "Samples"),
      new InformationViewPerson("Dino", "Becker", "CSS"),
      new InformationViewPerson("Johan", "Bastinck", "Samples"));
    infoTable.setItems(personData);
  }

  /*
   * Set the style for the Pane.
   */
  private void setStyle() {
    setStyle("-fx-font: normal 15px 'Segoe UI'");
    setPadding(new Insets(10, 10, 10, 10));
  }
}
