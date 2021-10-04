package 剑指offer专项突击版;

import java.util.Arrays;
import java.util.List;

/**
 * Title: 最小时间差035
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-04
 */
public class 最小时间差035 {
    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[] times = new int[len];
        for (int i = 0; i < len; i++) {
            times[i] = toTime(timePoints.get(i));
        }
        Arrays.sort(times);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            min = Math.min(min, times[i] - times[i - 1]);
        }

        min = Math.min(min, 1440 + times[0] - times[len - 1]);

        return min;
    }

    private int toTime (String t) {
        int h = (t.charAt(0) - '0') * 10 + t.charAt(1) - '0';
        int m = (t.charAt(3) - '0') * 10 + t.charAt(4) - '0';
        return h * 60 + m;
    }

    public static void main(String[] args) {
        最小时间差035 res = new 最小时间差035();
//        System.out.println(res.findMinDifference(Arrays.asList("23:59", "00:00")));
        System.out.println(res.findMinDifference(Arrays.asList("00:00","23:59","00:00")));
        System.out.println(res.findMinDifference(Arrays.asList("00:00","04:00","22:00")));
    }
}
