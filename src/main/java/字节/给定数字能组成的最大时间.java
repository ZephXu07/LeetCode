package 字节;


/**
 * Title: 给定数字能组成的最大时间
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-22
 */
public class 给定数字能组成的最大时间 {
    public String largestTimeFromDigits(int[] arr) {
        int res = -1;

        for (int i = 0; i < 4; ++i) {
            //小时第一位
            for (int j = 0; j < 4; ++j) {
                //小时第二位
                if (j != i) {
                    //不可以同一个数
                    for (int k = 0; k < 4; ++k) {
                        //分钟第一个数
                        if (k != i && k != j) {
                            //与前两个不可以一样
                            int l = 6 - i - j - k;
                            //坐标计算出剩下的分钟数
                            int hours = 10 * arr[i] + arr[j];
                            //小时
                            int mins = 10 * arr[k] + arr[l];
                            //分钟
                            if (hours < 24 && mins < 60) {
                                //合格的时间
                                res = Math.max(res, hours * 60 + mins);
                                //比较
                            }
                        }
                    }
                }
            }

        }
        return res >= 0 ? String.format("%02d:%02d", res / 60, res % 60) : "";
    }

}
