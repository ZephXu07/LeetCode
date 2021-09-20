package codetop;

/**
 * Title: 第N位数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-16
 */
public class 第N位数字 {
    public int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }

        int count = 189;
        /*
            个位数与十位数的集合
         */
        int len = 3;
        int pre = 9;
        while (count < n) {
            pre = count;
            /*
                记录上一位数的总和
             */
            count += Math.pow(10, len - 1) * 9 * len;
            /*
                记录新的位数的总和 189 + 90 * 2 + 900 * 3 + 9000 * 4
                以此类推
             */
            len++;

        }
        n -= pre;
        /*
            在这个位数它是第几位
         */
        len--;
        /*
            当前的数几位
         */
        int inx = (n - 1) % len;
        /*
            在当前 n 位数他是第几位（从左往右递增，0开始）
         */
        n = (n - 1) / len;
        /*
            当前位数的数中第几位
         */
        String num = String.valueOf((int)Math.pow(10, len - 1) + n);
        /*
            得到当前这个数，将其转为字符
         */
        return num.charAt(inx) - '0';
        /*
        返回 int 类型的值
         */
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= 2000; i++) {
            builder.append(i);
        }
        System.out.println(builder);
        第N位数字 res = new 第N位数字();
        System.out.println(res.findNthDigit(2890) + "\t" + builder.charAt(2890));
        for (int i = 10; i <= 3000; i++) {
            System.out.println(res.findNthDigit(i) + "\t" + builder.charAt(i));
        }
    }
}
