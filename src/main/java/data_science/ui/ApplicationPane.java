package data_science.ui;

import com.lynden.gmapsfx.GoogleMapView;
import javafx.scene.layout.Pane;

/**
 * The root pane.
 * @author I.A
 */
public final class ApplicationPane extends Pane {
	/**
	 * The pane of {@link CategorizedTab}s.
	 */
	private final CategorizedTabPane tabs;

	/**
	 * Creates a new {@link ApplicationPane} that renders the given {@link GoogleMapView}.
	 */
	ApplicationPane(GoogleMapView view) {
		this.tabs = new CategorizedTabPane(view);

		getChildren().add(tabs);
	}
}