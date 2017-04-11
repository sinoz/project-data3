package data_science.ui;

import com.lynden.gmapsfx.GoogleMapView;
import javafx.scene.layout.BorderPane;
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
  BorderPane borderPane = new BorderPane();
  public ApplicationPane(GoogleMapView view) {

      // Set Location Labels
      Text locationLabel1 = new Text("Checkboxes");
      Text locationLabel2 = new Text("Graphs");

      // Maak GridPanes
      GridPane mapPane = new GridPane();
      GridPane graphPane = new GridPane();

      // Maak Checkboxes
      CheckBox cb = new CheckBox("Show bike thefts");
      cb.setIndeterminate(false);
      CheckBox cb1 = new CheckBox("Show bike thefts with violence");
      cb.setIndeterminate(false);

      // Set padding
      mapPane.setPadding(new Insets(10, 10, 10, 10));
      mapPane.setVgap(5);
      mapPane.setHgap(5);
      graphPane.setPadding(new Insets(10, 10, 10, 10));
      graphPane.setVgap(5);
      graphPane.setHgap(5);

      // Fill mapPane
      mapPane.add(locationLabel1, 0, 0);
      mapPane.add(cb,1,0);
      mapPane.add(cb1,1,1);
      mapPane.setStyle("-fx-font: normal bold 15px 'serif' ");

      // Fill graphPane
      graphPane.add(locationLabel2, 0, 0);
      graphPane.setStyle("-fx-font: normal bold 15px 'serif' ");

      // Maak tabpane & tabs
      BorderPane borderpane = new BorderPane();
      TabPane tabpane = new TabPane();
      Tab tab1 = new Tab();
      tabpane.getTabs().add(tab1);
      tab1.setGraphic(new Text("Map"));
      Tab tab2 = new Tab();
      tabpane.getTabs().add(tab2);
      tab2.setGraphic(new Text("Graph"));

      // Specificeer HBoxes voor de Panes
      HBox hbox1 = new HBox();
      hbox1.getChildren().add(mapPane);

      hbox1.setPrefWidth(RESOLUTION.getWidth() * 0.25F);
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