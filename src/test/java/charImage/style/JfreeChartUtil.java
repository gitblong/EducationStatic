//import CharDemo.PieChart;
//import javafx.scene.chart.BarChart;
//import javafx.scene.chart.LineChart;
//import org.apache.poi.xwpf.usermodel.XWPFParagraph;
//import org.apache.poi.xwpf.usermodel.XWPFRun;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.StandardChartTheme;
//import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.labels.ItemLabelAnchor;
//import org.jfree.chart.labels.ItemLabelPosition;
//import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
//import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
//import org.jfree.chart.plot.*;
//import org.jfree.chart.renderer.category.LineAndShapeRenderer;
//import org.jfree.chart.renderer.category.StandardBarPainter;
//import org.jfree.chart.renderer.xy.StandardXYBarPainter;
//import org.jfree.data.category.DefaultCategoryDataset;
//import org.jfree.data.general.DefaultPieDataset;
//import org.jfree.ui.RectangleInsets;
//import org.jfree.ui.TextAnchor;
//
//import java.awt.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.DecimalFormat;
//import java.text.NumberFormat;
//
///**
// * 生成饼图、环形、柱状、线型、面积等统计图片
// * Utils:poi生成word工具类
// * @author zyl
// * @date 2017-09-20
// */
//public class JfreeChartUtil {
//    private static final String FILE_OUT_PUT_PATH = "D://";
////    private static final Logger log = LoggerFactory.getLogger(JfreeChartUtil.class);
//    private static String NO_DATA_MSG = "数据加载失败";
//    private static Font FONT = new Font("宋体", Font.PLAIN, 10);
//    private static Font FONT_BOLD = new Font("宋体",Font.BOLD+Font.PLAIN,20);
//    public static Color[] CHART_COLORS = {
//        new Color(31,129,188), new Color(92,92,97), new Color(144,237,125), new Color(255,188,117),
//        new Color(153,158,255), new Color(255,117,153), new Color(253,236,109), new Color(128,133,232),
//        new Color(158,90,102),new Color(255, 204, 102)};//颜色
//    static {
//        setChartTheme();
//    }
//    /**
//     * 中文主题样式 解决乱码
//     */
//    public static void setChartTheme() {
//        // 设置中文主题样式 解决乱码
//        StandardChartTheme chartTheme = new StandardChartTheme("CN");
//        // 设置标题字体，加粗
//        chartTheme.setExtraLargeFont(FONT_BOLD);
//        // 设置图例的字体
//        chartTheme.setRegularFont(FONT);
//        // 设置轴向的字体
//        chartTheme.setLargeFont(FONT);
//
//        chartTheme.setSmallFont(FONT);
//        chartTheme.setTitlePaint(new Color(51, 51, 51));
//        chartTheme.setSubtitlePaint(new Color(85, 85, 85));
//
//        chartTheme.setLegendBackgroundPaint(Color.WHITE);// 设置标注
//        chartTheme.setLegendItemPaint(Color.BLACK);//
//        chartTheme.setChartBackgroundPaint(Color.WHITE);
//        // 绘制颜色绘制颜色.轮廓供应商
//        // paintSequence,outlinePaintSequence,strokeSequence,outlineStrokeSequence,shapeSequence
//
//        Paint[] OUTLINE_PAINT_SEQUENCE = new Paint[] { Color.WHITE };
//        // 绘制器颜色源
//        DefaultDrawingSupplier drawingSupplier = new DefaultDrawingSupplier(CHART_COLORS, CHART_COLORS, OUTLINE_PAINT_SEQUENCE,
//                DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE, DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
//                DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE);
//        chartTheme.setDrawingSupplier(drawingSupplier);
//
//        chartTheme.setPlotBackgroundPaint(Color.WHITE);// 绘制区域
//        chartTheme.setPlotOutlinePaint(Color.WHITE);// 绘制区域外边框
//        chartTheme.setLabelLinkPaint(new Color(8, 55, 114));// 链接标签颜色
//        chartTheme.setLabelLinkStyle(PieLabelLinkStyle.CUBIC_CURVE);
//
//        chartTheme.setAxisOffset(new RectangleInsets(5, 12, 5, 12));
//        chartTheme.setDomainGridlinePaint(new Color(192, 208, 224));// X坐标轴垂直网格颜色
//        chartTheme.setRangeGridlinePaint(new Color(192, 192, 192));// Y坐标轴水平网格颜色
//
//        chartTheme.setBaselinePaint(Color.WHITE);
//        chartTheme.setCrosshairPaint(Color.BLUE);// 不确定含义
//        chartTheme.setAxisLabelPaint(new Color(51, 51, 51));// 坐标轴标题文字颜色
//        chartTheme.setTickLabelPaint(new Color(67, 67, 72));// 刻度数字
//        chartTheme.setBarPainter(new StandardBarPainter());// 设置柱状图渲染
//        chartTheme.setXYBarPainter(new StandardXYBarPainter());// XYBar 渲染
//
//        chartTheme.setItemLabelPaint(Color.black);
//        chartTheme.setThermometerPaint(Color.white);// 温度计
//
//        ChartFactory.setChartTheme(chartTheme);
//    }
//
//    /**
//     * 获取饼状图
//     * @param title  标题
//     * @param data  饼状体数据集
//     * @param is3D   是否3D生成
//     */
//    public static JFreeChart getPieChart(String title, PieChart data, boolean is3D){
//        DefaultPieDataset dataset = new DefaultPieDataset();
//        for(PieChartSeriesData data_ : data.getOpinionData()){
//            String name = data_.getName();
//            Integer value = data_.getValue();
//            dataset.setValue(name, value);
//        }
//        //创建 Jfreechart对象
//        JFreeChart jfreechart = null;
//        if(is3D){
//            jfreechart = ChartFactory.createPieChart3D(title, dataset, true, true, false);
//        }else{
//            jfreechart = ChartFactory.createPieChart(title, dataset, true, true, false);
//        }
//        //设置文本抗锯齿
//        jfreechart.setTextAntiAlias(false);
//        PiePlot piePlot = (PiePlot) jfreechart.getPlot();
//        piePlot.setNoDataMessage(NO_DATA_MSG);
//        piePlot.setInsets(new RectangleInsets(0, 0, 0, 0));
//        piePlot.setCircular(true);// 圆形
//
//        piePlot.setLabelGap(0.01);
//        piePlot.setInteriorGap(0.05D);
//        piePlot.setLegendItemShape(new Rectangle(10, 10));// 图例形状
//        //去掉背景色
//        piePlot.setLabelBackgroundPaint(null);
//        //去掉阴影
//        piePlot.setLabelShadowPaint(null);
//        //去掉边框
//        piePlot.setLabelOutlinePaint(null);
//        piePlot.setShadowPaint(null);
//        //设置Pie的边框是否可见
//        piePlot.setSectionOutlinesVisible(false);
//        // 指定图片的透明度(0.0-1.0)
//        piePlot.setForegroundAlpha(1.0f);
//        //设置边框的颜色
//        piePlot.setBaseSectionOutlinePaint(Color.green);
//        //设置边框的粗细,new BasicStroke(2.0f)
//        piePlot.setBaseSectionOutlineStroke(new BasicStroke(1));
//        //设置空值,0值,负值是否显示出来,如果显示的话就是false
//        piePlot.setIgnoreNullValues(true);
//        piePlot.setIgnoreZeroValues(true);
//        //设置上面的样式,0表示KEY,1表示VALUE,2表示百分之几,DecimalFormat用来显示百分比的格式
//        piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{2}", NumberFormat.getNumberInstance(),new DecimalFormat("0.00%")));
//        //设置下面方框的样式,0表示KEY,1表示VALUE,2表示百分之几,DecimalFormat用来显示百分比的格式
//        piePlot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}({1},{2})",NumberFormat.getNumberInstance(),   new DecimalFormat("0.00%")));
//        //爆炸模式,使Pie的一块分离出去,不支持3D  piePlot.setExplodePercent("正面", 0.10);
//
//        return jfreechart;
//    }
//
//    /**
//     * 获取折线图
//     * @param title  标题
//     * @param data  折线图数据集
//     * @param is3D   是否3D生成
//     */
//    public static JFreeChart getLineChart(String title, LineChart data, boolean is3D){
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        java.util.List<String> navdata = data.getNavdata();
//        java.util.ListList<String> xAxisdata = data.getxAxisdata();
//        for(int i = 0;i < navdata.size();i++){
//            String navName = navdata.get(i);
//            List<Integer> dataList = data.getOpinionData().get(i).getData();
//            for(int j = 0; j< xAxisdata.size();j++){
//                String date = xAxisdata.get(j);
//                Integer count = dataList.get(j);
//                dataset.setValue(count, navName, String.valueOf(date));
//            }
//        }
//        //创建 Jfreechart对象
//        JFreeChart jfreechart = null;
//        if(is3D){
//            jfreechart = ChartFactory.createLineChart3D(title,
//                "时间", //横坐标名称
//                "数量", //纵坐标名称
//                dataset,//数据
//                PlotOrientation.VERTICAL, //垂直视图
//                true, //include legend
//                true, //tooltips
//                false
//            );
//        }else{
//            jfreechart = ChartFactory.createLineChart(title,
//                "时间", //横坐标名称
//                "数量", //纵坐标名称
//                dataset,//数据
//                PlotOrientation.VERTICAL, //垂直视图
//                true, //include legend
//                true, //tooltips
//                false
//            );
//        }
//
//        //设置文本抗锯齿
//        jfreechart.setTextAntiAlias(false);
//        CategoryPlot plot = jfreechart.getCategoryPlot();
//        plot.setNoDataMessage(NO_DATA_MSG);
//        plot.setRangeGridlinesVisible(true); //是否显示格子线
//        plot.setBackgroundAlpha(0.3f); //设置背景透明度
//        NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
//        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//        rangeAxis.setAutoRangeIncludesZero(true);
//        rangeAxis.setUpperMargin(0.10);
//        rangeAxis.setLabelAngle(Math.PI / 2.0);
//
//        // 数据渲染部分 主要是对折线做操作
//        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
//        renderer.setBaseItemLabelsVisible(true);
//        renderer.setBaseShapesFilled(true);
//        renderer.setBaseItemLabelsVisible(true);
//        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
//        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//        plot.setRenderer(renderer);
//        return jfreechart;
//    }
//
//    /**
//     * 获取柱状图
//     * @param title  标题
//     * @param data   柱状图数据集
//     * @param is3D   是否3D生成
//     */
//    public static JFreeChart getBarChart(String title, BarChart data, boolean is3D){
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        List<String> navdata = data.getNavdata();
//        List<String> xAxisdata = data.getxAxisdata();
//        for(int i = 0;i < navdata.size();i++){
//            String navName = navdata.get(i);
//            List<Integer> dataList = data.getOpinionData().get(i).getData();
//            for(int j = 0; j< xAxisdata.size();j++){
//                String date = xAxisdata.get(j);
//                Integer count = dataList.get(j);
//                dataset.setValue(count, navName, String.valueOf(date));
//            }
//        }
//        //创建 Jfreechart对象
//        JFreeChart jfreechart = null;
//        if(is3D){
//            jfreechart = ChartFactory.createBarChart3D(title,
//                "时间", //横坐标名称
//                "数量", //纵坐标名称
//                dataset,//数据
//                PlotOrientation.VERTICAL, //垂直视图
//                true, //include legend
//                true, //tooltips
//                false
//            );
//        }else{
//            jfreechart = ChartFactory.createBarChart(title,
//                "时间", //横坐标名称
//                "数量", //纵坐标名称
//                dataset,//数据
//                PlotOrientation.VERTICAL, //垂直视图
//                true, //include legend
//                true, //tooltips
//                false
//            );
//        }
//        //设置文本抗锯齿
//        jfreechart.setTextAntiAlias(false);
//        CategoryPlot plot = jfreechart.getCategoryPlot();
//        plot.setNoDataMessage(NO_DATA_MSG);
//        plot.setInsets(new RectangleInsets(10, 10, 5, 10));
//        plot.setRangeGridlinesVisible(true); //是否显示格子线
//        plot.setBackgroundAlpha(0.3f); //设置背景透明度
//        //对y轴操作
//        NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
//        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//        //上边距
//        rangeAxis.setUpperMargin(0.10);
//        //字体倾斜度
//        rangeAxis.setLabelAngle(Math.PI / 2.0);
//
//        BarRenderer renderer = (BarRenderer) plot.getRenderer();
//        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//        renderer.setMaximumBarWidth(0.075);// 设置柱子最大宽度
//        renderer.setBaseItemLabelsVisible(true);
//        //显示数字和数字显示的位置
//        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER));
//        renderer.setItemLabelAnchorOffset(20D);
//        return jfreechart;
//    }
//
//    /**
//     *获取面积图
//     * @param title  标题
//     * @param data  数据集
//     * @param is3D   是否3D生成
//     */
//    public static JFreeChart getAreaChart(String title,LineChart data){
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        List<String> navdata = data.getNavdata();
//        List<String> xAxisdata = data.getxAxisdata();
//        for(int i = 0;i < navdata.size();i++){
//            String navName = navdata.get(i);
//            List<Integer> dataList = data.getOpinionData().get(i).getData();
//            for(int j = 0; j< xAxisdata.size();j++){
//                String date = xAxisdata.get(j);
//                Integer count = dataList.get(j);
//                dataset.setValue(count, navName, String.valueOf(date));
//            }
//        }
//        //创建 Jfreechart对象
//        JFreeChart jfreechart = ChartFactory.createAreaChart(title,
//            "时间", //横坐标名称
//            "数量", //纵坐标名称
//            dataset,//数据
//            PlotOrientation.VERTICAL, //垂直视图
//            true, //include legend
//            true, //tooltips
//            false
//        );
//        //设置文本抗锯齿
//        jfreechart.setTextAntiAlias(false);
//        CategoryPlot plot = jfreechart.getCategoryPlot();
//        plot.setNoDataMessage(NO_DATA_MSG);
//        plot.setRangeGridlinesVisible(true); //是否显示格子线
//        plot.setBackgroundAlpha(0.3f); //设置背景透明度
//        NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
//        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//        rangeAxis.setAutoRangeIncludesZero(true);
//        rangeAxis.setUpperMargin(0.10);
//        rangeAxis.setLabelAngle(Math.PI / 2.0);
//
//        return jfreechart;
//    }
//
//    /**
//     * 获取环形图
//     * @param title  标题
//     * @param data  数据集
//     * @param is3D   是否3D生成
//     */
//    public static JFreeChart getRingChart(String title,PieChart data){
//        DefaultPieDataset dataset = new DefaultPieDataset();
//        for(PieChartSeriesData data_ : data.getOpinionData()){
//            String name = data_.getName();
//            Integer value = data_.getValue();
//            dataset.setValue(name, value);
//        }
//        //创建 Jfreechart对象
//        JFreeChart jfreechart = ChartFactory.createRingChart(title, dataset, true, true, false);
//        //设置文本抗锯齿
//        jfreechart.setTextAntiAlias(false);
//        PiePlot piePlot = (PiePlot) jfreechart.getPlot();
//        piePlot.setNoDataMessage(NO_DATA_MSG);
//        piePlot.setInsets(new RectangleInsets(0, 0, 0, 0));
//        piePlot.setCircular(true);// 圆形
//
//        piePlot.setLabelGap(0.01);
//        piePlot.setInteriorGap(0.05D);
//        piePlot.setLegendItemShape(new Rectangle(10, 10));// 图例形状
//        //去掉背景色
//        piePlot.setLabelBackgroundPaint(null);
//        //去掉阴影
//        piePlot.setLabelShadowPaint(null);
//        //去掉边框
//        piePlot.setLabelOutlinePaint(null);
//        piePlot.setShadowPaint(null);
//        //设置Pie的边框是否可见
//        piePlot.setSectionOutlinesVisible(false);
//        // 指定图片的透明度(0.0-1.0)
//        piePlot.setForegroundAlpha(1.0f);
//        //设置边框的颜色
//        piePlot.setBaseSectionOutlinePaint(Color.green);
//        //设置边框的粗细,new BasicStroke(2.0f)
//        piePlot.setBaseSectionOutlineStroke(new BasicStroke(1));
//        //设置空值,0值,负值是否显示出来,如果显示的话就是false
//        piePlot.setIgnoreNullValues(true);
//        piePlot.setIgnoreZeroValues(true);
//        //设置上面的样式,0表示KEY,1表示VALUE,2表示百分之几,DecimalFormat用来显示百分比的格式
//        piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{2}",NumberFormat.getNumberInstance(),new DecimalFormat("0.00%")));
//        //设置下面方框的样式,0表示KEY,1表示VALUE,2表示百分之几,DecimalFormat用来显示百分比的格式
//        piePlot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}({1},{2})",NumberFormat.getNumberInstance(),   new DecimalFormat("0.00%")));
//        //爆炸模式,使Pie的一块分离出去,不支持3D
//        //piePlot.setExplodePercent("正面", 0.10);
//        return jfreechart;
//    }
//
//    /**
//     * 获取图片流
//     * @param jfreechart
//     * @param weight
//     * @param height
//     * @return
//     */
//    public static InputStream getChartStream(JFreeChart jfreechart,int weight, int height){
//        InputStream input = null;
//        try {
//            BufferedImage bufferedImage = jfreechart.createBufferedImage(weight, height);
//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//            ImageIO.write(bufferedImage, "png", os);
//            input = new ByteArrayInputStream(os.toByteArray());
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.info("------------------------------------" + e.getMessage());
//        }
//        return input;
//
//    }
//    /**
//     * 保存为文件
//     * @param chart
//     * @param fileName
//     * @param weight
//     * @param height
//     * @throws Exception
//     */
//    public static void saveAsFile(JFreeChart chart, String fileName,int weight, int height) {
//        FileOutputStream out = null;
//        File outFile = new File(FILE_OUT_PUT_PATH + fileName);
//        if (!outFile.getParentFile().exists()) {
//            outFile.getParentFile().mkdirs();
//        }
//        try {
//            out = new FileOutputStream(FILE_OUT_PUT_PATH + fileName);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            log.info("------------------------------------" + e.getMessage());
//        }
//        // 保存为PNG
//        try {
//            ChartUtilities.writeChartAsPNG(out, chart, weight, height);
//        } catch (IOException e) {
//            e.printStackTrace();
//            log.info("------------------------------------" + e.getMessage());
//        }finally{
//            try {
//                out.flush();
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    //比较器类
//    static class MapValueComparator implements Comparator<Map.Entry<String, String>> {
//        public int compare(Entry<String, String> me1, Entry<String, String> me2) {
//            return me1.getValue().compareTo(me2.getValue());
//        }
//    }
//    /**
//     * poi生成word工具类
//     * @author zyl
//     *
//     */
//    public static class Utils{
//        private static final String FONT_FAMILY = "宋体";//字体类型
//        private static final int DOC_NAME = 20;//文档名称
//        private static final int FONT_TITLE_1 = 18;//一级标题文字大小
//        private static final int FONT_TITLE_2 = 10;//二级标题文字大小
//        private static final int FONT_SIZE = 10;//正文字体大小
//        private static final String HEAD_BG_COLOR = "ffff66";//表格标题背景颜色
//        private static final int HR_HEIGHT = 300;//表格行高
//        private static final int IMG_WIDTH = 600;//图片宽度
//        private static final int IMG_HEIGHT = 400;//图片高度
//
//        /**
//         * 为段落添加内容
//         * @param p  当前段落
//         * @param isBold  是否加粗
//         * @param fontSize  字体大小
//         * @param text  文本内容
//         * @param isBreak  是否换行
//         */
//        public static void addText(XWPFParagraph p, String text, boolean isBold, int fontSize, String fontColor, boolean isBreak){
//            XWPFRun run = p.createRun();
//            run.setFontSize(fontSize == 0 ? FONT_SIZE : fontSize);
//            run.setText(text);
//            run.setFontFamily(FONT_FAMILY);
//            if(fontColor != null && !"".equals(fontColor))
//                run.setColor(fontColor);
//            run.setBold(isBold);
//            if(isBreak)
//                run.addBreak();
//        }
//        /**
//         * 添加正文内容和颜色
//         * @param p
//         * @param colors
//         * @param content
//         * @param isBreak
//         */
//        public static void addText(XWPFParagraph p,Map<String,String> colors,String content,boolean isBreak){
//            //关键词位置
//            if(colors != null && !colors.isEmpty() && content != null && !"".equals(content)){
//                int curPos = 0;
//                String curStr = content;
//                for(String key : colors.keySet()){
//                    String color = colors.get(key);
//                    Integer pos = curStr.indexOf(key);
//                    if(pos < 0){
//                        continue;
//                    }
//                    //添加文本
//                    Utils.addText(p, curStr.substring(curPos, pos), false, Utils.FONT_SIZE, "", false);
//                    //添加文本
//                    Utils.addText(p,curStr.substring(pos, (pos + key.length()) > curStr.length() ? curStr.length() : (pos + key.length())), true, Utils.FONT_SIZE,color, false);
//                    curStr= curStr.substring(pos + key.length());
//                }
//                if(curStr != null && !"".equals(curStr))
//                    Utils.addText(p,curStr, false, Utils.FONT_SIZE,"", isBreak);
//
//            }else{
//                Utils.addText(p,content, false, Utils.FONT_SIZE,"", isBreak);
//            }
//        }
//
//        /**  添加正文
//         * @param p
//         * @param content
//         * @param isBreak
//         */
//        public static void addText(XWPFParagraph p,String content,boolean isBreak){
//            Utils.addText(p,content, false, Utils.FONT_SIZE,"", isBreak);
//          }
//
//        /**
//         * 文档添加表格
//         * @param p
//         * @param rows
//         * @param cols
//         * @param dataset  key:类型，value：类型的数据
//         */
//        public static void addTable(XWPFParagraph p,int w,String[][] dataset){
//            if(dataset.length == 0){
//                return;
//            }
//            int rows = dataset.length;
//            int cols = dataset[0].length;
//            //创建表格
//            XWPFTable table= p.getDocument().createTable(rows, cols);
//
//            CTTbl ttbl = table.getCTTbl();
//            CTTblPr tblPr = ttbl.getTblPr() == null ? ttbl.addNewTblPr() : ttbl.getTblPr();
//            CTTblWidth tblWidth = tblPr.isSetTblW() ? tblPr.getTblW() : tblPr.addNewTblW();
//            CTJc cTJc=tblPr.addNewJc();
//            cTJc.setVal(STJc.Enum.forString("center"));
//            tblWidth.setW(new BigInteger(String.valueOf(w == 0 ? 8000 : w)));
//            tblWidth.setType(STTblWidth.DXA);
//
//
//            //设置表格行高
//            for(XWPFTableRow  row : table.getRows()){
//                row.setHeight(HR_HEIGHT);
//            }
//            //设置表格数据
//            for(int i= 0;i < dataset.length;i++){
//                for(int j = 0;j < dataset[i].length;j++){
//                    if(i == 0){
//                        //填充表头数据
//                        Utils.addCell(table.getRow(i),j, dataset[i][j], Utils.HEAD_BG_COLOR,"", 9, true);
//                    }else{
//                        Utils.addCell(table.getRow(i),j,dataset[i][j], "","", 9, false);
//                    }
//                }
//            }
//
//            //删除第一列
//            for(XWPFTableRow r : table.getRows()){
//                r.removeCell(0);
//            }
//
//        }
//        /**
//         * 添加单元格
//         * @param r  当前行
//         * @param index 列索引
//         * @param text  文本内容
//         * @param cellColor  单元格背景颜色
//         * @param textColor  单元格文本颜色
//         * @param fontSize   单元格文字大小
//         * @param isBold  是否加粗
//         */
//        public static void addCell(XWPFTableRow r,int index,String text,String cellColor,String textColor,int fontSize,boolean isBold){
//            XWPFTableCell cell = r.getCell(index);
//            cell.setVerticalAlignment(XWPFVertAlign.CENTER);
//            if(cellColor != null && !"".equals(cellColor))
//                cell.setColor(cellColor);
//            XWPFParagraph xp = cell.addParagraph();
//            xp.setAlignment(ParagraphAlignment.CENTER);
//            cell.removeParagraph(0);
//            XWPFRun xpRun = xp.createRun();
//            xpRun.setBold(isBold);
//            xpRun.setText(text);
//            xpRun.setFontSize(fontSize == 0 ? FONT_SIZE : fontSize );
//            if(textColor != null && !"".equals(textColor))
//                xpRun.setColor(textColor);
//        }
//        /**
//         * 添加图片
//         * @param doc    文档对象
//         * @param input  图片流
//         * @param width  图片宽度
//         * @param height 图片高度
//         */
//        public static void addImage(CustomXWPFDocument doc,InputStream input,int width,int height){
//            //创建空的段落
//            XWPFParagraph p = doc.createParagraph();
//            try {
//                doc.addPictureData(input, XWPFDocument.PICTURE_TYPE_PNG);
//                doc.createPicture(p,doc.getAllPictures().size()-1, width, height,"");
//            } catch (InvalidFormatException e) {
//
//                e.printStackTrace();
//            }
//        }
//        /**
//         * 添加文档概括信息
//         * @param doc 文档对象
//         * @param dataset 数据集
//         */
//        public static void addSummary(CustomXWPFDocument doc,Map<String,String> colors,Map<String,String> dataset){
//            if(dataset == null || dataset.isEmpty()) return;
//            XWPFParagraph p  = doc.createParagraph();
//            p.setAlignment(ParagraphAlignment.LEFT);
//            for(String key : dataset.keySet()){
//                String[] array = dataset.get(key).split("\n");
//                addText(p, key+"：", true, FONT_SIZE, "", array.length > 1 ? true : false);
//                for(String str : array){
//                    StringBuilder sb = new StringBuilder("");
//                    if(array.length > 1){
//                        for(int j = 1;j < 4;j++){//缩进两个字符
//                            sb.append(" ");
//                        }
//                    }
//                    sb.append(str);
//                    if(array.length > 1)
//                        addText(p, colors,sb.toString(),true);
//                    else addText(p,sb.toString(),true);
//                }
//            }
//        }
//        /**
//         * 添加文档标题
//         * @param doc  文档对象
//         * @param title  标题名称
//         */
//        public static void addTitle(CustomXWPFDocument doc,String title){
//            if(title == null || "".equals(title)) return;
//            XWPFParagraph p  = doc.createParagraph();
//            p.setAlignment(ParagraphAlignment.CENTER);
//            addText(p, title, true, DOC_NAME, "", false);
//        }
//        /**
//         * 添加段落
//         * @param doc  当前文档
//         * @param text  内容
//         * @param isBold 是否加粗
//         * @param isBreak 是否换行
//         * @param position 对齐方式
//         */
//        public static XWPFParagraph addParagraph(CustomXWPFDocument doc,String text,boolean isBold,boolean isBreak,ParagraphAlignment position){
//            XWPFParagraph p  = doc.createParagraph();
//            p.setAlignment(position == null ? ParagraphAlignment.CENTER : position);
//            if(text != null && !"".equals(text))
//                addText(p,text, isBold, FONT_SIZE, "", isBreak);
//            return p;
//        }
//        /**  添加一级段落
//         * @param doc  当前文档对象
//         * @param title 段落内容
//         * @param index 段落索引
//         */
//        public static XWPFParagraph addParagraphLevel1(CustomXWPFDocument doc,String text,String index){
//            XWPFParagraph p  = doc.createParagraph();
//            p.setAlignment(ParagraphAlignment.LEFT);
//            addText(p, index + "."+text, true, FONT_TITLE_1, "", false);
//            return p;
//        }
//        /**  添加二级段落
//         * @param doc  当前文档对象
//         * @param title 段落内容
//         * @param index 段落索引
//         */
//        public static XWPFParagraph addParagraphLevel2(CustomXWPFDocument doc,String text,String index){
//            XWPFParagraph p  = doc.createParagraph();
//            p.setAlignment(ParagraphAlignment.LEFT);
//            addText(p, index + "."+text, true, FONT_TITLE_2, "", true);
//            return p;
//        }
//
//        /**
//         *
//         * @param doc  当前文档
//         * @param name  二级标题名称
//         * @param index  二级标题索引
//         * @param content 文本内容
//         * @param dataset 表格数据集
//         * @param img  图片集
//         */
//        public static void addPart(CustomXWPFDocument doc,String name,String index,String content,Map<String,String> colors,Map<String,String[][]> dataset,Map<String,InputStream> img){
//            //添加二级段落
//            XWPFParagraph para1 = Utils.addParagraphLevel2(doc, name,index);
//            if(content != null && !"".equals(content)){
//                //添加文本内容
//                Utils.addText(para1, colors, content,false);
//            }
//            if(dataset != null && dataset.size() > 0){
//                for(String key : dataset.keySet()){
//                    //添加居中段落
//                    Utils.addParagraph(doc, key, false, false,ParagraphAlignment.CENTER);
//                    //添加表格
//                    Utils.addTable(para1, 8000, dataset.get(key));
//                }
//            }
//            if(img != null && !img.isEmpty()){
//                for(String key : img.keySet()){
//                    Utils.addImage(doc,img.get(key),IMG_WIDTH,IMG_HEIGHT);
//                    Utils.addParagraph(doc,key, false, false,ParagraphAlignment.CENTER);
//                }
//            }
//        }
//        /**
//         * 使用 Map按value进行排序
//         * @param map
//         * @return
//         */
//        public static Map<String, String> sortMapByValue(Map<String, String> map) {
//            if (map == null || map.isEmpty()) {
//                return null;
//            }
//            Map<String, String> sortedMap = new LinkedHashMap<>();
//            List<Map.Entry<String, String>> entryList = new ArrayList<Map.Entry<String, String>>(map.entrySet());
//            Collections.sort(entryList, new MapValueComparator());
//            Iterator<Map.Entry<String, String>> iter = entryList.iterator();
//            Map.Entry<String, String> tmpEntry = null;
//            while (iter.hasNext()) {
//                tmpEntry = iter.next();
//                sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
//            }
//            return sortedMap;
//        }
//        /**
//         * @param doc  文档对象
//         * @param fileName 文件名称
//         */
//        public static void saveDoc(CustomXWPFDocument doc,String fileName){
//            try {
//                FileOutputStream out = new FileOutputStream(FILE_OUT_PUT_PATH + fileName);
//                try {
//                    doc.write(out);
//                    out.close();
//                    log.info(FILE_OUT_PUT_PATH + fileName + "----------------------------创建成功");
//                } catch (IOException e) {
//
//                    e.printStackTrace();
//                    log.info("------------------------------------" + e.getMessage());
//                }
//            } catch (FileNotFoundException e) {
//
//                e.printStackTrace();
//            }
//        }
//    }
//    public static void main(String[] args) {
//        System.out.println("");
//        /*//饼状图数据集
//        PieChart pieData = new PieChart();
//        pieData.setLeftData(new ArrayList<String>(){{
//            add("正面");
//            add("负面");
//            add("中性");
//        }});
//        pieData.setOpinionData(new ArrayList<PieChartSeriesData>(){{
//            PieChartSeriesData dd = new PieChartSeriesData(){{
//                setName("正面");
//                setValue(300);
//            }};
//            PieChartSeriesData dd1 = new PieChartSeriesData(){{
//                setName("负面");
//                setValue(565);
//            }};
//            PieChartSeriesData dd2 = new PieChartSeriesData(){{
//                setName("中性");
//                setValue(196);
//            }};
//            add(dd);
//            add(dd1);
//            add(dd2);
//        }});
//        //表格数据集
//        Map<String,String[][]> dataset = new HashMap<String,String[][]>();
//        String[][] table = {{"正面","负面"},{"121","2323"}};
//        dataset.put("这是一个表格",table);
//        //文档概括数据集
//        Map<String,String> summaryDataset = new HashMap<String,String>(){{
//            put("监测时间","2012年2月16日");
//            put("监测范围","新闻、博客、论坛、贴吧、、、、、等全面监测");
//            put("监测方案","监测方案一、监测方案二、监测方案二");
//            put("内容摘要论坛内容","2012年2月16日信息总量1124条，比2012年2月15日增加75条信息。\n2012年2月16日信息量最多的网站类型是新闻，占总数的35.7%\n2012年2月16日信息量最多的网站是zhidao.baidu.com");
//        }};
//
//
//
//        //创建word文档
//        CustomXWPFDocument doc = new CustomXWPFDocument();
//        //添加标题
//        Utils.addTitle(doc, "智慧商情日报");
//        //添加文档综述
//        Utils.addSummary(doc,new HashMap(){{
//
//        /*String projectPath = request.getRealPath("/");
//
//
//            put("新闻","cc0033");
//            put("2012","cc66ff");
//        }},summaryDataset);
//        //添加一级段落
//        Utils.addParagraphLevel1(doc,"信息综述", "1");
//        Utils.addPart(doc, "七日传播趋势汇总", "1.1", "2012年2月16日，新闻网站上共监测到信息401条，比2012年2月15日增加64条信息。",null, dataset, new HashMap(){{
//            put("传播趋势七天不同类型饼图",JfreeChartUtil.getChartStream(JfreeChartUtil.getPieChart("七天饼状图", pieData, false),500, 300));
//        }});
//
//        //生成doc文件
//        Utils.saveDoc(doc, "智慧商情日报.docx");*/
//    }
//}
//
//
//
//
//
