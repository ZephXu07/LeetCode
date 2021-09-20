package codetop;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Title: 图像重叠
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-20
 */
public class 图像重叠 {
//    public int largestOverlap(int[][] img1, int[][] img2) {
//        /*
//            记录 A B 的 1 的位置
//            枚举 A 的 1 与 B 的 1 的偏移量 off = B - A
//            如果此偏移量没有记录过，则枚举 off + A 是否存在 B 中
//         */
//        List<Point> list1 = new LinkedList<>();
//        List<Point> list2 = new LinkedList<>();
//
//        int len = img1.length;
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {
//                if (img1[i][j] == 1) {
//                    list1.add(new Point(i, j));
//                }
//                if (img2[i][j] == 1) {
//                    list2.add(new Point(i, j));
//                }
//            }
//        }
//        Set<Point> set2 = new HashSet<>(list2);
//        Set<Point> offset = new HashSet<>();
//        int res = 0;
//        for (Point a : list1) {
//            for (Point b : list2) {
//                Point off = new Point(b.x - a.x, b.y - a.y);
//                if (offset.contains(off)) {
//                    continue;
//                }
//                offset.add(off);
//                int count = 0;
//                for (Point aa : list1) {
//                    if (set2.contains(new Point(aa.x + off.x, aa.y + off.y))) {
//                        count++;
//                    }
//                }
//                res = Math.max(res, count);
//            }
//        }
//
//        return res;
//
//    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        /*
            记录所有 A 的 1 对 B 的 1 的所有偏移量
            找到出现次数最多的那个的次数
         */
        int len = img1.length;
        Map<Point, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (img1[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < len; k++) {
                    for (int l = 0; l < len; l++) {
                        if (img2[k][l] == 0) {
                            continue;
                        }
                        Point p = new Point(i - k, j - l);
                        map.put(p, map.getOrDefault(p, 0) + 1);
                    }
                }
            }
        }
        int res = 0;
        for (Integer i : map.values()) {
            res = Math.max(res, i);
        }
        return res;
    }

    public static void main(String[] args) {
        图像重叠 res = new 图像重叠();
        int[][] a = {{1,1,0},{0,1,0},{0,1,0}};
        int[][] b = {{0,0,0},{0,1,1},{0,0,1}};
        System.out.println(res.largestOverlap(a, b));

        Set<int[]> set = new HashSet<>();


    }
}
