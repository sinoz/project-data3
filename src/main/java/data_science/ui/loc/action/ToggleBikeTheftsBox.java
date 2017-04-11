package data_science.ui.loc.action;

import javafx.beans.value.ObservableValue;
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

		selectedProperty().addListener(this::stateChange);
		setIndeterminate(false);
	}

	/**
	 * Reacts to a change of state e.g on user input.
	 */
	private void stateChange(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		// TODO
	}
}
