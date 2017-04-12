package data_science.ui;

import com.lynden.gmapsfx.GoogleMapView;
import data_science.ApplicationRoot;
import data_science.ui.graph.GraphPaneTab;
import data_science.ui.loc.LocationViewTab;
import javafx.scene.control.TabPane;

/**
 * A {@link TabPane} of {@link CategorizedTab}.
 * @author I.A
 */
public final class CategorizedTabPane extends TabPane {
	/**
	 * The {@link CategorizedTab} for all of the graphs.
	 */
	private final CategorizedTab graphTab;

	/**
	 * The {@link CategorizedTab} for the locations view.
	 */
	private final CategorizedTab locTab;

	/**
	 * Creates a new {@link CategorizedTabPane}.
	 */
	CategorizedTabPane(GoogleMapView mapView) {
		this.graphTab = new GraphPaneTab();
        graphTab.setStyle("-fx-background-color: rgba(60,63,65,0.99)");

        this.locTab = new LocationViewTab(mapView);
        locTab.setStyle("-fx-background-color: rgba(60,63,65,0.99)");

		getTabs().add(locTab);
		getTabs().add(graphTab);

		sizeToScene();
	}

	private void sizeToScene() {
		setPrefWidth(ApplicationRoot.RESOLUTION.getWidth());
		setPrefHeight(ApplicationRoot.RESOLUTION.getHeight());
	}
}
