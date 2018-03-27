
package draw;

import extend.ChartUtils;
import entity.ScatterEntity;
import extend.ExtendedScatterItemLabelGeneratory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;

import java.awt.*;

/**
 * 模板1 图3,4三点图
 * A bubble chart demo.
 */
public class BubbleChart {
    //设置z的值，确定圆点的大小
    private final static double radius = 0.03;

    /**
     * 画散点图
     * @param scatterEntity
     * @return
     */
    public static JFreeChart drawScatterChart(ScatterEntity scatterEntity)throws Exception {
        return createChart(createDataset(scatterEntity),scatterEntity);
    }

    /**
     * Creates a chart.
     *
     * @param dataset  the dataset.
     *
     * @return The chart.
     */
    public static JFreeChart createChart(XYZDataset dataset, ScatterEntity scatterEntity)throws Exception {
        ChartUtils.setChartTheme();
        JFreeChart chart = ChartFactory.createBubbleChart(
                "", scatterEntity.getxAxisLabel(), scatterEntity.getyAxisLabel(), dataset,
                PlotOrientation.HORIZONTAL, true, true, false);

        XYPlot plot = (XYPlot) chart.getPlot();

        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        //渲染
        XYItemRenderer renderer = plot.getRenderer();
        //设置点颜色，设置边框
        renderer.setSeriesPaint(0, new Color(0,0,255,72));
        renderer.setSeriesOutlinePaint(0, new Color(0,0,0,150));

        LegendTitle legend = chart.getLegend();
        legend.setVisible(false);
        //设置边框颜色
        plot.setOutlinePaint(new Color(0, 0, 0));
        //设置背景颜色，白色
        plot.setBackgroundPaint(new Color(255,255,255,0));

        //横轴纵轴虚线
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        //纵轴虚线
        plot.setDomainCrosshairValue(scatterEntity.getY()[scatterEntity.getCityIndex()]);
        plot.setDomainCrosshairPaint(Color.red);

        //横轴虚线
        plot.setRangeCrosshairValue(scatterEntity.getX()[scatterEntity.getCityIndex()]);
        plot.setRangeCrosshairPaint(Color.RED);

        //为每个点设置标签名labelValue
        renderer.setBaseItemLabelGenerator(new ExtendedScatterItemLabelGeneratory(scatterEntity.getLabeValues()));
        renderer.setBaseToolTipGenerator(new StandardXYZToolTipGenerator());
        renderer.setBaseItemLabelsVisible(true);


        //设置Y轴范围
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        //设置坐标值
        domainAxis.setRange(scatterEntity.getMinRange(),scatterEntity.getMaxRange());

        //设置x轴范围
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(scatterEntity.getMinDomain(),scatterEntity.getMaxDomain());
        ChartUtils.setAntiAlias(chart);
        return chart;
    }

    /**
     * Creates a sample dataset.
     *
     * @return A sample dataset.
     */

    public static XYZDataset createDataset(ScatterEntity scatterEntity)throws Exception {
        DefaultXYZDataset dataset = new DefaultXYZDataset();
        double[] x = scatterEntity.getY();
        double[] y = scatterEntity.getX();
        double[] z = new double[x.length];
        for (int i = 0;i<x.length;i++) {
            z[i] = radius;
        }
        double[][] series = new double[][] {x,y,z };
        dataset.addSeries("Series 1", series);
        return dataset;
    }

}