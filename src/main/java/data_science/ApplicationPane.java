package data_science;

import com.lynden.gmapsfx.GoogleMapView;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import static data_science.ApplicationRoot.RESOLUTION;

/**
 * The root pane.
 * @author I.A
 */
public final class ApplicationPane extends BorderPane {
  /**
   * Creates a new {@link ApplicationPane} that renders the given {@link GoogleMapView}.
   */
  ApplicationPane(GoogleMapView view) {
    HBox statusbar = new HBox();

    view.setPrefWidth(RESOLUTION.getWidth() * 0.75F);
    view.setPrefHeight(RESOLUTION.getHeight());

    setRight(view);
    setLeft(statusbar);
  }
}
