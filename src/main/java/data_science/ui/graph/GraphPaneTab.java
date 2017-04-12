package data_science.ui.graph;

import data_science.ui.CategorizedTab;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * A {@link CategorizedTab} to showcase the {@link GraphViewPane}.
 * @author I.A
 */
public final class GraphPaneTab extends CategorizedTab {
	/**
	 * The {@link GraphViewPane} showcasing the different types of data graphs.
	 */
	private final GraphViewPane pane;

	/**
	 * Creates a new {@link GraphPaneTab}.
	 */
	public GraphPaneTab() {
		super("Statistieken");

		this.pane = new GraphViewPane();

		applyStyling();
		setContent(pane);
	}

	private void applyStyling() {
		setStyle("-fx-background-color: rgba(60,63,65,0.99)");
	}

	@Override
	protected Paint textColor() {
		return Color.WHITE;
	}
}
