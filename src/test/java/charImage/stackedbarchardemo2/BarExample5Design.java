/**
 *
 */
package charImage.stackedbarchardemo2;

import extend.ChartUtils;
import extend.ChartUtils3_2;
import extend.PathConfig;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

/**
 * @author cuiran
 */
public class BarExample5Design extends ApplicationFrame {
    Color series1 = new Color(122, 122, 122);
    Color series2 = new Color(245, 194, 1);
    Color series3 = new Color(82, 109, 176);
    public BarExample5Design(String title) {

        /**
         * Creates a new demo instance.
         *
         * @param title  the frame title.
         */
        super(title);
        DefaultCategoryDataset dataset = createDataSet();
        JFreeChart chart = createChart(dataset);
        JPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(PathConfig.IMAGEWIDTH, PathConfig.IMAGEHEIGHT));
        setContentPane(chartPanel);
    }


    public JFreeChart createChart(DefaultCategoryDataset dataset) {


        ChartUtils3_2.setChartTheme();
        JFreeChart chart = ChartFactory.createBarChart("", // chart
                // title
                "", // domain axis label
                "", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips?
                false // URLs?
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
        rangeAxis.setNumberFormatOverride(NumberFormat.getPercentInstance());
        rangeAxis.setTickUnit(new NumberTickUnit(0.1));
        rangeAxis.setRange(0, 1);
        plot.setRangeAxis(rangeAxis);

        ChartUtils.setAntiAlias(chart);
        return chart;
    }



    public DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0, "等级1", "校1");
        dataset.addValue(0, "等级1", "校2");
        dataset.addValue(0, "等级1", "校3");
        dataset.addValue(0, "等级1", "校4");
        dataset.addValue(0, "等级1", "校5");
        dataset.addValue(0, "等级1", "校6");
        dataset.addValue(0.01, "等级1", "校7");
        dataset.addValue(0.05, "等级1", "民办");
        dataset.addValue(0, "等级1", "公办");
        dataset.addValue(0, "等级1", "本县");
        dataset.addValue(0.01, "等级1", "全市");

        dataset.addValue(0.38, "等级2", "校1");
        dataset.addValue(0.45, "等级2", "校2");
        dataset.addValue(0.36, "等级2", "校3");
        dataset.addValue(0.22, "等级2", "校4");
        dataset.addValue(0.41, "等级2", "校5");
        dataset.addValue(0.15, "等级2", "校6");
        dataset.addValue(0.22, "等级2", "校7");
        dataset.addValue(0.11, "等级2", "民办");
        dataset.addValue(0.7, "等级2", "公办");
        dataset.addValue(0.6, "等级2", "本县");
        dataset.addValue(0.23, "等级2", "全市");

        dataset.addValue(0.63, "等级3", "校1");
        dataset.addValue(0.55, "等级3", "校2");
        dataset.addValue(0.64, "等级3", "校3");
        dataset.addValue(0.78, "等级3", "校4");
        dataset.addValue(0.59, "等级3", "校5");
        dataset.addValue(0.85, "等级3", "校6");
        dataset.addValue(0.76, "等级3", "校7");
        dataset.addValue(0.84, "等级3", "民办");
        dataset.addValue(0.93, "等级3", "公办");
        dataset.addValue(0.94, "等级3", "本县");
        dataset.addValue(0.76, "等级3", "全市");
        return dataset;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param args
     */
    public static void main(String[] args) {
        BarExample5Design demo = new BarExample5Design("机构风险数量统计表");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}