package entity;

import java.util.Collections;
import java.util.List;

/**
 * Created by Blong on 2018/3/19.
 */
public class DualAxisChartEntity {

    private List<String> columnKeyList;
    private List<Double> valuelist;

    private double minRange;
    private double maxRange;


    public DualAxisChartEntity() {
    }

    public DualAxisChartEntity(List<String> columnKeyList, List<Double> valuelist) {
        this.columnKeyList = columnKeyList;
        this.valuelist = valuelist;

        setMaxValue();
        setMinValue();
    }

    private void setMaxValue() {
        this.maxRange = Collections.max(this.valuelist);
    }

    private void setMinValue() {
        this.minRange = Collections.min(this.valuelist);
    }

    public List<String> getColumnKeyList() {
        return columnKeyList;
    }

    public void setColumnKeyList(List<String> columnKeyList) {
        this.columnKeyList = columnKeyList;
    }

    public List<Double> getValuelist() {
        return valuelist;
    }

    public void setValuelist(List<Double> valuelist) {
        this.valuelist = valuelist;
        setMaxValue();
        setMinValue();
    }

    public double getMinRange() {
        return minRange;
    }

    public void setMinRange(double minRange) {
        this.minRange = minRange;
    }

    public double getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(double maxRange) {
        this.maxRange = maxRange;
    }

    @Override
    public String toString() {
        return "DualAxisChartEntity{" +
                "columnKeyList=" + columnKeyList +
                ", valuelist=" + valuelist +
                ", minRange=" + minRange +
                ", maxRange=" + maxRange +
                '}';
    }
}
