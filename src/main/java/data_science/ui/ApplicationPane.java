package data_science.ui;

import com.lynden.gmapsfx.GoogleMapView;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import static data_science.ApplicationRoot.RESOLUTION;

/**
 * The root pane.
 * @author I.A
 */
public class ApplicationPane extends BorderPane {
  /**
   * Creates a new {@link ApplicationPane} that renders the given {@link GoogleMapView}.
   */
  public ApplicationPane(GoogleMapView view) {
      // Set Location Labels
      Text locationLabel1 = new Text("Map");

      // Pane voor Map
      GridPane mapPane = new GridPane();

      // Maak Checkboxes
      CheckBox cb = new CheckBox("Show bike thefts");
      cb.setIndeterminate(false);
      CheckBox cb1 = new CheckBox("Show bike thefts with violence");
      cb.setIndeterminate(false);

      // Set padding
      mapPane.setPadding(new Insets(10, 10, 10, 10));
      mapPane.setVgap(5);
      mapPane.setHgap(5);

      // Fill mapPane
      mapPane.add(locationLabel1, 0, 0);
      mapPane.add(cb,1,0);
      mapPane.add(cb1,1,1);
      mapPane.setStyle("-fx-font: normal bold 15px 'serif' ");

      // Maak tabpane
      BorderPane borderpane = new BorderPane();
      TabPane tabpane = new TabPane();
      Tab tab = new Tab();
      tabpane.getTabs().add(tab);
      tab.setGraphic(new Text("Location"));

      // Maak HBoxes voor de Panes
      HBox hbox1 = new HBox();
      hbox1.getChildren().add(mapPane);
      view.setPrefWidth(RESOLUTION.getWidth() * 0.75F);
      view.setPrefHeight(RESOLUTION.getHeight());

      hbox1.setStyle("-fx-background-color: rgba(60,63,65,0.99)");
      hbox1.setPrefWidth(RESOLUTION.getWidth() * 0.25F);

      tabpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
      borderpane.setCenter(tabpane);

      setRight(view);
      setLeft(hbox1);
  }
}
/*
// Set view size
      view.setPrefWidth(RESOLUTION.getWidth() * 0.75F);
      view.setPrefHeight(RESOLUTION.getHeight());

      // Set Location Labels
      Text locationLabel1 = new Text("Map");
      Text locationLabel2 = new Text("Graph");

      // Pane voor Map
      Pane mapPane = new Pane();

      // Set padding
      mapPane.setPadding(new Insets(10, 10, 10, 10));

      // de elementen toevoegen door een plaats toe te wijzen op de grid
      // de grootte van de grid wordt automatisch aangepast
      // (het element, x positie, y positie)
      mapPane.getChildren().addAll(locationLabel1);
      mapPane.getChildren().addAll(view);
      mapPane.setStyle("-fx-font: normal bold 15px 'serif' ");

      // Maak HBoxes voor de Panes
      HBox hbox1 = new HBox();
      hbox1.getChildren().add(mapPane);
      hbox1.setAlignment(Pos.CENTER);

      // Maak een borderpane
      BorderPane borderpane = new BorderPane();

      // Maak tabpane
      TabPane tabpane = new TabPane();

      // Maak 2 tabs, Map en Graph
      Tab tab1 = new Tab();
      tabpane.getTabs().add(tab1);
      tab1.setGraphic(new Text("Map"));
      tab1.setContent(hbox1);
      Tab tab2 = new Tab();
      tabpane.getTabs().add(tab2);
      tab2.setGraphic(new Text("Graph"));


      // Voeg de tabs toe aan de tabpane
      tabpane.getTabs().add(tab1);
      tabpane.getTabs().add(tab2);
      tabpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

      borderpane.setCenter(tabpane);
 */


/*
      Text locationLabel = new Text("Area");
      Text locationLabel1 = new Text("Graphics");

      // Combobox wordt aangemaakt met alle opties die je kan selecteren
      ComboBox locationchoiceBox = new ComboBox(
              FXCollections.observableArrayList("lekker boeiend", "Oud-IJsselmonde", "Groot-IJsselmonde"));
      ComboBox locationchoiceBox1 = new ComboBox(
              FXCollections.observableArrayList("lekker boeiend", "Oud-IJsselmonde", "Groot-IJsselmonde"));
      CheckBox cb = new CheckBox("Show bike thefts");
      cb.setIndeterminate(false);
      CheckBox cb1 = new CheckBox("Show bike thefts with violence");
      cb.setIndeterminate(false);

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

      GridPane gridPane2 = new GridPane();
      gridPane2.setPadding(new Insets(10, 10, 10, 10));
      gridPane2.setVgap(5);
      gridPane2.setHgap(5);
      gridPane2.setAlignment(Pos.CENTER);
      gridPane2.add(locationLabel1, 0, 0);
      gridPane2.add(cb,1,0);
      gridPane2.add(cb1,1,1);
      locationLabel1.setStyle("-fx-font: normal bold 15px 'serif' ");

      gridPane.setStyle("-fx-background-color: BEIGE;");
      BorderPane borderpane = new BorderPane();
      TabPane tabpane = new TabPane();
      Tab tab = new Tab();
      tabpane.getTabs().add(tab);
      tab.setGraphic(new Text("Location"));
      HBox hbox = new HBox();
      hbox.getChildren().add(gridPane);
      hbox.setAlignment(Pos.CENTER);
      tab.setContent(hbox);

      // Add tab 2
      Tab tab2 = new Tab();
      tab2.setGraphic(new Text("Graphs"));
      HBox hbox2 = new HBox();
      hbox2.getChildren().add(gridPane2);
      hbox2.setAlignment(Pos.CENTER);
      tab2.setContent(hbox2);

      tabpane.getTabs().add(tab2);
      tabpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

      //borderpane.prefHeightProperty().bind(scene.heightProperty());
      //borderpane.prefWidthProperty().bind(scene.widthProperty());
      borderpane.setCenter(tabpane);
 */