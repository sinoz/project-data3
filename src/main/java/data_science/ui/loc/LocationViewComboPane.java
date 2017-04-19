package data_science.ui.loc;

import data_science.ui.loc.action.*;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * A {@link GridPane} that acts as an action bar on the side left to the google maps.
 * @author I.A
 * @author Jasper Wijnhoven
 */
public final class LocationViewComboPane extends GridPane {
    /**
     * Dropdown menu to select a month.
     */
    private final ComboBox selectMonth = new MonthSelectionDropdown(this);

    /**
     * Dropdown menu to select a day.
     */
    private final ComboBox selectDay = new DaySelectionDropdown(this);

    /**
     * Text for Dropdown month.
     */
    private final Text monthLabel = new Text("Month");

    /**
     * Text for Dropdown day.
     */
    private final Text dayLabel = new Text("Day");

    /**
     * Creates a new {@link LocationViewActionBar}.
     */
    LocationViewComboPane() {
        addPadding();
        addSubordinates();
        applyStyling();
    }

    private void applyStyling() {
        setStyle("-fx-font: normal bold 16px 'Segoe UI' ");
    }

    private void addSubordinates() {
        add(monthLabel,0,0);
        add(selectMonth,0,1);
        add(dayLabel,1,0);
        add(selectDay,1,1);
    }

    private void addPadding() {
        setPadding(new Insets(10, 10, 10, 0));
        setVgap(5);
        setHgap(25);
    }
}
