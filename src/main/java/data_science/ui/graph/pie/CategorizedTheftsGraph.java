package data_science.ui.graph.pie;

import data_science.database.query.graph.CategorizedTheftCounts;
import data_science.model.TheftCategory;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;

import java.text.DecimalFormat;
import java.util.List;

/**
 * A {@link PieChart} to present a graph that shows the theft counts
 * for each category.
 * @author I.A
 */
public final class CategorizedTheftsGraph extends PieChart {
	/**
	 * The decimal format to present percentages.
	 */
	private static final String FORMAT = "#.##";

	/**
	 * Creates a new {@link CategorizedTheftsGraph}.
	 */
	public CategorizedTheftsGraph() {
		configureGraph();
		fillData();
	}

	/**
	 * Configures this graph.
	 */
	private void configureGraph() {
		setLegendSide(Side.BOTTOM);
		setTitle("Amount Bicycle Thefts Sorted By Category");
		setClockwise(true);
		setLabelsVisible(true);
		setLabelLineLength(40);
	}

	/**
	 * Fills data inside of the graph by computing it and transforming it to a suitable presentable format.
	 */
	private void fillData() {
		CategorizedTheftCounts.compute() // initiates a stream of data of categorized theft counts
				.toList() // blocks until all data has been computed to turn it into a list of theft categories
				.map(this::theftCategoriesToPieChartData) // transform the list to a suitable presentation format (PieChart.Data)
				.subscribe((ObservableList<Data> data) -> Platform.runLater(() -> setData(data))); // then finally present it
	}

	/**
	 * Transforms the given {@link List} of {@link TheftCategory}s to a suitable {@link ObservableList}
	 * format that can be presented inside of this graph.
	 */
	private ObservableList<Data> theftCategoriesToPieChartData(List<TheftCategory> theftCategories) {
		ObservableList<Data> data = FXCollections.observableArrayList();

		// we utilize a functional data stream here to sum up the counts of each category to obtain a total of theft counts
		double total = theftCategories.stream().mapToInt(TheftCategory::getCount).sum();

		// and here we add data imperatively to the ObservableList for the sake of readability
		DecimalFormat df = new DecimalFormat(FORMAT);
		for (TheftCategory category : theftCategories) {
			double percentage = ((double) category.getCount() / total) * 100D;

			data.add(new Data(category.getName() + " - " + df.format(percentage) + "%", percentage));
		}

		return data;
	}
}
