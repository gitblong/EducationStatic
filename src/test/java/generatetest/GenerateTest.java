package generatetest;

import draw.DualAxisChart;
import entity.*;
import generate.PoiPatternGenerate;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Blong on 2018/3/19.
 */
public class GenerateTest {

    @Test
    public void testPattern5() {
        List<DualAxisChartEntity> dualAxisChartEntityList = new ArrayList<>();
        List<String> columnKeyList = new ArrayList<>();
        List<Double> valueList = new ArrayList<>();

        columnKeyList.add("感受很不好");
        columnKeyList.add("感受较不好");
        columnKeyList.add("感受教好");
        columnKeyList.add("感受好");

        valueList.add(582.98);
        valueList.add(551.55);
        valueList.add(544.33);
        valueList.add(552.26);
        DualAxisChartEntity dualAxisChartEntity = new DualAxisChartEntity(columnKeyList, valueList);
        dualAxisChartEntityList.add(dualAxisChartEntity);
        System.out.println(dualAxisChartEntityList);
//
//        try {
//            PoiPatternGenerate.pattern5(dualAxisChartEntityList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InvalidFormatException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    @Test
    public void generatePattern3_1() {
        List<SingleBarEntity> singleBarEntityList = new ArrayList<>();
        SingleBarEntity singleBarEntity = new SingleBarEntity();
        List<String> columnList = new ArrayList<>();
        columnList.add("五年以下");
        columnList.add("5-10年");
        columnList.add("11-15年");
        columnList.add("16-20年");
        columnList.add("20年以上");
        List<Double> valuelist = new ArrayList<>();
        valuelist.add(.105);
        valuelist.add(.182);
        valuelist.add(.163);
        valuelist.add(.236);
        valuelist.add(.314);
        singleBarEntity.setColumnList(columnList);
        singleBarEntity.setValueList(valuelist);
        singleBarEntityList.add(singleBarEntity);
        singleBarEntityList.add(singleBarEntity);

//        try {
//            PoiPatternGenerate.pattern3_1(singleBarEntityList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InvalidFormatException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


    @Test
    public void generatePattern3_2() {
        List<MultiBarEntity> multiBarEntitieList = new ArrayList<>();

        List<String> columnList = new ArrayList<>();
        columnList.add("校1");
        columnList.add("校2");
        columnList.add("校3");
        columnList.add("校4");
        columnList.add("校5");
        columnList.add("校6");
        columnList.add("校7");
        columnList.add("民办");
        columnList.add("公办");
        columnList.add("本县");
        columnList.add("全市");
        List<String> rowKeyList = new ArrayList<>();
        rowKeyList.add("等级1");
        rowKeyList.add("等级2");
        rowKeyList.add("等级3");
        List<Double> values1 = new ArrayList<>();
        values1.add(0d);
        values1.add(.38);
        values1.add(.63);
        List<Double> values2 = new ArrayList<>();
        values2.add(0d);
        values2.add(.45);
        values2.add(.55);
        List<Double> values3 = new ArrayList<>();
        values3.add(0d);
        values3.add(.36);
        values3.add(.64);
        List<Double> values4 = new ArrayList<>();
        values4.add(0d);
        values4.add(.22d);
        values4.add(.78);
        List<Double> values5 = new ArrayList<>();
        values5.add(0d);
        values5.add(.41);
        values5.add(.59);
        List<Double> values6 = new ArrayList<>();
        values6.add(0d);
        values6.add(.15);
        values6.add(.85);
        List<Double> values7 = new ArrayList<>();
        values7.add(.1);
        values7.add(.22);
        values7.add(.76);
        List<Double> values8 = new ArrayList<>();
        values8.add(.5);
        values8.add(.11);
        values8.add(.84);
        List<Double> values9 = new ArrayList<>();
        values9.add(0d);
        values9.add(.7);
        values9.add(.93);
        List<Double> values10 = new ArrayList<>();
        values10.add(0d);
        values10.add(.6);
        values10.add(.94);
        List<Double> values11 = new ArrayList<>();
        values11.add(.1);
        values11.add(.23);
        values11.add(.76);
        List<List<Double>> listValues = new ArrayList<>();
        listValues.add(values1);
        listValues.add(values2);
        listValues.add(values3);
        listValues.add(values4);
        listValues.add(values5);
        listValues.add(values6);
        listValues.add(values7);
        listValues.add(values8);
        listValues.add(values9);
        listValues.add(values10);
        listValues.add(values11);
        MultiBarEntity multiBarEntity = new MultiBarEntity(rowKeyList, columnList, listValues);
        multiBarEntitieList.add(multiBarEntity);
        multiBarEntitieList.add(multiBarEntity);
        List<List<Double>> valueList = multiBarEntitieList.get(0).getValueList();
        List<Double> maxValueList = new ArrayList<>();
        for (int i = 0; i < valueList.size(); i++) {
            double max = Collections.max(valueList.get(i));
            maxValueList.add(max);

        }
        System.out.println(Collections.max(maxValueList));
//
//        try {
//            PoiPatternGenerate.pattern3_2(multiBarEntitieList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InvalidFormatException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void generatePattern4() {
        List<MultiStackBarEntity> multiStackBarEntityList = new ArrayList<>();

        List<String> columnKeyList = new ArrayList<>();
        columnKeyList.add("县1");
        columnKeyList.add("县2");
        columnKeyList.add("县3");
        columnKeyList.add("县4");
        columnKeyList.add("县5");
        columnKeyList.add("县6");
        columnKeyList.add("县7");
        columnKeyList.add("县8");
        columnKeyList.add("县9");
        columnKeyList.add("县10");
        columnKeyList.add("全市");
        List<Double> values1 = new ArrayList<>();
        List<Double> values2 = new ArrayList<>();
        List<Double> values3 = new ArrayList<>();
        List<Double> values4 = new ArrayList<>();
        List<Double> values5 = new ArrayList<>();
        List<Double> values6 = new ArrayList<>();
        List<Double> values7 = new ArrayList<>();

        values1.add(181.1);
        values2.add(194d);
        values3.add(86d);
        values4.add(50.3);
        values5.add(185.5);
        values6.add(1d);
        values7.add(202.8);


        values1.add(179.2d);
        values2.add(226.4);
        values3.add(74.2);
        values4.add(66.6);
        values5.add(189.8);
        values6.add(1d);
        values7.add(163.8);

        values1.add(243.6);
        values2.add(168.4);
        values3.add(70.6);
        values4.add(56.4);
        values5.add(196.2);
        values6.add(1d);
        values7.add(164.8);

        values1.add(190d);
        values2.add(230.1);
        values3.add(64.1);
        values4.add(68.5);
        values5.add(188.3);
        values6.add(1d);
        values7.add(159d);

        values1.add(187.6);
        values2.add(234.6);
        values3.add(69.8);
        values4.add(57d);
        values5.add(218.8);
        values6.add(1d);
        values7.add(132.2);

        values1.add(184d);
        values2.add(243d);
        values3.add(75.4);
        values4.add(63d);
        values5.add(163.6);
        values6.add(1d);
        values7.add(171d);

        values1.add(179.2);
        values2.add(254.2);
        values3.add(72.2);
        values4.add(68.1999999999999);
        values5.add(224.6);
        values6.add(1d);
        values7.add(101.6);

        values1.add(221.8);
        values2.add(217.2);
        values3.add(76.6);
        values4.add(70.1999999999999);
        values5.add(176d);
        values6.add(1d);
        values7.add(138.2);

        values1.add(210d);
        values2.add(247.1);
        values3.add(65.9);
        values4.add(56.5);
        values5.add(174.3);
        values6.add(1d);
        values7.add(146.2);

        values1.add(284.4);
        values2.add(185.2);
        values3.add(78.5);
        values4.add(62.8);
        values5.add(147.1);
        values6.add(1d);
        values7.add(142d);

        values1.add(207.8);
        values2.add(287.3);
        values3.add(71.1999999999999);
        values4.add(56.5);
        values5.add(175.6);
        values6.add(1d);
        values7.add(101.6);

        List<List<Double>> listValues = new ArrayList<>();
        listValues.add(values1);
        listValues.add(values2);
        listValues.add(values3);
        listValues.add(values4);
        listValues.add(values5);
        listValues.add(values6);
        listValues.add(values7);
        MultiStackBarEntity multiStackBarEntity= new MultiStackBarEntity(listValues,columnKeyList);
        System.out.println(multiStackBarEntity.toString());
        multiStackBarEntityList.add(multiStackBarEntity);
        multiStackBarEntityList.add(multiStackBarEntity);
//        try {
//            PoiPatternGenerate.pattern4(multiStackBarEntityList,new Flag());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InvalidFormatException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void generatePattern2() {

        List<String> contents = new ArrayList<>();
        contents.add("t_1");
        contents.add("t_2");
        contents.add("t_3");
        contents.add("t_4");

        List<StackBarEntity> barEntityList = new ArrayList<>();
        StackBarEntity stackBarEntity = new StackBarEntity();
        List<String> columKeyList = new ArrayList<>();
        columKeyList.add("晋源区");
        columKeyList.add("古交市");
        columKeyList.add("小店区");
        columKeyList.add("清徐县");
        columKeyList.add("全市");
        columKeyList.add("尖草坪区");
        columKeyList.add("万柏林区");
        columKeyList.add("迎泽区");
        columKeyList.add("杏花岭区");
        columKeyList.add("娄烦县");
        columKeyList.add("阳曲县");

        List<String> rowKeyList = new ArrayList<>();
        rowKeyList.add("不太好");
        rowKeyList.add("比较好");
        rowKeyList.add("很好");
        stackBarEntity.setRowKeyList(rowKeyList);
        stackBarEntity.setColumnKeyList(columKeyList);
        double[] int1 = {57, 39, 4};
        double[] int2 = {45, 40, 15};
        double[] int3 = {32, 59, 9};
        double[] int4 = {32, 68, 0};
        double[] int5 = {29, 55, 16};
        double[] int6 = {28, 62, 10};
        double[] int7 = {27, 54, 19};
        double[] int8 = {23, 40, 37};
        double[] int9 = {14, 61, 25};
        double[] int10 = {11, 67, 22};
        double[] int11 = {7, 86, 7};
        List<Double> values1 = new ArrayList<>();
        values1.add(57d);
        values1.add(39d);
        values1.add(4d);
        List<Double> values2 = new ArrayList<>();
        values2.add(45d);
        values2.add(40d);
        values2.add(15d);
        List<Double> values3 = new ArrayList<>();
        values3.add(32d);
        values3.add(59d);
        values3.add(9d);
        List<Double> values4 = new ArrayList<>();
        values4.add(32d);
        values4.add(68d);
        values4.add(0d);
        List<Double> values5 = new ArrayList<>();
        values5.add(29d);
        values5.add(55d);
        values5.add(16d);
        List<Double> values6 = new ArrayList<>();
        values6.add(28d);
        values6.add(62d);
        values6.add(10d);
        List<Double> values7 = new ArrayList<>();
        values7.add(27d);
        values7.add(54d);
        values7.add(19d);
        List<Double> values8 = new ArrayList<>();
        values8.add(23d);
        values8.add(40d);
        values8.add(37d);
        List<Double> values9 = new ArrayList<>();
        values9.add(14d);
        values9.add(61d);
        values9.add(25d);
        List<Double> values10 = new ArrayList<>();
        values10.add(11d);
        values10.add(67d);
        values10.add(22d);
        List<Double> values11 = new ArrayList<>();
        values11.add(7d);
        values11.add(86d);
        values11.add(7d);
        List<List<Double>> listValues = new ArrayList<>();
        listValues.add(values1);
        listValues.add(values2);
        listValues.add(values3);
        listValues.add(values4);
        listValues.add(values5);
        listValues.add(values6);
        listValues.add(values7);
        listValues.add(values8);
        listValues.add(values9);
        listValues.add(values10);
        listValues.add(values11);


        stackBarEntity.setValues(listValues);

        barEntityList.add(stackBarEntity);
        barEntityList.add(stackBarEntity);


        List<List<String>> listList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            List<String> colInfo = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                colInfo.add("" + j);
            }
            listList.add(colInfo);
        }
        POIDrawTableEntity POIDrawTableEntity = new POIDrawTableEntity(listList, 3);

        List<POIDrawTableEntity> POIDrawTableEntityList = new ArrayList<>();
        POIDrawTableEntityList.add(POIDrawTableEntity);
        POIDrawTableEntityList.add(POIDrawTableEntity);

        List<ScatterEntity> scatterChartList = new ArrayList<>();
        double[] x = {1.2, 1.5, 1.36, 1.7, 1.3, 1.67, 1.58, 2.36, 2.1, 2.2, 2.7};
        double[] y = {529.19, 557.77, 511.88, 491.19, 500.98, 479.93, 510.47, 482.1, 469.05, 479.56, 524.83};
        String arr[] = {"迎泽区", "小店区", "杏花岭区", "清徐县", "尖草坪区", "全市", "晋源区", "古交市", "万柏林区", "娄烦县", "阳曲县"};
        String xAxis = "等级";
        String yAxis = "成绩";
        ScatterEntity scatterEntity = new ScatterEntity(x, y, arr, yAxis, xAxis);
        scatterChartList.add(scatterEntity);
        scatterChartList.add(scatterEntity);

        System.out.println(scatterChartList.toString());
        List<String> imagePaths = new ArrayList<>();
        imagePaths.add("f:/4/2.jpg");
        imagePaths.add("f:/4/2.jpg");
        imagePaths.add("f:/4/1.png");
        imagePaths.add("f:/4/1.png");

        System.out.println(barEntityList.toString());
        System.out.println(POIDrawTableEntityList.toString());
        System.out.println(scatterChartList.toString());
        System.out.println(contents.toString());
        try {
            PoiPatternGenerate.patternTwo(contents, barEntityList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
