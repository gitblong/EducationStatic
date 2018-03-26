package charImage.stackedbarchardemo3;

 

import java.awt.*; 

import java.text.DecimalFormat; 

import java.text.NumberFormat;


import javax.swing.*;


import org.jfree.chart.*;

import org.jfree.chart.axis.*;

import org.jfree.chart.plot.CategoryPlot;

import org.jfree.chart.plot.PlotOrientation; 

import org.jfree.chart.title.LegendTitle; 

import org.jfree.data.category.CategoryDataset; 

import org.jfree.data.category.DefaultCategoryDataset; 

import org.jfree.ui.ApplicationFrame;

import org.jfree.ui.RefineryUtilities;


// Referenced classes of package demo: 

//            ExtendedStackedBarRenderer 

 

public class StackedBarChartDemo3 extends ApplicationFrame { 

 

    private static final long serialVersionUID = 1L; 

 

    public StackedBarChartDemo3(String s) { 

        super(s); 

        JPanel jpanel = createDemoPanel(); 

        jpanel.setPreferredSize(new Dimension(500, 270)); 

        setContentPane(jpanel); 

    } 

 

    private static CategoryDataset createDataset() { 

        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset(); 

        defaultcategorydataset.addValue(.101D, "Series 1", "Cross Contamination (4.3)"); 

        defaultcategorydataset.addValue(.4D, "Series 2", "Cross Contamination (4.3)"); 

        return defaultcategorydataset; 

    } 

 

    private static JFreeChart createChart(CategoryDataset categorydataset) { 

 

        JFreeChart jfreechart = ChartFactory.createStackedBarChart("Stacked Bar Chart Demo 3", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, false); 

 

        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot(); 

        //柱体 

        ExtendedStackedBarRenderer extendedstackedbarrenderer = new ExtendedStackedBarRenderer(new DecimalFormat("#0.0%")); 

        //柱体标签是否可见 

        extendedstackedbarrenderer.setBaseItemLabelsVisible(true); 

        Font labelFont = new Font("Arial", Font.PLAIN, 12); 

        extendedstackedbarrenderer.setBaseItemLabelPaint(new GradientPaint(0.0f, 0.0f, new Color(255, 255, 255), 0.0f, 0.0f, new Color(0, 0, 0))); 

        //设置柱体标签值的格式 

        ExtendedStandardCategoryItemLabelGeneratory generator = new ExtendedStandardCategoryItemLabelGeneratory("{3}", 

                NumberFormat.getPercentInstance(), new DecimalFormat("#0.0%"),false); 

        extendedstackedbarrenderer.setBaseItemLabelGenerator(generator); 
        //自定义柱体颜色

        Paint p0 = new GradientPaint(0.0f, 0.0f, new Color(237, 125, 49), 0.0f, 0.0f, new Color(237, 125, 49)); 

        extendedstackedbarrenderer.setSeriesPaint(0, p0); 

        Paint p1 = new GradientPaint(0.0f, 0.0f, new Color(91, 155, 213), 0.0f, 0.0f, new Color(91, 155, 213)); 

        extendedstackedbarrenderer.setSeriesPaint(1, p1); 

 

        categoryplot.setRenderer(extendedstackedbarrenderer); 

 

        //Y 轴 

        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis(); 

        //不设置是自动显示步长 

        numberaxis.setTickUnit(new NumberTickUnit(0.05)); 

        numberaxis.setLowerMargin(0.14999999999999999D); 

        numberaxis.setUpperMargin(0.14999999999999999D); 

        //设置是否是百分率 

        numberaxis.setNumberFormatOverride(NumberFormat.getPercentInstance()); 

 

        //X 辆 

        CategoryAxis categoryAxis = categoryplot.getDomainAxis(); 

        //x轴旋转 

        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)); 

 

        //标注 

        LegendTitle legendtitle = (LegendTitle)jfreechart.getLegend(); 

        legendtitle.setBorder(0, 0, 0, 0); 

        return jfreechart; 

    } 

 

    public static JPanel createDemoPanel() { 

        JFreeChart jfreechart = createChart(createDataset()); 

        return new ChartPanel(jfreechart); 

    } 

 

    public static void main(String args[]) { 

        StackedBarChartDemo3 stackedbarchartdemo3 = new StackedBarChartDemo3("Stacked Bar Chart Demo 3"); 

        stackedbarchartdemo3.pack(); 

        RefineryUtilities.centerFrameOnScreen(stackedbarchartdemo3); 

        stackedbarchartdemo3.setVisible(true); 

    } 

} 

 

 
