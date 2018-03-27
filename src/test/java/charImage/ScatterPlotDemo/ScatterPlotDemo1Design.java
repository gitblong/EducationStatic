/* ---------------------
 * ScatterPlotDemo1.java
 * ---------------------
 * (C) Copyright 2002-2009, by Object Refinery Limited.
 *
 */

package charImage.ScatterPlotDemo;

import entity.ScatterEntity;
import extend.ChartUtils;
import extend.ExtendedScatterItemLabelGeneratory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
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

/**
 * A demo scatter plot.
 */
public class ScatterPlotDemo1Design extends ApplicationFrame {

    /**
     * A demonstration application showing a scatter plot.
     *
     * @param title  the frame title.
     */
    public ScatterPlotDemo1Design(String title) throws Exception {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }

    private static JFreeChart createChart(XYDataset dataset, ScatterEntity scatterEntity) {
        ChartUtils.setChartTheme();
        JFreeChart chart = ChartFactory.createScatterPlot("",
                scatterEntity.getxAxisLabel(), scatterEntity.getyAxisLabel(), dataset, PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = (XYPlot) chart.getPlot();
        LegendTitle legend = chart.getLegend();
        legend.setVisible(false);

        plot.setOutlinePaint(new Color(0,0,0));
        Shape circle = new Ellipse2D.Double(-5, -5, 8, 8);
        XYPlot xyPlot = (XYPlot) chart.getPlot();
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setBaseShape(circle);
//        renderer.setBaseOutlinePaint(new Color(0,0,0));
        renderer.setBasePaint(Color.red);
        renderer.setSeriesShape(0, circle);
        renderer.setSeriesPaint(0, new Color(0,0,255,72));
        renderer.setSeriesOutlinePaint(0, new Color(0,0,0));
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
        plot.setDomainCrosshairValue(scatterEntity.getY()[scatterEntity.getCityIndex()]);
        plot.setDomainCrosshairPaint(Color.RED);

        //横轴虚线
        plot.setRangeCrosshairValue(scatterEntity.getX()[scatterEntity.getCityIndex()]);
        plot.setRangeCrosshairPaint(Color.RED);

        //设置Y轴范围
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        //设置坐标值
        System.out.println(scatterEntity.getMaxRange());
        domainAxis.setRange(scatterEntity.getMinRange(),scatterEntity.getMaxRange());
        domainAxis.setTickUnit(new NumberTickUnit(0.2));
        //设置x轴范围
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        System.out.println(scatterEntity.getMaxDomain());
        rangeAxis.setRange(scatterEntity.getMinDomain(),scatterEntity.getMaxDomain());
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
        double[] x = scatterEntity.getY();
        double[] y = scatterEntity.getX();double[] z = new double[x.length];
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
        double[] y = {1.2, 1.5, 1.36, 1.7, 1.3, 1.67, 1.58, 2.36, 2.1, 2.2, 2.7};
        double[] x = {210, 220, 200, 230, 240, 250, 260, 270, 280, 290, 300};
        String[] labelValue = {"1","2","3","4","5","6","7","8","9","10","11",};


        ScatterEntity scatterEntity = new ScatterEntity();
        scatterEntity.setX(x);
        scatterEntity.setY(y);

        scatterEntity.setCityIndex(1);
        scatterEntity.setLabeValues(labelValue);
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
        ScatterPlotDemo1Design demo = new ScatterPlotDemo1Design(
                "JFreeChart: ScatterChart.java");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}