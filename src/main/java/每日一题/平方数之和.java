package 每日一题;

/**
 * Title: 平方数之和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-28
 */
public class 平方数之和 {
    public boolean judgeSquareSum(int c) {
//        int ceiling = (int)Math.sqrt(c);
//        for (int i = 0; i <= ceiling; i++) {
//            double sqrt = Math.sqrt(c - i * i);
//            if (sqrt == (int)sqrt) {
//                return true;
//            }
//        }
//        return false;


        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;


    }


    public static void main(String[] args) {
        平方数之和 sum = new 平方数之和();
        int c = 5;
        System.out.println(c + "-->" + sum.judgeSquareSum(c));
        c = 4;
        System.out.println(c + "-->" + sum.judgeSquareSum(c));
        c = 3;
        System.out.println(c + "-->" + sum.judgeSquareSum(c));
        c = 2;
        System.out.println(c + "-->" + sum.judgeSquareSum(c));
        c = 1;
        System.out.println(c + "-->" + sum.judgeSquareSum(c));
    }

}
