package data_science.ui.loc;

import com.lynden.gmapsfx.GoogleMapView;
import data_science.ApplicationRoot;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * A {@link BorderPane} to position the {@link LocationViewActionBar} onto the
 * left side and the {@link GoogleMapView} onto the right side of the tab.
 * @author I.A
 */
public final class LocationViewPane extends BorderPane {
	/**
	 * The {@link LocationViewActionBar}.
	 */
	private final GridPane actionBar = new LocationViewActionBar();

	/**
	 * The corresponding {@link GoogleMapView}.
	 */
	private final GoogleMapView mapView;

	/**
	 * Creates a new {@link LocationViewPane}.
	 */
	LocationViewPane(GoogleMapView mapView) {
		this.mapView = mapView;

		setLeft(actionBar);
		setRight(mapView);

		sizeUpMap();
	}

	private void sizeUpMap() {
		mapView.setPrefWidth(ApplicationRoot.RESOLUTION.getWidth() * 0.75F);
		mapView.setPrefHeight(ApplicationRoot.RESOLUTION.getHeight());
	}
}
