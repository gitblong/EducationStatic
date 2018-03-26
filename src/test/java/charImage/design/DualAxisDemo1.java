/* ------------------
 * DualAxisDemo1.java
 * ------------------
 * (C) Copyright 2002-2008, by Object Refinery Limited.
 *
 */

package charImage.design;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a dual axis chart
 * based on data from two {@link CategoryDataset} instances.
 */
public class DualAxisDemo1 extends ApplicationFrame {

    /**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     */
    public DualAxisDemo1(String title) {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }


    /**
     * Creates a sample dataset.
     *
     * @return  The dataset.
     */
    private static CategoryDataset createDataset1() {

        // row keys...
        String series1 = "S1";
        String series2 = "S2";
        String series3 = "S3";

        // column keys...
        String category1 = "Category 1";
        String category2 = "Category 2";
        String category3 = "Category 3";
        String category4 = "Category 4";

        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        dataset.addValue(582.98, series2, category1);
        dataset.addValue(551.55, series2, category2);
        dataset.addValue(544.33, series2, category3);
        dataset.addValue(552.26, series2, category4);

        return dataset;

    }

    /**
     * Creates a sample dataset.
     *
     * @return  The dataset.
     */
    private static CategoryDataset createDataset2() {

        // row keys...
        String series1 = "S4";

        // column keys...
        String category1 = "Category 1";
        String category2 = "Category 2";
        String category3 = "Category 3";
        String category4 = "Category 4";

        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(582.98, series1, category1);
        dataset.addValue(551.55, series1, category2);
        dataset.addValue(544.33, series1, category3);
        dataset.addValue(552.26, series1, category4);

        return dataset;

    }

    /**
     * Creates the demo chart.
     *
     * @return The chart.
     */
    private static JFreeChart createChart() {
        // create the chart...
        JFreeChart chart = ChartFactory.createBarChart(
            "DualAxisDemo1",          // chart title
            "Category",               // domain axis label
            "Value",                  // range axis label
            createDataset1(),         // data
            PlotOrientation.VERTICAL,
            false,                    // include legend
            true,                     // tooltips?
            false                     // URL generator?  Not required...
        );


        // get a reference to the plot for further customisation...
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        CategoryDataset dataset2 = createDataset2();
        plot.setDataset(1, dataset2);
        plot.mapDatasetToRangeAxis(1, 1);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        ValueAxis axis2 = new NumberAxis("Secondary");
        axis2.setRangeAboutValue(500,200);
        plot.setRangeAxis(1, axis2);



        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setRangeAboutValue(500,200);

        LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
        renderer2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        plot.setRenderer(1, renderer2);
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

//        LegendTitle legend1 = new LegendTitle(plot.getRenderer(0));
//        legend1.setMargin(new RectangleInsets(2, 2, 2, 2));
//        legend1.setFrame(new BlockBorder());

//        LegendTitle legend2 = new LegendTitle(plot.getRenderer(1));
//        legend2.setMargin(new RectangleInsets(2, 2, 2, 2));
//        legend2.setFrame(new BlockBorder());

//        BlockContainer container = new BlockContainer(new BorderArrangement());
//        container.add(legend1, RectangleEdge.LEFT);
//        container.add(legend2, RectangleEdge.RIGHT);
//        container.add(new EmptyBlock(2000, 0));
//        CompositeTitle legends = new CompositeTitle(container);
//        legends.setPosition(RectangleEdge.BOTTOM);
//        chart.addSubtitle(legends);

        ChartUtilities.applyCurrentTheme(chart);
        return chart;
    }

    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart();
        return new ChartPanel(chart);
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(String[] args) {
        DualAxisDemo1 demo = new DualAxisDemo1(
                "JFreeChart: DualAxisDemo1.java");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}