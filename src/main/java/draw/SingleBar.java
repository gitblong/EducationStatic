package draw;

import entity.SingleBarEntity;
import extend.ChartUtils;
import extend.ChartUtils3_2;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;

/**
 * 模板3-1图
 * Created by Blong on 2018/3/18.
 */
public class SingleBar {
    private static Color series1 = new Color(79, 128, 189);

    public static JFreeChart drawSingleBar(SingleBarEntity singleBarEntity)throws Exception {
        return createChart(createDataSet(singleBarEntity),singleBarEntity);
    }

    public static JFreeChart createChart(DefaultCategoryDataset dataset,SingleBarEntity singleBarEntity)throws Exception {
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
        chart.getLegend().setVisible(false);
        CategoryPlot plot = chart.getCategoryPlot();//获得图表区域对象

        //设置图表的颜色
        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, series1);
        renderer.setItemMargin(0);//组内柱子间隔为组宽的
        renderer.setShadowVisible(false);
        renderer.setBarPainter(new StandardBarPainter());
        plot.setRenderer(renderer);//使用我们设计的效果

        //分类轴边距
        CategoryAxis categoryAxis = new CategoryAxis();
        if (dataset.getColumnKeys().size() > 9) {
            categoryAxis.setCategoryMargin(0.1);
        }else{
            categoryAxis.setCategoryMargin(0.6);
        }

        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        plot.setDomainAxis(categoryAxis);
        //设置网格线
        plot.setRangeGridlineStroke(new BasicStroke(1.0f));
        //设置图表的纵轴和横轴org.jfree.chart.axis.CategoryAxis
        // X 轴
        Font xfont = new Font("宋体",Font.PLAIN,16) ;// X轴
        Font yfont = new Font("宋体",Font.PLAIN,16) ;// y轴

        CategoryAxis domainAxis = plot.getDomainAxis();

        domainAxis.setTickLabelPaint(new Color(0,0,0));          //X轴的标题文字颜色
        domainAxis.setTickMarksVisible(true);             //标记线是否显示
        domainAxis.setTickMarkOutsideLength(5);           //标记线向外长度
        domainAxis.setTickMarkPaint(new Color(0,0,0));           //标记线颜色
        domainAxis.setAxisLinePaint(new Color(0, 0, 0));
        domainAxis.setTickLabelFont(xfont);

        // Y 轴
        ValueAxis rAxis = plot.getRangeAxis();            //对Y轴做操作
        rAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rAxis.setAxisLinePaint(Color.BLACK);
        rAxis.setAutoRange(false);
        rAxis.setAutoRangeMinimumSize(1000);
        rAxis.setTickLabelFont(xfont);
        NumberAxis rangeAxis = new NumberAxis();
        rangeAxis.setTickLabelFont(yfont);
        double maxRange = singleBarEntity.getMaxRange();
        if (singleBarEntity.getModel() == 1) {
//            rangeAxis.setTickUnit(new NumberTickUnit(0.1));
            rangeAxis.setNumberFormatOverride(NumberFormat.getPercentInstance());
            maxRange = maxRange+0.1;
            if (maxRange > 1) {
                maxRange = 1;
            }
        }else{
            categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
            if (maxRange > 10) {
//                rangeAxis.setTickUnit(new NumberTickUnit(10));
                maxRange = maxRange + 10;
            }else{
//                rangeAxis.setTickUnit(new NumberTickUnit(2));
                maxRange = maxRange + 2;
            }
        }
        rangeAxis.setRange(0, maxRange);
        plot.setRangeAxis(rangeAxis);

        ChartUtils.setAntiAlias(chart);
        return chart;
    }


    public static DefaultCategoryDataset createDataSet(SingleBarEntity singleBarEntity)throws Exception {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        java.util.List<String> columnList = singleBarEntity.getColumnList();
        List<Double> valueList = singleBarEntity.getValueList();
        for (int j = 0; j < columnList.size(); j++) {
            dataset.addValue(valueList.get(j), "1", columnList.get(j));
        }
        return dataset;
    }

}
