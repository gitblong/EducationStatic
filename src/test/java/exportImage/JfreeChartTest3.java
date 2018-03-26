package exportImage;

import java.awt.Font;
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartUtilities;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PiePlot;  
import org.jfree.chart.title.LegendTitle;  
import org.jfree.chart.title.TextTitle;  
import org.jfree.data.general.DefaultPieDataset;  
  
/** 
 * 由JFreeChart生成图片放到硬盘上  
 * 对于Swing程序可以由org.jfree.chart.ChartUtilities类完成图片的生成 
 *  
 * @author 张明学 
 *  
 */  
public class JfreeChartTest3 {  
  
    public static void main(String[] args) {  
  
        JFreeChart chart = ChartFactory.createPieChart("某公司组织结构图",  
                getDataset(), true, false, false);  
        chart  
                .setTitle(new TextTitle("某公司组织结构图", new Font("仿宋", Font.BOLD,  
                        20)));  
        LegendTitle legend = chart.getLegend(0);  
        legend.setItemFont(new Font("隶书", Font.TYPE1_FONT, 16));  
        PiePlot plot = (PiePlot) chart.getPlot();  
        plot.setLabelFont(new Font("宋体", Font.HANGING_BASELINE, 12));  
  
        try {  
            OutputStream os = new FileOutputStream("company.jpeg");  
            try {  
                // 由ChartUtilities生成文件到一个体outputStream中去  
                ChartUtilities.writeChartAsJPEG(os, chart, 1000, 800);  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        }  
  
    }  
  
    private static DefaultPieDataset getDataset() {  
        DefaultPieDataset dpd = new DefaultPieDataset();  
        dpd.setValue("管理人员", 25);  
        dpd.setValue("市场人员", 10);  
        dpd.setValue("开发人员", 50);  
        dpd.setValue("其它人员", 15);  
        return dpd;  
    }  
  
}  