package data_science.ui.loc.action;

import javafx.scene.control.CheckBox;

/**
 * A {@link CheckBox} for a user to toggle whether to show all bike thefts.
 * @author I.A
 */
public final class ToggleBikeTheftsBox extends CheckBox {
	/**
	 * Creates a new {@link ToggleBikeTheftsBox}.
	 */
	public ToggleBikeTheftsBox() {
		super("Show Bike Thefts");

		setIndeterminate(false);
	}
}
