package charImage.style;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
/** *//**
 * 功能描述:使用Itext组件创建pdf文档<br>
 * 创建时间:2010-07-01
 * @author sxyx2008
 *
 */
public class CreatePdf {
    public CreatePdf() throws Exception{
        
        //创建一个文档对象纸张大小为A4
        Document doc=new Document(PageSize.A4,50,50,50,50);
        //设置要输出到磁盘上的文件名称
        PdfWriter writer=PdfWriter.getInstance(doc,new FileOutputStream(new File("徐熙媛.pdf")));
        //设置作者信息
        doc.addAuthor("sxyx2008");
        //设置文档创建日期
        doc.addCreationDate();
        //设置标题
        doc.addTitle("iText测试");
        //设置值主题
        doc.addSubject("iText");
        
        //构建页脚
        HeaderFooter footer=new HeaderFooter(new Phrase(), true);
        //设置页脚是否有边框
        //0表示无
        //1上边框
        //2下边框
        //3上下边框都有 默认都有
        //设置页脚是否有边框
        footer.setBorder(0);
        //footer.setBorder(1);
        //footer.setBorder(2);
        //footer.setBorder(3);
        //设置页脚的对齐方式
        footer.setAlignment(Element.ALIGN_CENTER);
        //将页脚添加到文档中
        doc.setFooter(footer);
        
        //打开文档开始写内容
        doc.open();
        //Paragraph par1=new Paragraph("Hello,Welcome You");
        //Paragraph par2=new Paragraph("你好，中文测试",ChineseFont());
        /**//*par1.setAlignment(Element.ALIGN_CENTER);
        doc.add(par1);*/
        //par2.setAlignment(Element.ALIGN_CENTER);
        //doc.add(par2);
        
        //构建一段落
        Paragraph par3=new Paragraph("客户信息表",ChineseFont());
        //设置局中对齐
        par3.setAlignment(Element.ALIGN_CENTER);
        //添加到文档
        doc.add(par3);
        
        //创建一个四列的表格
        Table table=new Table(4);
        //设置边框
        table.setBorder(1);
        
        //创建表头
        
        Cell cell1=new Cell(new Phrase("编号",ChineseFont()));
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_CENTER);
        cell1.setHeader(true);
        cell1.setBackgroundColor(Color.RED);
        
        
        Cell cell2=new Cell(new Phrase("姓名",ChineseFont()));
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_CENTER);
        cell2.setHeader(true);
        cell2.setBackgroundColor(Color.RED);
        
        Cell cell3=new Cell(new Phrase("性别",ChineseFont()));
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_CENTER);
        cell3.setHeader(true);
        cell3.setBackgroundColor(Color.RED);
        
        Cell cell4=new Cell(new Phrase("备注",ChineseFont()));
        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell4.setVerticalAlignment(Element.ALIGN_CENTER);
        cell4.setHeader(true);
        cell4.setBackgroundColor(Color.RED);
        
        
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        //添加此代码后每页都会显示表头
        table.endHeaders();
        
        
        //循环向表格中添加100条记录 100行4列的表格
        
        //以下代码的作用是创建100行数据,其中每行有四列,列依次为 编号 姓名 性别 备注
        for (int i = 1; i <=100; i++) {
            
            //设置编号单元格
            Cell cell11=new Cell(i+"");
            //设置姓名单元格
            Cell cell22=new Cell(new Phrase("徐熙媛",ChineseFont()));
            //设置性别单元格
            Cell cell33=new Cell(new Phrase("女",ChineseFont()));
            //设置备注单元格
            Cell cell44=new Cell(new Phrase("好姑娘",ChineseFont()));
            
            //单元格水平对齐方式
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            //单元格垂直对齐方式
            cell11.setVerticalAlignment(Element.ALIGN_CENTER);
            
            cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell22.setVerticalAlignment(Element.ALIGN_CENTER);
            
            cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell33.setVerticalAlignment(Element.ALIGN_CENTER);
            
            cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell44.setVerticalAlignment(Element.ALIGN_CENTER);
            
            
            table.addCell(cell11);
            table.addCell(cell22);
            table.addCell(cell33);
            table.addCell(cell44);
            
        }
        
        //将表格添加到新的文档
        doc.add(table);
        //创建新的一页
        doc.newPage();
        //添加图片
        Image image=Image.getInstance("D://Program Files//myeclipseworkspace//6.5//iText//src//5.jpg");
        //添加到文档
        doc.add(image);
        //设置对象方式
        image.setAlignment(Element.ALIGN_CENTER);
        
        doc.close();
        writer.close();
    }
    
    //pdf文档中文字符处理
    public static Font ChineseFont()
    {
        BaseFont baseFont=null;
        try {
            baseFont=BaseFont.createFont("STSong-Light","UniGB-UCS2-H", true);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font chineseFont=new Font(baseFont,8,Font.NORMAL,Color.BLUE);
        return chineseFont;
    }
    
    
    public static void main(String[] args) {
        try {
            new CreatePdf();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
