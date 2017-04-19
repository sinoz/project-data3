package data_science.ui.info;

import data_science.ui.CategorizedTab;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Information about the creators of this Application
 * @author Jasper Wijnhoven
 */
public final class InformationViewTab extends CategorizedTab {
    /**
     * The corresponding {@link InformationViewPane}.
     */
    private final InformationViewPane pane;

    /**
     * Creates a new {@link InformationViewTab}.
     */
    public InformationViewTab() {
        super("Informatie");
        this.pane = new InformationViewPane();
        setContent(this.pane);
    }

    protected Paint textColor() {
        return Color.WHITE;
    }
}
