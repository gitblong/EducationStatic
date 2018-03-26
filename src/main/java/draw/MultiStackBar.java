
package draw;


import entity.MultiStackBarEntity;
import extend.ChartUtils;
import extend.ChartUtils4;
import extend.PathConfig;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultKeyedValues2DDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * 模板4 图
 * Created by Blong on 2018/3/18.
 */

    public class MultiStackBar {
        static Color color1 = new Color(185,205,229);
        static Color color2 = new Color(142,180,227);
        static Color color3 = new Color(255, 255, 255,0);

        public static JFreeChart createChart(CategoryDataset dataset)throws Exception {
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

            // 图标区域对象，基本上这个对象决定着图表的样式..
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            //系列位置 不显示
            chart.getLegend().setVisible(false);
            //数据区的边界线条颜色
            plot.setOutlineVisible(false);
            plot.setDomainGridlinesVisible(true);

            //网格线条不可见
            plot.setDomainGridlinesVisible(true);
            plot.setRangeGridlinesVisible(true);
//            plot.setDomainGridlinePosition(CategoryAnchor.END);
            plot.getBackgroundAlpha();
            //蛇者背景为白色
            plot.setBackgroundPaint(color3);
            plot.setRangeGridlineStroke(new BasicStroke(1.0f));
            plot.setDomainGridlineStroke(new BasicStroke(1.0f));
            Font xfont = new Font("宋体", Font.PLAIN, 12);
            plot.getRangeAxis().setTickLabelFont(xfont);

            //x轴
            NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();//坐标轴
            rangeAxis.setTickUnit(new NumberTickUnit(100));
            rangeAxis.setRange(101,905);
            rangeAxis.setVisible(true);
            //柱状图渲染
            BarRenderer renderer = (BarRenderer) plot.getRenderer();
            renderer.setSeriesOutlinePaint(0,new Color(255,255,255, 255));
            renderer.setSeriesOutlinePaint(1,new Color(0,0,0));
            renderer.setSeriesOutlinePaint(2,new Color(0,0,0));
            renderer.setSeriesOutlinePaint(3,new Color(0,0,0));
            renderer.setSeriesOutlinePaint(4,new Color(0,0,0));
            renderer.setSeriesOutlinePaint(5,new Color(0,0,0));
            renderer.setSeriesOutlinePaint(6,new Color(255,255,255, 0));

            //设置边框
            renderer.setDrawBarOutline(true);
            renderer.setSeriesPaint(0, color3);
            renderer.setSeriesPaint(1, color1);
            renderer.setSeriesPaint(2, color2);
            renderer.setSeriesPaint(3, color2);
            renderer.setSeriesPaint(4, color1);
            renderer.setSeriesPaint(5, new Color(0,0,0));
            renderer.setSeriesPaint(6, color3);
            renderer.setBarPainter(new StandardBarPainter());

            //分类轴边距
            CategoryAxis categoryAxis = new CategoryAxis();
            if (dataset.getColumnCount() <= 11) {
                categoryAxis.setCategoryMargin(0.5);
            }else{
                categoryAxis.setCategoryMargin(0.2);
            }
            plot.setDomainAxis(categoryAxis);
            categoryAxis.setTickLabelFont(xfont);
            plot.setDomainAxis(categoryAxis);
            ChartUtils.setAntiAlias(chart);


            return chart;
        }

        /**
         * Creates a dataset.
         *
         * @return A dataset.
         */
        public static CategoryDataset createDataset(MultiStackBarEntity multiStackBarEntity)throws Exception {
            // create the dataset...
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            java.util.List<String> columnKeyList = multiStackBarEntity.getColumnList();
            java.util.List<java.util.List<Double>> values = multiStackBarEntity.getValueList();

            for (int i = 0; i < values.size(); i++) {
                for (int j=0;j<values.get(i).size();j++) {

                    dataset.addValue(values.get(i).get(j),i+"",columnKeyList.get(j));
                }
            }
            return dataset;
        }

    public static JFreeChart drawMultiStackBar(MultiStackBarEntity multiStackBarEntity)throws Exception {

        return createChart(createDataset(multiStackBarEntity));
    }
}