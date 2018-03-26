/* -------------------------
 * StackedBarChartDemo2.java
 * -------------------------
 * (C) Copyright 2006, by Object Refinery Limited.
 *
 */

package charImage.stackedbarchardemo2;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import extend.ChartUtils;
import extend.CustomXWPFDocument;
import extend.PathConfig;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
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
import org.jfree.ui.*;
import output.OutputImage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * A stacked bar chart with a horizontal orientation.
 */
public class StackedBarChartDesign extends ApplicationFrame {

    /**
     * Creates a new demo instance.
     *
     * @param title the frame title.
     */
    public StackedBarChartDesign(String title) {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }

    /**
     * Returns a sample dataset.
     *
     * @return The dataset.
     */
    private static CategoryDataset createDataset() {

        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

//        dataset.addValue(57, "不太好", "晋源区"   );
//        dataset.addValue(45, "不太好", "古交市"   );
//        dataset.addValue(32, "不太好", "小店区"   );
//        dataset.addValue(32, "不太好", "清徐县"   );
//        dataset.addValue(29, "不太好", "全市"     );
//        dataset.addValue(28, "不太好", "尖草坪区" );
//        dataset.addValue(27, "不太好", "万柏林区" );
//        dataset.addValue(23, "不太好", "迎泽区"   );
//        dataset.addValue(14, "不太好", "杏花岭区" );
//        dataset.addValue(11, "不太好", "娄烦县"   );
//        dataset.addValue(7, "不太好",  "阳曲县"   );

        dataset.addValue(57, "晋源区" , "不太好"  );
        dataset.addValue(45, "古交市" , "不太好"  );
        dataset.addValue(32, "小店区" , "不太好"  );
        dataset.addValue(32, "清徐县" , "不太好"  );
        dataset.addValue(29, "全市"  , "不太好"   );
        dataset.addValue(28, "尖草坪区", "不太好" );
        dataset.addValue(27, "万柏林区", "不太好" );
        dataset.addValue(23, "迎泽区" , "不太好"  );
        dataset.addValue(14, "杏花岭区", "不太好" );
        dataset.addValue(11, "娄烦县" , "不太好"  );
        dataset.addValue(7 ,  "阳曲县",  "不太好"  );

        dataset.addValue(39, "晋源区" , "比较好");
        dataset.addValue(40, "古交市" , "比较好");
        dataset.addValue(59, "小店区" , "比较好");
        dataset.addValue(68, "清徐县" , "比较好");
        dataset.addValue(55, "全市"  , "比较好");
        dataset.addValue(62, "尖草坪区", "比较好");
        dataset.addValue(54, "万柏林区", "比较好");
        dataset.addValue(40, "迎泽区" , "比较好");
        dataset.addValue(61, "杏花岭区", "比较好");
        dataset.addValue(67, "娄烦县" , "比较好");
        dataset.addValue(86,  "阳曲县", "比较好");

        dataset.addValue(4 , "晋源区", "很好");
        dataset.addValue(15, "古交市", "很好");
        dataset.addValue(9 , "小店区", "很好");
        dataset.addValue(0 , "清徐县", "很好");
        dataset.addValue(16, "全市", "很好");
        dataset.addValue(10, "尖草坪区", "很好");
        dataset.addValue(19, "万柏林区", "很好");
        dataset.addValue(37, "迎泽区", "很好");
        dataset.addValue(25, "杏花岭区", "很好");
        dataset.addValue(22, "娄烦县", "很好");
        dataset.addValue(7 , "阳曲县", "很好");
        return dataset;
    }

    /**
     * Creates a sample chart.
     *
     * @param dataset the dataset.
     * @return The chart.
     */
    private static JFreeChart createChart(CategoryDataset dataset) {

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
        items.add(new LegendItem((String) dataset.getRowKey(0), new Color(123, 118, 125)));
        items.add(new LegendItem((String) dataset.getRowKeys().get(1), new Color(247, 192, 3)));
        items.add(new LegendItem("很好", new Color(81, 111, 175)));
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
        categoryAxis.setCategoryMargin(0.3);
        plot.setDomainAxis(categoryAxis);

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
        ChartUtils.setAntiAlias(chart);

        // set up gradient paints for series...
        renderer.setSeriesPaint(0, new Color(123, 118, 125));
        renderer.setSeriesPaint(1, new Color(247, 192, 3));
        renderer.setSeriesPaint(2, new Color(81, 111, 175));
        renderer.setBarPainter(new StandardBarPainter());
        return chart;

    }

    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        try {
            ByteArrayOutputStream byteOutputStream = OutputImage.getChartByteArray(chart, PathConfig.IMAGEWIDTH,PathConfig.IMAGEHEIGHT);
//            ChartUtilities.writeChartAsPNG(byteOutputStream,chart,500,270);
            CustomXWPFDocument document = new CustomXWPFDocument();
            String blipId = document.addPictureData(byteOutputStream.toByteArray(), Document.PICTURE_TYPE_PNG);
            System.out.println(blipId);
            System.out.println(document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG));
            int nextPicNameNumber = document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG);
            document.createPicture(blipId, 6, 500, 270);
            FileOutputStream outputStream = new FileOutputStream(new File("f:/4/chartOutput.docx"));
            document.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return new ChartPanel(chart);
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args ignored.
     */
    public static void main(String[] args) {
        StackedBarChartDesign demo = new StackedBarChartDesign(
                "JFreeChart: StackedBarChartDemo2.java");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}