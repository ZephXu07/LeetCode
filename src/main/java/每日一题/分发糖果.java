package 每日一题;

/**
 * Title: 分发糖果
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-24
 */
public class 分发糖果 {
    public int candy(int[] ratings) {
//        if (null == ratings) {
//            return 0;
//        }
//        if (ratings.length == 1) {
//            return 1;
//        }
//        int len = ratings.length;
//        int[] left = new int[len];
//        left[0] = 1;
//        int res = 0;
//        for (int i = 1; i < len; i++) {
//            if (ratings[i] > ratings[i - 1]) {
//                left[i] = left[i - 1] + 1;
//            } else {
//                left[i] = 1;
//            }
//        }
//        int right = 1;
//        for (int i = len - 1; i >= 0; i--) {
//            if (i < len - 1 && ratings[i] > ratings[i + 1]) {
//                right ++;
//            } else {
//                right = 1;
//            }
//            res += Math.max(left[i], right);
//        }
//        return res;


        if (null == ratings) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        int len = ratings.length;
        int decLen = 0;
        int incMax = 1;
        int res = 1;
        int pre = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                decLen = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                res += pre;
                incMax = pre;
            } else {
                decLen ++;
                if (decLen == incMax) {
                    decLen ++;
                }
                res += decLen;
                pre = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ratings = {29,51,87,87,72,12};
        分发糖果 res = new 分发糖果();
        System.out.println(res.candy(ratings));
    }
}
