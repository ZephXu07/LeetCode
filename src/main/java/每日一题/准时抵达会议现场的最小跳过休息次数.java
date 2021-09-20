package 每日一题;

/**
 * Title: 准时抵达会议现场的最小跳过休息次数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-01
 */
public class 准时抵达会议现场的最小跳过休息次数 {
    private int min = -1;
    private int[] dist;
    private double speed;
    private int hours;
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        this.dist = dist;
        this.speed = speed;
        this.hours = hoursBefore;
        helper(0, 0, 0);
        return min;
    }

    private void helper (int count, double sum, int inx) {
        if (sum >= hours) {
            if (sum == hours && inx == dist.length) {
                min = min == -1 ? count : Math.min(min, count);
            }
            return;
        }
        if (inx == dist.length) {
            min = min == -1 ? count : Math.min(min, count);
            return;
        }
        double tmp = dist[inx] / speed;
        if ((int)tmp != tmp) {
            helper(count, (float) (sum + Math.ceil(tmp)), inx + 1);
            helper(count + 1, sum + tmp, inx + 1);
        } else {
            helper(count, sum + tmp, inx + 1);
        }
    }


    public static void main(String[] args) {
        准时抵达会议现场的最小跳过休息次数 res = new 准时抵达会议现场的最小跳过休息次数();
//        int[] dist = {1,3,2};
//        int speed = 4;
//        int hoursBefore = 2;
        int[] dist = {7,3,5,5};
        int speed = 2;
        int hoursBefore = 10;
//        int[] dist = {7,3,5,5};
//        int speed = 1;
//        int hoursBefore = 10;
        System.out.println(res.minSkips(dist, speed, hoursBefore));
    }
}
