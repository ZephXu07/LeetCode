package 每日一题;

/**
 * Title: 爱吃香蕉的珂珂
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-26
 */
public class 爱吃香蕉的珂珂 {
    public int minEatingSpeed(int[] piles, int H) {
        /*
            二分法，寻找左边界
            low：从1开始，每小时吃 1 根
            high： 最大的香蕉堆数量，即一小时吃完这一整堆，
            因为再快速度也是需要一小时，下一堆需要从下一个小时开始
         */
        int low = 1;
        int high = getMax(piles);
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (canFinish(piles, mid, H)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private int useTime(int sum, int speed) {
        /*
            根据数量运算出时间，不满足一个小时所吃的仍算一小时
         */
        return (sum / speed) + ((sum % speed == 0 )? 0:1);
    }

    private boolean canFinish(int[] piles, int speed, int H) {
        /*
            不需要按顺序吃的，且吃的小时向上取整，所以直接计算每堆需要的小时，计算总数是否小于给定的时间
         */
        int sum  = 0;
        for(int i : piles) {
            sum += useTime(i, speed);
        }
        return sum <= H;
    }

    private int getMax(int[] piles) {
        /*
            得到香蕉堆最大数量
         */
        int max = 0;
        for(int i : piles) {
            max = Math.max(max, i);
        }
        return max;
    }
}
