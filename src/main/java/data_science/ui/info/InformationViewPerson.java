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

  public String getFName() {
    return fName.get();
  }

  public void setFName(String fName) {
    this.fName = new SimpleStringProperty(fName);
  }

  public String getLtName() {
    return lName.get();
  }

  public void setLName(String lName) {
    this.lName = new SimpleStringProperty(lName);
  }

  public String getDone() {
    return done.get();
  }

  public void setDone(String done) {
    this.done = new SimpleStringProperty(done);
  }
}
