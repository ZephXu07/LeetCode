package 字节;

/**
 * Title: 分发糖果
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-01
 */
public class 分发糖果 {
//    public int candy1(int[] ratings) {
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
//        //贪心
//        for (int i = 1; i < len; i++) {
//            if (ratings[i] > ratings[i - 1]) {
//                left[i] = left[i - 1] + 1;
//                //当严格大于左边时，比左边多一
//            } else {
//                left[i] = 1;
//                //否则则是从1开始
//            }
//        }
//        int right = 1;
//        for (int i = len - 1; i >= 0; i--) {
//            if (i < len - 1 && ratings[i] > ratings[i + 1]) {
//                right++;
//            } else {
//                right = 1;
//            }
//            //右边同理左边
//            //但同时在计算总数，所以不需要new新数组
//            res += Math.max(left[i], right);
//            //哪个更大，说明可能比左边或者右边大，所以需要选择大的才符合题目要求
//        }
//        return res;
//    }

    public int candy(int[] ratings) {
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
                //递减序列的长度为0
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                //计算是否 大于左边
                res += pre;
                incMax = pre;
                //为了当递增序列和递减序列交界的最大值
            } else {
                decLen ++;
                //递减长度+1
                if (decLen == incMax) {
                    //当递增和递减最大值一样时归为递减队列，所以+1
                    decLen ++;
                }
                res += decLen;
                //把左到右递减序列当右到左的递增序列，因此直接添加即可
                pre = 1;
            }
        }
        return res;
    }
}
