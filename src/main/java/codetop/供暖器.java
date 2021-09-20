package codetop;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Title: 供暖器
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-19
 */
public class 供暖器 {
    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);
        /*
            两个在从小到大的情况下才能方便计算
         */
        int right = Math.max(heaters[heaters.length - 1], houses[houses.length - 1]) - 1;
        /*
            假设当前供暖器在1位置，取房屋最大位置，其之间的差；
            或者房屋在1，取供暖器的最大位置，其之间的差；
             两个取最大值则是二分查找的最大值。
         */
        int left = 0;

        while (left < right) {
            int mid = left + (right - left) / 2;
            /*
                存在的是最小的
                mid 满足时，[mid,right] 一定满足，左侧不清楚，所以 right = mid
                mid 不满足时，[left,mid] 不满足，右侧不清楚，所以 left = mid + 1
             */
            if (isCovered(houses, heaters, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    private boolean isCovered (int[] houses, int[] heaters, int radius) {
        int m = houses.length;
        /*
            从小到大枚举每一个供暖器的最远边界，从小到大测试房子是否在范围内
            如果在遍历供暖器结束前已经遍历到所有房屋，即可以，否则不行
         */
        int inx = 0;
        for (int heater : heaters) {
            int left = heater - radius;
            int right = heater + radius;

            while (inx < m && houses[inx] >= left && houses[inx] <= right) {
                inx++;
            }

            if (inx == m) {
                return true;
            }

        }

        return false;
    }
}
