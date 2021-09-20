package codetop;

import java.util.*;

/**
 * Title: 按权重随机选择
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-18
 */
public class 按权重随机选择 {

//    private Random random;
//    private TreeMap<Integer, Integer> treeMap;
//    private int sum;
//    //    public Solution(int[] w) {
//    public 按权重随机选择(int[] w) {
//        sum = Arrays.stream(w).sum();
//        random = new Random();
//        treeMap = new TreeMap<>();
//        int pre = 0;
//        treeMap.put(0, 0);
//        for (int i = 0; i < w.length; i++) {
//            pre = pre + w[i];
//            treeMap.put(pre, i + 1);
//        }
//    }
//
//    /*
//        前缀 + 二分
//        前缀+下标存储在treeMap 中
//        随机数 num 是[1,sum]
//        找到等于小于 num 的数，等于这个数对应的下标-1是结果，否则是右边的数，则刚好下标
//     */
//
//
//    public int pickIndex() {
//        int num = random.nextInt(sum) + 1;
//        Map.Entry<Integer, Integer> floor = treeMap.floorEntry(num);
//        return floor.getKey() == num ? floor.getValue() - 1 : floor.getValue();
//    }

    private Random random;
    private int sum;
    private int[] pre;
    //    public Solution(int[] w) {
    public 按权重随机选择(int[] w) {
        sum = Arrays.stream(w).sum();
        random = new Random();
        pre = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            pre[i + 1] = pre[i] + w[i];
        }
    }

    /*
        前缀 + 二分
        前缀+下标存储在treeMap 中
        随机数 num 是[1,sum]
        找到等于小于 num 的数，等于这个数对应的下标-1是结果，否则是右边的数，则刚好下标
     */


    public int pickIndex() {
        int num = random.nextInt(sum);
        int left = 0;
        int right = pre.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (pre[mid] <= num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        按权重随机选择 res = new 按权重随机选择(new int[]{4,2});
        System.out.println(res.pickIndex());
    }
}

