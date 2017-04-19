package data_science.ui.loc;

import data_science.ui.loc.action.*;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

/**
 * A {@link GridPane} that acts as an action bar on the side left to the google maps.
 * @author I.A
 * @author Jasper Wijnhoven
 */
public final class LocationViewActionBar extends GridPane {

	private final GridPane comboBox = new LocationViewComboPane();
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
	private final CheckBox top5SafestBicycleStalls = new ToggleSafestBicycleStallsBox(this);

	/**
	 * A checkbox to toggle whether to showcase the top 5 least safe bicycle stalls.
	 */
    private final CheckBox top5LeastSafeBicycleStalls = new ToggleLeastSafeBicycleStallsBox(this);

    /**
     * Creates a new {@link LocationViewActionBar}.
     */
	LocationViewActionBar() {
        this.add(comboBox,1,4);
		addPadding();
		addSubordinates();
		applyStyling();
	}

	private void applyStyling() {
		setStyle("-fx-font: normal bold 16px 'Segoe UI' ");
	}

	private void addSubordinates() {
		add(bicycleStalls,1,0);
		add(bicycleTheftsFromStalls,1,1);
		add(top5SafestBicycleStalls,1,2);
		add(top5LeastSafeBicycleStalls, 1, 3);
	}

	private void addPadding() {
		setPadding(new Insets(20, 10, 10, 15));
		setVgap(5);
		setHgap(5);
	}

	public CheckBox getSafestBicycleStallsBox() {
		return top5SafestBicycleStalls;
	}

	public CheckBox getBicycleStallsBox() {
		return bicycleStalls;
	}

	public CheckBox getBicycleTheftsFromStallsBox() {
		return bicycleTheftsFromStalls;
	}

    public CheckBox getLeastSafeBicycleStallsBox() {
        return top5LeastSafeBicycleStalls;
    }
}
