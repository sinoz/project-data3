package data_science.ui.graph;

import data_science.ui.CategorizedTab;

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

		setContent(pane);
	}
}
