package dao;

import draw.MultiStackBar;
import draw.SingleBar;
import entity.*;
import extend.CustomXWPFDocument;
import generate.PoiPatternGenerate;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import utils.WDWUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blong on 2018/3/19.
 */
public class DataBase {

    public static void generatePattern(int model, String excelPath) throws Exception {
        if (Flag.isFirst) {
            CustomXWPFDocument customXWPFDocument = new CustomXWPFDocument();
            PoiPatternGenerate.writeWord(customXWPFDocument);
        }
        if (model == 1) {
            ModelOneData modelOneData = getDataFromExcel_model1(excelPath);
            PoiPatternGenerate.patternOne(modelOneData.getContentList(), modelOneData.getStackBarEntityList(), modelOneData.getPoiDrawTableEntityList(), modelOneData.getScatterEntityList());
        } else if (model == 2) {
            ModelOneData modelOneData = getDataFromExcel_model2(excelPath);
            PoiPatternGenerate.patternTwo(modelOneData.getContentList(), modelOneData.getStackBarEntityList());
        } else if (model == 3) {
            ModelOneData modelOneData = getDataFromExcel_model3_1(excelPath);
            PoiPatternGenerate.pattern3_1(modelOneData.getContentList(),modelOneData.getSingleBarEntityList());

        } else if (model == 4) {
            ModelOneData modelOneData = getDataFromExcel_model3_2(excelPath);
            PoiPatternGenerate.pattern3_2(modelOneData.getContentList(),modelOneData.getMultiBarEntityList());
        } else if (model == 5) {
            ModelOneData modelOneData = getDataFromExcel_model4(excelPath);
            PoiPatternGenerate.pattern4(modelOneData.getContentList(),modelOneData.getMultiStackBarEntityList());
        } else if (model == 6) {
            ModelOneData modelOneData = getDataFromExcel_model5(excelPath);
            PoiPatternGenerate.pattern5(modelOneData.getContentList(),modelOneData.getDualAxisChartEntityList());
        } else if (model == 7) {
            ModelOneData modelOneData = getDataFromExcel_model6_1(excelPath);
            PoiPatternGenerate.pattern6_1(modelOneData.getContentList(),modelOneData.getSingleBarEntityList());
        } else if (model == 8) {
            ModelOneData modelOneData = getDataFromExcel_model6_2(excelPath);
            PoiPatternGenerate.pattern6_2(modelOneData.getContentList(),modelOneData.getMultiBarEntityList());
        } else if (model == 9) {
            ModelOneData modelOneData = getDataFromExcel_model1_1(excelPath);
            PoiPatternGenerate.patternOne_1(modelOneData.getContentList(), modelOneData.getScatterEntityList());
        }
    }

    /**
     * 模板1数据接口
     *
     * @param pathName
     * @return
     */
    public static ModelOneData getDataFromExcel_model1(String pathName)throws Exception {

        Workbook workbook = WDWUtil.getWorkbook(pathName);

        List<String> contentList = new ArrayList<>();
        //StackBarEntity
        List<StackBarEntity> stackBarEntityList = new ArrayList<>();


        //POIDrawTableEntity
        List<POIDrawTableEntity> poiDrawTableEntitieList = new ArrayList<>();

        //ScatterBarEntity
        List<ScatterEntity> scatterEntityList = new ArrayList<>();

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            int rowsCount = sheet.getPhysicalNumberOfRows();
            String sheetName = sheet.getSheetName();
            contentList.add(sheetName);
            if (i <= 1) {
                List<String> rowKeyList = new ArrayList<>();
                List<String> columnList = new ArrayList<>();
                List<List<Double>> valuesList = new ArrayList<>();
                for (int j = 0; j < rowsCount; j++) {
                    Row row = sheet.getRow(j);
                    int cellCounts = row.getPhysicalNumberOfCells();
                    List<Double> values = new ArrayList<>();
                    for (int k = 0; k < cellCounts; k++) {
                        Cell cell = row.getCell(k);
                        String stringCellValue = cellValue(cell);
                        if (j == 0) {

                            cell = row.getCell(k + 1);
                            if (!cellValue(cell).isEmpty()) {
                                rowKeyList.add(cellValue(cell));
                            }
                        } else {
                            if (k == 0) {
                                columnList.add(stringCellValue);
                            } else {
                                if (!stringCellValue.isEmpty()) {

                                    String substring = stringCellValue.substring(0, stringCellValue.length());
                                    double value = Double.parseDouble(substring)/100;
                                    values.add(value);
                                }

                            }
                        }
                    }

                    if (j > 0) {
                        valuesList.add(values);
                    }
                }
                //StackBarEntity
                StackBarEntity stackBarEntity = new StackBarEntity(columnList, rowKeyList, valuesList);
                stackBarEntityList.add(stackBarEntity);
            } else if (i > 1 && i <= 3) {
                int allCity = 0;
                List<List<String>> tableInfo = new ArrayList<>();
                for (int j = 0; j < rowsCount; j++) {
                    Row row = sheet.getRow(j);
                    int cellCount = row.getPhysicalNumberOfCells();
                    List<String> rowInfo = new ArrayList<>();
                    if (j == 0) {
                        rowInfo.add(" ");
                    }
                    for (int k = 0; k < cellCount; k++) {
                        Cell cell = row.getCell(k);
                        String stringCellValue = cellValue(cell);
                        if (j == 0) {
                            cell = row.getCell(k + 1);
                            stringCellValue = cellValue(cell);
                            if (!stringCellValue.isEmpty()) {

                                rowInfo.add(stringCellValue);
                            }
                        } else {
                            if (!stringCellValue.isEmpty()) {

                                rowInfo.add(stringCellValue);
                            }
                        }

                        if (stringCellValue.equals("全市")) {
                            allCity = j;
                        }
                    }
                    tableInfo.add(rowInfo);
                }
                //POIDrawTableEntity
                POIDrawTableEntity poiDrawTableEntity = new POIDrawTableEntity(tableInfo, allCity);
                poiDrawTableEntitieList.add(poiDrawTableEntity);
            } else {
                //ScatterBarEntity
                int len = sheet.getPhysicalNumberOfRows() - 1;
                double x[] = new double[len];
                double y[] = new double[len];
                String[] labelValues = new String[len];
                String xAxisLable = "";
                String yAxisLable = "";
                int cityIndex = 0;
                for (int j = 0; j < rowsCount; j++) {
                    Row row = sheet.getRow(j);
                    int cellCount = row.getPhysicalNumberOfCells();
                    for (int k = 0; k < cellCount; k++) {
                        Cell cell = row.getCell(k);
                        String stringCellValue = cellValue(cell);
                        if (j == 0) {
                            if (k == 0) {
                                Cell cell1 = cell = row.getCell(1);
                                yAxisLable = cellValue(cell1);
                            } else if (k == 1) {
                                Cell cell1 = cell = row.getCell(2);
                                xAxisLable = cellValue(cell1);
                            }
                        } else {
                            if (k == 0) {
                                if (stringCellValue.equals("全市")) {
                                    cityIndex = j-1;
                                }
                                labelValues[j - 1] = stringCellValue;
                            } else {
                                if (!stringCellValue.isEmpty()) {

                                    double XY = Double.parseDouble(stringCellValue);
                                    if (k == 1) {
                                        x[j - 1] = XY;
                                    } else {
                                        y[j - 1] = XY;
                                    }
                                }
                            }
                        }
                    }

                }
                ScatterEntity scatterEntity = new ScatterEntity(x, y, labelValues, xAxisLable, yAxisLable);
                scatterEntity.setCityIndex(cityIndex);
                scatterEntityList.add(scatterEntity);
            }
        }


        ModelOneData modelOneData = new ModelOneData(contentList, stackBarEntityList, poiDrawTableEntitieList, scatterEntityList);


        return modelOneData;
    }
    public static ModelOneData getDataFromExcel_model1_1(String pathName)throws Exception {

        Workbook workbook = WDWUtil.getWorkbook(pathName);

        List<String> contentList = new ArrayList<>();
        //ScatterBarEntity
        List<ScatterEntity> scatterEntityList = new ArrayList<>();

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            int rowsCount = sheet.getPhysicalNumberOfRows();
            String sheetName = sheet.getSheetName();
            contentList.add(sheetName);
            if (i <= 1) {
                //ScatterBarEntity
                int len = sheet.getPhysicalNumberOfRows() - 1;
                double x[] = new double[len];
                double y[] = new double[len];
                String[] labelValues = new String[len];
                String xAxisLable = "";
                String yAxisLable = "";
                int cityInde = 0;
                for (int j = 0; j < rowsCount; j++) {
                    Row row = sheet.getRow(j);
                    int cellCount = row.getPhysicalNumberOfCells();
                    for (int k = 0; k < cellCount; k++) {
                        Cell cell = row.getCell(k);
                        String stringCellValue = cellValue(cell);
                        if (j == 0) {
                            if (k == 0) {
                                Cell cell1 = cell = row.getCell(1);
                                yAxisLable = cellValue(cell1);
                            } else if (k == 1) {
                                Cell cell1 = cell = row.getCell(2);
                                xAxisLable = cellValue(cell1);
                            }
                        } else {
                            if (k == 0) {
                                if (stringCellValue.equals("全市")) {
                                    cityInde = j-1;
                                }
                                labelValues[j - 1] = stringCellValue;
                            } else {
                                if (!stringCellValue.isEmpty()) {

                                    double XY = Double.parseDouble(stringCellValue);
                                    if (k == 1) {
                                        x[j - 1] = XY;
                                    } else {
                                        y[j - 1] = XY;
                                    }
                                }
                            }
                        }
                    }

                }
                ScatterEntity scatterEntity = new ScatterEntity(x, y, labelValues, xAxisLable, yAxisLable);
                scatterEntity.setCityIndex(cityInde);
                scatterEntityList.add(scatterEntity);
            }
        }


        ModelOneData modelOneData = new ModelOneData();
        modelOneData.setContentList(contentList);
        modelOneData.setScatterEntityList(scatterEntityList);


        return modelOneData;
    }
    /**
     * 模板2的数据
     *
     * @param pathName
     * @return
     */
    public static ModelOneData getDataFromExcel_model2(String pathName)throws Exception {
        Workbook workbook = WDWUtil.getWorkbook(pathName);

        List<String> contentList = new ArrayList<>();
        //StackBarEntity
        List<StackBarEntity> stackBarEntityList = new ArrayList<>();
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            int rowsCount = sheet.getPhysicalNumberOfRows();
            String sheetName = sheet.getSheetName();
            contentList.add(sheetName);
            List<String> rowKeyList = new ArrayList<>();
            List<String> columnList = new ArrayList<>();
            List<List<Double>> valuesList = new ArrayList<>();
            for (int j = 0; j < rowsCount; j++) {
                Row row = sheet.getRow(j);
                int cellCounts = row.getPhysicalNumberOfCells();
                List<Double> values = new ArrayList<>();
                for (int k = 0; k < cellCounts; k++) {
                    Cell cell = row.getCell(k);
                    String stringCellValue = cellValue(cell);
                    if (j == 0) {
                        cell = row.getCell(k + 1);
                        if (!cellValue(cell).isEmpty()) {
                            rowKeyList.add(cellValue(cell));
                        }
                    } else {
                        if (k == 0) {
                            columnList.add(stringCellValue);
                        } else {
                            if (!stringCellValue.isEmpty()) {

                                String substring = stringCellValue.substring(0, stringCellValue.length());
                                double value = Double.parseDouble(substring);
                                values.add(value);
                            }

                        }
                    }
                }

                if (j > 0) {
                    valuesList.add(values);
                }
            }
            //StackBarEntity
            StackBarEntity stackBarEntity = new StackBarEntity(columnList, rowKeyList, valuesList);
            stackBarEntityList.add(stackBarEntity);
        }
        ModelOneData modelOneData = new ModelOneData();
        modelOneData.setStackBarEntityList(stackBarEntityList);
        modelOneData.setContentList(contentList);
        return modelOneData;
    }

    /**
     * 模板3-1的数据
     *
     * @param pathName
     * @return
     */
    public static ModelOneData getDataFromExcel_model3_1(String pathName) throws Exception{
        Workbook workbook = WDWUtil.getWorkbook(pathName);
        int numberOfSheets = workbook.getNumberOfSheets();
        List<SingleBarEntity> singleBarEntityList = new ArrayList<>();
        List<String> contents = new ArrayList<>();
        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            contents.add(sheet.getSheetName());
            int rowCount = sheet.getPhysicalNumberOfRows();
            List<String> columnList = new ArrayList<>();
            List<Double> valueList = new ArrayList<>();
            for (int j = 0; j < rowCount; j++) {
                if (j < 2) {

                    Row row = sheet.getRow(j);
                    int cellCounts = row.getPhysicalNumberOfCells();
                    for (int k = 0; k < cellCounts; k++) {
                        Cell cell = row.getCell(k);
                        String cellValue = cellValue(cell);
                        if (!cellValue.isEmpty()) {

                            if (j == 0) {
                                columnList.add(cellValue);
                            } else {
                                String substring = cellValue.substring(0, cellValue.length());
                                double value = Double.parseDouble(substring)/100;
                                valueList.add(value);
                            }
                        }
                    }
                }
            }
            SingleBarEntity singleBarEntity = new SingleBarEntity(columnList, valueList);
            singleBarEntityList.add(singleBarEntity);
        }
        ModelOneData modelOneData = new ModelOneData();
        modelOneData.setSingleBarEntityList(singleBarEntityList);
        modelOneData.setContentList(contents);
        return modelOneData;
    }

    /**
     * 模板3-2的数据
     *
     * @param pathName
     * @return
     */
    public static ModelOneData getDataFromExcel_model3_2(String pathName)throws Exception {
        Workbook workbook = WDWUtil.getWorkbook(pathName);

        //StackBarEntity
        List<MultiBarEntity> multiBarEntityList = new ArrayList<>();
        List<String> contents = new ArrayList<>();
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            if (i < 2) {
                Sheet sheet = workbook.getSheetAt(i);
                contents.add(sheet.getSheetName());
                int rowsCount = sheet.getPhysicalNumberOfRows();
                List<String> rowKeyList = new ArrayList<>();
                List<String> columnList = new ArrayList<>();
                List<List<Double>> valuesList = new ArrayList<>();
                for (int j = 0; j < rowsCount; j++) {
                    Row row = sheet.getRow(j);
                    int cellCounts = row.getPhysicalNumberOfCells();
                    List<Double> values = new ArrayList<>();
                    for (int k = 0; k < cellCounts; k++) {
                        Cell cell = row.getCell(k);
                        String stringCellValue = cellValue(cell);
                        if (j == 0) {
                            cell = row.getCell(k + 1);
                            stringCellValue = cellValue(cell);
                            rowKeyList.add(stringCellValue);
                        } else {
                            if (k == 0) {
                                columnList.add(stringCellValue);
                            } else {
                                String substring = stringCellValue.substring(0, stringCellValue.length());
                                double value = Double.parseDouble(substring);
                                values.add(value);
                            }
                        }
                    }

                    if (j > 0) {
                        valuesList.add(values);
                    }
                }
                //StackBarEntity
                MultiBarEntity multiStackBarEntity = new MultiBarEntity(rowKeyList, columnList, valuesList);
                multiBarEntityList.add(multiStackBarEntity);
            }
        }
        ModelOneData modelOneData = new ModelOneData();
        modelOneData.setMultiBarEntityList(multiBarEntityList);
        modelOneData.setContentList(contents);
        return modelOneData;
    }

    /**
     * 模板4的数据
     *
     * @param pathName
     * @return
     */
    public static ModelOneData getDataFromExcel_model4(String pathName)throws Exception {

        Workbook workbook = WDWUtil.getWorkbook(pathName);
        int sheetCounts = workbook.getNumberOfSheets();
        List<MultiStackBarEntity> multiStackBarEntityList = new ArrayList<>();
        List<List<Double>> valuesList = new ArrayList<>();
        List<String> columnKeyList = new ArrayList<>();
        List<String> contents = new ArrayList<>();
        for (int i = 0; i < sheetCounts; i++) {
            if (i < 1) {

                Sheet sheet = workbook.getSheetAt(i);
                contents.add(sheet.getSheetName());
                int rowCounts = sheet.getPhysicalNumberOfRows();
                Row row = sheet.getRow(0);
                int cellCounts = row.getPhysicalNumberOfCells();
                for (int k = 0; k < cellCounts; k++) {
                    List<Double> values = new ArrayList<>();
                    if (k == cellCounts - 1) {
                        List<Double> values1 = new ArrayList<>();
                        for (int a = 0; a < rowCounts; a++) {
                            values1.add(1d);
                        }
                        valuesList.add(values1);
                    }
                    for (int j = 0; j < rowCounts; j++) {
                        row = sheet.getRow(j);
                        Cell cell = row.getCell(k);
                        String cellValue = cellValue(cell);
                        if (!cellValue.isEmpty()) {

                            if (k == 0) {
                                columnKeyList.add(cellValue);
                            } else {
                                values.add(Double.parseDouble(cellValue));
                            }
                        }
                    }
                    valuesList.add(values);
                }
                MultiStackBarEntity multiStackBar = new MultiStackBarEntity(valuesList, columnKeyList);
                multiStackBarEntityList.add(multiStackBar);

            }
        }
        ModelOneData modelOneData = new ModelOneData();
        modelOneData.setMultiStackBarEntityList(multiStackBarEntityList);
        modelOneData.setContentList(contents);
        return modelOneData;
    }

    /**
     * 模板5的数据
     *
     * @param pathName
     * @return
     */

    public static ModelOneData getDataFromExcel_model5(String pathName)throws Exception {
        List<DualAxisChartEntity> dualAxisChartEntityList = new ArrayList<>();
        Workbook workbook = WDWUtil.getWorkbook(pathName);
        List<String> contents = new ArrayList<>();
        for (int k = 0; k < workbook.getNumberOfSheets(); k++) {

            Sheet sheet0 = workbook.getSheetAt(k);
            contents.add(sheet0.getSheetName());
            List<String> columnKeyList = new ArrayList<>();
            List<Double> valueList = new ArrayList<>();
            for (int i = 0; i < sheet0.getPhysicalNumberOfRows(); i++) {
                Row row = sheet0.getRow(i);

                int cellCounts = row.getPhysicalNumberOfCells();
                for (int j = 0; j < cellCounts; j++) {
                    Cell cell = row.getCell(j);
                    String cellValue = cellValue(cell);
                    if (!cellValue.isEmpty()) {

                        if (i == 0) {
                            columnKeyList.add(cellValue);
                        } else if (i == 1) {
                            valueList.add(Double.parseDouble(cellValue));
                        }
                    }
                }
            }
            DualAxisChartEntity dualAxisChartEntity = new DualAxisChartEntity(columnKeyList, valueList);
            dualAxisChartEntityList.add(dualAxisChartEntity);
        }

        ModelOneData modelOneData = new ModelOneData();
        modelOneData.setDualAxisChartEntityList(dualAxisChartEntityList);
        modelOneData.setContentList(contents);

        return modelOneData;
    }

    /**
     * 模板6-1的数据
     *
     * @param pathName
     * @return
     */
    public static ModelOneData getDataFromExcel_model6_1(String pathName)throws Exception {
        Workbook workbook = WDWUtil.getWorkbook(pathName);
        int numberOfSheets = workbook.getNumberOfSheets();
        List<SingleBarEntity> singleBarEntityList = new ArrayList<>();
        List<String> contents = new ArrayList<>();
        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            contents.add(sheet.getSheetName());
            int rowCount = sheet.getPhysicalNumberOfRows();
            List<String> columnList = new ArrayList<>();
            List<Double> valueList = new ArrayList<>();
            for (int j = 0; j < rowCount; j++) {
                if (j < 2) {

                    Row row = sheet.getRow(j);
                    int cellCounts = row.getPhysicalNumberOfCells();
                    for (int k = 0; k < cellCounts; k++) {
                        Cell cell = row.getCell(k);
                        String cellValue = cellValue(cell);

                        if (j == 0) {
                            columnList.add(cellValue);
                        } else {
                            String substring = cellValue.substring(0, cellValue.length());
                            double value = Double.parseDouble(substring);
                            valueList.add(value);
                        }
                    }
                }
            }
            SingleBarEntity singleBarEntity = new SingleBarEntity(columnList, valueList, 2);
            singleBarEntityList.add(singleBarEntity);
        }
        ModelOneData modelOneData = new ModelOneData();
        modelOneData.setSingleBarEntityList(singleBarEntityList);
        modelOneData.setContentList(contents);

        return modelOneData;
    }

    /**
     * 模板6-2的数据
     *
     * @param pathName
     * @return
     */
    public static ModelOneData getDataFromExcel_model6_2(String pathName)throws Exception {
        Workbook workbook = WDWUtil.getWorkbook(pathName);
        List<String> contents = new ArrayList<>();
        //StackBarEntity
        List<MultiBarEntity> multiBarEntityList = new ArrayList<>();
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            if (i < 2) {

                Sheet sheet = workbook.getSheetAt(i);
                contents.add(sheet.getSheetName());
                int rowsCount = sheet.getPhysicalNumberOfRows();
                List<String> rowKeyList = new ArrayList<>();
                List<String> columnList = new ArrayList<>();
                List<List<Double>> valuesList = new ArrayList<>();
                for (int j = 0; j < rowsCount; j++) {
                    Row row = sheet.getRow(j);
                    int cellCounts = row.getPhysicalNumberOfCells();
                    List<Double> values = new ArrayList<>();
                    for (int k = 0; k < cellCounts; k++) {
                        Cell cell = row.getCell(k);
                        String stringCellValue = cellValue(cell);
                        if (j == 0) {
                            if (k < cellCounts - 1) {
                                cell = row.getCell(k + 1);
                                stringCellValue = cellValue(cell);
                                if (!stringCellValue.isEmpty()) {

                                    rowKeyList.add(stringCellValue);
                                }

                            }
                        } else {
                            if (!stringCellValue.isEmpty()) {

                                if (k == 0) {
                                    columnList.add(stringCellValue);
                                } else {
                                    String substring = stringCellValue.substring(0, stringCellValue.length());
                                    double value = Double.parseDouble(substring);
                                    values.add(value);

                                }
                            }
                        }
                    }

                    if (j > 0) {
                        valuesList.add(values);
                    }
                }
                //StackBarEntity
                MultiBarEntity multiStackBarEntity = new MultiBarEntity(rowKeyList, columnList, valuesList, 2);
                multiBarEntityList.add(multiStackBarEntity);
            }
        }
        ModelOneData modelOneData = new ModelOneData();
        modelOneData.setMultiBarEntityList(multiBarEntityList);
        modelOneData.setContentList(contents);

        return modelOneData;
    }


    /**
     * 处理Excel单元格值
     *
     * @param cell
     * @return
     */
    public static String cellValue(Cell cell) {
        String cellValue = "";
        if (null != cell) {
            // 以下是判断数据的类型
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                    cellValue = cell.getNumericCellValue() + "";
                    break;
                case HSSFCell.CELL_TYPE_STRING: // 字符串
                    cellValue = cell.getStringCellValue();
                    if (cellValue.contains("%")) {
                        cellValue = cellValue.substring(0, cellValue.length() - 1);
                    }
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                    cellValue = cell.getBooleanCellValue() + "";

                    break;
                case HSSFCell.CELL_TYPE_FORMULA: // 公式
                    cellValue = cell.getCellFormula() + "";
                    break;
                case HSSFCell.CELL_TYPE_BLANK: // 空值
                    cellValue = "";
                    break;
                case HSSFCell.CELL_TYPE_ERROR: // 故障
                    cellValue = "非法字符";
                    break;
                default:
                    cellValue = "未知类型";
                    break;
            }
        }
        return cellValue;
    }

    public static void main(String args[]) throws Exception {
        String pathName = "f:/model/5.xlsx";
        List<String> contents = new ArrayList<>();
        ModelOneData dataFromExcel_model1 = getDataFromExcel_model5(pathName);
        try {
            PoiPatternGenerate.pattern5(contents,dataFromExcel_model1.getDualAxisChartEntityList());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
