package codetop;

import labuladong.Solution;

import java.util.*;

/**
 * Title: 插入区间57
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-21
 */
public class 插入区间57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        /*
            要插入的区间的左右边界
            包含可能的和左右区间合并了的
         */
        boolean insert = false;
        /*
            是否插入
         */
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!insert) {
                    ans.add(new int[]{left, right});
                    insert = true;
                }
                ans.add(interval);
                /*
                    1.
                    |__| |___| |___|
                    中间的为待插入区间
                    2.
                    |__|_|___| |___|
                    前面两个区间有交集了，形成新区间
                    与后面的区间分离了
                    3.
                    |___| |___|
                    第一个为待插入区间，
                    第二个是区间列表的开端
                 */
            } else if (interval[1] < left) {

                ans.add(interval);
                /*
                    1.
                    即在待插入区间的左侧，
                    且没有交集，而待插入区间及其后面的区间情况未知
                 */
            } else {
                /*
                    与插入区间有交集，
                    计算并集
                    成为新的区间
                 */
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!insert) {
            ans.add(new int[]{left, right});
            /*
                还没有插入的情况
                1.
                |__| |___| |___|
                第一个第二代表题目的区间，
                最后一个是待插入区间
                此时即是把这个待插入区间插入
                2.
                |___| |___|___|___|
                第一个是前面的无交集的区间
                第二个是待插入区间形成的新的区间
                由于其包括了后面的所有区间，
                因此没有插入，所以在此插入
             */
        }
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); ++i) {
            res[i] = ans.get(i);
        }
        return res;
    }



    public static void main(String[] args) {
        插入区间57 res = new 插入区间57();
//        int[][] intervals = {{1,3},{6,9}};
//        int[] newInterval = {2, 5};
//        System.out.println(Arrays.deepToString(res.insert(intervals, newInterval)));
//        intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
//        newInterval = new int[]{4,8};
//        System.out.println(Arrays.deepToString(res.insert(intervals, newInterval)));
//        intervals = new int[][]{};
//        newInterval = new int[]{5,7};
//        System.out.println(Arrays.deepToString(res.insert(intervals, newInterval)));
//        /*int[][] */intervals = new int[][]{{1,5}};
//        /*int[] */newInterval = new int[]{2,3};
//        System.out.println(Arrays.deepToString(res.insert(intervals, newInterval)));
//        /*int[][] */intervals = new int[][]{{1,5}};
//        /*int[] */newInterval = new int[]{2,7};
//        System.out.println(Arrays.deepToString(res.insert(intervals, newInterval)));
//        int[][] intervals = new int[][]{{0,2},{3,9}};
//        int[] newInterval = new int[]{6,8};
//        System.out.println(Arrays.deepToString(res.insert(intervals, newInterval)));

        int[][] intervals = new int[][]{{3,5},{12,15}};
        int[] newInterval = new int[]{6,4};
        System.out.println(Arrays.deepToString(res.insert(intervals, newInterval)));
    }
}
