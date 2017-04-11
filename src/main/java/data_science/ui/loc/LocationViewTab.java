package data_science.ui.loc;

import com.lynden.gmapsfx.GoogleMapView;
import data_science.ui.CategorizedTab;

/**
 * A {@link CategorizedTab} to present the {@link GoogleMapView}.
 * @author I.A
 */
public final class LocationViewTab extends CategorizedTab {
	/**
	 * The corresponding {@link LocationViewPane}.
	 */
	private final LocationViewPane pane;

	/**
	 * Creates a new {@link LocationViewTab}.
	 */
	public LocationViewTab(GoogleMapView mapView) {
		super("Locatie");

		this.pane = new LocationViewPane(mapView);

		setContent(pane);
	}
}
