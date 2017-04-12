package data_science.ui.loc;

import com.lynden.gmapsfx.GoogleMapView;
import data_science.ApplicationRoot;
import data_science.ui.CategorizedTab;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

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

		applyStyling();
		setContent(pane);
	}

	private void applyStyling() {
		//setStyle("-fx-background-color: rgba(60,63,65,0.99)");
	}

	@Override
	protected Paint textColor() {
		return Color.WHITE;
	}
}
