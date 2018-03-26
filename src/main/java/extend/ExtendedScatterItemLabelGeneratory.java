package extend;


import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.data.DataUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;


public class ExtendedScatterItemLabelGeneratory extends StandardXYItemLabelGenerator implements PublicCloneable, Cloneable, Serializable {



    private static final long serialVersionUID = -7108591260223293197L;

    private String labelFormat;

    private String nullValueString;

    private NumberFormat numberFormat;

    private DateFormat dateFormat;

    private NumberFormat percentFormat;

    private String[] labelValue;
    //新增加了参数，柱体series的值是否是总值的百分比，还是仅仅将原来的小数转化为百分数

    private boolean isPercent = false;

    public ExtendedScatterItemLabelGeneratory(){

    }


    public ExtendedScatterItemLabelGeneratory(String[] labelValue){
        this.labelValue = labelValue;
    }


    @Override
    public String generateLabel(XYDataset dataset, int series, int item) {

        return labelValue[item];
    }
 

 

} 