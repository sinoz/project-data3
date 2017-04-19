package data_science.ui.graph;

import data_science.ui.graph.pie.CategorizedTheftsGraph;
import data_science.ui.graph.pie.TheftsByDate;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.Arrays;

/**
 * A {@link BorderPane} that displays all of the data graphs.
 * @author I.A
 * @author Johan Bastinck
 */
public final class GraphViewPane extends BorderPane {
	/**
	 * Creates a new {@link GraphViewPane}.
	 */
	GraphViewPane() {
		TreeItem<String> rootItem = new TreeItem<>("Data", null);
		rootItem.setExpanded(true);
		rootItem.getChildren().addAll(Arrays.asList(new TreeItem<>("Categorized Theft Counts"), new TreeItem<>("Some other bs"), new TreeItem<>("Fiets Diefstallen")));

		TreeView<String> tree = new TreeView<>(rootItem);

		tree.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			switch (newValue.getValue()) {
				case "Categorized Theft Counts":
					presentCategorizedTheftsGraph();

					break;

                case "Fiets Diefstallen":
                    presentTheftsByDate();
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

    private void presentTheftsByDate() {
        setCenter(new VBox(TheftsByDate.create()));
    }
}
