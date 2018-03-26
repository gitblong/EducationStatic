package charImage.style;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
//import util.StringUtil;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;
 
public class CreateWord {
	
	 public void createWord() {  
	        String filePath = "f://word.doc";
	        String content=getFileToString("f:/1.txt");
	        // 设置纸张大小  
	        Document document = new Document(PageSize.A4);  
	        try {  
	            // 建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中  
	            RtfWriter2.getInstance(document, new FileOutputStream(filePath));  
	            document.open();  
	            // 设置中文字体  
	            BaseFont bfChinese = BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);  
	            // 标题字体风格  
	            Font titleFont = new Font(bfChinese, 12, Font.BOLD);  
	            // 正文字体风格  
	            Font contextFont = new Font(bfChinese, 10, Font.NORMAL);  
	            //导出标题
	            Paragraph title = new Paragraph(StringUtil.getStringTime()+ "导出Word示例", FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 18, Font.BOLD,new Color(0, 0, 0)));  
	            title.setAlignment(Element.ALIGN_CENTER);  
	            title.setFont(titleFont);  
	            document.add(title);  
	            
	            // 导出一段落  
	            String contextString = "导出时间：" + StringUtil.getStringLongTime() + "," + content;  
	             contextString= contextString.replaceAll("/r/n", "/n");//String strTemp
	            Paragraph context = new Paragraph(contextString);  
	            context.setFont(contextFont);
	            // 正文格式左对齐  
	            context.setAlignment(Element.ALIGN_LEFT);  
	            // 离上一段落（标题）空的行数  
	            context.setSpacingBefore(5);  
	            // 设置第一行空的列数  
	            context.setFirstLineIndent(20);  
	            document.add(context); 
	            document.add(new Paragraph("/n"));  
	            
	            //导出列表
	            pointList(document);
	            //导出表格
	            pointTable(document);
	            
	            // 导出图片  
	            pointImg(document, "g://13.JPG");
	            document.close();  
	        } catch (DocumentException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        System.out.println("生成完毕");  
	    } 
	 /**
	  * 获取文件内容
	  * @param fileName 文件名称
	  * @return 文件内容
	  * @throws IOException
	  */
	 public String getFileToString(String fileName) {
		   BufferedReader sr;
		   StringBuffer sb=null ;
		try {
			sr = new BufferedReader(new FileReader(fileName));
			sb = new StringBuffer();
	        for(String str=null;(str =sr.readLine())!=null;){
	        	sb.append(str).append(System.getProperty("line.separator"));
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	        return sb.toString();
	 }
	 /**
	  * 导出图片
	  * @param document 文档
	  * @param imagePath 图片来源
	  * @throws DocumentException
	  * @throws MalformedURLException
	  * @throws IOException
	  */
	 public void pointImg(Document document,String imagePath) throws DocumentException, MalformedURLException, IOException{
//		 document.add(new Paragraph("/n"));  
         Paragraph pacti = new Paragraph("图片信息", FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 13, Font.BOLD,new Color(0, 0, 0)));  
         document.add(pacti);  
         Image img = Image.getInstance(imagePath);  
         img.setAbsolutePosition(0, 0);  
         img.setAlignment(Image.LEFT);// 设置图片显示位置  
         img.scaleAbsolute(img.getWidth(),img.getHeight());// 直接设定显示尺寸  12, 35
         img.scalePercent(50);// 表示显示的大小为原尺寸的50%  
         img.scalePercent(50, 50);// 图像高宽的显示比例  
         img.setRotation(30);// 图像旋转一定角度  
         document.add(img);  
         document.add(new Paragraph("/n"));  
	 }
	 /**导出列表示例*/
	 public void pointList(Document document) throws DocumentException{
		   //导出列表
         Paragraph listLine = new Paragraph("导出列表",FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 13, Font.BOLD,new Color(0, 0, 0)));
         document.add(listLine);
         Table lTable = new Table(4);
         int [] widths = new int[]{30,30,30,30};
         lTable.setWidths(widths);
         lTable.setWidth(85);
         lTable.setAlignment(Element.ALIGN_CENTER);
         lTable.setAlignment(Element.ALIGN_MIDDLE);// 纵向居中显示  
         lTable.setAutoFillEmptyCells(true); // 自动填满  
         lTable.setBorderWidth(5); // 边框宽度  
         lTable.setBorderColor(new Color(0, 125, 255)); // 边框颜色  
         lTable.setPadding(20);// 衬距，看效果就知道什么意思了  
         lTable.setSpacing(0);// 即单元格之间的间距  
         lTable.setBorder(5);// 边框  
         lTable.addCell("编号");
         lTable.addCell("姓名");
         lTable.addCell("地址");
         lTable.addCell("手机");
         for(int i =1;i<=4;i++){
         	lTable.addCell("编号"+i);
	            lTable.addCell("姓名"+i);
	            lTable.addCell("地址"+i);
	            lTable.addCell("手机"+i);
         }
         document.add(lTable);
         document.add(new Paragraph("/n"));
	 }
	 /**
	  * 导出表格
	  * @param document
	  * @throws DocumentException
	  */
	 public void pointTable(Document document) throws DocumentException{
         // 导出表格  
         Paragraph underline = new Paragraph("导出表格示例", FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 13, Font.BOLD,new Color(0, 0, 0)));  
         document.add(underline);  
         // 设置 Table 表格  
         Table aTable = new Table(6);  
         int width[] = { 20, 20, 20, 20, 20, 20 };  
         aTable.setWidths(width);// 设置每列所占比例  
         aTable.setWidth(90); // 占页面宽度 90%  
         aTable.setAlignment(Element.ALIGN_CENTER);// 居中显示  
         aTable.setAlignment(Element.ALIGN_MIDDLE);// 纵向居中显示  
         aTable.setAutoFillEmptyCells(true); // 自动填满  
         aTable.setBorderWidth(5); // 边框宽度  
         aTable.setBorderColor(new Color(0, 125, 255)); // 边框颜色  
         aTable.setPadding(5);// 衬距，看效果就知道什么意思了  
         aTable.setSpacing(0);// 即单元格之间的间距  
         aTable.setBorder(5);// 边框  
       //  aTable.getDefaultCell().setBorder(5);// 边框显示方式  
         // 设置表头  
         /** 
          * cell.setHeader(true);是将该单元格作为表头信息显示； 
          * cell.setColspan(3);指定了该单元格占3列； 为表格添加表头信息时，要注意的是一旦表头信息添加完了之后， 必须调用 
          * endHeaders()方法，否则当表格跨页后，表头信息不会再显示 
          */  
         aTable.addCell(new Cell("姓名"));  
         aTable.addCell(new Cell("小白"));  
         aTable.addCell(new Cell("年龄"));  
         aTable.addCell(new Cell("25"));  
         aTable.addCell(new Cell("性别"));  
         aTable.addCell(new Cell("男"));  
         aTable.addCell(new Cell("出生日期"));  
         Cell cell3 = new Cell(new Phrase("1987-05-02"));  
         cell3.setColspan(3);  
         cell3.setVerticalAlignment(Element.ALIGN_CENTER);  
         aTable.addCell(cell3);  
         aTable.addCell(new Cell("情况描述"));  
         Cell cell4 = new Cell(new Phrase("QQQQQQQQQQQQQ"));  
         // cell4.setColspan(5);  
         cell4.setVerticalAlignment(Element.ALIGN_CENTER);  
         aTable.addCell(cell4);  
         aTable.addCell(new Cell("车道数"));  
         aTable.addCell(new Cell("    "));  
         aTable.addCell(new Cell("占用车道数"));  
         Cell cell5 = new Cell(new Phrase("6"));  
         cell5.setColspan(3);  
         cell5.setVerticalAlignment(Element.ALIGN_CENTER);  
         aTable.addCell(cell5);  
         document.add(aTable);  
         document.add(new Paragraph("/n"));  
	 }
	    public static void main(String[] args) throws IOException {  
	        CreateWord creat = new CreateWord();  
	        creat.createWord();  
	    }  
}
