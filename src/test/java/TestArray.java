import org.junit.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Blong on 2018/3/23.
 */
public class TestArray {
    @org.junit.Test
    public void test() {
        String s = "迎泽区, 小店区, 晋源区, 尖草坪区, 杏花岭区, 万柏林区, 清徐县, 阳曲县, 娄烦县, 古交市, 民办, 市直, 全市";
        String[] split = s.split(s);
        List<String> stringsli = new ArrayList<>();
        stringsli.add("迎泽区");
        stringsli.add("小店区");
        stringsli.add("晋源区");
        stringsli.add("尖草坪区");
        stringsli.add("杏花岭区");
        stringsli.add("万柏林区");
        stringsli.add("清徐县");
        stringsli.add("阳曲县");
        stringsli.add("娄烦县");
        stringsli.add("古交市");
        stringsli.add("全市");
        stringsli.add("市直");
        int cite= Arrays.binarySearch(split, "全市");
        System.out.println(cite);

    }
}
