package generate;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;
import draw.DrawTable;
import entity.TableInfo;
import extend.PathConfig;
import pattern.paragraph.ParagraphPattern;
import pattern.text.PatternOneText;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Blong on 2018/3/16.
 */
public class PatternGenerate {

    String wordPathName;

    public PatternGenerate() {
        wordPathName = PathConfig.WORDPATH + System.currentTimeMillis() + ".docx";
    }

    public static void main(String args[]) {
        try {
            String conents[] = {"1", "2", "3"};
            java.util.List<String> imagePaths = new ArrayList<>();
            imagePaths.add("C:/Users/a3858/Desktop/company1.png");
            imagePaths.add("C:/Users/a3858/Desktop/company1.png");
            imagePaths.add("C:/Users/a3858/Desktop/company1.png");
            imagePaths.add("C:/Users/a3858/Desktop/company1.png");
            java.util.List<String> contents = new ArrayList<>();
            contents.add("test1");
            contents.add("test2");
            contents.add("test3");
            java.util.List<TableInfo> tableInfoList = new ArrayList<>();
            new PatternGenerate().patternOne(contents, tableInfoList,imagePaths);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  String patternOne(java.util.List<String> contents, java.util.List<TableInfo> tableInfoList, java.util.List<String>imagePaths) throws Exception {

        Document document = new Document(PageSize.A4);
        RtfWriter2.getInstance(document, new FileOutputStream(wordPathName));

        //调用系统的“宋体”字体，设置该段落时宋体
        BaseFont songTi = BaseFont.createFont("C:\\Windows\\Fonts\\SIMSUN.TTC,0", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        BaseFont heiTi = BaseFont.createFont("C:\\Windows\\Fonts\\SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        //打开document
        document.open();
        //一级内容
        Paragraph paragraph = ParagraphPattern.creParOneTitle(songTi, PatternOneText.getOneTitle(contents.get(0)));
        document.add(paragraph);
        paragraph = ParagraphPattern.creParText(songTi, PatternOneText.getOneTitleText(contents.get(0)));
        document.add(paragraph);
        paragraph = ParagraphPattern.creParText(songTi, PatternOneText.getOneTitleText1(contents.get(0)));
        document.add(paragraph);
        paragraph = ParagraphPattern.creParText(songTi, PatternOneText.getOneTitleText2(contents.get(0)));
        document.add(paragraph);
        paragraph = ParagraphPattern.creParText(songTi, PatternOneText.getOneTitleText3(contents.get(0)));
        document.add(paragraph);
        paragraph = ParagraphPattern.creParText(songTi, PatternOneText.getOneTitleText4(contents.get(0)));
        document.add(paragraph);
        //二级1
        paragraph = ParagraphPattern.creParTwoTitle(songTi, PatternOneText.getTwoTitle1(contents.get(0)));
        document.add(paragraph);
        paragraph = ParagraphPattern.creParText(songTi, PatternOneText.getTwoTitleText1_11(contents.get(0)));
        document.add(paragraph);
        paragraph = ParagraphPattern.creParText(songTi, PatternOneText.getTwoTitleText1_12(contents.get(0)));
        document.add(paragraph);
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        Image image = Image.getInstance(imagePaths.get(0));
        // Image img = Image.getInstance(new URL("http://xxx.com/logo.jpg)");
        // 设置图片的绝对大小，宽和高
        image.scaleAbsolute(450, 300f);
        // 设置图片居中显示
        image.setAlignment(Image.MIDDLE);
        document.add(image);

        paragraph = ParagraphPattern.creParPhoTitle(heiTi, PatternOneText.getTwoPhoTitle1_1(contents.get(0)));
        document.add(paragraph);
        paragraph = ParagraphPattern.creParText(songTi, PatternOneText.getTwoTitleText1_2());
        document.add(paragraph);
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        image = Image.getInstance(imagePaths.get(1));
        // Image img = Image.getInstance(new URL("http://xxx.com/logo.jpg)");
        // 设置图片的绝对大小，宽和高
        image.scaleAbsolute(450, 300f);
        // 设置图片居中显示
        image.setAlignment(Image.MIDDLE);
        document.add(image);
        paragraph = ParagraphPattern.creParPhoTitle(heiTi, PatternOneText.getTwoPhoTitle1_2(contents.get(0)));
        document.add(paragraph);

        //二级2
        paragraph = ParagraphPattern.creParTwoTitle(songTi, PatternOneText.getTwoTitle2(contents.get(1)));
        document.add(paragraph);
        paragraph = ParagraphPattern.creParText(songTi, PatternOneText.getTwoTitleText2_1(contents.get(1)));
        document.add(paragraph);
        paragraph = ParagraphPattern.creParPhoTitle(heiTi, PatternOneText.getTwoPhoTitle2_1(contents.get(1)));
        document.add(paragraph);
        //插入表格位置
        DrawTable.drawTable(document, tableInfoList.get(0));
        paragraph = ParagraphPattern.creParPhoTitle(heiTi, PatternOneText.getTwoPhoTitle2_2(contents.get(1)));
        document.add(paragraph);
        //插入表格位置
        DrawTable.drawTable(document, tableInfoList.get(1));
        //三级
        paragraph = ParagraphPattern.creParTwoTitle(songTi, PatternOneText.getTwoTitle3(contents.get(2)));
        document.add(paragraph);
        paragraph = ParagraphPattern.creParText(songTi, PatternOneText.getTwoTitleText3_1(contents.get(2)));
        document.add(paragraph);
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        image = Image.getInstance(imagePaths.get(2));
        // Image img = Image.getInstance(new URL("http://xxx.com/logo.jpg)");
        // 设置图片的绝对大小，宽和高
        image.scaleAbsolute(450, 300f);
        // 设置图片居中显示
        image.setAlignment(Image.MIDDLE);
        document.add(image);
        paragraph = ParagraphPattern.creParPhoTitle(heiTi, PatternOneText.getTwoPhoTitle3_1(contents.get(2)));
        document.add(paragraph);
        paragraph = ParagraphPattern.creParText(songTi, PatternOneText.getTwoTitleText3_2(contents.get(2)));
        document.add(paragraph);
        //插入图片位置
        // 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
        image = Image.getInstance(imagePaths.get(3));
        // Image img = Image.getInstance(new URL("http://xxx.com/logo.jpg)");
        // 设置图片的绝对大小，宽和高
        image.scaleAbsolute(450, 300f);
        // 设置图片居中显示
        image.setAlignment(Image.MIDDLE);
        document.add(image);
        paragraph = ParagraphPattern.creParPhoTitle(heiTi, PatternOneText.getTwoPhoTitle3_2(contents.get(3)));
        document.add(paragraph);

        // 关闭document
        document.close();
        return wordPathName;
    }


}
