package draw;

import entity.Flag;
import entity.POIDrawTableEntity;
import extend.CustomXWPFDocument;
import extend.PathConfig;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import pattern.paragraph.POIParagraphPattern;

import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用poi插入表格
 * Created by Blong on 2018/3/17.
 */
public class POIDrawTable {
    private static Color borderColor = new Color(123, 160, 205);
    private static String borderColorStr = "7ba0cd";
    private static Color colorTitleBackground = new Color(79, 129, 189);
    private static String colorTitleBackgroundStr = "4f81bd";
    private static Color allCityColor = new Color(84, 142, 212);
    private static String allCityColorStr = "548ed4";
    private static Color oddColorBackground = new Color(211, 223, 238);
    private static String oddColorBackgroundStr = "d3dfee";
    private static Color evenColorBackground = new Color(255, 255, 255);
    private static String evenColorBackgroundStr = "ffffff";
    private static final int WIDTH= 8000;
    public static void createTable(CustomXWPFDocument document, POIDrawTableEntity POIDrawTableEntity) throws IOException {
        File file = new File("root.docx");
        List<List<String>> tableEntities = POIDrawTableEntity.getTableInfo();
        int allCityFlag = POIDrawTableEntity.getAllCityFlag();

        XWPFTable table = document.createTable(tableEntities.size(), tableEntities.get(0).size());
        //这里增加的列原本初始化创建的那5行在通过getTableCells()方法获取时获取不到，但通过row新增的就可以。
        List<XWPFTableRow> rows = table.getRows();
        CTTblPr ctTblPr = table.getCTTbl().addNewTblPr();
        //表格属性
        CTTblPr tablePr = table.getCTTbl().addNewTblPr();
        //表格宽度
        CTTblWidth width = tablePr.addNewTblW();
        width.setW(BigInteger.valueOf(WIDTH));


        for(int i = 0; i< tableEntities.size();i++) {
            List<String> colInfo= tableEntities.get(i);
            if (i == 0) {
                XWPFTableRow row = rows.get(i);
                row.setHeight(572);
            }else{
                XWPFTableRow row = rows.get(i);
                row.setHeight(286);
            }
            for(int j=0;j<colInfo.size();j++) {
                XWPFTableRow row = rows.get(i);
                XWPFTableCell cell = row.getCell(j);
//                XWPFParagraph xwpfParagraph = new XWPFParagraph(cell.getCTTc().addNewP(), cell);
//                xwpfParagraph.setAlignment(ParagraphAlignment.CENTER);
//                XWPFRun run = xwpfParagraph.createRun();
//                run.setText(colInfo.get(j));
                cell.setText(colInfo.get(j));
                cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
                if (i == 0) {
                    cell.setColor(colorTitleBackgroundStr);
                } else if (i % 2 == 0 && i != 0 && i != allCityFlag) {
                    cell.setColor(oddColorBackgroundStr);
                } else if (i % 2 != 0 && i != 0 && i != allCityFlag) {
                    cell.setColor(evenColorBackgroundStr);
                } else if (i == allCityFlag) {
                    cell.setColor(allCityColorStr);
                }
                CTTcPr cellPr = cell.getCTTc().addNewTcPr();
                cellPr.addNewVAlign().setVal(STVerticalJc.CENTER);
                cellPr.addNewTcW().setW(BigInteger.valueOf((int)(WIDTH/colInfo.size())));

            }
        }
        tablePr.addNewJc().setVal(STJc.CENTER);
        //空一行
        POIParagraphPattern.spaceLine(document);
        //文件不存在时会自动创建
        OutputStream os = new FileOutputStream(Flag.wordPath);
        //写入文件
        document.write(os);
        os.close();
    }

    public static void main(String args[]) {
        List<List<String>> listList = new ArrayList<>();
        for(int i = 0;i<5;i++) {
            List<String> colInfo = new ArrayList<>();
            for(int j=0;j<7; j++) {
                colInfo.add(""+j);
            }
            listList.add(colInfo);
        }
        POIDrawTableEntity POIDrawTableEntity = new POIDrawTableEntity(listList,3);

    }

}
