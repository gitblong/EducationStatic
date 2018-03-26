/* -------------------------
 * PopulationChartDemo1.java
 * -------------------------
 * (C) Copyright 2003-2009, by Object Refinery Limited.
 *
 */

package charImage.design;

import entity.MultiStackBarEntity;
import extend.ChartUtils;
import extend.ChartUtils4;
import extend.PathConfig;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultKeyedValues2DDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;

/**
 * A population pyramid demo.
 */
public class PopulationChartDesign extends ApplicationFrame {
    static Color color1 = new Color(185,205,229);
    static Color color2 = new Color(142,180,227);
    static Color color3 = new Color(255, 255, 255);
    public static Color[] CHART_COLORS = {new Color(31, 129, 188), new Color(241, 92, 128), new Color(124, 181, 236), new Color(102, 172, 204),
            new Color(102, 102, 0), new Color(204, 153, 102), new Color(0, 153, 255), new Color(204, 255, 255), new Color(51, 153, 153),
            new Color(255, 204, 102), new Color(102, 102, 0), new Color(204, 204, 204), new Color(204, 255, 255), new Color(255, 204, 204),
            new Color(255, 255, 204), new Color(255, 153, 204), new Color(51, 0, 0), new Color(0, 51, 102), new Color(0, 153, 102), new Color(153, 102, 153),
            new Color(102, 153, 204), new Color(153, 204, 153), new Color(204, 204, 153), new Color(255, 255, 153), new Color(255, 204, 153),
            new Color(255, 153, 204), new Color(204, 153, 153), new Color(204, 204, 255), new Color(204, 255, 204), new Color(153, 204, 153),
            new Color(255, 204, 102)};//颜色
    static Paint[] OUTLINE_PAINT_SEQUENCE = new Paint[]{Color.WHITE};
    private static Font FONT = new Font("宋体", Font.PLAIN, 12);
    /**
     * Creates a new demo.
     *
     * @param title the frame title.
     */
    public PopulationChartDesign(String title) {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(PathConfig.IMAGEWIDTH, PathConfig.IMAGEHEIGHT));
        setContentPane(chartPanel);
    }

    public static JFreeChart createChart(CategoryDataset dataset) {
        ChartUtils4.setChartTheme();
        JFreeChart chart = ChartFactory.createStackedBarChart(
                "",
                "",     // domain axis label
                "", // range axis label
                dataset,         // data
                PlotOrientation.HORIZONTAL,
                true,            // include legend
                true,            // tooltips
                false            // urls
        );
        chart.setPadding(RectangleInsets.ZERO_INSETS);
        ChartUtils.setAntiAlias(chart);
        // 图标区域对象，基本上这个对象决定着图表的样式..
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        //系列位置 不显示
        chart.getLegend().setVisible(false);
        //数据区的边界线条颜色
        plot.setOutlineVisible(false);
        plot.setDomainGridlinesVisible(true);

        //网格线条不可见
        plot.setDomainGridlinesVisible(false);
        plot.setRangeGridlinesVisible(false);
        //蛇者背景为白色
        plot.setBackgroundPaint(color3);
        //x轴
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();//坐标轴
        rangeAxis.setTickUnit(new NumberTickUnit(100));
        rangeAxis.setRange(100,900);
        rangeAxis.setVisible(true);
        //柱状图渲染
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesOutlinePaint(0,new Color(255,255,255));
        renderer.setSeriesOutlinePaint(1,new Color(0,0,0));
        renderer.setSeriesOutlinePaint(2,new Color(0,0,0));
        renderer.setSeriesOutlinePaint(3,new Color(0,0,0));
        renderer.setSeriesOutlinePaint(4,new Color(0,0,0));
        renderer.setSeriesOutlinePaint(5,new Color(0,0,0));
        renderer.setSeriesOutlinePaint(dataset.getRowCount()-1,new Color(255,255,255));

        //设置边框
        renderer.setDrawBarOutline(true);
        renderer.setSeriesPaint(0, color3);
        renderer.setSeriesPaint(1, color1);
        renderer.setSeriesPaint(2, color2);
        renderer.setSeriesPaint(3, color2);
        renderer.setSeriesPaint(4, color1);
        renderer.setSeriesPaint(5, new Color(0,0,0));
        renderer.setSeriesPaint(dataset.getRowCount()-1, color3);
        renderer.setBarPainter(new StandardBarPainter());

        //分类轴边距
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setCategoryMargin(0.5);
        plot.setDomainAxis(categoryAxis);


        return chart;
    }

    /**
     * Creates a dataset.
     *
     * @return A dataset.
     */
    public static CategoryDataset createDataset() {
        DefaultKeyedValues2DDataset data = new DefaultKeyedValues2DDataset();
        data.addValue(181.4, "score1", "县9");
        data.addValue(179.2, "score1", "县3");
        data.addValue(243.6, "score1", "县10");
        data.addValue(190, "score1", "县4");
        data.addValue(187.6, "score1", "县8");
        data.addValue(184, "score1", "县7");
        data.addValue(179.2, "score1", "全市");
        data.addValue(221.8, "score1", "县6");
        data.addValue(210, "score1", "县2");
        data.addValue(284.4, "score1", "县1");
        data.addValue(207.8, "score1", "县5");


        data.addValue(194, "score2", "县9");
        data.addValue(226.4, "score2", "县3");
        data.addValue(168.4, "score2", "县10");
        data.addValue(230.1, "score2", "县4");
        data.addValue(234.6, "score2", "县8");
        data.addValue(243, "score2", "县7");
        data.addValue(254.2, "score2", "全市");
        data.addValue(217.2, "score2", "县6");
        data.addValue(247.1, "score2", "县2");
        data.addValue(185.2, "score2", "县1");
        data.addValue(287.3, "score2", "县5");

        data.addValue(86, "score3", "县9");
        data.addValue(74.2, "score3", "县3");
        data.addValue(70.6, "score3", "县10");
        data.addValue(64.1, "score3", "县4");
        data.addValue(69.8, "score3", "县8");
        data.addValue(75.4, "score3", "县7");
        data.addValue(72.2, "score3", "全市");
        data.addValue(76.6, "score3", "县6");
        data.addValue(65.9, "score3", "县2");
        data.addValue(78.5, "score3", "县1");
        data.addValue(71.2, "score3", "县5");


        data.addValue(50.3, "score4", "县9");
        data.addValue(66.6, "score4", "县3");
        data.addValue(56.4, "score4", "县10");
        data.addValue(68.5, "score4", "县4");
        data.addValue(57, "score4", "县8");
        data.addValue(63, "score4", "县7");
        data.addValue(68.2, "score4", "全市");
        data.addValue(70.2, "score4", "县6");
        data.addValue(56.5, "score4", "县2");
        data.addValue(62.8, "score4", "县1");
        data.addValue(56.5, "score4", "县5");

        data.addValue(185.5, "score5", "县9");
        data.addValue(189.8, "score5", "县3");
        data.addValue(196.2, "score5", "县10");
        data.addValue(188.3, "score5", "县4");
        data.addValue(218.8, "score5", "县8");
        data.addValue(163.6, "score5", "县7");
        data.addValue(224.6, "score5", "全市");
        data.addValue(176, "score5", "县6");
        data.addValue(174.3, "score5", "县2");
        data.addValue(147.1, "score5", "县1");
        data.addValue(175.6, "score5", "县5");

        data.addValue(1, "mark", "县9");
        data.addValue(1, "mark", "县3");
        data.addValue(1, "mark", "县10");
        data.addValue(1, "mark", "县4");
        data.addValue(1, "mark", "县8");
        data.addValue(1, "mark", "县7");
        data.addValue(1, "mark", "全市");
        data.addValue(1, "mark", "县6");
        data.addValue(1, "mark", "县2");
        data.addValue(1, "mark", "县1");
        data.addValue(1, "mark", "县5");

        data.addValue(202.8, "score6", "县9");
        data.addValue(163.8, "score6", "县3");
        data.addValue(164.8, "score6", "县10");
        data.addValue(159, "score6", "县4");
        data.addValue(132.2, "score6", "县8");
        data.addValue(171, "score6", "县7");
        data.addValue(101.6, "score6", "全市");
        data.addValue(138.2, "score6", "县6");
        data.addValue(146.2, "score6", "县2");
        data.addValue(142, "score6", "县1");
        data.addValue(101.6, "score6", "县5");
        return data;
    }

    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart);
        return panel;
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args ignored.
     */
    public static void main(String[] args) {
        PopulationChartDesign demo = new PopulationChartDesign(
                "JFreeChart: PopulationChartDemo1.java");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}