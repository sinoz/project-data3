package samples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class piechart extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("geweldige fietsdiefstallen");

		// piechart aanmaken
		PieChart pieChart = new PieChart();

		// slices creeeren
		PieChart.Data slice1 = new PieChart.Data("diefstallen zonder geweld", 213);
		PieChart.Data slice2 = new PieChart.Data("diefstallen met geweld", 67);

		// slices toevoegen aan de piechart
		pieChart.getData().add(slice1);
		pieChart.getData().add(slice2);

		VBox vbox = new VBox(pieChart);

		Scene scene = new Scene(vbox, 400, 200);

		primaryStage.setScene(scene);
		primaryStage.setHeight(300);
		primaryStage.setWidth(1200);

		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}