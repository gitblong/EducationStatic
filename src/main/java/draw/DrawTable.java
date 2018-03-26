package draw;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;
import entity.TableInfo;
import entity.TableEntity;

import java.awt.*;
import java.io.IOException;
import java.util.List;

/**
 * 插入表格
 * Created by Blong on 2018/3/16.
 */
public class DrawTable {
    private static Color borderColor = new Color(123, 160, 205);
    private static Color colorTitleBackground = new Color(79, 129, 189);
    private static Color allCityColor = new Color(84, 142, 212);
    private static Color oddColorBackground = new Color(211, 223, 238);
    private static Color evenColorBackground = new Color(255, 255, 255);
    private static final int TABLEPADDING = 3;
    private final static int col = 5;
    private static int width = 250;
    public static boolean drawTable(Document document, TableInfo tableInfo) throws IOException, DocumentException,Exception {
        List<TableEntity> tableEntityList = tableInfo.getTableEntities();
        int allCityFlag = tableInfo.getAllCityFlag();


        BaseFont baseFont = BaseFont.createFont("C:\\Windows\\Fonts\\SIMSUN.TTC,0", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font headFont = new Font(baseFont,14,Font.BOLD,new Color(0,0,0));
        Font bodyFont= new Font(baseFont,11,Font.NORMAL,new Color(0,0,0));
        Font firstCol = new Font(baseFont, 11, Font.BOLD, new Color(0, 0, 0));
        boolean flag = false;
        // 创建有三列的表格
        Table table = new Table(col, tableEntityList.size());
        // 设置table的边框宽度为1
        table.setBorderWidth(1f);
        table.setBorderColor(borderColor);
        // 设置表格右对齐，其中1为居中对齐，2为右对齐，3为左对齐
        table.setAlignment(1);
        //设置内边距
        table.setPadding(TABLEPADDING);
        // 设置各列的宽度
        table.setWidth(95);
        for (int i = 0;i<tableEntityList.size();i++) {
            TableEntity tableEntity = tableEntityList.get(i);
            if(i==0){
                Cell cell1 = new Cell(new Paragraph(tableEntity.getValue1(),headFont));
                // 设置垂直居中
                cell1.setVerticalAlignment(1);
                cell1.setBackgroundColor(colorTitleBackground);
                cell1.setBorderColor(borderColor);
                // 设置水平居中
                cell1.setHorizontalAlignment(1);
                cell1.setHeader(true);
                //设置行高
                cell1.setMaxLines(1);
                table.addCell(cell1);

                Cell cell2 = new Cell(new Paragraph(tableEntity.getValue2(),headFont));
                // 设置垂直居中
                cell2.setVerticalAlignment(1);
                cell2.setBackgroundColor(colorTitleBackground);
                cell2.setBorderColor(borderColor);
                // 设置水平居中
                cell2.setHorizontalAlignment(1);
                cell2.setHeader(true);
                table.addCell(cell2);

                Cell cell3 = new Cell(new Paragraph(tableEntity.getValue3(),headFont));
                // 设置垂直居中
                cell3.setVerticalAlignment(1);
                cell3.setBackgroundColor(colorTitleBackground);
                cell3.setBorderColor(borderColor);
                // 设置水平居中
                cell3.setHorizontalAlignment(1);
                cell3.setHeader(true);
                table.addCell(cell3);

                Cell cell4 = new Cell(new Paragraph(tableEntity.getValue4(),headFont));
                // 设置垂直居中
                cell4.setVerticalAlignment(1);
                cell4.setBackgroundColor(colorTitleBackground);
                cell4.setBorderColor(borderColor);
                // 设置水平居中
                cell4.setHorizontalAlignment(1);
                cell4.setHeader(true);
                table.addCell(cell4);

                Cell cell5 = new Cell(new Paragraph(tableEntity.getValue5(),headFont));
                // 设置垂直居中
                cell5.setVerticalAlignment(1);
                cell5.setBackgroundColor(colorTitleBackground);
                cell5.setBorderColor(borderColor);
                // 设置水平居中
                cell5.setHorizontalAlignment(1);
                cell5.setHeader(true);
                table.addCell(cell5);
            }
            if(i==allCityFlag){
                Cell cell1 = new Cell(new Paragraph(tableEntity.getValue1(),firstCol));
                // 设置垂直居中
                cell1.setVerticalAlignment(1);
                cell1.setBackgroundColor(allCityColor);
                cell1.setBorderColor(borderColor);
                // 设置水平居中
                cell1.setHorizontalAlignment(1);
                cell1.setHeader(true);
                table.addCell(cell1);

                Cell cell2 = new Cell(new Paragraph(tableEntity.getValue2(),firstCol));
                // 设置垂直居中
                cell2.setVerticalAlignment(1);
                cell2.setBackgroundColor(allCityColor);
                cell2.setBorderColor(borderColor);
                // 设置水平居中
                cell2.setHorizontalAlignment(1);
                table.addCell(cell2);

                Cell cell3 = new Cell(new Paragraph(tableEntity.getValue3(),firstCol));
                // 设置垂直居中
                cell3.setVerticalAlignment(1);
                cell3.setBackgroundColor(allCityColor);
                cell3.setBorderColor(borderColor);
                // 设置水平居中
                cell3.setHorizontalAlignment(1);
                table.addCell(cell3);

                Cell cell4 = new Cell(new Paragraph(tableEntity.getValue4(),firstCol));
                // 设置垂直居中
                cell4.setVerticalAlignment(1);
                cell4.setBackgroundColor(allCityColor);
                cell4.setBorderColor(borderColor);
                // 设置水平居中
                cell4.setHorizontalAlignment(1);
                table.addCell(cell4);

                Cell cell5 = new Cell(new Paragraph(tableEntity.getValue5(),firstCol));
                // 设置垂直居中
                cell5.setVerticalAlignment(1);
                cell5.setBackgroundColor(allCityColor);
                cell5.setBorderColor(borderColor);
                // 设置水平居中
                cell5.setHorizontalAlignment(1);
                table.addCell(cell5);
            }
            if(i!=0&&i%2 != 0){
                if (i == allCityFlag||i==0) {
                    continue;
                }
                Cell cell1 = new Cell(new Paragraph(tableEntity.getValue1(),firstCol));
                // 设置垂直居中
                cell1.setVerticalAlignment(1);
                cell1.setBorderColor(borderColor);
                // 设置水平居中
                cell1.setHorizontalAlignment(1);
                table.addCell(cell1);

                Cell cell2 = new Cell(new Paragraph(tableEntity.getValue2(),bodyFont));
                // 设置垂直居中
                cell2.setVerticalAlignment(1);
                cell2.setBorderColor(borderColor);
                // 设置水平居中
                cell2.setHorizontalAlignment(1);
                table.addCell(cell2);

                Cell cell3 = new Cell(new Paragraph(tableEntity.getValue3(),bodyFont));
                // 设置垂直居中
                cell3.setVerticalAlignment(1);
                cell3.setBorderColor(borderColor);
                // 设置水平居中
                cell3.setHorizontalAlignment(1);
                table.addCell(cell3);

                Cell cell4 = new Cell(new Paragraph(tableEntity.getValue4(),bodyFont));
                // 设置垂直居中
                cell4.setVerticalAlignment(1);
                cell4.setBorderColor(borderColor);
                // 设置水平居中
                cell4.setHorizontalAlignment(1);
                table.addCell(cell4);

                Cell cell5 = new Cell(new Paragraph(tableEntity.getValue5(),bodyFont));
                // 设置垂直居中
                cell5.setVerticalAlignment(1);
                cell5.setBorderColor(borderColor);
                // 设置水平居中
                cell5.setHorizontalAlignment(1);
                table.addCell(cell5);
            }
            if(i!=0&&i%2==0){
                if (i == allCityFlag||i==0) {
                    continue;
                }
                Cell cell1 = new Cell(new Paragraph(tableEntity.getValue1(),firstCol));
                // 设置垂直居中
                cell1.setVerticalAlignment(1);
                cell1.setBorderColor(borderColor);
                cell1.setBackgroundColor(oddColorBackground);
                // 设置水平居中
                cell1.setHorizontalAlignment(1);
                table.addCell(cell1);

                Cell cell2 = new Cell(new Paragraph(tableEntity.getValue2(),bodyFont));
                // 设置垂直居中
                cell2.setVerticalAlignment(1);
                cell2.setBorderColor(borderColor);
                cell2.setBackgroundColor(oddColorBackground);
                // 设置水平居中
                cell2.setHorizontalAlignment(1);
                table.addCell(cell2);

                Cell cell3 = new Cell(new Paragraph(tableEntity.getValue3(),bodyFont));
                // 设置垂直居中
                cell3.setVerticalAlignment(1);
                cell3.setBorderColor(borderColor);
                cell3.setBackgroundColor(oddColorBackground);
                // 设置水平居中
                cell3.setHorizontalAlignment(1);
                table.addCell(cell3);

                Cell cell4 = new Cell(new Paragraph(tableEntity.getValue4(),bodyFont));
                // 设置垂直居中
                cell4.setVerticalAlignment(1);
                cell4.setBorderColor(borderColor);
                cell4.setBackgroundColor(oddColorBackground);
                // 设置水平居中
                cell4.setHorizontalAlignment(1);
                table.addCell(cell4);

                Cell cell5 = new Cell(new Paragraph(tableEntity.getValue5(),bodyFont));
                // 设置垂直居中
                cell5.setVerticalAlignment(1);
                cell5.setBorderColor(borderColor);
                cell5.setBackgroundColor(oddColorBackground);
                // 设置水平居中
                cell5.setHorizontalAlignment(1);
                table.addCell(cell5);
            }
        }

        // document.add(new Paragraph("用java生成word文件"));
        document.add(table);
        document.close();
        flag = true;
        return flag;
    }

}
