package data_science.ui.loc.text;

import javafx.scene.text.Text;

/**
 * A {@link Text} label widget containing the 'Filter' text.
 * @author I.A
 */
public final class FilterText extends Text {
	/**
	 * Creates a new {@link FilterText}.
	 */
	public FilterText() {
		super("Filter");

		applyStyling();
	}

	private void applyStyling() {
		setStyle("-fx-font: normal 25px 'Segoe UI'");
	}
}
