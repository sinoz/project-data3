package data_science.ui.stat;

import data_science.ui.CategorizedTab;

/**
 * A {@link CategorizedTab} to showcase the {@link StatisticsViewPane}.
 * @author I.A
 */
public final class StatisticsPaneTab extends CategorizedTab {
	/**
	 * The {@link StatisticsViewPane} showcasing the different types of data graphs.
	 */
	private final StatisticsViewPane pane;

	/**
	 * Creates a new {@link StatisticsPaneTab}.
	 */
	public StatisticsPaneTab() {
		super("Graphs");

		this.pane = new StatisticsViewPane();

		applyStyling();
		setContent(pane);
	}

	private void applyStyling() {
		//setStyle("-fx-background-color: rgba(60,63,65,0.99)");
	}
}
