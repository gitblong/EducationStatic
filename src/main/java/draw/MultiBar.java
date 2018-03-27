package draw;

import entity.MultiBarEntity;
import extend.ChartUtils;
import extend.ChartUtils3_2;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;

import java.awt.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;

/**
 * 模板3-2图
 * Created by Blong on 2018/3/18.
 */
public class MultiBar {
    private static Color series1 = new Color(122, 122, 122);
    private static Color series2 = new Color(245, 194, 1);
    private static Color series3 = new Color(82, 109, 176);

    public static JFreeChart drawMultiBar(MultiBarEntity multiBarEntity)throws Exception {
        return createChart(createDataSet(multiBarEntity),multiBarEntity);
    }
    public static JFreeChart createChart(DefaultCategoryDataset dataset,MultiBarEntity multiBarEntity)throws Exception {


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

        Font xfont = new Font("宋体",Font.PLAIN,16) ;// X轴
        Font yfont = new Font("宋体",Font.PLAIN,16) ;// y轴

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
        domainAxis.setTickLabelFont(xfont);

        // Y 轴
        ValueAxis rAxis = plot.getRangeAxis();            //对Y轴做操作
        rAxis.setTickLabelFont(yfont);
        rAxis.setAxisLinePaint(Color.BLACK);
        rAxis.setAutoRange(false);
        rAxis.setAutoRangeMinimumSize(1000);
        NumberAxis rangeAxis = new NumberAxis();
        rangeAxis.setTickLabelFont(xfont);
        double maxRange = multiBarEntity.getMaxValue();
        if (multiBarEntity.getModel() == 1) {
//            rangeAxis.setTickUnit(new NumberTickUnit(0.1));
            rangeAxis.setNumberFormatOverride(NumberFormat.getPercentInstance());//设置Y轴%显示
            maxRange = maxRange + 0.1;
            if (maxRange > 1) {
                maxRange = 1;
            }
        } else{
//            rangeAxis.setTickUnit(new NumberTickUnit(10));
            maxRange = maxRange + 10;
        }
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        rangeAxis.setRange(0, maxRange);
        plot.setRangeAxis(rangeAxis);

        ChartUtils.setAntiAlias(chart);
        return chart;
    }



    public static DefaultCategoryDataset createDataSet(MultiBarEntity multiBarEntity)throws Exception {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        java.util.List<String> columnKeyList = multiBarEntity.getColumnKeyList();
        List<String> rowKeyList = multiBarEntity.getRowKeyList();
        List<List<Double>> valueList = multiBarEntity.getValueList();

        for (int i = 0; i < rowKeyList.size(); i++) {
            for (int j=0;j<columnKeyList.size();j++) {
                dataset.addValue(valueList.get(j).get(i),rowKeyList.get(i),columnKeyList.get(j));
            }
        }
        return dataset;
    }

}
