package data_science.ui.loc.text;

import javafx.scene.text.Text;

/**
 * A {@link Text} label widget containing the 'Select' text.
 * @author I.A
 */
public final class SelectText extends Text {
	/**
	 * Creates a new {@link SelectText}.
	 */
	public SelectText() {
		super("Select");

		applyStyling();
	}

	private void applyStyling() {
		setStyle("-fx-font: normal 25px 'Segoe UI'");
	}
}
