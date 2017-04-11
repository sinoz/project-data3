package graphs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class linechart extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Line Chart Sample");
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Tijdstip");
		yAxis.setLabel("Aantal diefstallen");
		final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

		lineChart.setTitle("Aantal diefstallen per tijdstip");

		XYChart.Series series1 = new XYChart.Series();

		series1.getData().add(new XYChart.Data("0:00", 23));
		series1.getData().add(new XYChart.Data("2:00", 14));
		series1.getData().add(new XYChart.Data("4:00", 15));
		series1.getData().add(new XYChart.Data("6:00", 24));
		series1.getData().add(new XYChart.Data("8:00", 34));
		series1.getData().add(new XYChart.Data("10:00", 36));
		series1.getData().add(new XYChart.Data("12:00", 22));
		series1.getData().add(new XYChart.Data("14:00", 45));
		series1.getData().add(new XYChart.Data("16:00", 43));
		series1.getData().add(new XYChart.Data("18:00", 17));
		series1.getData().add(new XYChart.Data("20:00", 29));
		series1.getData().add(new XYChart.Data("22:00", 25));

		lineChart.setCreateSymbols(false);

		Scene scene = new Scene(lineChart, 800, 600);
		lineChart.getData().addAll(series1);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}