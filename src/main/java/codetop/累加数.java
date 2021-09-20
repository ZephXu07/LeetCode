package codetop;

/**
 * Title: 累加数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-30
 */
public class 累加数 {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int j = 1; j < len; j++) {
            /*
                枚举第二个数开始的位置，由于第一个数开始是 0 ，自然也得到了第二个数
             */
            for (int k = j + 1; k < len; k++) {
                /*
                    枚举第三个数开始的位置
                 */
                if (dfs(num, 0, j, k)) {
                    /*
                        只要一个成功就返回
                     */
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs (String num, int i, int j, int k) {
        if (num.charAt(i) == '0' && j - i > 1) {
            /*
                第一个数长度大于 1 ，且有前缀 0 ，直接 false
             */
            return false;
        }

        if (num.charAt(j) == '0' && k - j > 1) {
            /*
                同理第二个数长度大于 1 ，且有前缀 0 ，直接 false
             */
            return false;
        }

        String sum = addStrings(num, i, j - 1, j, k - 1);
        /*
            前两个数相加
         */

        if (sum.length() + k > num.length() || !isSame(sum, num, k)) {
            /*
                前两个数相加和的长度大于 num 剩余的第三个数的长度
                或者 和 与 第三个数不一样
             */
            return false;
        }
        if (sum.length() + k == num.length()) {
            /*
                第三个数结尾了，nums 也结尾了，成功
             */
            return true;
        }
        return dfs(num, j, k, k + sum.length());
        /*
            判断后续的三个数
         */

    }

    private String addStrings(String num, int i1, int i2, int j1, int j2) {
        /*
            大数相加，在原来字符串上操作
         */
        int add = 0;
        StringBuilder res = new StringBuilder();
        while (i2 >= i1 || j2 >= j1 || add != 0) {
            int x = i2 >= i1 ? num.charAt(i2) - '0' : 0;
            int y = j2 >= j1 ? num.charAt(j2) - '0' : 0;
            int result = x + y + add;
            res.append(result % 10);
            add = result / 10;
            i2--;
            j2--;
        }
        // 计算完以后的答案需要翻转过来
        res.reverse();
        return res.toString();
    }

    private boolean isSame (String sum, String num, int k) {
        /*
            判断前两个数是否和后面一个数相同
         */
        int inx = 0;
        while (inx < sum.length()) {
            if (sum.charAt(inx) == num.charAt(k)) {
                inx++;
                k++;
            } else {
                return false;
            }
        }
        return true;

    }


    public static void main(String[] args) {
        累加数 res = new 累加数();
        System.out.println(res.isAdditiveNumber("112358"));
        System.out.println(res.isAdditiveNumber("199100199"));
    }
}
