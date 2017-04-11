package data_science.ui.graph;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * A {@link BorderPane} that displays all of the data graphs.
 * @author I.A
 */
public final class GraphViewPane extends BorderPane {
	/**
	 * Creates a new {@link GraphViewPane}.
	 */
	GraphViewPane() {
		// TODO split this up
		ObservableList<PieChart.Data> pieChartData =
				FXCollections.observableArrayList(
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
	}
}
