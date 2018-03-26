package entity;

import extend.PathConfig;

/**
 * Created by Blong on 2018/3/18.
 */
public class Flag {
    public static  boolean isFirst = true;
    public static String wordPath = PathConfig.WORDROOT;
    public static String inputPath = "d:/";

    public Flag() {
    }

    public static boolean isIsFirst() {
        return isFirst;
    }

    public static void setIsFirst(boolean isFirst) {
        Flag.isFirst = isFirst;
    }

    public static String getWordPath() {
        return wordPath;
    }

    public static void setWordPath(String wordPath) {
        Flag.wordPath = wordPath;
    }

    @Override
    public String toString() {
        return "Flag{" +
                "isFirst=" + isFirst +
                '}';
    }
}
