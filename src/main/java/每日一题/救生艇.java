package 每日一题;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Title: 救生艇
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-26
 */
public class 救生艇 {
//    public int numRescueBoats(int[] people, int limit) {
//        /*
//            枚举，在TreeMap找到小于等于 limit - p 的最大值
//            找得到则这两个一只船，否则 p 一只船
//         */
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        for (int p : people) {
//            treeMap.put(p, treeMap.getOrDefault(p, 0) + 1);
//        }
//
//        int res = 0;
//        int sum = 0;
//        for (int p : people) {
//            if (treeMap.containsKey(p)) {
//                del(treeMap, p);
//                sum += p;
//                Integer diff = treeMap.floorKey(limit - sum);
//                if (null != diff) {
//                    del(treeMap, diff);
//                }
//                res++;
//                sum = 0;
//            }
//        }
//        return res;
//
//    }
//
//    private void del (TreeMap<Integer, Integer> treeMap, int p) {
//        int freq = treeMap.get(p) - 1;
//        if (freq != 0) {
//            treeMap.put(p, freq);
//        } else {
//            treeMap.remove(p);
//        }
//    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            /*
                现有最轻和最终的尝试同一条船
                如果可以一起坐，则他俩同一条船
                否则最重的自己一条船，最轻的和剩下最重的再比较

                当 left + 1 == right 时
                如果其可以一条船，则 left = right， right = left 结束
                否则 right 自己一条船，然后 right == left，此时 left 也需要一条船
                所以 循环结束条件是 left <= right
             */
            if (people[right] + people[left] <= limit) {
                left++;
            }
            right--;
            res++;

        }
        return res;
    }

    public static void main(String[] args) {
        救生艇 res = new 救生艇();
        System.out.println(res.numRescueBoats(new int[]{1, 2}, 3) + "\t1");
        System.out.println(res.numRescueBoats(new int[]{3,2,2,1}, 3) + "\t3");
        System.out.println(res.numRescueBoats(new int[]{3,5,3,4}, 5) + "\t4");
        System.out.println(res.numRescueBoats(new int[]{5,1,4,2}, 6) + "\t2");
        System.out.println(res.numRescueBoats(new int[]{3,1,7}, 7) + "\t2");
        System.out.println(res.numRescueBoats(new int[]{1,5,3,5}, 7) + "\t3");
        System.out.println(res.numRescueBoats(new int[]{3,8,7,1,4}, 9) + "\t3");
        System.out.println(res.numRescueBoats(new int[]{3,2,3,2,2}, 6) + "\t3");
    }
}
