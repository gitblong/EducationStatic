package pattern.paragraph;

import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.awt.*;

/**
 * Created by Blong on 2018/3/16.
 */
public class POIParagraphPattern {

    /**
     * 一级标题样式
     * @param document
     * @param content
     */
    public static void creParOneTitle(XWPFDocument document , String content) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(14);
        run.setFontFamily("宋体");
        run.setText(content);
        spaceLine(document);
    }
    //**添加一个空行
    public static void spaceLine(XWPFDocument document) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(14);
        run.setFontFamily("宋体");
        run.setText(" ");
    }

    /**
     * 二级标题样式
     * @param document
     * @param content
     */
    public static void creParTwoTitle(XWPFDocument document , String content) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(12);
        run.setFontFamily("宋体");
        run.setText(content);
        spaceLine(document);
    }

    /**
     * 正文
     * @param document
     * @param content
     */
    public static void creParText(XWPFDocument document , String content) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setFontSize(11);
        run.setFontFamily("宋体");
        run.setText(content);
        spaceLine(document);
    }

    /**
     * 题注
     * @param document
     * @param content
     */
    public static void creParPhoTitle(XWPFDocument document , String content) {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setFontSize(9);
        run.setFontFamily("黑体");
        run.setText(content);
        spaceLine(document);
    }
}
