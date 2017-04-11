package data_science;

import com.lynden.gmapsfx.GoogleMapView;
import data_science.database.HikariDbService;
import data_science.ui.map.MapViewScene;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The main entry point to this application.
 * @author I.A
 */
public final class ApplicationRoot extends Application {
  /**
   * The default resolution of this application.
   */
  public static Rectangle2D RESOLUTION;

  /**
   * The {@link GoogleMapView} to present a map on.
   */
  private GoogleMapView mapView;

  /**
   * The current {@link Scene} to present.
   */
  private Scene scene;

  @Override
  public void start(Stage stage) throws Exception {
    RESOLUTION = Screen.getPrimary().getVisualBounds(); // TODO turn into a constant

    initDbService();
    initUserInterface();

    configure(stage);
  }

  /**
   * Initializes the {@link HikariDbService}.
   */
  private void initDbService() {
    //HikariDbService.initialize();
  }

  /**
   * Initializes the user interface.
   */
  private void initUserInterface() {
    if (mapView != null || scene != null) {
      throw new IllegalStateException();
    }

    mapView = new GoogleMapView();
    scene = new MapViewScene(mapView);
  }

  /**
   * Configures the given {@link Stage}.
   */
  private void configure(Stage stage) {
    {
      stage.setMinWidth(RESOLUTION.getWidth() / 2);
      stage.setMinHeight(RESOLUTION.getHeight() * 0.75);

      stage.setWidth(RESOLUTION.getWidth());
      stage.setHeight(RESOLUTION.getHeight());
    }

    stage.setResizable(true);

    stage.setTitle("FX");
    stage.setScene(scene);

    stage.show();
  }
}