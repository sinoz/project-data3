package samples;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavafxSample extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root,500,300,Color.WHITE);
		// stukje text om aan te geven waar de box voor is
		Text locationLabel = new Text("location");

		// Combobox wordt aangemaakt met alle opties die je kan selecteren
		ComboBox locationchoiceBox = new ComboBox(
				FXCollections.observableArrayList("Test", "Oud-IJsselmonde", "Groot-IJsselmonde"));
		CheckBox cb = new CheckBox("show/hide bike thefts");
		cb.setIndeterminate(false);
		// locationchoiceBox.getItems().addAll("Hyderabad", "Chennai", "Delhi",
		// "Mumbai", "Vishakhapatnam");
		ComboBox locationchoiceBox1 = new ComboBox(
				FXCollections.observableArrayList("Eerste optie", "Oud-IJsselmonde", "Groot-IJsselmonde"));
		
		// Grid Pane creëeren voor de positie van alle elementen
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
		gridPane.add(cb,2,0);
		locationLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
		// zorgt ervoor dat er al een optie is gekozen in de combobox
		locationchoiceBox.setValue("lekker boeiend");

		gridPane.setStyle("-fx-background-color: BEIGE;");
		BorderPane borderpane = new BorderPane();
		TabPane tabpane = new TabPane();
		Tab tab = new Tab();
		tab.setGraphic(new Text("locatie"));
		HBox hbox = new HBox();
		hbox.getChildren().add(gridPane);
		hbox.setAlignment(Pos.CENTER);
		tab.setContent(hbox);
		tabpane.getTabs().add(tab);
		tabpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		//borderpane.prefHeightProperty().bind(scene.heightProperty());
		//borderpane.prefWidthProperty().bind(scene.widthProperty());
		borderpane.setCenter(tabpane);
		root.getChildren().add(borderpane);

		stage.setTitle("leuke dingen");

		stage.setScene(scene);

		stage.show();

	}

	public static void main(String args[]) {
		launch(args);
	}
}
