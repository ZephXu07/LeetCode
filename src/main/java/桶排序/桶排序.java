package 桶排序;

import java.util.*;

/**
 * Title: 桶排序
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-17
 */
public class 桶排序 {

    public double[] bucketSort(double[] array) {
        //1.得到数组的最大值最小值，并计算差值
        double max = array[0];
        double min = array[0];

        for (double d : array) {
            max = Math.max(d, max);
            min = Math.min(d, min);
        }

        double diff = max - min;
        //差值

        //2.初始化桶
        int len = array.length;
        //桶数量，差值 / 桶数量 = 桶内范围

        double range = diff / (len - 1);


        List<List<Double>> buckets = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            buckets.add(new LinkedList<>());
        }

        //3.遍历原始数组，将每个元素放入桶中
        for (double v : array) {
            int inx = (int) ((v - min) / (range));
            //桶坐标

            buckets.get(inx).add(v);
        }

        //4.对桶内排序
        for (int i = 0; i < len; i++) {
            //jdk使用归并或者归并的优化版本
            Collections.sort(buckets.get(i));
        }

        //5.输出所有元素
        double[] res = new double[len];
        int inx = 0;

        for (List<Double> list : buckets) {
            for (double num : list) {
                res[inx++] = num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        桶排序 sort = new 桶排序();
        double[] arr = {4.12,6.421,0.0023,3.0,2.213,8.122,4.12,10.09};
        System.out.println(Arrays.toString(sort.bucketSort(arr)));
    }

}
