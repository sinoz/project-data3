package data_science.ui;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.event.UIEventHandler;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import data_science.ui.loc.LocationViewActionBar;
import data_science.ui.loc.LocationViewListener;
import javafx.scene.Scene;
import netscape.javascript.JSObject;

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
   * @see {@link ApplicationScene#presentMarker(MarkerOptions, InfoWindowOptions)}.
   */
  public void presentMarker(MarkerOptions options) {
    presentMarker(options, null);
  }

  /**
   * Adds a new {@link Marker} using the given {@link MarkerOptions} to the {@link GoogleMap}.
   */
  public void presentMarker(MarkerOptions options, InfoWindowOptions infoWindowOptions) {
    Marker marker = new Marker(options);

    if (infoWindowOptions != null) {
      view.getMap().addUIEventHandler(marker, UIEventType.click, (JSObject jsObject) -> {
        InfoWindow infoWindow = new InfoWindow(infoWindowOptions);
        infoWindow.open(view.getMap(), marker);
      });
    }

    view.getMap().addMarker(marker);
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
