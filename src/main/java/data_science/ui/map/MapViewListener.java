package data_science.ui.map;

import com.google.common.collect.ImmutableList;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import data_science.database.query.ComputeCategorizedTheftCounts;
import data_science.database.query.ComputeViolentTheftsCount;
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

    ImmutableList<LatLong> points = ImmutableList.<LatLong>builder()
        .add(new LatLong(51.92293167, 4.46130991))
        .add(new LatLong(51.92410235, 4.482054381))
        .build();

    //Add a marker to the map
    for (LatLong point : points) {
      Marker marker = new Marker(new MarkerOptions()
          .position(point)
          .visible(Boolean.TRUE)
          .title("My Marker"));

      map.addMarker(marker);
    }

    // samples of code fetching some data from the database and presenting it on the screen
    ComputeViolentTheftsCount.create().subscribe((Integer count) -> {
      Platform.runLater(() -> {
        // for now we just create a marker on our map
        Marker marker = new Marker(new MarkerOptions()
            .position(new LatLong(51.93014908, 4.466259956))
            .visible(Boolean.TRUE)
            .title("IT WORKED"));

        map.addMarker(marker);
      });
    });

    ComputeCategorizedTheftCounts.create().subscribe((ImmutableList<ComputeCategorizedTheftCounts.Category> c) -> {
      c.forEach(System.out::println);
    });
  }
}
