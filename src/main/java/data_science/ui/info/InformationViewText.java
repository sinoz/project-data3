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
        "Deze applicatie is gemaakt door Ilyas, Jasper, Xin Hao, Dino en Johan. \n" +
            "In de tabel hierboven kunt u zien wie wat heeft gedaan. \n"
    );
    getChildren().add(infoText);
  }

  private void setStyle() {
    setPadding(new Insets(10, 10, 10, 30));
  }
}