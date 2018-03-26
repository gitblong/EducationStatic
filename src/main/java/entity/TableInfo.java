package entity;

import java.util.List;

/**
 * Created by Blong on 2018/3/16.
 */

/**
 * 表的数据集以及，全市在集合里的下标
 */
public class TableInfo {
    private List<TableEntity> tableEntities;
    private int allCityFlag;

    public TableInfo() {
    }

    public TableInfo(List<TableEntity> tableEntities, int allCityFlag) {
        this.tableEntities = tableEntities;
        this.allCityFlag = allCityFlag;
    }

    public List<TableEntity> getTableEntities() {
        return tableEntities;
    }

    public void setTableEntities(List<TableEntity> tableEntities) {
        this.tableEntities = tableEntities;
    }

    public int getAllCityFlag() {
        return allCityFlag;
    }

    public void setAllCityFlag(int allCityFlag) {
        this.allCityFlag = allCityFlag;
    }
}
