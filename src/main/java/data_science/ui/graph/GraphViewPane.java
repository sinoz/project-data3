package data_science.ui.graph;

import data_science.ui.graph.line.TheftsByDateGraph;
import data_science.ui.graph.line.TheftsByTimestampGraph;
import data_science.ui.graph.pie.CategorizedTheftsGraph;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.Arrays;

/**
 * A {@link BorderPane} that displays all of the data graphs.
 *
 * @author I.A
 * @author Johan Bastinck
 */
public final class GraphViewPane extends BorderPane {
	/**
	 * TODO
	 */
	private static final String BY_CATEGORY = "Thefts Sorted By Category";

	/**
	 * TODO
	 */
	private static final String BY_DATE = "Thefts Sorted By Date";

	/**
	 * TODO
	 */
	private static final String BY_TIMESTAMP = "Thefts Sorted By Timestamp";

	/**
	 * Creates a new {@link GraphViewPane}.
	 */
	GraphViewPane() {
		TreeItem<String> rootItem = new TreeItem<>("Data", null);

		rootItem.getChildren().addAll(Arrays.asList(
				new TreeItem<>(BY_CATEGORY),
				new TreeItem<>(BY_DATE),
				new TreeItem<>(BY_TIMESTAMP)
		));
		rootItem.setExpanded(true);

		TreeView<String> tree = new TreeView<>(rootItem);

		tree.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			switch (newValue.getValue()) {
				case BY_CATEGORY:
					presentCategorizedTheftsGraph();

					break;
				case BY_TIMESTAMP:
					presentTheftsByTimestamp();

					break;
				case BY_DATE:
					presentTheftsByDate();

					break;
			}
		});

		setLeft(tree);
	}

	/**
	 * Presents the {@link CategorizedTheftsGraph}.
	 */
	private void presentCategorizedTheftsGraph() {
		setCenter(new VBox(new CategorizedTheftsGraph()));
	}

	/**
	 * Presents the {@link TheftsByDateGraph}.
	 */
	private void presentTheftsByDate() {
		setCenter(new VBox(TheftsByDateGraph.create()));
	}

	/**
	 * Presents the {@link TheftsByTimestampGraph}.
	 */
	private void presentTheftsByTimestamp() {
		setCenter(new VBox(TheftsByTimestampGraph.create()));
	}
}
