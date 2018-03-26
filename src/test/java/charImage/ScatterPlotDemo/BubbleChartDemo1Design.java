/* ---------------------
 * BubbleChartDemo1.java
 * ---------------------
 * (C) Copyright 2003-2009, by Object Refinery Limited.
 */

package charImage.ScatterPlotDemo;

import extend.ChartUtils;
import extend.ExtendedScatterItemLabelGeneratory;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * A bubble chart demo.
 */
public class BubbleChartDemo1Design extends ApplicationFrame {

    /**
     * A demonstration application showing a bubble chart.
     *
     * @param title  the frame title.
     */
    public BubbleChartDemo1Design(String title) {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }

    /**
     * Creates a chart.
     *
     * @param dataset  the dataset.
     *
     * @return The chart.
     */
    private static JFreeChart createChart(XYZDataset dataset) {
        ChartUtils.setChartTheme();
        JFreeChart chart = ChartFactory.createBubbleChart(
                "", "成绩", "等级", dataset,
                PlotOrientation.HORIZONTAL, true, true, false);

        XYPlot plot = (XYPlot) chart.getPlot();
//        plot.setForegroundAlpha(1f);

        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        XYItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(0,0,255,72));
        LegendTitle legend = chart.getLegend();
        legend.setVisible(false);
        renderer.setSeriesOutlinePaint(0, new Color(0,0,0,150));

        plot.setOutlinePaint(new Color(0, 0, 0));
        //plot.setDomainTickBandPaint(new Color(200, 200, 100, 100));
        LegendItemCollection legendItems = plot.getLegendItems();
        plot.setBackgroundPaint(new Color(255,255,255,0));

        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        plot.setDomainCrosshairValue(250);
        plot.setDomainCrosshairPaint(Color.red);

        plot.setRangeCrosshairValue(1.67);
        plot.setRangeCrosshairPaint(Color.RED);

        String arr[] = {"迎泽区","小店区","杏花岭区","清徐县","尖草坪区","全市","晋源区","古交市","万柏林区","娄烦县","阳曲县"};
        renderer.setBaseItemLabelGenerator(new ExtendedScatterItemLabelGeneratory(arr));
        renderer.setBaseToolTipGenerator(new StandardXYZToolTipGenerator());
        renderer.setBaseItemLabelsVisible(true);


        //设置Y轴
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        //设置坐标值
        domainAxis.setRange(190,320);

        //设置x轴
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(1,2.9);
        ChartUtils.setAntiAlias(chart);
        try {
            OutputStream os = new FileOutputStream("company1.png");
            try {
                // 由ChartUtilities生成文件到一个体outputStream中去
                ChartUtilities.writeChartAsPNG(os,chart,500,270);
//                ChartUtilities.writeChartAsJPEG(os, chart, 1500, 1000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return chart;
    }

    /**
     * Creates a sample dataset.
     *
     * @return A sample dataset.
     */
    static double radius = 0.03;
    public static XYZDataset createDataset() {
        DefaultXYZDataset dataset = new DefaultXYZDataset();
        double[] y = {1.2, 1.5, 1.36, 1.7, 1.3, 1.67, 1.58, 2.36, 2.1, 2.2,2.7};
        double[] x = {210, 220, 200, 230, 240, 250, 260, 270, 280, 290,300};
        double[] z = {radius, radius, radius, radius, radius, radius, radius, radius, radius, radius,radius};
        double[][] series = new double[][] { x, y, z };
        dataset.addSeries("Series 1", series);
        return dataset;
    }

    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setDomainZoomable(true);
        chartPanel.setRangeZoomable(true);
        return chartPanel;
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(String[] args) {
        BubbleChartDemo1Design demo = new BubbleChartDemo1Design(
                "JFreeChart: BubbleChartDemo1.java");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}