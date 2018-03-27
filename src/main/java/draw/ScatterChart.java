/* ---------------------
 * ScatterPlotDemo1.java
 * ---------------------
 * (C) Copyright 2002-2009, by Object Refinery Limited.
 *
 */

package draw;

import entity.ScatterEntity;
import extend.ChartUtils;
import extend.ExtendedScatterItemLabelGeneratory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Collections;

/**
 * A demo scatter plot.
 */
public class ScatterChart extends ApplicationFrame {

    /**
     * A demonstration application showing a scatter plot.
     *
     * @param title  the frame title.
     */
    public ScatterChart(String title) throws Exception {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }

    public static JFreeChart createChart(XYDataset dataset, ScatterEntity scatterEntity) {
        ChartUtils.setChartTheme();
        JFreeChart chart = ChartFactory.createScatterPlot("",
                scatterEntity.getyAxisLabel(), scatterEntity.getxAxisLabel(), dataset, PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = (XYPlot) chart.getPlot();
        LegendTitle legend = chart.getLegend();
        legend.setVisible(false);

        plot.setOutlinePaint(new Color(0,0,0));
        Shape circle = new Ellipse2D.Double(-4, -4, 8, 8);


        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        //渲染
        XYItemRenderer renderer = plot.getRenderer();
        //设置点颜色，设置边框
        renderer.setSeriesShape(0,circle);
        renderer.setSeriesPaint(0, new Color(0,0,255,72));
        renderer.setSeriesStroke(0, new BasicStroke(2f, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND, 0.0f, new float[]{4.0f, 8.0f}, 0.3f));

        /**
         * 设置点的边框
         */
        XYLineAndShapeRenderer rendererXY
                = (XYLineAndShapeRenderer) plot.getRenderer();
        rendererXY.setSeriesOutlinePaint(0, new Color(0,0,0,150));
        rendererXY.setUseOutlinePaint(true);


        //为每个点设置标签名labelValue
        renderer.setBaseItemLabelGenerator(new ExtendedScatterItemLabelGeneratory(scatterEntity.getLabeValues()));
        renderer.setBaseToolTipGenerator(new StandardXYZToolTipGenerator());
        renderer.setBaseItemLabelsVisible(true);

        // set only shape of series with index i

        //横轴纵轴虚线
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        //纵轴虚线
        plot.setDomainCrosshairValue(scatterEntity.getX()[scatterEntity.getCityIndex()]);
        plot.setDomainCrosshairPaint(Color.RED);

        //横轴虚线
        plot.setRangeCrosshairValue(scatterEntity.getY()[scatterEntity.getCityIndex()]);
        plot.setRangeCrosshairPaint(Color.RED);

        //设置Y轴范围
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        //设置坐标值
        System.out.println(scatterEntity.getMaxRange());
        domainAxis.setRange(scatterEntity.getMinDomain(),scatterEntity.getMaxDomain());
//        domainAxis.setTickUnit(new NumberTickUnit(0.2));
        //设置x轴范围
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        System.out.println(scatterEntity.getMaxDomain());
        rangeAxis.setRange(scatterEntity.getMinRange(),scatterEntity.getMaxRange());
        ChartUtils.setAntiAlias(chart);

        return chart;
    }

    /**
     * Creates a sample dataset.
     *
     * @return A sample dataset.
     */
        static double radius = 0;
    public static XYZDataset createDataset(ScatterEntity scatterEntity) {
        DefaultXYZDataset dataset = new DefaultXYZDataset();
        double[] y = scatterEntity.getY();
        double[] x = scatterEntity.getX();
        double[] z = new double[x.length];
        for (int i = 0;i<x.length;i++) {
            z[i] = radius;
        }

        double[][] series = new double[][] {x,y,z};
        dataset.addSeries("Series 1", series);
        return dataset;
    }

    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public JPanel createDemoPanel() throws Exception {
        double[] x = {1.2, 1.5, 1.36, 1.7, 1.3, 1.67, 1.58, 2.36, 2.1, 2.2, -10};
        double[] y = {210, 220, 200, 230, 240, 250, 260, 270, 280, 290, 1000};
        String[] labelValue = {"1","2","3","4","5","6","7","8","9","10","11",};


        ScatterEntity scatterEntity = new ScatterEntity(x,y,labelValue,"","");

        scatterEntity.setCityIndex(1);
System.out.println(scatterEntity.toString());
        JFreeChart chart = createChart(createDataset(scatterEntity),scatterEntity);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(String[] args) throws Exception {
        ScatterChart demo = new ScatterChart(
                "JFreeChart: ScatterChart.java");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

    public static JFreeChart drawChart(ScatterEntity scatterEntity) {
        return createChart(createDataset(scatterEntity), scatterEntity);
    }
}