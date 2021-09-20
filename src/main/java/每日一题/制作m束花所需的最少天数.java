package 每日一题;

/**
 * Title: 制作m束花所需的最少天数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-09
 */
public class 制作m束花所需的最少天数 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (k * m > bloomDay.length) {
            return -1;
            //花的数目少于制作成花束需要的数目，直接返回 -1
        }
        int low = 1;
        int high = 1000_000_000;
        //根据题目给的范围
        while (low < high) {
            //二分查找
            int mid = (high - low) / 2 + low;
            if (canMake(bloomDay, mid, m, k)) {
                //mid可以满足，所以high从mid开始
                high = mid;
            } else {
                //不满足，则说明天数少了，由于是左边界的二分查找，low = mid+1
                low = mid + 1;
            }
        }
        return canMake(bloomDay, low, m, k) ? low : -1;
    }


    private boolean canMake (int[] bloomDay, int day, int m, int k) {
        //花数组，在day天内，m束花，一束花k支花
        int bunch = 0;
        //花束
        int count = 0;
        //每花束已经多少支花
        for (int j : bloomDay) {
            //遍历花数组
            if (j <= day) {
                //开花天数少于day
                count++;
                //可以加入一起制作
                if (count == k) {
                    //达到花束的数目，花束 + 1，清空花束花数目
                    bunch++;
                    count = 0;
                }
            } else {
                //需要相邻并达到花束要求数目，否则直接清空
                count = 0;
            }
        }
        return bunch >= m;
        //返回已有花束数目是否符合题目要求
    }
}
