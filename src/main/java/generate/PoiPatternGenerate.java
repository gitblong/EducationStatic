package generate;

import draw.*;
import entity.*;
import extend.CustomXWPFDocument;
import extend.PathConfig;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import output.OutputImage;
import pattern.paragraph.POIParagraphPattern;
import pattern.text.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blong on 2018/3/17.
 */
public class PoiPatternGenerate {
    private final static int IMAGEWIDTH = PathConfig.IMAGEWIDTH;
    private final static int IMAGEHEIGHT = PathConfig.IMAGEHEIGHT;



    /**
     * 生成模板1    当前使用byte数据直接生成
     * @param contents 文本变量
     * @param stackBarEntityList 堆状图数据
     * @param POIDrawTableEntityList 表数据
     * @param scatterEntityList 散点图数据
//     * @param imagePaths 图片保存路径，先将图片导出，后再插入word
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    public static void patternOne(java.util.List<String> contents, List<StackBarEntity> stackBarEntityList, java.util.List<POIDrawTableEntity> POIDrawTableEntityList,
                                    List<ScatterEntity> scatterEntityList) throws Exception {
        CustomXWPFDocument document;
        if (!Flag.isFirst) {
            document = new CustomXWPFDocument(new FileInputStream(new File(Flag.wordPath)));
        } else {
            document = new CustomXWPFDocument();
        }

        //一级内容
        POIParagraphPattern.creParOneTitle(document, PatternOneText.getOneTitle(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getOneTitleText(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getOneTitleText1(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getOneTitleText2(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getOneTitleText3(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getOneTitleText4(contents.get(0)));

        //二级1
        POIParagraphPattern.creParTwoTitle(document, PatternOneText.getTwoTitle1(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getTwoTitleText1_11(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getTwoTitleText1_12(contents.get(0)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream1 = OutputImage.getChartByteArray(StackBarChart.drawStackedBarChart(stackBarEntityList.get(0)),IMAGEWIDTH,IMAGEHEIGHT);
        String barBlipId1 = document.addPictureData(barOutputStream1.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId = document.addPictureData(new FileInputStream(new File(imagePaths.get(0))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId,Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);

        POIParagraphPattern.creParPhoTitle(document, PatternOneText.getTwoPhoTitle1_1(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getTwoTitleText1_2());
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream2 = OutputImage.getChartByteArray(StackBarChart.drawStackedBarChart(stackBarEntityList.get(1)),IMAGEWIDTH,IMAGEHEIGHT);
        String barBlipId2 = document.addPictureData(barOutputStream2.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId2, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId1 = document.addPictureData(new FileInputStream(new File(imagePaths.get(1))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        POIParagraphPattern.creParPhoTitle(document, PatternOneText.getTwoPhoTitle1_2(contents.get(1)));

        //二级2
        POIParagraphPattern.creParTwoTitle(document, PatternOneText.getTwoTitle2(contents.get(2)));
        POIParagraphPattern.creParText(document, PatternOneText.getTwoTitleText2_1(contents.get(2)));
        POIParagraphPattern.creParPhoTitle(document, PatternOneText.getTwoPhoTitle2_1(contents.get(2)));
        //插入表格位置
        POIDrawTable.createTable(document, POIDrawTableEntityList.get(0));
        POIParagraphPattern.creParPhoTitle(document, PatternOneText.getTwoPhoTitle2_2(contents.get(3)));
        //插入表格位置
        POIDrawTable.createTable(document, POIDrawTableEntityList.get(1));
        //三级
        POIParagraphPattern.creParTwoTitle(document, PatternOneText.getTwoTitle3(contents.get(4)));
        POIParagraphPattern.creParText(document, PatternOneText.getTwoTitleText3_1(contents.get(4)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream scatterOutputStream1 = OutputImage.getChartByteArray(ScatterChart.drawChart(scatterEntityList.get(0)),IMAGEWIDTH,IMAGEHEIGHT);
        String scatterBlipId1 = document.addPictureData(scatterOutputStream1.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(scatterBlipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId2 = document.addPictureData(new FileInputStream(new File(imagePaths.get(2))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId2, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        POIParagraphPattern.creParPhoTitle(document, PatternOneText.getTwoPhoTitle3_1(contents.get(4)));
        POIParagraphPattern.creParText(document, PatternOneText.getTwoTitleText3_2(contents.get(4)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream scatterOutputStream2 = OutputImage.getChartByteArray(ScatterChart.drawChart(scatterEntityList.get(1)),IMAGEWIDTH,IMAGEHEIGHT);
        String scatterBlipId2 = document.addPictureData(scatterOutputStream2.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(scatterBlipId2, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId3 = document.addPictureData(new FileInputStream(new File(imagePaths.get(3))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId3, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        POIParagraphPattern.creParPhoTitle(document, PatternOneText.getTwoPhoTitle3_2(contents.get(5)));
        writeWord(document);

    }
    /**
     * 生成模板1_1    当前使用byte数据直接生成
     * @param contents 文本变量
     * @param scatterEntityList 散点图数据
    //     * @param imagePaths 图片保存路径，先将图片导出，后再插入word
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    public static void patternOne_1(java.util.List<String> contents,List<ScatterEntity> scatterEntityList) throws Exception {
        CustomXWPFDocument document;
        if (!Flag.isFirst) {
            document = new CustomXWPFDocument(new FileInputStream(new File(Flag.wordPath)));
        } else {
            document = new CustomXWPFDocument();
        }

        //三级
        POIParagraphPattern.creParTwoTitle(document, PatternOneText.getTwoTitle3(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getTwoTitleText3_1(contents.get(0)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream scatterOutputStream1 = OutputImage.getChartByteArray(ScatterChart.drawChart(scatterEntityList.get(0)),IMAGEWIDTH,IMAGEHEIGHT);
        String scatterBlipId1 = document.addPictureData(scatterOutputStream1.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(scatterBlipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId2 = document.addPictureData(new FileInputStream(new File(imagePaths.get(2))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId2, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        POIParagraphPattern.creParPhoTitle(document, PatternOneText.getTwoPhoTitle3_1(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getTwoTitleText3_2(contents.get(0)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream scatterOutputStream2 = OutputImage.getChartByteArray(ScatterChart.drawChart(scatterEntityList.get(1)),IMAGEWIDTH,IMAGEHEIGHT);
        String scatterBlipId2 = document.addPictureData(scatterOutputStream2.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(scatterBlipId2, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId3 = document.addPictureData(new FileInputStream(new File(imagePaths.get(3))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId3, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        POIParagraphPattern.creParPhoTitle(document, PatternOneText.getTwoPhoTitle3_2(contents.get(1)));
        writeWord(document);

    }
    /**
     * 生成模板2
     * @param contents
     * @param stackBarEntityList
     * @throws IOException
     * @throws InvalidFormatException
     */
    public static void patternTwo(java.util.List<String> contents, List<StackBarEntity> stackBarEntityList) throws Exception {

        CustomXWPFDocument document;
        if (!Flag.isFirst) {
            document = new CustomXWPFDocument(new FileInputStream(new File(Flag.wordPath)));
        } else {
            document = new CustomXWPFDocument();
        }

        //一级内容
        POIParagraphPattern.creParOneTitle(document, PatternOneText.getOneTitle(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getOneTitleText(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getOneTitleText1(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getOneTitleText2(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getOneTitleText3(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getOneTitleText4(contents.get(0)));

        //二级1
        POIParagraphPattern.creParTwoTitle(document, PatternOneText.getTwoTitle1(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getTwoTitleText1_11(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getTwoTitleText1_12(contents.get(0)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream1 = OutputImage.getChartByteArray(StackBarChart.drawStackedBarChart(stackBarEntityList.get(0)), IMAGEWIDTH, IMAGEHEIGHT);
        String barBlipId1 = document.addPictureData(barOutputStream1.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId = document.addPictureData(new FileInputStream(new File(imagePaths.get(0))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId,Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);

        POIParagraphPattern.creParPhoTitle(document, PatternOneText.getTwoPhoTitle1_1(contents.get(0)));
        POIParagraphPattern.creParText(document, PatternOneText.getTwoTitleText1_2());
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream2 = OutputImage.getChartByteArray(StackBarChart.drawStackedBarChart(stackBarEntityList.get(1)), IMAGEWIDTH, IMAGEHEIGHT);
        String barBlipId2 = document.addPictureData(barOutputStream2.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId2, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId1 = document.addPictureData(new FileInputStream(new File(imagePaths.get(1))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        POIParagraphPattern.creParPhoTitle(document, PatternOneText.getTwoPhoTitle1_2(contents.get(1)));
        writeWord(document);
    }

    /**
     * 生成模板3_1
     * @param singleBarEntityList
     * @throws IOException
     * @throws InvalidFormatException
     */
    public static void pattern3_1(List<String>contents,List<SingleBarEntity> singleBarEntityList) throws Exception {

        CustomXWPFDocument document;
        if (!Flag.isFirst) {
            document = new CustomXWPFDocument(new FileInputStream(new File(Flag.wordPath)));
        } else {
            document = new CustomXWPFDocument();
        }

        //一级内容
        POIParagraphPattern.creParText(document, PatternThreeText.model3_1(contents.get(0)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream1 = OutputImage.getChartByteArray(SingleBar.drawSingleBar(singleBarEntityList.get(0)), 600, IMAGEHEIGHT);
        String barBlipId1 = document.addPictureData(barOutputStream1.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId = document.addPictureData(new FileInputStream(new File(imagePaths.get(0))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId,Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        POIParagraphPattern.creParText(document, PatternThreeText.model3_1(contents.get(1)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream2 = OutputImage.getChartByteArray(SingleBar.drawSingleBar(singleBarEntityList.get(1)), 600, IMAGEHEIGHT);
        String barBlipId2 = document.addPictureData(barOutputStream2.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId2, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId1 = document.addPictureData(new FileInputStream(new File(imagePaths.get(1))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        writeWord(document);
    }

    /**
     * 生成模板3_2
     * @param multiBarList
     * @throws IOException
     * @throws InvalidFormatException
     */
    public static void pattern3_2(List<String>contents,List<MultiBarEntity> multiBarList) throws Exception {

        CustomXWPFDocument document;
        if (!Flag.isFirst) {
            document = new CustomXWPFDocument(new FileInputStream(new File(Flag.wordPath)));
        } else {
            document = new CustomXWPFDocument();
        }

        //一级内容
        POIParagraphPattern.creParText(document, PatternThreeText.model3_2(contents.get(0)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream1 = OutputImage.getChartByteArray(MultiBar.drawMultiBar(multiBarList.get(0)), IMAGEWIDTH, IMAGEHEIGHT);
        String barBlipId1 = document.addPictureData(barOutputStream1.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId = document.addPictureData(new FileInputStream(new File(imagePaths.get(0))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId,Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        POIParagraphPattern.creParText(document, PatternThreeText.model3_2(contents.get(1)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream2 = OutputImage.getChartByteArray(MultiBar.drawMultiBar(multiBarList.get(1)), IMAGEWIDTH, IMAGEHEIGHT);
        String barBlipId2 = document.addPictureData(barOutputStream2.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId2, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId1 = document.addPictureData(new FileInputStream(new File(imagePaths.get(1))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        writeWord(document);
    }

    /**
     * 生成模板4
     * @param multiStackBarEntityList
     * @throws IOException
     * @throws InvalidFormatException
     */
    public static void pattern4(List<String>contents,List<MultiStackBarEntity> multiStackBarEntityList) throws Exception {

        CustomXWPFDocument document;
        if (!Flag.isFirst) {
            document = new CustomXWPFDocument(new FileInputStream(new File(Flag.wordPath)));
        } else {
            document = new CustomXWPFDocument();
        }

        //一级内容
        POIParagraphPattern.creParText(document, PatternFourText.getmodel4(contents.get(0)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream1 = OutputImage.getChartByteArray(MultiStackBar.drawMultiStackBar(multiStackBarEntityList.get(0)), IMAGEWIDTH, IMAGEHEIGHT);
        String barBlipId1 = document.addPictureData(barOutputStream1.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId = document.addPictureData(new FileInputStream(new File(imagePaths.get(0))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId,Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        writeWord(document);
    }


    /**
     * 生成模板5
     * @param dualAxisChartEntityList
     * @throws IOException
     * @throws InvalidFormatException
     */
    public static void pattern5(List<String> contetnts,List<DualAxisChartEntity> dualAxisChartEntityList) throws Exception {

        CustomXWPFDocument document;
        if (!Flag.isFirst) {
            document = new CustomXWPFDocument(new FileInputStream(new File(Flag.wordPath)));
        } else {
            document = new CustomXWPFDocument();
        }
        //一级内容
        POIParagraphPattern.creParText(document, PatternFiveText.getmodel5(contetnts.get(0)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream1 = OutputImage.getChartByteArray(DualAxisChart.drawChart(dualAxisChartEntityList.get(0)), 600, IMAGEHEIGHT);
        String barBlipId1 = document.addPictureData(barOutputStream1.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId = document.addPictureData(new FileInputStream(new File(imagePaths.get(0))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId,Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        writeWord(document);

        //一级内容
        POIParagraphPattern.creParText(document, PatternFiveText.getmodel5(contetnts.get(1)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream2 = OutputImage.getChartByteArray(DualAxisChart.drawChart(dualAxisChartEntityList.get(1)), 600, IMAGEHEIGHT);
        String barBlipId2 = document.addPictureData(barOutputStream2.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId2, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId = document.addPictureData(new FileInputStream(new File(imagePaths.get(0))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId,Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        writeWord(document);
    }


    /**
     * 生成模板6_1
     * @param singleBarEntityList
     * @throws IOException
     * @throws InvalidFormatException
     */
    public static void pattern6_1(List<String> contetnts,List<SingleBarEntity> singleBarEntityList) throws Exception {

        CustomXWPFDocument document;
        if (!Flag.isFirst) {
            document = new CustomXWPFDocument(new FileInputStream(new File(Flag.wordPath)));
        } else {
            document = new CustomXWPFDocument();
        }

        //一级内容
        POIParagraphPattern.creParText(document, PatternSixText.model6_1(contetnts.get(0)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream1 = OutputImage.getChartByteArray(SingleBar.drawSingleBar(singleBarEntityList.get(0)), 600, IMAGEHEIGHT);
        String barBlipId1 = document.addPictureData(barOutputStream1.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId = document.addPictureData(new FileInputStream(new File(imagePaths.get(0))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId,Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        //一级内容
        POIParagraphPattern.creParText(document, PatternSixText.model6_1(contetnts.get(1)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream2 = OutputImage.getChartByteArray(SingleBar.drawSingleBar(singleBarEntityList.get(1)), 600, IMAGEHEIGHT);
        String barBlipId2 = document.addPictureData(barOutputStream2.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId2, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId1 = document.addPictureData(new FileInputStream(new File(imagePaths.get(1))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        writeWord(document);
    }

    /**
     * 生成模板6_2
     * @param multiBarList
     * @throws IOException
     * @throws InvalidFormatException
     */
    public static void pattern6_2(List<String> contetnts,List<MultiBarEntity> multiBarList) throws Exception {

        CustomXWPFDocument document;
        if (!Flag.isFirst) {
            document = new CustomXWPFDocument(new FileInputStream(new File(Flag.wordPath)));
        } else {
            document = new CustomXWPFDocument();
        }

        //一级内容
        POIParagraphPattern.creParText(document, PatternSixText.model6_2(contetnts.get(0)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream1 = OutputImage.getChartByteArray(MultiBar.drawMultiBar(multiBarList.get(0)), IMAGEWIDTH, IMAGEHEIGHT);
        String barBlipId1 = document.addPictureData(barOutputStream1.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId = document.addPictureData(new FileInputStream(new File(imagePaths.get(0))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId,Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        //一级内容
        POIParagraphPattern.creParText(document, PatternSixText.model6_2(contetnts.get(1)));
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        ByteArrayOutputStream barOutputStream2 = OutputImage.getChartByteArray(MultiBar.drawMultiBar(multiBarList.get(1)), IMAGEWIDTH, IMAGEHEIGHT);
        String barBlipId2 = document.addPictureData(barOutputStream2.toByteArray(), Document.PICTURE_TYPE_PNG);
        document.createPicture(barBlipId2, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
//        String blipId1 = document.addPictureData(new FileInputStream(new File(imagePaths.get(1))), Document.PICTURE_TYPE_PNG);
//        document.createPicture(blipId1, Document.PICTURE_TYPE_PNG, IMAGEWIDTH, IMAGEHEIGHT);
        writeWord(document);
    }


    /**
     * 输出document
     * @param document
     * @throws IOException
     */
    public static void writeWord(XWPFDocument document) throws IOException {
        if (Flag.isFirst) {
            String wordPath = PathConfig.WORDPATH + System.currentTimeMillis() + ".docx";
            Flag.wordPath = wordPath;
            Flag.isFirst = false;
        }
        System.out.println(Flag.wordPath);
        File f = new File(PathConfig.WORDPATH);
        if (!f.exists()) {
            f.mkdirs();
        }
        FileOutputStream os = new FileOutputStream(Flag.wordPath);
        document.write(os);
        os.close();
    }
    public static void main(String args[]) throws Exception {

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
        double[] int10 ={11, 67, 22};
        double[] int11 ={7, 86, 7};
        List<Double> values1= new ArrayList<>();
        values1.add(57d);values1.add(39d);values1.add(4d);
        List<Double> values2= new ArrayList<>();
        values2.add(45d);values2.add(40d);values2.add(15d);
        List<Double> values3= new ArrayList<>();
        values3.add(32d);values3.add(59d);values3.add(9d);
        List<Double> values4= new ArrayList<>();
        values4.add(32d);values4.add(68d);values4.add(0d);
        List<Double> values5= new ArrayList<>();
        values5.add(29d);values5.add(55d);values5.add(16d);
        List<Double> values6= new ArrayList<>();
        values6.add(28d);values6.add(62d);values6.add(10d);
        List<Double> values7= new ArrayList<>();
        values7.add(27d);values7.add(54d);values7.add(19d);
        List<Double> values8= new ArrayList<>();
        values8.add(23d);values8.add(40d);values8.add(37d);
        List<Double> values9= new ArrayList<>();
        values9.add(14d);values9.add(61d);values9.add(25d);
        List<Double> values10= new ArrayList<>();
        values10.add(11d);values10.add(67d);values10.add(22d);
        List<Double> values11= new ArrayList<>();
        values11.add(7d);values11.add(86d);values11.add(7d);
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
        double[] x = {1.2, 1.5, 1.36, 1.7, 1.3, 1.67, 1.58, 2.36, 2.1, 2.2,2.7};
        double[] y = {529.19, 557.77, 511.88, 491.19, 500.98, 479.93, 510.47, 482.1, 469.05, 479.56,524.83};
        String arr[] = {"迎泽区","小店区","杏花岭区","清徐县","尖草坪区","全市","晋源区","古交市","万柏林区","娄烦县","阳曲县"};
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

        patternOne(contents, barEntityList, POIDrawTableEntityList, scatterChartList);

    }
}
