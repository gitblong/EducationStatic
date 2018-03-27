/* -------------------------
 * XYShapeRendererDemo1.java
 * -------------------------
 * (C) Copyright 2008, 2009, by Object Refinery Limited.
 */

package charImage.ScatterPlotDemo;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;

/**
 * A simple demo for the {@link XYShapeRenderer} class.
 */
public class XYShapeRendererDemo1Design extends ApplicationFrame {
    private static String NO_DATA_MSG = "数据加载失败";
    private static Font FONT = new Font("宋体", Font.PLAIN, 12);
    public static Color[] CHART_COLORS = {new Color(31, 129, 188), new Color(241, 92, 128), new Color(124, 181, 236), new Color(102, 172, 204),
            new Color(102, 102, 0), new Color(204, 153, 102), new Color(0, 153, 255), new Color(204, 255, 255), new Color(51, 153, 153),
            new Color(255, 204, 102), new Color(102, 102, 0), new Color(204, 204, 204), new Color(204, 255, 255), new Color(255, 204, 204),
            new Color(255, 255, 204), new Color(255, 153, 204), new Color(51, 0, 0), new Color(0, 51, 102), new Color(0, 153, 102), new Color(153, 102, 153),
            new Color(102, 153, 204), new Color(153, 204, 153), new Color(204, 204, 153), new Color(255, 255, 153), new Color(255, 204, 153),
            new Color(255, 153, 204), new Color(204, 153, 153), new Color(204, 204, 255), new Color(204, 255, 204), new Color(153, 204, 153),
            new Color(255, 204, 102)};//颜色


    /**
     * A demonstration application showing a bubble chart.
     *
     * @param title  the frame title.
     */
    public XYShapeRendererDemo1Design(String title) {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
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
        // 设置中文主题样式 解决乱码
        StandardChartTheme chartTheme = new StandardChartTheme("CN");
        // 设置标题字体
        chartTheme.setExtraLargeFont(FONT);
        // 设置图例的字体
        chartTheme.setRegularFont(FONT);
        // 设置轴向的字体
        chartTheme.setLargeFont(FONT);
        chartTheme.setSmallFont(FONT);
        chartTheme.setTitlePaint(new Color(51, 51, 51));
        chartTheme.setSubtitlePaint(new Color(85, 85, 85));

        chartTheme.setLegendBackgroundPaint(Color.WHITE);// 设置标注
        chartTheme.setLegendItemPaint(Color.BLACK);//
        chartTheme.setChartBackgroundPaint(Color.WHITE);
        // 绘制颜色绘制颜色.轮廓供应商
        // paintSequence,outlinePaintSequence,strokeSequence,outlineStrokeSequence,shapeSequence

        Paint[] OUTLINE_PAINT_SEQUENCE = new Paint[]{Color.WHITE};
        //绘制器颜色源
        DefaultDrawingSupplier drawingSupplier = new DefaultDrawingSupplier(CHART_COLORS, CHART_COLORS, OUTLINE_PAINT_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE, DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE);
        chartTheme.setDrawingSupplier(drawingSupplier);

        chartTheme.setPlotBackgroundPaint(Color.WHITE);// 绘制区域
        chartTheme.setPlotOutlinePaint(Color.WHITE);// 绘制区域外边框
        chartTheme.setLabelLinkPaint(new Color(8, 55, 114));// 链接标签颜色
        chartTheme.setLabelLinkStyle(PieLabelLinkStyle.CUBIC_CURVE);

        chartTheme.setAxisOffset(new RectangleInsets(5, 0, 0, 0));
        chartTheme.setDomainGridlinePaint(new Color(255, 255, 255));// X坐标轴垂直网格颜
        chartTheme.setRangeGridlinePaint(new Color(255, 255, 255));// Y坐标轴水平网格颜色

        chartTheme.setBaselinePaint(Color.WHITE);
        chartTheme.setCrosshairPaint(Color.BLUE);// 不确定含义
        chartTheme.setAxisLabelPaint(new Color(51, 51, 51));// 坐标轴标题文字颜色
        chartTheme.setTickLabelPaint(new Color(67, 67, 72));// 刻度数字
        chartTheme.setBarPainter(new StandardBarPainter());// 设置柱状图渲染
        chartTheme.setXYBarPainter(new StandardXYBarPainter());// XYBar 渲染

        chartTheme.setItemLabelPaint(Color.black);
        chartTheme.setThermometerPaint(Color.white);// 温度计
        NumberAxis xAxis = new NumberAxis("");
        xAxis.setAutoRangeIncludesZero(false);
        NumberAxis yAxis = new NumberAxis("");
        yAxis.setAutoRangeIncludesZero(false);
        XYShapeRenderer renderer = new XYShapeRenderer();
        LookupPaintScale ps = new LookupPaintScale(1.0, 4.0, new Color(0, 0, 255));
//        ps.add(2.0, new Color(100, 100, 255));
//        ps.add(3.0, new Color(200, 200, 255));
        renderer.setPaintScale(ps);
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        //渲染
        XYItemRenderer renderer1 = plot.getRenderer();
        //设置点颜色，设置边框
        renderer1.setSeriesPaint(0, new Color(0,0,255,72));
        renderer1.setSeriesOutlinePaint(0, new Color(0,0,0,150));
        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        JFreeChart chart = new JFreeChart("XYShapeRendererDemo1", plot);
        chart.removeLegend();
        NumberAxis zAxis = new NumberAxis("Score");
        zAxis.setVisible(false);
        zAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        ChartUtilities.applyCurrentTheme(chart);
        return chart;
    }

    /**
     * Creates a sample dataset.
     *
     * @return A sample dataset.
     */
    public static XYZDataset createDataset() {
        DefaultXYZDataset dataset = new DefaultXYZDataset();
        double[] x = {2.1, 2.3, 2.3, 2.2, 2.2, 1.8, 1.8, 1.9, 2.3, 2.8};
        double[] y = {14.1, 17.1, 10.0, 8.8, 8.7, 8.4, 5.4, 4.1, 4.1, 25};
        double[] z = {2.4, 2.7, 1.7, 2.2, 1.3, 2.2, 2.1, 3.2, 1.6, 3.4};
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
        return chartPanel;
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(String[] args) {
        XYShapeRendererDemo1Design demo = new XYShapeRendererDemo1Design(
                "JFreeChart: XYShapeRendererDemo1.java");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}