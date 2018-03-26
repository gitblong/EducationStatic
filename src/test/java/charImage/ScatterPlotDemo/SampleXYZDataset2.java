/* ----------------------
 * SampleXYZDataset2.java
 * ----------------------
 * (C) Copyright 2005, by Object Refinery Limited.
 *
 */

package charImage.ScatterPlotDemo;

import org.jfree.data.xy.AbstractXYZDataset;
import org.jfree.data.xy.XYZDataset;

/**
 * A quick-and-dirty implementation of the {@link XYZDataset interface}.  
 * Hard-coded and not useful beyond the demo.
 */
public class SampleXYZDataset2 extends AbstractXYZDataset 
        implements XYZDataset {

    /** The x values. */
//    private double[][] xVal = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
    double[] xVal = {2.1, 2.3, 2.3, 2.2, 2.2, 1.8, 1.8, 1.9, 2.3, 3.8};
    double[] yVal = {14.1, 11.1, 10.0, 8.8, 8.7, 8.4, 5.4, 4.1, 4.1, 25};
    /** The y values. */
//    private double[][] yVal = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
    private static double radius = 0.5;
    double[] zVal = {radius, radius, radius, radius, radius, radius, radius, radius, radius, radius};
    /** The z values. */
//    private double[][] zVal = {{1.1, 2.2, 3.3}, {4.4, 5.5, 6.6}};

    /**
     * Returns the number of series in the dataset.
     *
     * @return The series count.
     */
    public int getSeriesCount() {
        return this.xVal.length;
    }

    /**
     * Returns the key for a series.
     *
     * @param series  the series (zero-based index).
     *
     * @return The key for the series.
     */
    public Comparable getSeriesKey(int series) {
        return "Series " + series;
    }

    /**
     * Returns the number of items in a series.
     *
     * @param series  the series (zero-based index).
     *
     * @return The number of items within the series.
     */
    public int getItemCount(int series) {
        return this.xVal.length;
    }

    /**
     * Returns the x-value for an item within a series.
     * <P>
     * The implementation is responsible for ensuring that the x-values are
     * presented in ascending order.
     *
     * @param series  the series (zero-based index).
     * @param item  the item (zero-based index).
     *
     * @return The x-value.
     */
    public Number getX(int series, int item) {
        return new Double(this.xVal[item]);
    }

    /**
     * Returns the y-value for an item within a series.
     *
     * @param series  the series (zero-based index).
     * @param item  the item (zero-based index).
     *
     * @return The y-value.
     */
    public Number getY(int series, int item) {
        return new Double(this.yVal[item]);
    }

    /**
     * Returns the z-value for the specified series and item.
     *
     * @param series  the series index (zero-based).
     * @param item  the item index (zero-based).
     *
     * @return The value.
     */
    public Number getZ(int series, int item) {
        return new Double(this.zVal[item]);
    }
    
}