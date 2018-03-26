package draw;

import entity.DualAxisChartEntity;
import extend.ChartUtils;
import extend.ChartUtils3_2;
import extend.PathConfig;
import javafx.scene.chart.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blong on 2018/3/19.
 */
public class DualAxisChart {

    private static Color barColor =new Color(79, 128, 189);
    private static Color lineColor = new Color(178, 178, 178);


    public static JFreeChart drawChart(DualAxisChartEntity dualAxisChartEntity)throws Exception {
        return createChart(dualAxisChartEntity);
    }

    /**
     * Creates a sample dataset.
     *
     * @return The dataset.
     */
    private static CategoryDataset createDataset1(DualAxisChartEntity dualAxisChartEntity)throws Exception {
        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i=0;i<dualAxisChartEntity.getColumnKeyList().size();i++) {
            dataset.addValue(dualAxisChartEntity.getValuelist().get(i), "bar", dualAxisChartEntity.getColumnKeyList().get(i));
        }
        return dataset;

    }

    /**
     * Creates a sample dataset.
     *
     * @return The dataset.
     */
    private static CategoryDataset createDataset2(DualAxisChartEntity dualAxisChartEntity)throws Exception {


        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i=0;i<dualAxisChartEntity.getColumnKeyList().size();i++) {
            dataset.addValue(dualAxisChartEntity.getValuelist().get(i), "line", dualAxisChartEntity.getColumnKeyList().get(i));
        }

        return dataset;

    }

    /**
     * Creates the demo chart.
     *
     * @return The chart.
     */
    private static JFreeChart createChart(DualAxisChartEntity dualAxisChartEntity)throws Exception {
        // create the chart...
        ChartUtils3_2.setChartTheme();
        JFreeChart chart = ChartFactory.createBarChart(
                "",          // chart title
                "",               // domain axis label
                "",                  // range axis label
                createDataset1(dualAxisChartEntity),         // data
                PlotOrientation.VERTICAL,
                false,                    // include legend
                true,                     // tooltips?
                false                     // URL generator?  Not required...
        );
        Font xfont = new Font("宋体", Font.PLAIN, 16);
        Font yfont = new Font("宋体", Font.PLAIN, 16);

        //得到画板
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        //将折线图插入柱状图
        CategoryDataset dataset2 = createDataset2(dualAxisChartEntity);
        plot.setDataset(1, dataset2);
        plot.mapDatasetToRangeAxis(1, 1);
        //设置网格线
        plot.setRangeGridlineStroke(new BasicStroke(1.0f));


        //设置折线Y轴范围
        ValueAxis axis2 = new NumberAxis();
        axis2.setTickLabelFont(xfont);
        axis2.setRange(dualAxisChartEntity.getMinRange()-20, dualAxisChartEntity.getMaxRange()+20);
        axis2.setVisible(false);
        plot.setRangeAxis(1, axis2);
        //设置Y轴刻度间距为10
        NumberAxis rangeAxis1 = new NumberAxis();
        rangeAxis1.setTickUnit(new NumberTickUnit(10));
        plot.setRangeAxis(rangeAxis1);

        //设置柱状图Y轴范围
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setTickLabelFont(yfont);
        rangeAxis.setRange(dualAxisChartEntity.getMinRange()-20, dualAxisChartEntity.getMaxRange()+20);

        //分类轴边距
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setCategoryMargin(0.5);
        plot.setDomainAxis(categoryAxis);

        //设置柱体颜色
        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, barColor);
        renderer.setShadowVisible(false);
        renderer.setBarPainter(new StandardBarPainter());
        plot.setRenderer(renderer);

        //折线颜色与虚线设置
        LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
        renderer2.setSeriesStroke(0, new BasicStroke(2f, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND, 0.0f, new float[]{4.0f, 8.0f}, 0.3f));
        renderer2.setSeriesPaint(0, lineColor);
        renderer2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());

        plot.setRenderer(1, renderer2);
        //设置折线图在柱状图上
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        categoryAxis.setTickLabelFont(xfont);
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        ChartUtils.setAntiAlias(chart);
        return chart;
    }
}


