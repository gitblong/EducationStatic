package pattern.text;

/**
 * 模板3
 * Created by Blong on 2018/3/19.
 */
public class PatternThreeText {

    /**
     * 模板3-1
     * @return
     */
    public static String model3_1() {
        StringBuffer sb = new StringBuffer("模板3-1");
        return sb.toString();
    }

    /**
     * 模板3-2
     * @return
     */
    public static String model3_2() {
        StringBuffer sb = new StringBuffer("模板3-2");
        return sb.toString();
    }


    public static String model3_2(String s) {
        StringBuffer sb = new StringBuffer("模板3-2");
        sb.append(s);
        return sb.toString();
    }

    public static String model3_1(String s) {
        StringBuffer sb = new StringBuffer("模板3-1");
        sb.append(s);
        return sb.toString();
    }
}
