package poi;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Blong on 2018/3/17.
 */
public class test {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        String filepath = "f:/4/moban.docx";
        String destpath = "f:/4/moban1.docx";

        OPCPackage opcPackage = POIXMLDocument.openPackage(filepath);
        XWPFDocument xwpfDocument = new XWPFDocument(opcPackage);
        List<XWPFParagraph> xwpfParas = xwpfDocument.getParagraphs();
        int num=0;
        for(int i=0;i<xwpfParas.size();i++){
            if(num==3) break;
            XWPFParagraph xwpfParagraph = xwpfParas.get(i);
            String text=xwpfParagraph.getText();

            //插入段落
            if(text.equals("${mark_newParagraph}")){
                XmlCursor cursor = xwpfParagraph .getCTP().newCursor();
                XWPFParagraph newPara = xwpfDocument.insertNewParagraph(cursor);
                newPara.setAlignment(ParagraphAlignment.BOTH);//两端对齐
                newPara.setIndentationFirstLine(480);//首行缩进24磅
                XWPFRun newParaRun = newPara.createRun();
                newParaRun.setText("这是新插入的段落！");
                newParaRun.setFontFamily("宋体");
                newParaRun.setFontSize(12);
                newParaRun.setBold(false);
                xwpfDocument.removeBodyElement(xwpfDocument.getPosOfParagraph(xwpfParagraph));
            }

            //插入表格
            if(text.equals("${mark_newTable}")){
                XmlCursor cursor= xwpfParagraph.getCTP().newCursor();
                XWPFTable table = xwpfDocument.insertNewTbl(cursor);

                XWPFTableRow row_0 = table.getRow(0);
                row_0.getCell(0).setText("姓名");
                row_0.addNewTableCell().setText("年龄");

                XWPFTableRow row_1 = table.createRow();
                row_1.getCell(0).setText("隔壁老王");
                row_1.getCell(1).setText("48");

                setTableLocation(table,"center");
                setCellLocation(table,"CENTER","center");
                xwpfDocument.removeBodyElement(xwpfDocument.getPosOfParagraph(xwpfParagraph));
            }

            //插入图片
            if(text.equals("${mark_newPicture}")){

                XmlCursor cursor = xwpfParagraph .getCTP().newCursor();
                XWPFParagraph newPara = xwpfDocument.insertNewParagraph(cursor);
                newPara.setAlignment(ParagraphAlignment.CENTER);//居中
                XWPFRun newParaRun = newPara.createRun();
                newParaRun.addPicture(new FileInputStream("f:/3/bar2.png"),XWPFDocument.PICTURE_TYPE_PNG,"bus.png,", Units.toEMU(200), Units.toEMU(200));
                xwpfDocument.removeBodyElement(xwpfDocument.getPosOfParagraph(xwpfParagraph));
            }
        }
        xwpfDocument.write(new FileOutputStream(destpath));
    }


    /**
     * 设置单元格水平位置和垂直位置
     *
     * @param xwpfTable
     * @param verticalLoction    单元格中内容垂直上TOP，下BOTTOM，居中CENTER，BOTH两端对齐
     * @param horizontalLocation 单元格中内容水平居中center,left居左，right居右，both两端对齐
     */
    public static void setCellLocation(XWPFTable xwpfTable, String verticalLoction, String horizontalLocation) {
        List<XWPFTableRow> rows = xwpfTable.getRows();
        for (XWPFTableRow row : rows) {
            List<XWPFTableCell> cells = row.getTableCells();
            for (XWPFTableCell cell : cells) {
                CTTc cttc = cell.getCTTc();
                CTP ctp = cttc.getPList().get(0);
                CTPPr ctppr = ctp.getPPr();
                if (ctppr == null) {
                    ctppr = ctp.addNewPPr();
                }
                CTJc ctjc = ctppr.getJc();
                if (ctjc == null) {
                    ctjc = ctppr.addNewJc();
                }
                ctjc.setVal(STJc.Enum.forString(horizontalLocation)); //水平居中
                cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.valueOf(verticalLoction));//垂直居中
            }
        }
    }

    /**
     * 设置表格位置
     *
     * @param xwpfTable
     * @param location  整个表格居中center,left居左，right居右，both两端对齐
     */
    public static void setTableLocation(XWPFTable xwpfTable, String location) {
        CTTbl cttbl = xwpfTable.getCTTbl();
        CTTblPr tblpr = cttbl.getTblPr() == null ? cttbl.addNewTblPr() : cttbl.getTblPr();
        CTJc cTJc = tblpr.addNewJc();
        cTJc.setVal(STJc.Enum.forString(location));
    }
}
