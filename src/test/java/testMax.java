import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class testMax {

    private static final String carSplit = ";";
    private static final String timeSplit = ",";
    private static final String regress = "(\\d{1,2},\\d{1,2};)*\\d{1,2},\\d{1,2}$";

    public static void main(String[] args) {
        String inString = null;
        // 数据输入
        Scanner in = new Scanner(System.in);
        inString = in.nextLine();
        //字符串数组格式校验
        Pattern pat = Pattern.compile(regress);
        if (inString == null || inString.trim().equals("") || !pat.matcher(inString).matches()) {
            System.out.println("输入错误!");
            return;
        }
        testMax sol = new testMax();
        int countCars = sol.countCars(sol.convertToArray(inString));
        System.out.println(countCars);
    }

    //输入字符串转数组
    public int[][] convertToArray(String str) {
        String[] strArray = str.split(carSplit);
        int row = strArray.length;
        int col = 2;
        // 字符转数组判断
        int[][] carArray = new int[row][col];
        int start, end;
        for (int i = 0; i < row; i++) {
            start = Integer.parseInt(strArray[i].split(timeSplit)[0]);
            end = Integer.parseInt(strArray[i].split(timeSplit)[1]);
            if (start > end) {
                continue;
            }
            carArray[i][0] = start;
            carArray[i][1] = end;
        }
        return carArray;
    }

    //核心算法实现
    public int countCars(int[][] carArray) {
        int ans = 0, a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0, a7 = 0, a8 = 0, a9 = 0, a10 = 0, a11 = 0;
        for (int i = 0; i < carArray.length; i++) {
            int start = carArray[i][0], end = carArray[i][1];
            if (start <= 1 && end > 1) a1++;
            if (start <= 2 && end > 2) a2++;
            if (start <= 3 && end > 3) a3++;
            if (start <= 4 && end > 4) a4++;
            if (start <= 5 && end > 5) a5++;
            if (start <= 6 && end > 6) a6++;
            if (start <= 7 && end > 7) a7++;
            if (start <= 8 && end > 8) a8++;
            if (start <= 9 && end > 9) a9++;
            if (start <= 10 && end > 10) a10++;
            if (start <= 11 && end > 11) a11++;
        }
        List<Integer> aList = new ArrayList<>();
        aList.add(a1);
        aList.add(a2);
        aList.add(a3);
        aList.add(a4);
        aList.add(a5);
        aList.add(a6);
        aList.add(a7);
        aList.add(a8);
        aList.add(a9);
        aList.add(a10);
        aList.add(a11);
        Integer max = Collections.max(aList);
        ans = max;
        return ans; // 返回计算结果}
    }
}