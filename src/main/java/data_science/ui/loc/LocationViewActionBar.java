package data_science.ui.loc;

import data_science.ui.loc.action.BicycleStallsCheckBox;
import data_science.ui.loc.action.LeastSafeBicycleStallsBox;
import data_science.ui.loc.action.SafestBicycleStallsCheckBox;
import data_science.ui.loc.action.TheftsFromStallsCheckBox;
import data_science.ui.loc.text.SelectText;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

/**
 * A {@link GridPane} that acts as an action bar on the side left to the google maps.
 *
 * @author I.A
 * @author Jasper Wijnhoven
 */
public final class LocationViewActionBar extends GridPane {
  /**
   * A checkbox to toggle whether to showcase all bicycle stalls.
   */
  private final CheckBox bicycleStalls = new BicycleStallsCheckBox(this);

  /**
   * A checkbox to toggle whether to showcase bike thefts that occurred at bicycle stalls.
   */
  private final CheckBox bicycleTheftsFromStalls = new TheftsFromStallsCheckBox(this);

  /**
   * A checkbox to toggle whether to showcase the top 3 safest bicycle stalls.
   */
  private final CheckBox top5SafestBicycleStalls = new SafestBicycleStallsCheckBox(this);

  /**
   * A checkbox to toggle whether to showcase the top 5 least safe bicycle stalls.
   */
  private final CheckBox top5LeastSafeBicycleStalls = new LeastSafeBicycleStallsBox(this);

  /**
   * Creates a new {@link LocationViewActionBar}.
   */
  LocationViewActionBar() {
    addPadding();
    addSubordinates();
    applyStyling();
  }

  private void applyStyling() {
    setStyle("-fx-font: normal 15px 'Segoe UI'");
  }

  private void addSubordinates() {
    add(new SelectText(), 1, 0);
    add(bicycleStalls, 1, 1);
    add(bicycleTheftsFromStalls, 1, 2);
    add(top5SafestBicycleStalls, 1, 3);
    add(top5LeastSafeBicycleStalls, 1, 4);
  }

  private void addPadding() {
    setPadding(new Insets(20, 10, 10, 15));
    setVgap(5);
    setHgap(5);
  }

  public CheckBox getSafestBicycleStallsBox() {
    return top5SafestBicycleStalls;
  }

  public CheckBox getBicycleStallsBox() {
    return bicycleStalls;
  }

  public CheckBox getBicycleTheftsFromStallsBox() {
    return bicycleTheftsFromStalls;
  }

  public CheckBox getLeastSafeBicycleStallsBox() {
    return top5LeastSafeBicycleStalls;
  }
}
