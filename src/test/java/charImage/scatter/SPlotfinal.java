package charImage.scatter;

import java.awt.*;
import java.util.*;
import javax.swing.JPanel;

import javafx.scene.shape.Ellipse;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;

public class SPlotfinal extends ApplicationFrame {

    public SPlotfinal(String s) {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(640, 480));
        add(jpanel);
    }

    public static JPanel createDemoPanel() {
        JFreeChart jfreechart = ChartFactory.createScatterPlot(
            "Scatter Plot Demo", "X", "Y", samplexydataset2(),
            PlotOrientation.VERTICAL, true, true, false);
        Shape cross = ShapeUtilities.createDiagonalCross(3, 1);
        Shape diamond = ShapeUtilities.createDiamond(4f);
        Shape downTriangle = ShapeUtilities.createDownTriangle(4f);
        Shape regularCross = ShapeUtilities.createRegularCross(4f, 4f);
        Shape upTriangle = ShapeUtilities.createUpTriangle(4f);

//        new DrawShape().drawRoundRect(0,0,4,4,0.5f,0.5f);
//        Ellipse ellipse = new Ellipse().;
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();

        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setSeriesShape(0, upTriangle);
        renderer.setSeriesPaint(0, Color.blue);
        renderer.setSeriesItemLabelsVisible(0,true);
        return new ChartPanel(jfreechart);
    }

    private static XYDataset samplexydataset2() {
        int cols = 20;
        int rows = 20;
        double[][] values = new double[cols][rows];
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        XYSeries series = new XYSeries("Random");
        Random rand = new Random();
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                double x = rand.nextGaussian();
                double y = rand.nextGaussian();
                series.add(x, y);
            }
        }
        xySeriesCollection.addSeries(series);
        return xySeriesCollection;
    }

    public static void main(String args[]) {
        SPlotfinal scatterplotdemo4 = new SPlotfinal("Scatter Plot Demo 4");
        scatterplotdemo4.pack();
        RefineryUtilities.centerFrameOnScreen(scatterplotdemo4);
        scatterplotdemo4.setVisible(true);
    }
}