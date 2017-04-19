package data_science.ui.graph;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * A {@link BorderPane} that displays all of the data graphs.
 *
 * @author I.A
 */
public final class GraphViewPane extends BorderPane {
	/**
	 * Creates a new {@link GraphViewPane}.
	 */
	GraphViewPane() {
		TreeItem<String> rootItem = new TreeItem<String>("Inbox", null);
		rootItem.setExpanded(true);
		for (int i = 1; i < 6; i++) {
			TreeItem<String> item = new TreeItem<String>("Message" + i);
			rootItem.getChildren().add(item);
		}
		TreeView<String> tree = new TreeView<String>(rootItem);

		tree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {

				TreeItem<String> selectedItem = (TreeItem<String>) newValue;
				System.out.println("Selected Text : " + selectedItem.getValue());
				if (selectedItem.getValue().equals("Message1")) {
					ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
							new PieChart.Data("Diefstallen zonder geweld - " + 60 + "%", 60),
							new PieChart.Data("Diefstallen met geweld - " + 40 + "%", 40));

					PieChart pieChart = new PieChart(pieChartData);
					pieChart.setLegendSide(Side.BOTTOM);
					pieChart.setTitle("Fietsdiefstallen");
					pieChart.setClockwise(true);
					pieChart.setLabelsVisible(true);
					pieChart.setLabelLineLength(40);

					VBox vbox = new VBox(pieChart);
					setCenter(vbox);
				} else if (selectedItem.getValue().equals("Message2")) {
					ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
							new PieChart.Data("Diefstallen zonder geweld - " + 50 + "%", 50),
							new PieChart.Data("Diefstallen met geweld - " + 50 + "%", 50));

					PieChart pieChart = new PieChart(pieChartData);
					pieChart.setLegendSide(Side.BOTTOM);
					pieChart.setTitle("Fietsdiefstallen");
					pieChart.setClockwise(true);
					pieChart.setLabelsVisible(true);
					pieChart.setLabelLineLength(40);

					VBox vbox = new VBox(pieChart);
					setCenter(vbox);
				}
			}

		});
		setLeft(tree);

	}
}
