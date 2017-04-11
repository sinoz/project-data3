package data_science.ui.loc.action;

import javafx.scene.control.CheckBox;

/**
 * A {@link CheckBox} for a user to toggle whether to show all bike thefts
 * that involved violence.
 * @author I.A
 */
public final class ToggleViolentBikeTheftsBox extends CheckBox {
	/**
	 * Creates a new {@link ToggleViolentBikeTheftsBox}.
	 */
	public ToggleViolentBikeTheftsBox() {
		super("Show Violent Bike Thefts");

		setIndeterminate(false);
	}
}
