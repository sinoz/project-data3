package data_science;

import com.lynden.gmapsfx.GoogleMapView;
import javafx.scene.Scene;

/**
 * A {@link Scene} to draw the google map view.
 * @author I.A
 */
public final class MapViewScene extends Scene {
  /**
   * The view.
   */
  private final GoogleMapView view;

  /**
   * Creates a new {@link MapViewScene}.
   */
  MapViewScene(GoogleMapView view) {
    super(new ApplicationPane(view));

    this.view = view;

    initMapView();
  }

  /**
   * Initializes the {@link GoogleMapView} by attaching a {@link MapViewListener}
   * to respond events to.
   */
  private void initMapView() {
    view.addMapInializedListener(new MapViewListener(view));
  }
}
