package pattern.text;

/**
 * 模板4
 * Created by Blong on 2018/3/19.
 */
public class PatternFourText {
    /**
     * 模板4
     * @return
     */
    public static String getmodel4() {
        StringBuffer sb = new StringBuffer("模板4");
        return sb.toString();
    }


    public static String getmodel4(String s) {
        StringBuffer sb = new StringBuffer("模板4");
        sb.append(s);
        return sb.toString();
    }
}
