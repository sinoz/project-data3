package data_science.ui.graph.line;

import javafx.geometry.Side;
import javafx.scene.chart.*;

/**
 * A {@link LineChart} to present a graph that shows the theft dates.
 *
 * @author I.A
 * @author Jasper Wijnhoven
 */
public final class TheftsByDateGraph extends LineChart<Number, Number> {
	/**
	 * A factory method to produce a new {@link TheftsByDateGraph} chart.
	 */
	public static TheftsByDateGraph create() {
		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis();

		xAxis.setLabel("Date");
		yAxis.setLabel("Count");

		return new TheftsByDateGraph(xAxis, yAxis);
	}

	/**
	 * Creates a new {@link TheftsByDateGraph}.
	 */
	private TheftsByDateGraph(NumberAxis xAxis, NumberAxis yAxis) {
		super(xAxis, yAxis);

		configureGraph();
		fillData();
	}

	private void configureGraph() {
		setLegendSide(Side.BOTTOM);
		setTitle("Amount bicycle thefts sorted by date");
	}

	/**
	 * Fills data inside of the graph by computing it and transforming it to a suitable presentable format.
	 */
	private void fillData() {
		getXAxis().setLabel("Date");
		XYChart.Series<Number, Number> series = new XYChart.Series<>();
		series.setName("Bicycle Thefts");
		series.getData().add(new XYChart.Data<>(1, 20));
		series.getData().add(new XYChart.Data<>(2, 25));
		getData().add(series);
	}
}
