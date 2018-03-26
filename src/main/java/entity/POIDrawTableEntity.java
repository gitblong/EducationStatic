package entity;

import java.util.List;

/**
 * Created by Blong on 2018/3/17.
 */
public class POIDrawTableEntity {
    private List<List<String>> tableInfo;
    private int allCityFlag;

    public POIDrawTableEntity() {
    }

    public POIDrawTableEntity(List<List<String>> tableInfo, int allCityFlag) {
        this.tableInfo = tableInfo;
        this.allCityFlag = allCityFlag;
    }

    public List<List<String>> getTableInfo() {
        return tableInfo;
    }

    public void setTableInfo(List<List<String>> tableInfo) {
        this.tableInfo = tableInfo;
    }

    public int getAllCityFlag() {
        return allCityFlag;
    }

    public void setAllCityFlag(int allCityFlag) {
        this.allCityFlag = allCityFlag;
    }

    @Override
    public String toString() {
        return "POIDrawTableEntity{" +
                "tableInfo=" + tableInfo +
                ", allCityFlag=" + allCityFlag +
                '}';
    }
}
