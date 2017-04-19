package data_science.ui.info;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * @author Jasper Wijnhoven
 */
public final class InformationViewPane extends GridPane {

    /**
     * Creates a new {@link InformationViewPane}.
     */
    InformationViewPane() {
        setStyle();
        setContent();
    }

    private void setContent() {
        add(new Text("Naam"),0,0);
        add(new Text(""),0,1);
        add(new Text("Ilyas Baas"),0,2);
        add(new Text("Jasper Wijnhoven"),0,3);
        add(new Text("Xin Hao Xia"),0,4);
        add(new Text("Dino Becker"),0,5);
        add(new Text("Johan Bastinck"),0,6);

        add(new Text("Gedaan"),1,0);
        add(new Text(""),1,1);
        add(new Text("TODO"),1,2);
        add(new Text("Checkboxes, Comboboxes, Linechart, Tabs"),1,3);
        add(new Text("Samples"),1,4);
        add(new Text("CSS"),1,5);
        add(new Text("Samples"),1,6);
    }

    private void setStyle() {
        setStyle("-fx-font: normal 15px 'Segoe UI'");
        setPadding(new Insets(10, 10, 10, 10));
        setVgap(7);
        setHgap(20);
    }
}
