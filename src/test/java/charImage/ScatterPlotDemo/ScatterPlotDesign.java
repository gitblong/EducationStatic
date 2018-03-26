/* ---------------------
 * ScatterPlotDemo4.java
 * ---------------------
 * (C) Copyright 2004-2008, by Object Refinery Limited.
 *
 */

package charImage.ScatterPlotDemo;

import extend.ChartUtils;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * A scatter plot demo using the {@link XYDotRenderer} class.
 */
public class ScatterPlotDesign extends ApplicationFrame {

    /**
     * A demonstration application showing a scatter plot.
     *
     * @param title  the frame title.
     */
    public ScatterPlotDesign(String title) {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }
    /**
     *
     * @param bloods
     * @return
     */
    public static XYDataset createxydataset(String bloods) {
        DefaultXYDataset xydataset = new DefaultXYDataset();

//        int size = xydatalist.size();
//        double[][] datas = new double[2][size];
//        for (int i = 0; i < size; i++) {
//            PressureBean pres = xydatalist.get(i);
//            int sys = pres.getSyspress();//收缩压
//            int dia = pres.getDiapress();//舒张压
//
//            datas[0][i] = sys;
//            datas[1][i] = dia;
//        }

        double[][] datas = new double[2][13];
        datas[0][0]=1.2;
        datas[0][1]=1.5;
        datas[0][2]=1.36;
        datas[0][3]=1.7;
        datas[0][4]=1.3;
        datas[0][5]=1.67;
        datas[0][6]=1.58;
        datas[0][7]=2.36;
        datas[0][8]=2.1;
        datas[0][9]=2.2;
        datas[0][10]=2.7;
        datas[0][11]=1.8;
        datas[0][12]=1.9;

        datas[1][0]=529.19;
        datas[1][1]=557.77;
        datas[1][2]=511.88;
        datas[1][3]=491.19;
        datas[1][4]=500.98;
        datas[1][5]=479.93;
        datas[1][6]=510.47;
        datas[1][7]=482.1;
        datas[1][8]=469.5;
        datas[1][9]=479.56;
        datas[1][10]=524.83;
        datas[1][11]=480.65;
        datas[1][12]=544.53;
        xydataset.addSeries(bloods, datas);
        return xydataset;

    }
    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createDemoPanel() {
        XYSeries xySeries = new XYSeries("1");

        XYDataset dataset = new SampleXYDataset2();

        ChartUtils.setChartTheme();
        JFreeChart chart = ChartFactory.createScatterPlot("",
            "等级", "成绩", createxydataset("text"), PlotOrientation.VERTICAL, true, true, false);
        ChartUtils.setAntiAlias(chart);

        LegendTitle legend = chart.getLegend();
        legend.setVisible(false);


        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setOutlinePaint(new Color(0, 0, 0));
        //plot.setDomainTickBandPaint(new Color(200, 200, 100, 100));
        LegendItemCollection legendItems = plot.getLegendItems();

        plot.setBackgroundPaint(new Color(255,255,255,0));
        XYDotRenderer renderer = new XYDotRenderer();
        renderer.setBaseItemLabelsVisible(true);
        renderer.setDotWidth(4);
        renderer.setDotHeight(4);

        renderer.setLegendShape( new Ellipse2D.Double(-4.0D, -4.0D, 8.0D, 8.0D));//画圆);
        plot.setRenderer(renderer);
//        plot.setDomainCrosshairVisible(true);
//        plot.setRangeCrosshairVisible(true);

        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setAutoRangeIncludesZero(false);
        plot.getRangeAxis().setInverted(true);
        return new ChartPanel(chart);
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(String[] args) {
        ScatterPlotDesign demo = new ScatterPlotDesign(
                "JFreeChart: ScatterPlotDemo4.java");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}