package entity;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Blong on 2018/3/16.
 */
public class ScatterEntity {
    //x轴值
    private double[] x;
    //y轴值
    private double[] y;
    //点的值
    private String[] labeValues;
    //x，y轴名称
    private String xAxisLabel;
    private String yAxisLabel;
    //市中心数组下标
    private int cityIndex;
    //y轴范围
    private double minRange;
    private double maxRange;
    //x轴范围
    private double minDomain;
    private double maxDomain;

    public ScatterEntity() {
    }

    public ScatterEntity(double[] x, double[] y, String[] labeValues,String xAxisLabel,String yAxisLabel) {
        this.x = x;
        this.y = y;
        this.labeValues = labeValues;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;
        setXValue();
        setYValue();
//        setCityIndex();
    }

    private void setCityIndex() {

        this.cityIndex= Arrays.binarySearch(this.labeValues, "全市");
        System.out.println(this.cityIndex);
        System.out.println(" Arrays.binarySearch(this.labeValues, \"全市\")"+ Arrays.binarySearch(this.labeValues, "全市"));
    }


    private void setXValue() {

        double min = Collections.min(Arrays.asList(ArrayUtils.toObject(this.x)));;
        this.minDomain = min - 0.2;
        double max = Collections.max(Arrays.asList(ArrayUtils.toObject(this.x)));
        this.maxDomain= max + 0.2;
    }

    private void setYValue() {
        double min = Collections.min(Arrays.asList(ArrayUtils.toObject(this.y)));;
        this.minRange = min - 20;
        double max = Collections.max(Arrays.asList(ArrayUtils.toObject(this.y)));
        this.maxRange = max + 20;
    }

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
        setXValue();
    }

    public double[] getY() {
        return y;
    }

    public void setY(double[] y) {
        this.y = y;
        setYValue();
    }

    public String[] getLabeValues() {
        return labeValues;
    }

    public void setLabeValues(String[] labeValues) {
        this.labeValues = labeValues;
//        setCityIndex();
    }

    public String getxAxisLabel() {
        return xAxisLabel;
    }

    public void setxAxisLabel(String xAxisLabel) {
        this.xAxisLabel = xAxisLabel;
    }

    public String getyAxisLabel() {
        return yAxisLabel;
    }

    public void setyAxisLabel(String yAxisLabel) {
        this.yAxisLabel = yAxisLabel;
    }

    public int getCityIndex() {
        return cityIndex;
    }

    public void setCityIndex(int cityIndex) {
        this.cityIndex = cityIndex;
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

    public double getMinDomain() {
        return minDomain;
    }

    public void setMinDomain(double minDomain) {
        this.minDomain = minDomain;
    }

    public double getMaxDomain() {
        return maxDomain;
    }

    public void setMaxDomain(double maxDomain) {
        this.maxDomain = maxDomain;
    }

    @Override
    public String toString() {
        return "ScatterEntity{" +
                "x=" + Arrays.toString(x) +
                ", y=" + Arrays.toString(y) +
                ", labeValues=" + Arrays.toString(labeValues) +
                ", xAxisLabel='" + xAxisLabel + '\'' +
                ", yAxisLabel='" + yAxisLabel + '\'' +
                ", cityIndex=" + cityIndex +
                ", minRange=" + minRange +
                ", maxRange=" + maxRange +
                ", minDomain=" + minDomain +
                ", maxDomain=" + maxDomain +
                '}';
    }
}
