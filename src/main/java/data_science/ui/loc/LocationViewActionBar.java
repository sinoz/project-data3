package data_science.ui.loc;

import data_science.ui.loc.action.ToggleBikeTheftsBox;
import data_science.ui.loc.action.ToggleViolentBikeTheftsBox;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

/**
 * A {@link GridPane} that acts as an action bar on the side left to the google maps.
 * @author Whis
 */
public final class LocationViewActionBar extends GridPane {
	/**
	 * A checkbox to toggle whether to showcase all bike thefts.
	 */
	private final CheckBox toggleBikeThefts = new ToggleBikeTheftsBox();

	/**
	 * A checkbox to toggle whether to showcase all bike thefts that involved violence.
	 */
	private final CheckBox violentBikeTheftsBox = new ToggleViolentBikeTheftsBox();

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
		add(toggleBikeThefts,1,0);
		add(violentBikeTheftsBox,1,1);
	}

	private void addPadding() {
		setPadding(new Insets(10, 10, 10, 10));
		setVgap(5);
		setHgap(5);
	}
}
