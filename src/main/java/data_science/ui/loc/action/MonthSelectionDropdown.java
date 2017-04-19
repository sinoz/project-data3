package data_science.ui.loc.action;

import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import data_science.database.query.AllBicycleStalls;
import data_science.model.BicycleStall;
import data_science.ui.ApplicationScene;
import data_science.ui.loc.LocationViewComboPane;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

/**
 * A {@link ComboBox} for a user to select results by month
 * @author Jasper Wijnhoven
 * @author I.A
 */
public final class MonthSelectionDropdown extends ComboBox {
    /**
     * The action bar this combobox belongs to.
     */
    private final LocationViewComboPane comboBox;

    /**
     * Creates a new {@link MonthSelectionDropdown}.
     */
    public MonthSelectionDropdown(LocationViewComboPane locationViewComboBox) {
        this.comboBox = locationViewComboBox;

        this.getItems().addAll(
                "*", "4", "5", "6"
        );
        this.setValue("*");
    }

    /**
     * Reacts to a change of state e.g on user input.
     */
    private void stateChange(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        ApplicationScene scene = (ApplicationScene) getScene();

        boolean enabled = newValue;
        if (enabled) {
            applyMarkers(scene);

            // actionBar.getSafestBicycleStallsBox().setSelected(false);
        } else {
            scene.clearAllMarkers();
        }
    }

    private void applyMarkers(ApplicationScene scene) {
        AllBicycleStalls.compute().subscribe((BicycleStall s) -> {
            Platform.runLater(() -> { // TODO integrate Platform thread with RxJava
                LatLong coordinates = new LatLong(s.getLatitude(), s.getLongitude());

                scene.presentMarker(new MarkerOptions().position(coordinates).visible(Boolean.TRUE));
            });
        });

        scene.clearAllMarkers();
    }
}
