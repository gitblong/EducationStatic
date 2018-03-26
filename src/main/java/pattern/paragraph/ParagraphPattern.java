package pattern.paragraph;

import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.awt.*;

/**
 * Created by Blong on 2018/3/16.
 */
public class ParagraphPattern {

    public static Paragraph creParOneTitle(BaseFont baseFont , String content) {
        Font font = new Font(baseFont, 14, Font.BOLD, Color.BLACK);
        Paragraph paragraph = new Paragraph(content,font);
        paragraph.setAlignment(3);
        paragraph.setLeading(font.getSize()*2f);

        return paragraph;
    }


    public static Paragraph creParTwoTitle(BaseFont baseFont ,String content) {
        Font font = new Font(baseFont, 12, Font.BOLD, Color.BLACK);
        Paragraph paragraph = new Paragraph(content,font);
        paragraph.setAlignment(3);
        paragraph.setLeading(font.getSize()*2f);
        return paragraph;
    }

    public static Paragraph creParText(BaseFont baseFont ,String content) {
        Font font = new Font(baseFont, 11f, Font.NORMAL, Color.BLACK);
        Paragraph paragraph = new Paragraph(content,font);
        paragraph.setAlignment(3);
        paragraph.setLeading(font.getSize()*2f);
        paragraph.setFirstLineIndent(font.getSize()*2);
        return paragraph;
    }

    public static Paragraph creParPhoTitle(BaseFont baseFont ,String content) {
        Font font = new Font(baseFont, 9, Font.NORMAL, Color.BLACK);
        Paragraph paragraph = new Paragraph(content,font);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        paragraph.setLeading(font.getSize()*2f);
        return paragraph;
    }
}
