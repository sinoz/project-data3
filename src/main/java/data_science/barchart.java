package graphs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class barchart extends Application {
	final static String district = "district";
	final static String werkgebied = "werkgebied";
	final static String plaats = "plaats";
	final static String buurt = "buurt";

	@Override
	public void start(Stage stage) {
		stage.setTitle("Bar Chart Sample");
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
		bc.setTitle("Diefstallen per regio 2013");
		xAxis.setLabel("Regio");
		yAxis.setLabel("Aantal diefstallen");

		XYChart.Series series1 = new XYChart.Series();

		series1.getData().add(new XYChart.Data(district, 25601.34));
		series1.getData().add(new XYChart.Data(werkgebied, 20148.82));
		series1.getData().add(new XYChart.Data(plaats, 10000));
		series1.getData().add(new XYChart.Data(buurt, 35407.15));

		Scene scene = new Scene(bc, 800, 600);
		bc.getData().addAll(series1);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}