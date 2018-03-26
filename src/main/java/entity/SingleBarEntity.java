package entity;

import java.util.Collections;
import java.util.List;

/**
 * Created by Blong on 2018/3/18.
 */
public class SingleBarEntity {
    private List<String> columnList;
    private List<Double> valueList;
    private double maxRange;
    private int model=1;//mode == 1是3_1,model == 2是6_1

    public SingleBarEntity(List<String> columnList, List<Double> valueList, int model) {
        this.columnList = columnList;
        this.valueList = valueList;
        this.model = model;
        setMaxValue();
    }

    public SingleBarEntity() {
    }

    public SingleBarEntity(List<String> columnList, List<Double> valueList) {
        this.columnList = columnList;
        this.valueList = valueList;
        setMaxValue();
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    private void setMaxValue() {
        this.maxRange = Collections.max(this.valueList);
    }

    public double getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(double maxRange) {
        this.maxRange = maxRange;
    }

    public List<Double> getValueList() {
        return valueList;
    }

    public void setValueList(List<Double> valueList) {
        this.valueList = valueList;
        setMaxValue();
    }

    public List<String> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<String> columnList) {
        this.columnList = columnList;
    }

    @Override
    public String toString() {
        return "SingleBarEntity{" +
                "columnList=" + columnList +
                ", valueList=" + valueList +
                ", maxRange=" + maxRange +
                ", model=" + model +
                '}';
    }
}
