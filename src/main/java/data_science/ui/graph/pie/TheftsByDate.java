package data_science.ui.graph.pie;

import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;

import java.text.DecimalFormat;
import java.util.List;

/**
 * A {@link LineChart} to present a graph that shows the theft dates.
 * @author I.A
 * @author Jasper Wijnhoven
 */
public final class TheftsByDate extends LineChart {

    /**
     * A factory method to produce a new {@link TheftsByDate} chart.
     */
    public static TheftsByDate create() {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Date");
        yAxis.setLabel("Count");

        return new TheftsByDate(xAxis, yAxis);
    }

    /**
     * Creates a new {@link TheftsByDate}.
     */
    private TheftsByDate(NumberAxis xAxis, NumberAxis yAxis) {
        super(xAxis, yAxis);

        configureGraph();
        fillData();
    }

    private void configureGraph() {
        setLegendSide(Side.BOTTOM);
        setTitle("Aantal fietsdiefstallen per datum");
    }

    /**
     * Fills data inside of the graph by computing it and transforming it to a suitable presentable format.
     */
    private void fillData() {
        getXAxis().setLabel("Dag");
        XYChart.Series series = new XYChart.Series();
        series.setName("Fietsdiefstallen");
        series.getData().add(new XYChart.Data(1,20));
        series.getData().add(new XYChart.Data(2,25));
        getData().add(series);
    }
}
