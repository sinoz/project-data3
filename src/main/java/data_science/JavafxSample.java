package data_science;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavafxSample extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		// stukje text om aan te geven waar de box voor is
		Text locationLabel = new Text("location");

		// Combobox wordt aangemaakt met alle opties die je kan selecteren
		ComboBox locationchoiceBox = new ComboBox(
				FXCollections.observableArrayList("lekker boeiend", "Oud-IJsselmonde", "Groot-IJsselmonde"));
		// locationchoiceBox.getItems().addAll("Hyderabad", "Chennai", "Delhi",
		// "Mumbai", "Vishakhapatnam");
		ComboBox locationchoiceBox1 = new ComboBox(
				FXCollections.observableArrayList("lekker boeiend", "Oud-IJsselmonde", "Groot-IJsselmonde"));

		// Grid Pane cre�eren voor de positie van alle elementen
		GridPane gridPane = new GridPane();

		// de padding zodat niet alles tegen de rand van de window aan ligt
		gridPane.setPadding(new Insets(10, 10, 10, 10));

		// zorgen dat er ruimte is tussen de element zodat ze niet tegen elkaar
		// aan liggen
		gridPane.setVgap(5);
		gridPane.setHgap(5);

		// positie van de grid ten op zichte van het scherm
		gridPane.setAlignment(Pos.CENTER);

		// de elementen toevoegen door een plaats toe te wijzen op de grid
		// de grootte van de grid wordt automatisch aangepast
		// (het element, x positie, y positie)
		gridPane.add(locationLabel, 0, 0);
		gridPane.add(locationchoiceBox, 0, 1);
		gridPane.add(locationchoiceBox1, 1, 1);
		locationLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
		// zorgt ervoor dat er al een optie is gekozen in de combobox
		locationchoiceBox.setValue("lekker boeiend");

		gridPane.setStyle("-fx-background-color: BEIGE;");
		Scene scene = new Scene(gridPane);

		stage.setTitle("Registration Form");

		stage.setScene(scene);

		stage.show();

	}

	public static void main(String args[]) {
		launch(args);
	}
}