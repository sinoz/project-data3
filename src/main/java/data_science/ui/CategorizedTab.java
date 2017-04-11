package data_science.ui;

import javafx.scene.control.Tab;
import javafx.scene.text.Text;

/**
 * A tab that is categorized with an applied text label.
 * @author I.A
 */
public abstract class CategorizedTab extends Tab {
	/**
	 * Creates a new {@link CategorizedTab}.
	 */
	public CategorizedTab(String categoryName) {
		setGraphic(new Text(categoryName));
	}
}
