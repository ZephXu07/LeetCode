package codetop;

import java.util.Arrays;

/**
 * Title: 两球之间的磁力
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-19
 */
public class 两球之间的磁力 {
    public int maxDistance(int[] position, int m) {
        /*
            篮子位置小到大排序
         */
        Arrays.sort(position);
        int left = 1;
        int right = (position[position.length - 1] - 1) / (m - 1);
        /*
            放 m 个球，即有 m - 1 个间隔，最大篮子的位置与最小篮子的位置即总共的间隔
            得到间隔的最大范围

            最小间隔即是左右相邻为 1
         */
        while (left < right) {
            /*
                找到最大的，
                如果 mid 符合，则 left = mid
                搜索 [mid,right]
                如果 mid 不符合，则 right = mid - 1
                又在 mid 的计算中使用了 +1 的操作
             */
            int mid = (left + right + 1) / 2;
            if (isValid(position, m, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean isValid (int[] pos, int m, int dis) {
        /*
            第一个球先放置在第一个篮子，
            于是直接看第二个球
         */
        int inx = 1;
        m--;
        int pre = pos[0];
        while (m > 0 && inx < pos.length) {
            if (pre + dis > pos[inx]) {
                /*
                    上一个位置加上间隔
                    超过当前的篮子位置
                    尝试下一个篮子
                 */
                inx++;
            } else if (pre + dis <= pos[inx]) {
                /*
                    上一个位置加上间隔
                    小于等于当前的篮子位置
                    表示在这个地方没有篮子，
                    只能用最近还没使用的篮子代替
                    于是球数建议，调整 pre
                    再尝试下一个球和下一个篮子
                 */
                pre = pos[inx];
                inx++;
                m--;
            }

        }
        return m == 0;
        /*
            在遍历完所有篮子后看球是否已经放完
         */
    }

    public static void main(String[] args) {
        两球之间的磁力 res = new 两球之间的磁力();
        System.out.println(res.maxDistance(new int[]{1, 2, 3, 4, 7}, 3) + "\t3");
        System.out.println(res.maxDistance(new int[]{5,4,3,2,1,1000000000}, 2) + "\t999999999");
        System.out.println(res.maxDistance(new int[]{79,74,57,22}, 4) + "\t5");
    }
}
