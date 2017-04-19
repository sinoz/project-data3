package data_science.ui.graph.line;

import data_science.database.query.graph.TheftCountsByTimestampQuery;
import data_science.model.TheftTimestamp;
import javafx.application.Platform;
import javafx.geometry.Side;
import javafx.scene.chart.*;

import java.util.List;

/**
 * A {@link LineChart} to present a graph that shows the theft timestamps.
 *
 * @author I.A
 * @author Jasper Wijnhoven
 */
public final class TheftsByTimestampGraph extends LineChart<String, Number> {
	/**
	 * The amount of timestamps to take and present in the graph from our stream of timestamps.
	 */
	private static final int COMPUTE_LIMIT = 25;

	/**
	 * A factory method to produce a new {@link TheftsByTimestampGraph} chart.
	 */
	public static TheftsByTimestampGraph create() {
		Axis<String> xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();

		xAxis.setLabel("Timestamp");
		yAxis.setLabel("Count");

		return new TheftsByTimestampGraph(xAxis, yAxis);
	}

	/**
	 * Creates a new {@link TheftsByDateGraph}.
	 */
	private TheftsByTimestampGraph(Axis<String> xAxis, NumberAxis yAxis) {
		super(xAxis, yAxis);

		configureGraph();
		fillData();
	}

	/**
	 * Configures this graph.
	 */
	private void configureGraph() {
		setLegendSide(Side.BOTTOM);
		setTitle("Amount (AVG) bicycle thefts sorted by timestamp");
	}

	/**
	 * Fills data inside of the graph by computing it and transforming it to a suitable presentable format.
	 */
	private void fillData() {
		TheftCountsByTimestampQuery.compute()
				.take(COMPUTE_LIMIT) // limit our results
				.toList() // blocks until all data has been computed to turn it into a list of theft timestamps
				.map(this::theftTimestamps2ChartSeries) // transform the list to a suitable presentation format (PieChart.Data)
				.subscribe((XYChart.Series<String, Number> data) -> Platform.runLater(() -> getData().add(data)));
	}

	/**
	 * Transforms the given {@link List} of {@link TheftTimestamp}s to a suitable {@link XYChart.Series}
	 * format that can be presented inside of this graph.
	 */
	private XYChart.Series<String, Number> theftTimestamps2ChartSeries(List<TheftTimestamp> stamps) {
		XYChart.Series<String, Number> series = new XYChart.Series<>();

		series.setName("Bicycle Thefts");

		stamps.stream().map((TheftTimestamp stamp) -> new XYChart.Data<String, Number>(stamp.getTimestamp(), stamp.getCount()))
				.forEach(stringIntegerData -> series.getData().add(stringIntegerData));

		return series;
	}
}