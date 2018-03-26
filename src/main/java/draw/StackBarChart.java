
package draw;

import extend.ChartUtils;
import entity.StackBarEntity;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 * 堆状图，模板1，图1，2
 */
public class StackBarChart {
    private static Color seriers3 = new Color(152,153,171);

    /**
     * 画堆状图：模型1，图1
     * @param stackBarEntity
     * @return
     */
    public static JFreeChart drawStackedBarChart(StackBarEntity stackBarEntity)throws Exception{
        CategoryDataset dataset = StackBarChart.createDataset(stackBarEntity);
        return StackBarChart.createChart(dataset);
    }
    /**
     * Returns a sample dataset.
     *
     * @return The dataset.
     */
    public static CategoryDataset createDataset(StackBarEntity stackBarEntity) throws Exception{

        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        java.util.List<String> rowKeyList = stackBarEntity.getRowKeyList();
        List<String> columnKeyList = stackBarEntity.getColumnKeyList();
        List<List<Double>> values = stackBarEntity.getValues();

        for (int i = 0; i < rowKeyList.size(); i++) {
                for (int j=0;j<columnKeyList.size();j++) {
                    dataset.addValue(values.get(j).get(i),rowKeyList.get(i),columnKeyList.get(j));
                    dataset.addValue(values.get(j).get(i),rowKeyList.get(i),columnKeyList.get(j));
                }
        }
        return dataset;
    }

    /**
     * Creates a sample chart.
     *
     * @param dataset the dataset.
     * @return The chart.
     */
    public static JFreeChart createChart(CategoryDataset dataset) {

        //设置样式
        // 设置中文主题样式 解决乱码
        ChartUtils.setChartTheme();

        //创建一个条形图表
        JFreeChart chart = ChartFactory.createStackedBarChart(
                "",
                "",                    // domain axis label
                "%",                 // range axis label
                dataset,                      // data
                PlotOrientation.HORIZONTAL,   // orientation
                false,                        // include legend
                true,                         // tooltips?
                false                         // URLs?
        );

        // 图标区域对象，基本上这个对象决定着图表的样式..
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        //系列配置颜色
        LegendItemCollection items = new LegendItemCollection();

        items.add(new LegendItem((String)dataset.getRowKey(0), new Color(123, 118, 125)));
        items.add(new LegendItem((String)dataset.getRowKey(1), new Color(247, 192, 3)));
        items.add(new LegendItem((String) dataset.getRowKey(2), new Color(81, 111, 175)));
        if (dataset.getRowCount() >= 4) {
            items.add(new LegendItem((String) dataset.getRowKey(3), seriers3));
        }
        plot.setFixedLegendItems(items);

        //系列位置
        LegendTitle legend = new LegendTitle(plot);
        legend.setPosition(RectangleEdge.TOP);//设置系列显示在顶部
        chart.addSubtitle(legend);

        //数据区的边界线条颜色
        plot.setOutlineVisible(false);
        plot.setDomainGridlinesVisible(true);

        //网格线条不可见
        plot.setDomainGridlinesVisible(false);
        plot.setRangeGridlinesVisible(false);


        //分类轴边距
        CategoryAxis categoryAxis = new CategoryAxis();
        if (dataset.getColumnCount() <= 14) {
            categoryAxis.setCategoryMargin(0.3);
        }else{
            categoryAxis.setCategoryMargin(0.1);
        }
        plot.setDomainAxis(categoryAxis);
        ValueAxis rangeAxis1 = plot.getRangeAxis();
        Font xfont = new Font("宋体",Font.PLAIN,16) ;// X轴
        rangeAxis1.setTickLabelFont(xfont);

        //x轴
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();//坐标轴
        //设置x轴不可见
        rangeAxis.setVisible(false);

        //柱状图渲染
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        //标签主题是否可见
        renderer.setBaseItemLabelsVisible(true);

        //设置柱体标签值的格式
        renderer.setBaseItemLabelGenerator(
                new StandardCategoryItemLabelGenerator("{3}",
                        NumberFormat.getIntegerInstance(), new DecimalFormat("0%")));
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
                ItemLabelAnchor.CENTER, TextAnchor.CENTER));
        renderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(
                ItemLabelAnchor.CENTER, TextAnchor.CENTER));

        ChartUtilities.applyCurrentTheme(chart);

        // set up gradient paints for series...
        renderer.setSeriesPaint(0, new Color(123, 118, 125));
        renderer.setSeriesPaint(1, new Color(247, 192, 3));
        renderer.setSeriesPaint(2, new Color(81, 111, 175));
        if (dataset.getRowCount() >= 4) {
            renderer.setSeriesPaint(3, seriers3);
        }
        renderer.setBarPainter(new StandardBarPainter());

        ChartUtils.setAntiAlias(chart);
        return chart;

    }


}