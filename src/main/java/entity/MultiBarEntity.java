package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Blong on 2018/3/18.
 */
public class MultiBarEntity {

    private List<String> rowKeyList;
    private List<String> columnKeyList;
    private List<List<Double>> valueList;
    private double maxValue;
    private int model=1;//mode == 1是3_2,model == 2是6_2

    public MultiBarEntity() {
    }

    public MultiBarEntity(List<String> rowKeyList, List<String> columnKeyList, List<List<Double>> valueList, int model) {
        this.rowKeyList = rowKeyList;
        this.columnKeyList = columnKeyList;
        this.valueList = valueList;
        this.model = model;
        setValue();
    }

    public MultiBarEntity(List<String> rowKeyList, List<String> columnKeyList, List<List<Double>> valueList) {
        this.rowKeyList = rowKeyList;
        this.columnKeyList = columnKeyList;
        this.valueList = valueList;
        setValue();
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    private void setValue(){
        List<Double> maxValueList = new ArrayList<>();
        for (int i = 0; i < this.valueList.size(); i++) {
            double max = Collections.max(this.valueList.get(i));
            maxValueList.add(max);
        }

        this.maxValue = Collections.max(maxValueList);
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public List<String> getRowKeyList() {
        return rowKeyList;
    }

    public void setRowKeyList(List<String> rowKeyList) {
        this.rowKeyList = rowKeyList;
    }

    public List<String> getColumnKeyList() {
        return columnKeyList;
    }

    public void setColumnKeyList(List<String> columnKeyList) {
        this.columnKeyList = columnKeyList;
    }

    public List<List<Double>> getValueList() {
        return valueList;
    }

    public void setValueList(List<List<Double>> valueList) {
        this.valueList = valueList;
        setValue();
    }

    @Override
    public String toString() {
        return "MultiBarEntity{" +
                "rowKeyList=" + rowKeyList +
                ", columnKeyList=" + columnKeyList +
                ", valueList=" + valueList +
                ", maxValue=" + maxValue +
                ", model=" + model +
                '}';
    }
}
