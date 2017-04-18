package data_science.ui.loc;

import data_science.ui.loc.action.ToggleBicycleStallsBox;
import data_science.ui.loc.action.ToggleTheftsFromStallsBox;
import data_science.ui.loc.action.ToggleSafestBicycleStallsBox;
import data_science.ui.loc.action.ToggleLeastSafeBicycleStallsBox;
import data_science.ui.loc.action.MonthSelectionDropdown;
import data_science.ui.loc.action.DaySelectionDropdown;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

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
	private final CheckBox top5SafestBicycleStalls = new ToggleSafestBicycleStallsBox(this);

	/**
	 * A checkbox to toggle whether to showcase the top 5 least safe bicycle stalls.
	 */
    private final CheckBox top5LeastSafeBicycleStalls = new ToggleLeastSafeBicycleStallsBox(this);

    /**
     * Dropdown menu to select a month.
     */
    private final ComboBox selectMonth = new MonthSelectionDropdown(this);

    /**
     * Dropdown menu to select a day.
     */
    private final ComboBox selectDay = new DaySelectionDropdown(this);

    /**
     * Text for Dropdown month.
     */
    private final Text monthLabel = new Text("Month");

    /**
     * Text for Dropdown day.
     */
    private final Text dayLabel = new Text("Day");

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
		add(top5SafestBicycleStalls,1,2);
		add(top5LeastSafeBicycleStalls, 1, 3);
        add(new Label(), 1, 4);
        add(new Label(), 2, 4);
		add(selectMonth,1,6);
        add(monthLabel,1,5);
		add(selectDay,2,6);
        add(dayLabel,2,5);
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
}
