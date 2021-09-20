package 每日一题;

/**
 * Title: 在D天内送达包裹的能力
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-26
 */
public class 在D天内送达包裹的能力 {
    public int shipWithinDays(int[] weights, int D) {
        /*
            在货物列表中，
            找到货物最大的，这是运输的最低的重量，因为运输带不能拆分货物
            计算货物的总质量，这是运输带的最大重量（再大没必要）
            二分法（左边界），在运输带最大最小的重量中找到时间范围内能找到的最小的运完质量
         */
        int[] mm = getMaxAndMin(weights);
        int max = mm[0] + 1;
        int min = mm[1];
        int mid;
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

    private int[] getMaxAndMin(int[] weights) {
        /*
            找到货物的最大质量（货物不能被拆分，运输带只能完整运输）
            货物总质量，运输带一次性运完
         */
        int max = 0;
        int min = weights[0];
        for(int i : weights) {
            max += i;
            min = Math.max(i, min);
        }
        return new int[]{max, min};
    }

    private boolean canFinish(int[] weights, int least, int D) {
        //货物组合，运输带最小运输重量，多少天
        int i = 0;
        for (int day = 0; day < D; day++) {
            //每天
            int sum = least;
            while ((sum -= weights[i]) >= 0) {
                //运输带能运多少货物，货物不能拆分，需要完整运输
                i++;
                //运了一件
                if (i == weights.length) {
                    //在时间限制内，货物都被运输完了
                    return true;
                }
            }
        }
        //时间用完了，货物还没运完，则在D天内，货物不能被运输带质量为least运完
        return false;
    }


}
