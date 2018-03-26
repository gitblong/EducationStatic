/* ------------------
 * DualAxisDemo1.java
 * ------------------
 * (C) Copyright 2002-2008, by Object Refinery Limited.
 *
 */

package charImage.design;

import extend.ChartUtils3_2;
import extend.PathConfig;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;

/**
 * A simple demonstration application showing how to create a dual axis chart
 * based on data from two {@link CategoryDataset} instances.
 */
public class DualAxisDemo1Design extends ApplicationFrame {

    private static Color barColor = new Color(122,122,122);
    private static Color lineColor= new Color(245,193,0);

    /**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     */
    public DualAxisDemo1Design(String title) {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(600, PathConfig.IMAGEHEIGHT));
        setContentPane(chartPanel);
    }


    /**
     * Creates a sample dataset.
     *
     * @return  The dataset.
     */
    private static CategoryDataset createDataset1() {

        // row keys...
        String series2 = "S2";

        // column keys...
        String category1 = "感觉很不好";
        String category2 = "感觉较不好";
        String category3 = "感觉较好";
        String category4 = "感觉很好";

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
        String series1 = "S2";

        // column keys...
        String category1 = "感觉很不好";
        String category2 = "感觉较不好";
        String category3 = "感觉较好";
        String category4 = "感觉很好";

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
        ChartUtils3_2.setChartTheme();
        JFreeChart chart = ChartFactory.createBarChart(
                "",          // chart title
                "",               // domain axis label
                "",                  // range axis label
                createDataset1(),         // data
                PlotOrientation.VERTICAL,
                false,                    // include legend
                true,                     // tooltips?
                false                     // URL generator?  Not required...
        );
        ChartUtils3_2.setAntiAlias(chart);

        //得到画板
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        //将折线图插入柱状图
        CategoryDataset dataset2 = createDataset2();
        plot.setDataset(1, dataset2);
        plot.mapDatasetToRangeAxis(1, 1);

        //设置折线Y轴范围
        ValueAxis axis2 = new NumberAxis();
        axis2.setRange(520, 590);
        axis2.setVisible(false);
        plot.setRangeAxis(1, axis2);
//设置网格线
        plot.setRangeGridlineStroke(new BasicStroke(1.0f));
        CategoryAxis domainAxis = plot.getDomainAxis();

        //设置Y轴刻度间距为10
        NumberAxis rangeAxis1 = new NumberAxis();
        rangeAxis1.setTickUnit(new NumberTickUnit(10));
        plot.setRangeAxis(rangeAxis1);

        //设置柱状图Y轴范围
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setRange(520, 590);

        //分类轴边距
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setCategoryMargin(0.5);
        plot.setDomainAxis(categoryAxis);

        //设置柱体颜色
        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, barColor);
        renderer.setShadowVisible(false);
        renderer.setBarPainter(new StandardBarPainter());
        plot.setRenderer(renderer);

        //折线颜色与虚线设置
        LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
        renderer2.setSeriesStroke(0, new BasicStroke(2f, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND, 0.0f, new float[]{4.0f, 8.0f}, 0.3f));
        renderer2.setSeriesPaint(0, new Color(245, 193, 0));
        renderer2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());

        plot.setRenderer(1, renderer2);
        //设置折线图在柱状图上
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

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
        DualAxisDemo1Design demo = new DualAxisDemo1Design(
                "JFreeChart: DualAxisDemo1.java");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}