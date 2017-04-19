package data_science.ui.stat;

import data_science.ui.stat.line.TheftsByDateChart;
import data_science.ui.stat.line.TheftsByTimestampChart;
import data_science.ui.stat.pie.CategorizedTheftsChart;
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
public final class StatisticsViewPane extends BorderPane {
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
	 * Creates a new {@link StatisticsViewPane}.
	 */
	StatisticsViewPane() {
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
	 * Presents the {@link CategorizedTheftsChart}.
	 */
	private void presentCategorizedTheftsGraph() {
		setCenter(new VBox(new CategorizedTheftsChart()));
	}

	/**
	 * Presents the {@link TheftsByDateChart}.
	 */
	private void presentTheftsByDate() {
		setCenter(new VBox(TheftsByDateChart.create()));
	}

	/**
	 * Presents the {@link TheftsByTimestampChart}.
	 */
	private void presentTheftsByTimestamp() {
		setCenter(new VBox(TheftsByTimestampChart.create()));
	}
}
