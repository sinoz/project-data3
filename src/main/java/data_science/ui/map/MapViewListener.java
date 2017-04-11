package data_science.ui.map;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import data_science.database.query.SafestBicycleStalls;
import data_science.model.BicycleStall;
import javafx.application.Platform;

/**
 * A {@link MapComponentInitializedListener} to react to map component events.
 * @author I.A
 */
public final class MapViewListener implements MapComponentInitializedListener {
  /**
   * The current {@link GoogleMap} to present.
   */
  private GoogleMap map;

  /**
   * The {@link GoogleMapView} to present the {@link GoogleMap} on.
   */
  private final GoogleMapView mapView;

  /**
   * Creates a new {@link MapViewListener}.
   */
  MapViewListener(GoogleMapView mapView) {
    this.mapView = mapView;
  }

  @Override
  public void mapInitialized() {
    //Set the initial properties of the map.
    MapOptions mapOptions = new MapOptions();
    mapOptions.center(new LatLong(51.934875, 4.3667926)).overviewMapControl(false).panControl(false).rotateControl(false).scaleControl(false).streetViewControl(false).zoomControl(false).zoom(12);

    map = mapView.createMap(mapOptions);

    // samples of code fetching some data from the database and presenting it on the screen
//    SafestBicycleStalls.compute().take(3).subscribe((BicycleStall s) -> {
//      Platform.runLater(() -> {
//        // for now we just create a marker on our map
//        LatLong coordinates = new LatLong(s.getLatitude(), s.getLongitude());
//        Marker marker = new Marker(new MarkerOptions().position(coordinates).visible(Boolean.TRUE));
//
//        map.addMarker(marker);
//      });
//    });
  }
}
