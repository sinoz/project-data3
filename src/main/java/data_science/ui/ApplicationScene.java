package data_science.ui;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import data_science.ui.loc.LocationViewActionBar;
import data_science.ui.loc.LocationViewListener;
import javafx.scene.Scene;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A {@link Scene} to draw the google map view.
 * @author I.A
 */
public final class ApplicationScene extends Scene {
  /**
   * Indicates whether the {@link GoogleMapView} is initialized or not. This attribute
   * may be accessed across multiple threads and is completely thread-safe.
   */
  private final AtomicBoolean viewIsInitialized = new AtomicBoolean();

  /**
   * TODO
   */
  private final LocationViewListener listener;

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
    this.listener = new LocationViewListener(view, viewIsInitialized);

    initMapView();
  }

  /**
   * Initializes the {@link GoogleMapView} by attaching a {@link LocationViewListener}
   * to respond events to.
   */
  private void initMapView() {
    view.addMapInializedListener(listener);
  }

  /**
   * Calls {@link GoogleMap#clearMarkers()}.
   */
  public void clearAllMarkers() {
    view.getMap().clearMarkers();
  }

  /**
   * Adds a new {@link Marker} using the given {@link MarkerOptions} to the {@link GoogleMap}.
   */
  public void presentMarker(MarkerOptions options) {
    view.getMap().addMarker(new Marker(options));
  }

  /**
   * Returns whether the {@link GoogleMapView} is initialized or not.
   */
  public boolean mapViewIsInitialized() {
    return viewIsInitialized.get();
  }

  /**
   * Returns the location view listener.
   */
  public LocationViewListener getListener() {
    return listener;
  }
}
