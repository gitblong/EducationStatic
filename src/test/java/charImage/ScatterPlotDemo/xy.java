package charImage.ScatterPlotDemo;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.*;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

import javax.swing.*;


public class xy {

    /**
     *
     */
    public static JFreeChart createChart(){
        // TODO Auto-generated method stub
        XYSeries xyseries = new XYSeries("First");

        xyseries.add(1.0D, 1.0D,true);
        xyseries.add(2D, 4D);
        xyseries.add(3D, 3D);
        xyseries.add(4D, 5D);
        xyseries.add(5D, 5D);
        xyseries.add(6D, 7D);
        xyseries.add(7D, 7D);
        xyseries.add(8D, 8D);
        XYSeries xyseries1 = new XYSeries("Second");
        xyseries1.add(1.0D, 5D);
        xyseries1.add(2D, 7D);
        xyseries1.add(3D, 6D);
        xyseries1.add(4D, 8D);
        xyseries1.add(5D, 4D);
        xyseries1.add(6D, 4D);
        xyseries1.add(7D, 2D);
        xyseries1.add(8D, 1.0D);

        XYSeries xyseries2 = new XYSeries("Third");
        xyseries2.add(3D, 4D);
        xyseries2.add(4D, 3D);
        xyseries2.add(5D, 2D);
        xyseries2.add(6D, 3D);
        xyseries2.add(7D, 6D);
        xyseries2.add(8D, 3D);
        xyseries2.add(9D, 4D);
        xyseries2.add(10D, 3D);

        XYSeriesCollection xyseriescollection = new XYSeriesCollection(); //再用XYSeriesCollection添加入XYSeries 对象
        xyseriescollection.addSeries(xyseries);
        xyseriescollection.addSeries(xyseries1);
        xyseriescollection.addSeries(xyseries2);



        //创建主题样式         
        StandardChartTheme standardChartTheme=new StandardChartTheme("CN");        
        //设置标题字体         
        standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));        
        //设置图例的字体        
        standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));        
        //设置轴向的字体       
        standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));        
        //应用主题样式      
        ChartFactory.setChartTheme(standardChartTheme);  
        //    JFreeChart chart=ChartFactory.createXYAreaChart("xyPoit", "点的标号", "出现次数", xyseriescollection, PlotOrientation.VERTICAL, true, false, false);
        JFreeChart chart=ChartFactory.createScatterPlot("xyPoit", "点的标号", "出现次数", xyseriescollection, PlotOrientation.VERTICAL, true, false, false);
        XYPlot xyPlot = chart.getXYPlot();
        XYItemRenderer renderer = xyPlot.getRenderer();

        renderer.setSeriesItemLabelFont(0,new Font("text",Font.PLAIN,12));
        renderer.setBaseItemLabelsVisible(true);
        return chart;
//        try {
//                    ChartUtilities.saveChartAsPNG(new File("E:/BarChart3D.png"), chart, 500, 500);
//                } catch (IOException e) {
//                     TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//        ChartFrame ChartFrame = new ChartFrame("水果产量图",chart);
//        ChartFrame.pack();
//        //ChartFrame.setFont(new Font("宋体",Font.BOLD,20));
//        ChartFrame.setVisible(true);
//        System.out.println("绘图完成"); 

    }
    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart();
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        panel.addChartMouseListener(new ScatterPlotDemo3.MyChartMouseListener(panel));
        return panel;
    }
    public static void main(String[] args) {
        ScatterPlotDemo3 demo = new ScatterPlotDemo3(
                "JFreeChart: ScatterPlotDemo3.java");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }



}