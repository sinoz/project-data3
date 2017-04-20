package data_science.ui.info;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

/*
 * @author Jasper Wijnhoven
 */
public final class InformationViewText extends VBox {

  /*
   * Creates a new {@link InformationViewText}.
   */
  InformationViewText() {
    setText();
  }

  private void setText() {
    Label infoText = new Label(
        "This application was made by Ilyas, Jasper, Xin Hao, Dino and Johan. \n" +
            "In the table above you can see who worked on which features."
    );
    getChildren().add(infoText);
  }

  private void setStyle() {
    setPadding(new Insets(10, 10, 10, 30));
  }
}