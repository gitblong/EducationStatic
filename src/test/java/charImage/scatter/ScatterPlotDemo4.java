package charImage.scatter;

import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.renderer.xy.XYDotRenderer;
;


/**
 * A simple demonstration application showing how to create a line chart using
 * data from an {@link XYDataset}.
 * <p>
 * IMPORTANT NOTE: THIS DEMO IS DOCUMENTED IN THE JFREECHART DEVELOPER GUIDE.
 * DO NOT MAKE CHANGES WITHOUT UPDATING THE GUIDE ALSO!!
 */
public class ScatterPlotDemo4 extends JDialog {//ApplicationFrame {

    /**
     * Creates a new demo.
     *
     * @param title the frame title.
     */

    public ScatterPlotDemo4(String title) {
//super(title);
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }

    /**
     * Creates a sample dataset.
     *
     * @return a sample dataset.
     */
    private static XYDataset createDataset() {
//XYSeries series1 = new XYSeries("First");
        XYSeries series1 = new XYSeries("");
        series1.add(1.0, 1.0);
        series1.add(1.0, 7.0);
        series1.add(1.0, 2.0);
        series1.add(1.0, 3.0);
        series1.add(1.0, 4.0);
        series1.add(1.0, 5.0);
        series1.add(1.0, 6.0);
        series1.add(3.0, 3.0);
        series1.add(3.0, 2.0);
        series1.add(3.0, 1.0);
        series1.add(3.0, 5.0);
        series1.add(3.0, 6.0);
        series1.add(5.0, 1.0);
        series1.add(5.0, 3.0);
        series1.add(5.0, 2.0);
        series1.add(5.0, 7.0);
        series1.add(5.0, 9.0);

        series1.add(6.0, 2.0);
        series1.add(6.0, 3.0);
        series1.add(6.0, 5.0);
        series1.add(6.0, 8.0);
        series1.add(6.0, 9.0);
        series1.add(6.0, 10.0);

        series1.add(12.0, 4.0);

        series1.add(10.0, 5.0);


        series1.add(7.0, 2.0);
        series1.add(7.0, 4.0);
        series1.add(7.0, 6.0);


        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);

        return dataset;
    }

    /**
     * Creates a chart.
     *
     * @param dataset the data for the chart.
     * @return a chart.
     */
    private static JFreeChart createChart(XYDataset dataset) {
// create the chart...
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Range vs Time", // chart title
                "Time(uSec)", // x axis label
                "Range", // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
        );
        chart.clearSubtitles();// hai add
// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) chart.getPlot();
        XYDotRenderer render = new XYDotRenderer();
        render.setDotWidth(5);
        render.setDotHeight(5);
        plot.setRenderer(render);
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);


// change the auto tick unit selection to integer units only...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
// OPTIONAL CUSTOMISATION COMPLETED.

        Axis axis = plot.getDomainAxis();
        axis.setTickMarksVisible(true);
// axis.setTickMarksVisible(false);
        return chart;


    }
/**
 * Creates a panel for the demo (used by SuperDemo.java).
 *
 * @return A panel.
 */
/*public static JPanel createDemoPanel() {
JFreeChart chart = createChart(createDataset());
return new ChartPanel(chart);
}*/

    /**
     * Starting point for the demonstration application.
     *
     * @param args ignored.
     */
    public static void main(String[] args) {
        ScatterPlotDemo4 demo = new ScatterPlotDemo4("Range vs Time");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}