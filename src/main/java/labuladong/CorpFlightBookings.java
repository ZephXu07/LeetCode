package labuladong;

/**
 * Title: labuladong.CorpFlightBookings
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-22
 */
public class CorpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        if (0 == n) {
            return null;
        }
        int[] res = new int[n];
        int start;
        int end;
        int value;
        Difference difference = new Difference(res);
        for (int[] booking : bookings) {
            start = booking[0] - 1;
            end = booking[1] - 1;
            value = booking[2];
            difference.change(start, end, value);
        }
        return difference.result();
    }
}
class Difference {
    private int[] diff;
    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public void change(int start, int end, int value) {
        diff[start] += value;
        if (end + 1 < diff.length) {
            diff[end + 1] -= value;
        }
    }

    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = diff[i] + res[i - 1];
        }
        return res;
    }
}
