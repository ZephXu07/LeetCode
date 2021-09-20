package 每日一题;

/**
 * Title: 解码方法
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-22
 */
public class 解码方法 {


    public int numDecodings(String s) {
        /*解题思路：
            从广州去北京，可以经过上海和武汉，
            经过上海的有五种方法，
            经过武汉的有七种方法，
            所以一共有12种方法

          当前字符是[1,9]则可以进行解码，此时解码方法是加上前面的解码方法数，上海
          当前字符与前一个字符是[10，26]也可以进行解码，此时是加上[i-2]解码数，武汉


         */

        s = " " + s;
        //添加空格来避免对负数坐标的讨论
        int[] dp = new int[s.length()];

        dp[0] = 1;
        //空字符只有一种解码饭方法
        for (int i = 1; i < s.length(); i++) {
            int a = s.charAt(i) - '0';
            //当前字符
            int b = s.charAt(i) - '0' + (s.charAt(i - 1) - '0') * 10;
            //当前与前一字符
            if (1 <= a && a <= 9) {
                dp[i] += dp[i - 1];
            }

            if (10 <= b && b <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }

    public int numDecodings1(String s) {
        /*解题思路：
            思路同上面，主要是内存优化，
            长度为3的数组，举例，当前坐标是8，8-1=7，8-2=6，取余3等于 2, 1, 0


         */

        s = " " + s;
        //添加空格来避免对负数坐标的讨论
        int[] dp = new int[3];

        dp[0] = 1;
        //空字符只有一种解码饭方法
        for (int i = 1; i < s.length(); i++) {
            dp[i % 3] = 0;
            int a = s.charAt(i) - '0';
            //当前字符
            int b = s.charAt(i) - '0' + (s.charAt(i - 1) - '0') * 10;
            //当前与前一字符
            if (1 <= a && a <= 9) {
                dp[i % 3] += dp[(i - 1) % 3];
            }

            if (10 <= b && b <= 26) {
                dp[i % 3] += dp[(i - 2) % 3];
            }
        }
        return dp[(s.length() - 1) % 3];
    }

    public static void main(String[] args) {
//        System.out.println(numDecodings("12"));
//        System.out.println(numDecodings("226"));
//        System.out.println(numDecodings("0"));
//        System.out.println(numDecodings("06"));
//        System.out.println(numDecodings1("12"));
//        System.out.println(numDecodings1("226"));
//        System.out.println(numDecodings1("0"));
//        System.out.println(numDecodings1("06"));
    }

}
