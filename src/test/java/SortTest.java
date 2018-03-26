import org.junit.*;
import org.junit.Test;

import javax.crypto.SealedObject;
import java.util.Arrays;

/**
 * Created by Blong on 2018/3/24.
 */
public class SortTest {
    int[] values = {21, 3, 43, 545, 656, 57, 7, 6, 34, 3, 42332323, 232323};

    /**
     *简单排序：
     * 每次找到最小的元素放在i位置
     * 反复循环
     */
    @Test
    public void simpleSort() {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                int minL = i;
                if (values[j] < values[minL]) {
                    minL = j;
                }
                if (minL != i) {
                    int temp = values[i];
                    values[i] = values[minL];
                    values[minL] = temp;
                }
                count++;
            }
        }
        System.out.println(Arrays.toString(values)+"--"+count);
    }

    /**
     * 冒泡排序
     * 1.对数组进行循环
     * 2.检测数组的元素是不是比第二个元素更大,因为每次是两个值的比较，所以循环的次数是values.length-1
     * 3.若更大，则交换位置
     * 4.循环以上步骤
     * 因为数组每次循环都可以确定出最大值，所以确定的值可以不再进行判断，所以为了减少循环，第二个循环的次数是values.length -1-i
     */
    @org.junit.Test
    public void bubleSort() {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - 1 - i; j++) {
                int temp = values[j];
                if (values[j] > values[j + 1]) {
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
                count++;
                System.out.println(Arrays.toString(values));
            }
            System.out.println("--------------------------------------");
        }
        System.out.println(Arrays.toString(values)+"_--"+count);
        fenSelect(values, 3);
    }


    @Test
    public void FDSF() {
        System.out.println(5 / 2);
    }

    /**
     * 二分查找
     * 二分查找的数组必须排好序
     * 1.要确定好两个指针，一个指针指向数组的起始位置start，另一个指针指向数组的结束位置end
     * 2.通过对start和end取得数组中间的下标mid
     * 3.通过下标获取中间值
     * 4.若下标的中间值小于要找的值，则end指针指向mid位置
     * 5.若下标的中间值大于要找的值，则start指向mid位置
     * 6.反复循环
     *
     * @param arr
     * @param search
     */
    public void fenSelect(int[] arr, int search) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            mid = (start + end) / 2;
            if (arr[mid] < search) {
                start = mid;
            } else if (arr[mid] > search) {
                end = mid;
            } else {
                break;
            }
        }
        System.out.println(mid);
    }
}
