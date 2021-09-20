package 每日一题;

/**
 * Title: 单调递增的数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-15
 */
public class 单调递增的数字 {
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N;
        }
        char[] chars = String.valueOf(N).toCharArray();
        int index = 1;
        while (index < chars.length && chars[index] >= chars[index - 1]) {
            index++;
        }
        if (index < chars.length) {
            while (index > 0 && chars[index] < chars[index - 1]) {
                chars[index - 1] -= 1;
                index --;
            }
            for (index += 1; index < chars.length; index ++) {
                chars[index] = '9';
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        单调递增的数字 res = new 单调递增的数字();
        int N = 200;
        System.out.println(res.monotoneIncreasingDigits(N));
    }
}
