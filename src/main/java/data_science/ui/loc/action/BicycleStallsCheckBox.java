package data_science.ui.loc.action;

import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import data_science.database.query.AllBicycleStallsQuery;
import data_science.model.BicycleStall;
import data_science.ui.ApplicationScene;
import data_science.ui.loc.LocationViewActionBar;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;

/**
 * A {@link CheckBox} for a user to toggle whether to show all bicycle stalls.
 * @author I.A
 * @author Jasper Wijnhoven
 */
public final class BicycleStallsCheckBox extends CheckBox {
	/**
	 * The action bar this checkbox belongs to.
	 */
	private final LocationViewActionBar actionBar;

	/**
	 * Creates a new {@link BicycleStallsCheckBox}.
	 */
	public BicycleStallsCheckBox(LocationViewActionBar locationViewActionBar) {
		super("Show All Bicycle Stalls");

		this.actionBar = locationViewActionBar;

		selectedProperty().addListener(this::stateChange);
		setIndeterminate(false);
	}

	/**
	 * Reacts to a change of state e.g on user input.
	 */
	private void stateChange(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		ApplicationScene scene = (ApplicationScene) getScene();

		boolean enabled = newValue;
		if (enabled) {
			applyMarkers(scene);

			scene.getListener().refresh();

			actionBar.getSafestBicycleStallsBox().setSelected(false);
			actionBar.getBicycleTheftsFromStallsBox().setSelected(false);
			actionBar.getLeastSafeBicycleStallsBox().setSelected(false);
		} else {
			scene.clearAllMarkers();
		}
	}

	private void applyMarkers(ApplicationScene scene) {
		AllBicycleStallsQuery.compute().subscribe((BicycleStall s) -> {
			Platform.runLater(() -> { // TODO integrate Platform thread with RxJava
				LatLong coordinates = new LatLong(s.getLatitude(), s.getLongitude());

				InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
				infoWindowOptions.content("<h2>" + s.getArea() + "</h2>"
						+ "Street Name: " + s.getName() + "<br>" );

				scene.presentMarker(new MarkerOptions().position(coordinates).visible(Boolean.TRUE), infoWindowOptions);
			});
		});

		scene.clearAllMarkers();
	}
}
