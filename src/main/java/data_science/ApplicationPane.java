package data_science;

import com.lynden.gmapsfx.GoogleMapView;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * TODO
 * @author I.A
 */
public final class ApplicationPane extends BorderPane {
  /**
   * TODO
   */
  ApplicationPane(GoogleMapView view) {
    HBox statusbar = new HBox();

    statusbar.getChildren().addAll(new Button("1"), new Button("2"), new Button("3"));

    view.setMaxWidth(500);
    view.setMaxHeight(500);

    setCenter(view);
    setTop(statusbar);
  }
}
