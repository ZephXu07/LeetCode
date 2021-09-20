package codetop;

import java.util.*;

/**
 * Title: 用户分组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-17
 */
public class 用户分组 {
//    public List<List<Integer>> groupThePeople(int[] groupSizes) {
//        int len = groupSizes.length;
//        int[][] num = new int[len][2];
//        for (int i = 0; i < len; i++) {
//            num[i][0] = groupSizes[i];
//            num[i][1] = i;
//        }
//
//        Arrays.sort(num, Comparator.comparingInt(n -> n[0]));
//
//        List<List<Integer>> res = new LinkedList<>();
//        List<Integer> level = null;
//        int size = 0;
//        for (int[] n : num) {
//            if (n[0] == 1) {
//                level = new ArrayList<>(1);
//                level.add(n[1]);
//                res.add(level);
//                size = 0;
//                level = null;
//            } else {
//                if (size == 0) {
//                    size = n[0];
//                    if (null != level && level.size() != 0) {
//                        res.add(level);
//                    }
//                    level = new ArrayList<>(size);
//                    level.add(n[1]);
//                    size--;
//                } else {
//                    level.add(n[1]);
//                    size--;
//                }
//            }
//        }
//        if (null != level) {
//            res.add(level);
//        }
//        resurn res;
//
//    }


    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        int len = groupSizes.length;
        /*
            hashArray[key] 表示保存 想要分组key人的用户的下标组成的链表 的哈希数组
            因为哈希表是从1开始，所以长度多开一个。
         */

        List<Integer>[] hashArray = new ArrayList[len + 1];
        for (int i = 0; i < len; i++) {
            int key = groupSizes[i];
            if (hashArray[key] == null) {
                /*
                    如果该key没有链表则创建一个
                 */
                List<Integer> list = new ArrayList<>();
                hashArray[key] = list;
            }
            hashArray[key].add(i);
            if (hashArray[key].size() == key) {
                /*
                    链表的长度达到key，就可以构建一个分组，此时将分组计入结果，然后清空拉链。
                 */
                res.add(new ArrayList(hashArray[key]));
                hashArray[key].clear();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        用户分组 res = new 用户分组();
        res.groupThePeople(new int[]{3,3,3,3,3,1,3}).forEach(System.out::println);
    }

}
