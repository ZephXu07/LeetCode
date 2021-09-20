package labuladong;

/**
 * Title: labuladong.ShipWithinDays
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-15
 */
public class ShipWithinDays {

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        ShipWithinDays shipWithinDays = new ShipWithinDays();
        boolean b = shipWithinDays.canFinish(weights, 14, D);
        System.out.println(b);
        int i = shipWithinDays.shipWithinDays(weights, D);
        System.out.println(i);
    }

    public int shipWithinDays(int[] weights, int D) {
        int[] mm = getMaxAndMin(weights);
        int max = mm[0] + 1;
        int min = mm[1];
        int mid;
        System.out.println(max +"\t" + min);
        while (min < max) {
            mid = min + (max - min) / 2;
            if (canFinish(weights, mid, D)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
    private boolean canFinish(int[] weights, int least, int D) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int sum = least;
            while ((sum -= weights[i]) >= 0) {
                i++;
                if (i == weights.length) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] getMaxAndMin(int[] weights) {
        int sum = 0;
        int max = weights[0];
        for(int i : weights) {
            sum += i;
            max = Math.max(i, max);
            //货物中最重是选择中最小的
        }
        return new int[]{sum, max};
    }
}
