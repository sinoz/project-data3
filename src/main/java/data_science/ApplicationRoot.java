package data_science;

import com.lynden.gmapsfx.GoogleMapView;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The main entry point to this application.
 * @author I.A
 */
public final class ApplicationRoot extends Application {
  /**
   * An {@link ExecutorService} to submit I/O tasks to.
   */
  private static ExecutorService ioService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

  /**
   * The default resolution of this application.
   */
  private final Rectangle2D RESOLUTION = Screen.getPrimary().getVisualBounds();

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
    mapView = new GoogleMapView();
    scene = new MapViewScene(mapView);

    configure(stage);
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

  /**
   * Returns the {@link ExecutorService} used to do I/O work on.
   */
  public static ExecutorService getIoService() {
    return ioService;
  }
}
