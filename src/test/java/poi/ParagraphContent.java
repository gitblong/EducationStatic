package poi;

import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 * Created by Blong on 2018/3/17.
 */
public class ParagraphContent {
    public static void createParagraphContent(CustomXWPFDocument doc,String content) {
        XWPFRun title= doc.createParagraph().createRun();// 设置一个新的段落
        title.setText(content);
        title.setFontFamily("宋体");
        title.setBold(true);
    }
}
