package poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlToken;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.*;
import java.math.BigInteger;
import java.util.List;

public class TestCustom extends XWPFDocument {
    public static void main(String[] a) throws FileNotFoundException, IOException, InvalidFormatException {

        CustomXWPFDocument document = new CustomXWPFDocument(new FileInputStream(new File("root.docx")));
        FileOutputStream fos = new FileOutputStream(new File("f:/4/new1.docx"));

        String blipId = document.addPictureData(new FileInputStream(new File("f:/3/bar.png")), Document.PICTURE_TYPE_JPEG);
        System.out.println(blipId);
        System.out.println(document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG));
//                XWPFParagraph newPara = new XWPFParagraph(cell.getCTTc().addNewP(), cell);
//                newPara.setSpacingAfterLines(-1);
//                newPara.setAlignment(ParagraphAlignment.CENTER);
//                newPara.setVerticalAlignment(TextAlignment.CENTER)

//                newPara.setBorderBottom(Borders.BASIC_BLACK_DASHES);
//                newPara.setBorderTop(Borders.BASIC_BLACK_DASHES);
//                newPara.setBorderLeft(Borders.BASIC_BLACK_DASHES);
//                newPara.setBorderRight(Borders.BASIC_BLACK_DASHES);

//                XWPFRun run = newPara.createRun();
        XWPFParagraph para = document.createParagraph();
        //一个XWPFRun代表具有相同属性的一个区域。
        XWPFRun run = para.createRun();
        run.setBold(true); //加粗
        run.setText("加粗的内容");
        run = para.createRun();
        run.setColor("FF0000");
        run.setText("红色的字。");
        para.addRun(run);


        XWPFTable table = document.createTable(5, 5);
        //这里增加的列原本初始化创建的那5行在通过getTableCells()方法获取时获取不到，但通过row新增的就可以。
//    table.addNewCol(); //给表格增加一列，变成6列
        table.createRow(); //给表格新增一行，变成6行
        List<XWPFTableRow> rows = table.getRows();
        //表格属性
        CTTblPr tablePr = table.getCTTbl().addNewTblPr();
        //表格宽度
        CTTblWidth width = tablePr.addNewTblW();
        width.setW(BigInteger.valueOf(8000));
        XWPFTableRow row;
        List<XWPFTableCell> cells;
        XWPFTableCell cell;
        int rowSize = rows.size();
        int cellSize;
        for (int i=0; i<rowSize; i++) {
            row = rows.get(i);
            //新增单元格
            row.addNewTableCell();
            //设置行的高度
            row.setHeight(500);
            //行属性
//       CTTrPr rowPr = row.getCtRow().addNewTrPr();
            //这种方式是可以获取到新增的cell的。
//       List<CTTc> list = row.getCtRow().getTcList();
            cells = row.getTableCells();
            cellSize = cells.size();
            for (int j=0; j<cellSize; j++) {
                cell = cells.get(j);
                if ((i+j)%2==0) {
                    //设置单元格的颜色
                    cell.setColor("ff0000"); //红色
                } else {
                    cell.setColor("0000ff"); //蓝色

                }
                //单元格属性
                cell.getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);
                CTTcPr cellPr = cell.getCTTc().addNewTcPr();
                cellPr.addNewVAlign().setVal(STVerticalJc.CENTER);
                if (j == 3) {
                    //设置宽度
                    cellPr.addNewTcW().setW(BigInteger.valueOf(3000));
                }
                cell.setText(i + ", " + j);
            }
        }
        tablePr.addNewJc().setVal(STJc.CENTER);
        //System.out.println(document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG));
        int nextPicNameNumber = document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG);
        System.out.println(nextPicNameNumber);

        document.createPicture(nextPicNameNumber, 500, 270);


        document.write(fos);
        fos.flush();
        fos.close();

    }
}