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