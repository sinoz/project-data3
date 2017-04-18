package data_science.ui.loc;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A {@link MapComponentInitializedListener} to react to map component events.
 * @author I.A
 */
public final class LocationViewListener implements MapComponentInitializedListener {
  /**
   * The current {@link GoogleMap} to present.
   */
  private GoogleMap map;

  /**
   * An atomically mutable flag to indicate whether the map view has been
   * successfully initialized or not.
   */
  private final AtomicBoolean viewIsInitialized;

  /**
   * The {@link GoogleMapView} to present the {@link GoogleMap} on.
   */
  private final GoogleMapView mapView;

  /**
   * Creates a new {@link LocationViewListener}.
   */
  public LocationViewListener(GoogleMapView mapView, AtomicBoolean viewIsInitialized) {
    this.mapView = mapView;
    this.viewIsInitialized = viewIsInitialized;
  }

  @Override
  public void mapInitialized() {
    //Set the initial properties of the map.
    map = mapView.createMap(initialMapViewSettings());

    // informs the scene that the map view has successfully been initialized
    viewIsInitialized.compareAndSet(false, true);
  }

  /**
   * Returns the default {@link MapOptions} for the {@link GoogleMap}.
   */
  private MapOptions initialMapViewSettings() {
    MapOptions opt = new MapOptions();

    opt.center(new LatLong(51.9200000, 4.4700000));
    opt.overviewMapControl(false);
    opt.panControl(false);
    opt.rotateControl(false);
    opt.scaleControl(false);
    opt.streetViewControl(false);
    opt.zoomControl(false);
    opt.zoom(13);

    return opt;
  }

  /**
   * Returns the state of the {@link GoogleMap}.
   */
  public GoogleMap getMap() {
    return map;
  }
}
