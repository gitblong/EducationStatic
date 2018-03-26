/**
 *
 */
package charImage.stackedbarchardemo2;

import extend.ChartUtils;
import extend.ChartUtils3_2;
import extend.PathConfig;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

/**
 *
 * @author cuiran
 */
public class BarExample5SingleDesign extends ApplicationFrame {
    Color series1 = new Color(122, 122, 122);
    Color series2 = new Color(245, 194, 1);
    Color series3 = new Color(82, 109, 176);
    public BarExample5SingleDesign(String title) {

        /**
         * Creates a new demo instance.
         *
         * @param title  the frame title.
         */
        super(title);
        DefaultCategoryDataset dataset = createDataSet();
        JFreeChart chart = createChart(dataset);
        JPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(PathConfig.IMAGEWIDTH, PathConfig.IMAGEHEIGHT));
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
        ;
        //设置图表的颜色
        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, series1);
        renderer.setItemMargin(0);//组内柱子间隔为组宽的
        renderer.setShadowVisible(false);
        renderer.setBarPainter(new StandardBarPainter());
        plot.setRenderer(renderer);//使用我们设计的效果

        //分类轴边距
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setCategoryMargin(0.5);
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
        dataset.addValue(0.005, "", "17岁");
        dataset.addValue(0.028, "", "16岁");
        dataset.addValue(0.366, "", "15岁");
        dataset.addValue(0.588, "", "14岁");
        dataset.addValue(0.014, "", "13岁");
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
        BarExample5SingleDesign demo = new BarExample5SingleDesign("机构风险数量统计表");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}