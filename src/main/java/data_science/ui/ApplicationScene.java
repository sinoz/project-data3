package data_science.ui;

import com.lynden.gmapsfx.GoogleMapView;
import data_science.ui.loc.LocationViewListener;
import javafx.scene.Scene;

/**
 * A {@link Scene} to draw the google map view.
 * @author I.A
 */
public final class ApplicationScene extends Scene {
  /**
   * The {@link GoogleMapView} to present inside of a tab.
   */
  private final GoogleMapView view;

  /**
   * Creates a new {@link ApplicationScene}.
   */
  public ApplicationScene(GoogleMapView view) {
    super(new ApplicationPane(view));

    this.view = view;

    initMapView();
  }

  /**
   * Initializes the {@link GoogleMapView} by attaching a {@link LocationViewListener}
   * to respond events to.
   */
  private void initMapView() {
    view.addMapInializedListener(new LocationViewListener(view));
  }
}
