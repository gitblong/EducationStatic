package charImage.style;

import java.awt.Color;
import java.io.FileOutputStream;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;
/**
 * @author typ
 * 
 */
public class TestItext {

	public TestItext() {
	}

	public static void main(String[] args) throws Exception {
		long l = System.currentTimeMillis();

		// 创建word文档,并设置纸张的大小
		Document document = new Document(PageSize.A4);
		RtfWriter2.getInstance(document, new FileOutputStream(
				"f:/4/"+l+".docx"));
		// 打开document
		document.open();
		// 设置字体，字号，加粗，颜色
		Font font = new Font(Font.NORMAL, 20, Font.BOLD, new Color(255, 0, 0));
		// 设置新的段落，使其字体为font
		Paragraph p = new Paragraph("文书制作", font);
		// 设置段落居中，其中1为居中对齐，2为右对齐，3为左对齐
		p.setAlignment(3);
		//设置行距
		p.setLeading(30f);
		// 文档中加入该段落
		document.add(p);
		//调用系统的“楷体”字体，设置该段落时楷体
		BaseFont bf = BaseFont.createFont("C:\\Windows\\Fonts\\simli.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		font = new Font(bf, 16, Font.NORMAL, new Color(0, 0, 0));
		p = new Paragraph(
				"    itext可以实现插入段落，可以设置段落的缩进，居中，首行缩进，段前距，段后距。可以设置字体，字号，格式。功能比较齐全。",
				font);
		// 设置段落缩进
		p.setIndentationLeft(20);
		// 设置首行缩进
		p.setFirstLineIndent(30f);
		// 设置段后距和段前距
		p.setSpacingAfter(10f);
		p.setSpacingBefore(100f);
		document.add(p);
		p = new Paragraph(
				"itext可以插入表格，设置表格的行列数，可以设置表格边框，可以设置表格位置，可以设置表格总宽度和每一列的宽度。单元格的插入和内容可控",
				font);
		document.add(p);
		p = new Paragraph("itext可以插入图片，可以设置图片的大小，gif、jpg、png格式的图片都可以", font);
		document.add(p);
		// 创建有三列的表格
		Table table = new Table(2, 3);
		// 设置table的边框宽度为0
		table.setBorderWidth(1f);
		// table.setAbsWidth("120px");
		// 设置表格右对齐，其中1为居中对齐，2为右对齐，3为左对齐
		table.setAlignment(2);
		// 设置各列的宽度
		int[] widths = { 200, 100 };
		table.setWidths(widths);
		// table.setPadding(0);
		// table.setSpacing(0);

		// 读取图片(参数为gif、jpg、png格式的图片都可以)，设置图片大小
		Image image = Image.getInstance("C:\\Users\\a3858\\Desktop\\company1.png");
		// Image img = Image.getInstance(new URL("http://xxx.com/logo.jpg)");
		// 设置图片的绝对大小，宽和高
		image.scaleAbsolute(50f, 50f);
		// 设置图片居中显示
		image.setAlignment(Image.MIDDLE);
		// 创建单元格,并且将单元格内容设置为图片

		Cell cell = new Cell("text");
		// 设置单元格边框为0
		cell.setBorder(1);
		cell.setBorderColor(Color.blue);
		// cell.setHeader(true);
		// cell.setColspan(3);// 设置表格为三列
		// cell.setRowspan(3);// 设置表格为三行
		table.addCell(cell);
		// table.endHeaders();// 表头结束
		table.addCell(cell);
		cell = new Cell("该单元格的长度是200");
		cell.setBorder(0);
		table.addCell(cell);
		cell = new Cell("该单元格的长度是100");
		// cell.setWidth("10px");
		table.addCell(cell);
		// cell.setBorder(1);
		// 设置垂直居中
		cell.setVerticalAlignment(1);
		// 设置水平居中
		cell.setHorizontalAlignment(1);
		// document.add(new Paragraph("用java生成word文件"));
		document.add(table);
		// 关闭document
		document.close();
	}
}