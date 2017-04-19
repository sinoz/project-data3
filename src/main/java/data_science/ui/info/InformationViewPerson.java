package data_science.ui.info;

import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

/**
 * @author Jasper Wijnhoven
 */
public class InformationViewPerson {
  private SimpleStringProperty fName;
  private SimpleStringProperty lName;
  private SimpleStringProperty done;

  public InformationViewPerson(String fName, String lName, String done) {
    this.fName = new SimpleStringProperty(fName);
    this.lName = new SimpleStringProperty(lName);
    this.done = new SimpleStringProperty(done);
  }
}
