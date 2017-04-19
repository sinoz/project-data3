package data_science.ui.graph.line;

import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

/**
 * A {@link LineChart} to present a graph that shows the theft dates.
 *
 * @author I.A
 * @author Jasper Wijnhoven
 */
public final class TheftsByTimestampGraph extends LineChart<Number, Number> {
	/**
	 * A factory method to produce a new {@link TheftsByTimestampGraph} chart.
	 */
	public static TheftsByTimestampGraph create() {
		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis();

		xAxis.setLabel("Time");
		yAxis.setLabel("Count");

		return new TheftsByTimestampGraph(xAxis, yAxis);
	}

	/**
	 * Creates a new {@link TheftsByTimestampGraph}.
	 */
	private TheftsByTimestampGraph(NumberAxis xAxis, NumberAxis yAxis) {
		super(xAxis, yAxis);

		configureGraph();
		fillData();
	}

	private void configureGraph() {
		setLegendSide(Side.BOTTOM);
		setTitle("Amount bicycle thefts sorted by timestamp");
	}

	/**
	 * Fills data inside of the graph by computing it and transforming it to a suitable presentable format.
	 */
	private void fillData() {
		getXAxis().setLabel("Time");
		Series<Number, Number> series = new Series<>();
		series.setName("Bicycle Thefts");
		series.getData().add(new Data<>(1, 20));
		series.getData().add(new Data<>(2, 25));
		getData().add(series);
	}
}
