package data_science.ui.loc;

import data_science.ui.loc.action.ToggleBicycleStallsBox;
import data_science.ui.loc.action.ToggleTheftsFromStallsBox;
import data_science.ui.loc.action.ToggleSafestBicycleStallsBox;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

/**
 * A {@link GridPane} that acts as an action bar on the side left to the google maps.
 * @author I.A
 */
public final class LocationViewActionBar extends GridPane {
	/**
	 * A checkbox to toggle whether to showcase all bicycle stalls.
	 */
	private final CheckBox bicycleStalls = new ToggleBicycleStallsBox(this);

	/**
	 * A checkbox to toggle whether to showcase bike thefts that occurred at bicycle stalls.
	 */
	private final CheckBox bicycleTheftsFromStalls = new ToggleTheftsFromStallsBox(this);

	/**
	 * A checkbox to toggle whether to showcase the top 3 safest bicycle stalls.
	 */
	private final CheckBox top3SafestBicycleStalls = new ToggleSafestBicycleStallsBox(this);

	/**
	 * Creates a new {@link LocationViewActionBar}.
	 */
	LocationViewActionBar() {
		addPadding();
		addSubordinates();
		applyStyling();
	}

	private void applyStyling() {
		setStyle("-fx-font: normal bold 15px 'serif' ");
	}

	private void addSubordinates() {
		add(bicycleStalls,1,0);
		add(bicycleTheftsFromStalls,1,1);
		add(top3SafestBicycleStalls,1,2);
	}

	private void addPadding() {
		setPadding(new Insets(20, 10, 10, 15));
		setVgap(5);
		setHgap(5);
	}

	public CheckBox getSafestBicycleStallsBox() {
		return top3SafestBicycleStalls;
	}

	public CheckBox getBicycleStallsBox() {
		return bicycleStalls;
	}

	public CheckBox getBicycleTheftsFromStallsBox() {
		return bicycleTheftsFromStalls;
	}
}
