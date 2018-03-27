package output;

import draw.BubbleChart;
import draw.StackBarChart;
import entity.ScatterEntity;
import entity.StackBarEntity;
import extend.PathConfig;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import java.io.*;

/**
 * Created by Blong on 2018/3/16.
 * 导出图片
 */

public class OutputImage {
    private static String imagePath = PathConfig.IMAGEPATH;
    private final static int WIDTH = 500;
    private final static int HEIGHT= 500;

    /**
     * 输出StackBarChar返回路径
     * @param stackBarEntity
     * @return
     * @throws IOException
     */
    public static String outPutStackBarChar(StackBarEntity stackBarEntity) throws Exception {
        createPath();
        JFreeChart jFreeChart = StackBarChart.drawStackedBarChart(stackBarEntity);
        String filePath = imagePath + System.currentTimeMillis()+".png";
        OutputStream os = new FileOutputStream(filePath);
        ChartUtilities.writeChartAsPNG(os,jFreeChart,500,270);
        return filePath;
    }

    /**
     * 输出ScatterChar返回路径
     * @param scatterEntity
     * @return
     * @throws IOException
     */
    public static String outPutScatterChar(ScatterEntity scatterEntity) throws Exception {
        createPath();
        JFreeChart jFreeChart = BubbleChart.drawScatterChart(scatterEntity);
        String filePath = imagePath + System.currentTimeMillis()+".png";
        OutputStream os = new FileOutputStream(filePath);
        ChartUtilities.writeChartAsPNG(os,jFreeChart,500,270);
        return filePath;
    }

    /**
     * 将成成的cahrt 生成 字节流
     */
    public static ByteArrayOutputStream getChartByteArray(JFreeChart chart,int width,int height) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ChartUtilities.writeChartAsPNG(byteArrayOutputStream,chart,width,height);
        return byteArrayOutputStream;
    }

    public static void createPath() {
        File f = new File(imagePath);
        if (!f.exists()) {
            f.mkdirs();
        }
    }
}
