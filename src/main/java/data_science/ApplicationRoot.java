package data_science;

import javafx.application.Application;
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
  private final Dimension RESOLUTION = new Dimension(800, 600);

  @Override
  public void start(Stage primaryStage) throws Exception {
    configure(primaryStage);
  }

  /**
   * Configures the {@link Stage} for this application.
   */
  private void configure(Stage stage) {
    {
      stage.setMinWidth(RESOLUTION.getWidth());
      stage.setMinHeight(RESOLUTION.getHeight());

      stage.setWidth(RESOLUTION.getWidth());
      stage.setHeight(RESOLUTION.getHeight());
    }

    stage.setResizable(false);
    stage.show();
  }

  /**
   * Returns the {@link ExecutorService} used to do I/O work on.
   */
  public static ExecutorService getIoService() {
    return ioService;
  }
}
