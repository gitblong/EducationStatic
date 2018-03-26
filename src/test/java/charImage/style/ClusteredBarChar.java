package charImage.style;/*

 * jfreechart

 *

 * */


import java.awt.Font;

import java.io.File;

import java.io.IOException;


import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartUtilities;

import org.jfree.chart.JFreeChart;

import org.jfree.chart.axis.CategoryAxis;

import org.jfree.chart.axis.ValueAxis;

import org.jfree.chart.labels.ItemLabelAnchor;

import org.jfree.chart.labels.ItemLabelPosition;

import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;

import org.jfree.chart.plot.CategoryPlot;

import org.jfree.chart.plot.PlotOrientation;

import org.jfree.chart.renderer.category.BarRenderer;

import org.jfree.data.category.CategoryDataset;

import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.ui.TextAnchor;
//簇状条形图

/**
 * jfreechart 复习笔记
 * <p>
 * <p>
 * 通过虚拟家乡甜点供应，做个图标展示一下
 *
 * @author terje liu
 */

public class ClusteredBarChar

{

    public static void main(String[] args) throws IOException

    {
        JFreeChart chart = ChartFactory.createBarChart("桂林甜点供应（个）", "城区",
                "供应量", getDateSet(), PlotOrientation.HORIZONTAL, true, true,
                false);


// ---------显示中文------------//
        chart.getTitle().setFont(new Font("宋体", Font.PLAIN, 20));
        CategoryPlot plot = chart.getCategoryPlot();


// 设置分类 中文，就是图片里面的那个"城区"和"xx区"
        CategoryAxis cgAxis = plot.getDomainAxis();
        cgAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 11));
        cgAxis.setLabelFont(new Font("宋体", Font.PLAIN, 15));


// 设置数值 中文
        ValueAxis vAxis = plot.getRangeAxis();
        vAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 11));
        vAxis.setLabelFont(new Font("宋体", Font.PLAIN, 15));


// 显示说明 中文
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 16));


// -------微调整-------//
// 设置边距，右边的（防止最大值，跑到图片外面去，所以要设置一下）
        vAxis.setUpperMargin(0.08);


// 设置最小值（有个最小值好一些，容易突出重点嘛）
        vAxis.setLowerBound(200);


// ------将每个柱子显示的数值 显示出来---------//
        BarRenderer barRender = new BarRenderer();
        barRender
                .setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        barRender.setBaseItemLabelFont(new Font("宋体", Font.PLAIN, 11));
        barRender.setBaseItemLabelsVisible(true);
// 避免因为数值过小，显示不明显，或则看不到
        barRender.setMinimumBarLength(10);
        plot.setRenderer(barRender);


// 调节柱子显示的数值的位置
// 通过设置ItemLabelPosition里面的2个静态参数（奇怪了，ItemLabelAnchor的含义文档好像没有怎么说）
        barRender.setBasePositiveItemLabelPosition(new ItemLabelPosition(
                ItemLabelAnchor.OUTSIDE2, TextAnchor.BASELINE_CENTER));


// ------将结果以图片形式输出------//
        File f = new File("domeone.jpg");
        ChartUtilities.saveChartAsJPEG(f, chart, 800, 640);


    }


    /**
     * 数据集
     */

    public static CategoryDataset getDateSet()

    {
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();


        dcd.addValue(552, "布丁", "七星高新区");
        dcd.addValue(1131, "蛋挞", "七星高新区");
        dcd.addValue(912, "海苔饼", "七星高新区");
        dcd.addValue(513, "脆皮奶", "七星高新区");
        dcd.addValue(313, "巧克力蛋糕", "七星高新区");


        dcd.addValue(946, "布丁", "秀峰区");
        dcd.addValue(563, "蛋挞", "秀峰区");
        dcd.addValue(712, "海苔饼", "秀峰区");
        dcd.addValue(399, "脆皮奶", "秀峰区");
        dcd.addValue(299, "巧克力蛋糕", "秀峰区");


        dcd.addValue(564, "布丁", "象山区");
        dcd.addValue(765, "蛋挞", "象山区");
        dcd.addValue(592, "海苔饼", "象山区");
        dcd.addValue(799, "脆皮奶", "象山区");
        dcd.addValue(499, "巧克力蛋糕", "象山区");


        dcd.addValue(464, "布丁", "叠彩区");
        dcd.addValue(263, "蛋挞", "叠彩区");
        dcd.addValue(992, "海苔饼", "叠彩区");
        dcd.addValue(691, "脆皮奶", "叠彩区");
        dcd.addValue(291, "巧克力蛋糕", "叠彩区");


        dcd.addValue(261, "布丁", "雁山区");
        dcd.addValue(333, "蛋挞", "雁山区");
        dcd.addValue(594, "海苔饼", "雁山区");
        dcd.addValue(599, "脆皮奶", "雁山区");
        dcd.addValue(201, "巧克力蛋糕", "雁山区");


        return dcd;

    }


}