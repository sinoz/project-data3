package data_science.ui.loc.action;

import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import data_science.database.query.SafestBicycleStalls;
import data_science.model.BicycleStall;
import data_science.ui.ApplicationScene;
import data_science.ui.loc.LocationViewActionBar;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.paint.Color;

/**
 * A {@link CheckBox} for a user to toggle whether to show the safest bicycle stalls.
 * @author I.A
 */
public final class ToggleSafestBicycleStallsBox extends CheckBox {
	/**
	 * The action bar this checkbox belongs to.
	 */
	private final LocationViewActionBar actionBar;

	/**
	 * Creates a new {@link ToggleSafestBicycleStallsBox}.
	 */
	public ToggleSafestBicycleStallsBox(LocationViewActionBar locationViewActionBar) {
		super("Show Top 3 Safest Bicycle Stalls");

		this.actionBar = locationViewActionBar;

		setTextFill(Color.WHITE);

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

			actionBar.getBicycleStallsBox().setSelected(false);
			actionBar.getBicycleTheftsFromStallsBox().setSelected(false);
		} else {
			scene.clearAllMarkers();
		}
	}

	private void applyMarkers(ApplicationScene scene) {
		SafestBicycleStalls.compute().take(3).subscribe((BicycleStall s) -> {
			Platform.runLater(() -> { // TODO integrate Platform thread with RxJava
				LatLong coordinates = new LatLong(s.getLatitude(), s.getLongitude());

				scene.presentMarker(new MarkerOptions().position(coordinates).visible(Boolean.TRUE));
			});
		});

		scene.clearAllMarkers();
	}
}
