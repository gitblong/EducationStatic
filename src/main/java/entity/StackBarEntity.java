package entity;

import java.util.List;

/**
 * Created by Blong on 2018/3/16.
 */
public class StackBarEntity {

    private List<String> columnKeyList;
    private List<String> rowKeyList;
    private List<List<Double>> values;

    public StackBarEntity() {
    }

    public StackBarEntity(List<String> columnKeyList, List<String> rowKeyList, List<List<Double>> values) {
        this.columnKeyList = columnKeyList;
        this.rowKeyList = rowKeyList;
        this.values = values;
    }

    public List<String> getColumnKeyList() {
        return columnKeyList;
    }

    public void setColumnKeyList(List<String> columnKeyList) {
        this.columnKeyList = columnKeyList;
    }

    public List<String> getRowKeyList() {
        return rowKeyList;
    }

    public void setRowKeyList(List<String> rowKeyList) {
        this.rowKeyList = rowKeyList;
    }

    public List<List<Double>> getValues() {
        return values;
    }

    public void setValues(List<List<Double>> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "StackBarEntity{" +
                "columnKeyList=" + columnKeyList +
                ", rowKeyList=" + rowKeyList +
                ", values=" + values +
                '}';
    }
}
