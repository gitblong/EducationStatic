package poi;

import org.apache.poi.ss.usermodel.IndexedColors;

import java.awt.*;

/**
 * Created by Blong on 2018/3/17.
 */
public class TestColor {

    public static void main(String args[]) {
        String s = String.valueOf(String.valueOf(IndexedColors.LIGHT_BLUE.getIndex()));
        System.out.println(s);

    }
}
