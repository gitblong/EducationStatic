package pattern.text;

/**
 * 模板4
 * Created by Blong on 2018/3/19.
 */
public class PatternFiveText {
    /**
     * 模板4
     * @return
     */
    public static String getmodel5() {
        StringBuffer sb = new StringBuffer("模板5");
        return sb.toString();
    }


    public static String getmodel5(String s) {
        StringBuffer sb = new StringBuffer("模板5");
        sb.append(s);
        return sb.toString();
    }
}
