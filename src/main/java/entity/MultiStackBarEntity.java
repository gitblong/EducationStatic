package entity;

import java.util.List;

/**
 * Created by Blong on 2018/3/18.
 */
public class MultiStackBarEntity {
    List<List<Double>> valueList;
    List<String> columnList;

    public MultiStackBarEntity() {
    }

    public MultiStackBarEntity(List<List<Double>> valueList, List<String> columnList) {
        this.valueList = valueList;
        this.columnList = columnList;
    }

    public List<List<Double>> getValueList() {
        return valueList;
    }

    public void setValueList(List<List<Double>> valueList) {
        this.valueList = valueList;
    }

    public List<String> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<String> columnList) {
        this.columnList = columnList;
    }

    @Override
    public String toString() {
        return "MultiStackBarEntity{" +
                "valueList=" + valueList +
                ", columnList=" + columnList +
                '}';
    }
}
