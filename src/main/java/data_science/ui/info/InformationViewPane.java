package data_science.ui.info;


import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/*
 * @author Jasper Wijnhoven
 */
public final class InformationViewPane extends BorderPane {

  private VBox tableBox = new InformationViewTable();

  private VBox textBox = new InformationViewText();

  /**
   * Creates a new {@link InformationViewPane}.
   */
  InformationViewPane() {
    setStyle();
    setTop(tableBox);
    setCenter(textBox);
  }

  private void setStyle() {
    setStyle("-fx-font: normal 15px 'Segoe UI'");
    setPadding(new Insets(10, 10, 10, 10));
  }
}
