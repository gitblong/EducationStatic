package importToWord;

import java.awt.Color;
import java.io.FileOutputStream;
import java.util.Date;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;
import com.lowagie.text.rtf.style.RtfFont;

public class ImgToWord {

	public static void main(String[] args) {
		try {
			/** 创建Document对象(word文档) **/
			Rectangle rectPageSize = new Rectangle(PageSize.A4);
			rectPageSize = rectPageSize.rotate();
			
			// 创建word文档,并设置纸张的大小
			Document doc = new Document(PageSize.A4);
			String fileName = "f:/3/" + System.currentTimeMillis() + ".doc";
			
			/**
			 * 建立一个书写器与document对象关联,通过书写器可以将文档写入到输出流中
			 */
			RtfWriter2.getInstance(doc, new FileOutputStream(fileName));
			doc.open();
			// 在列中添加图片
			Paragraph p1 = new Paragraph("Hello World ");
			doc.add(p1);
			
			Image png = Image.getInstance("C:\\Users\\a3858\\Desktop\\company1.png");
			png.scaleAbsolute(450f,300);
			png.setAlignment(Image.MIDDLE);
			doc.add(png);
			
			
			Paragraph p = new Paragraph("Hello World ");
			doc.add(p);
			
			doc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}