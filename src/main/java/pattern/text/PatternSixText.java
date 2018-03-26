package pattern.text;

/**
 * 模板4
 * Created by Blong on 2018/3/19.
 */
public class PatternSixText {
    /**
     * 模板6_1
     * @return
     */
    public static String model6_1() {
        StringBuffer sb = new StringBuffer("模板6-1");
        return sb.toString();
    }

    /**
     * 模板6_2
     * @return
     */
    public static String model6_2() {
        StringBuffer sb = new StringBuffer("模板6-2");
        return sb.toString();
    }


    public static String model6_2(String s) {
        StringBuffer sb = new StringBuffer("模板6-2");
        sb.append(s);
        return sb.toString();
    }

    public static String model6_1(String s) {
        StringBuffer sb = new StringBuffer("模板6-1");
        sb.append(s);
        return sb.toString();
    }
}
