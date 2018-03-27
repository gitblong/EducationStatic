//package charImage.ScatterPlotDemo;
//
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.BubbleChart;
//import javafx.scene.chart.XYChart;
//import javafx.scene.control.Button;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.ui.RefineryUtilities;
//
//import javax.swing.*;
//
//
//public class ScatterChartSampleDesign {
//
//    public void createChart(){
//        final NumberAxis xAxis = new NumberAxis(0.5, 10, 1);
//        final NumberAxis yAxis = new NumberAxis(0.5, 500, 100);
//        final BubbleChart<Number,Number> sc =
//                new BubbleChart<Number,Number>(xAxis,yAxis);
//        xAxis.setLabel("Age (years)");
//        yAxis.setLabel("Returns to date");
//        sc.setTitle("Investment Overview");
//
//        XYChart.Series series1 = new XYChart.Series();
//
//        series1.setName("Option 1");
//        series1.getData().add(new XYChart.Data(4.2, 193.2));
//        series1.getData().add(new XYChart.Data(2.8, 33.6));
//        series1.getData().add(new XYChart.Data(6.2, 24.8));
//        series1.getData().add(new XYChart.Data(1, 14));
//        series1.getData().add(new XYChart.Data(1.2, 26.4));
//        series1.getData().add(new XYChart.Data(4.4, 114.4));
//        series1.getData().add(new XYChart.Data(8.5, 323));
//        series1.getData().add(new XYChart.Data(6.9, 289.8));
//        series1.getData().add(new XYChart.Data(9.9, 287.1));
//        series1.getData().add(new XYChart.Data(0.9, -9));
//        series1.getData().add(new XYChart.Data(3.2, 150.8));
//        series1.getData().add(new XYChart.Data(4.8, 20.8));
//        series1.getData().add(new XYChart.Data(7.3, -42.3));
//        series1.getData().add(new XYChart.Data(1.8, 81.4));
//        series1.getData().add(new XYChart.Data(7.3, 110.3));
//        series1.getData().add(new XYChart.Data(2.7, 41.2));
//
//        sc.setPrefSize(500, 400);
//        sc.getData().addAll(series1);
//    }
//
//    /**
//     * Creates a panel for the demo (used by SuperDemo.java).
//     *
//     * @return A panel.
//     */
//    public static JPanel createDemoPanel() {
//        JFreeChart chart = ChartFactory.createBubbleChart();
//        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setMouseWheelEnabled(true);
//        return chartPanel;
//    }
//    /**
//     * Starting point for the demonstration application.
//     *
//     * @param args  ignored.
//     */
//    public static void main(String[] args) {
//        ScatterChart demo = new ScatterChart(
//                "JFreeChart: ScatterChart.java");
//        demo.pack();
//        RefineryUtilities.centerFrameOnScreen(demo);
//        demo.setVisible(true);
//    }
//}