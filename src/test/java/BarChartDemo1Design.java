/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2014, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * ------------------
 * BarChartDemo1.java
 * ------------------
 * (C) Copyright 2003-2014, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   ;
 *
 * Changes
 * -------
 * 09-Mar-2005 : Version 1 (DG);
 *
 */


import draw.SingleBar;
import entity.SingleBarEntity;
import extend.ChartUtils;
import extend.ChartUtils3_2;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

/**
 * A simple demonstration application showing how to create a bar chart.
 */
public class BarChartDemo1Design extends ApplicationFrame {
    private static Color series1 = new Color(122, 122, 122);
    private static Color series2 = new Color(245, 194, 1);
    private static Color series3 = new Color(82, 109, 176);
    public static final long serialVersionUID = 1L;

    /**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     */
    public BarChartDemo1Design(String title) {
        super(title);
        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        
        setContentPane(chartPanel);
    }

    /**
     * Returns a sample dataset.
     *
     * @return The dataset.
     */
    public static CategoryDataset createDataset() {

        // row keys...
        String series1 = "First";
        String series2 = "Second";
        String series3 = "Third";

        // column keys...
        String category1 = "Category 1";
        String category2 = "Category 2";
        String category3 = "Category 3";
        String category4 = "Category 4";
        String category5 = "Category 5";

        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, series1, category1);
        dataset.addValue(4.0, series1, category2);
        dataset.addValue(3.0, series1, category3);
        dataset.addValue(5.0, series1, category4);
        dataset.addValue(5.0, series1, category5);

        dataset.addValue(5.0, series2, category1);
        dataset.addValue(7.0, series2, category2);
        dataset.addValue(6.0, series2, category3);
        dataset.addValue(8.0, series2, category4);
        dataset.addValue(4.0, series2, category5);

        dataset.addValue(4.0, series3, category1);
        dataset.addValue(3.0, series3, category2);
        dataset.addValue(2.0, series3, category3);
        dataset.addValue(3.0, series3, category4);
        dataset.addValue(6.0, series3, category5);

        return dataset;

    }

    /**
     * Creates a sample chart.
     *
     * @param dataset  the dataset.
     *
     * @return The chart.
     */
    public static JFreeChart createChart(CategoryDataset dataset) {
        ChartUtils3_2.setChartTheme();
        JFreeChart chart = ChartFactory.createBarChart("", // chart
                // title
                "", // domain axis label
                "", // range axis label
                dataset
        );
        CategoryPlot plot = chart.getCategoryPlot();//获得图表区域对象
        // 设置系列标签位置
        LegendTitle legend = chart.getLegend();
        legend.setBorder(0, 0, 0, 0);
        legend.setPosition(RectangleEdge.TOP);
        //系列配置颜色
        LegendItemCollection items = new LegendItemCollection();

        items.add(new LegendItem((String)dataset.getRowKey(0), series1));
        items.add(new LegendItem((String)dataset.getRowKey(1), series2));
        items.add(new LegendItem((String) dataset.getRowKey(2), series3));
        plot.setFixedLegendItems(items);

        ;
        //设置图表的颜色
        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, series1);
        renderer.setSeriesPaint(1, series2);
        renderer.setSeriesPaint(2, series3);
        renderer.setItemMargin(0);//组内柱子间隔为组宽的
        renderer.setShadowVisible(false);
        renderer.setBarPainter(new StandardBarPainter());
        plot.setRenderer(renderer);//使用我们设计的效果

        //分类轴边距
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setCategoryMargin(0.25);
        plot.setDomainAxis(categoryAxis);
        //设置网格线
        plot.setRangeGridlineStroke(new BasicStroke(1.0f));
        //设置图表的纵轴和横轴org.jfree.chart.axis.CategoryAxis
        // X 轴
        CategoryAxis domainAxis = plot.getDomainAxis();

        domainAxis.setTickLabelPaint(new Color(0,0,0));          //X轴的标题文字颜色
        domainAxis.setTickMarksVisible(true);             //标记线是否显示
        domainAxis.setTickMarkOutsideLength(5);           //标记线向外长度
        domainAxis.setTickMarkPaint(new Color(0,0,0));           //标记线颜色
        domainAxis.setAxisLinePaint(new Color(0, 0, 0));
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));

        // Y 轴
        ValueAxis rAxis = plot.getRangeAxis();            //对Y轴做操作

        rAxis.setAxisLinePaint(Color.BLACK);
        rAxis.setAutoRange(false);
        rAxis.setAutoRangeMinimumSize(1000);
        NumberAxis rangeAxis = new NumberAxis();
//        rangeAxis.setNumberFormatOverride(NumberFormat.getPercentInstance());
        rangeAxis.setTickUnit(new NumberTickUnit(2));
        double maxRange = 10 + 0.1;
//        if (maxRange > 1) {
//            maxRange = 1;
//        }
        rangeAxis.setRange(0, maxRange);
        plot.setRangeAxis(rangeAxis);

        ChartUtils.setAntiAlias(chart);
        return chart;
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.add(new ChartPanel(createChart(createDataset())));
        jFrame.setVisible(true);

        BarChartDemo1Design demo = new BarChartDemo1Design(
                "JFreeChart 2: BarChartDemo1.java");
        demo.pack();
        demo.setVisible(true);
    }

}