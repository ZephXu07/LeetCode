package codetop;

/**
 * Title: 字符串相乘
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-27
 */
public class 字符串相乘 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            /*
                一个为0直接返回，避免浪费时间，且最后的处理前缀 0 不此处处理需要其他方式处理
             */
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        int inx1;
        int inx2;
        int pro;
        int sum;
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                pro = (num1.charAt(i) - '0') *
                        (num2.charAt(j) - '0');
                inx1 = i + j;
                /*
                    字符串高位到低位是 0下标递增的
                    所以个位反而下标值更大
                    十位
                 */
                inx2 = i + j + 1;
                /*
                    个位
                    个位与平时计算不一致的时候是因为人工计算省略了前面的 0
                    将两个数补充到相同位数，乘积长度等于原本长度的两倍
                    但前面的 0 是省略了
                    如
                        0 1
                        1 1
                     *  1 1
                     0 1 2 3
                     0 1 2 1
                     如 1 * 1
                        个位是 1 + 1 + 1
                        十位是 1 + 1

                 */
                sum = pro + res[inx2];
                /*
                    加上原来存在的个位，溢出一位时，会在下面叠加到十位
                 */
                res[inx2] = sum % 10;
                /*
                    计算个位，取余
                    因为此时个位的值加上乘积的，所以此处是等号
                    而十位是进位的，是加等于
                 */
                res[inx1] += sum / 10;
                /*
                    计算十位，整数除法
                 */
            }
        }
        StringBuilder ans = new StringBuilder();
        if (res[0] != 0) {
            ans.append(res[0]);
            /*
                因为前面进行了预处理，所以两个数的乘积为两个数的位数之和或者和加1，单独判断
                前导 0 需要删除，如果此处不是 1 则需要删除前导 0
             */
        }
        for (int i = 1; i < res.length; i++) {
            ans.append(res[i]);
        }
        return ans.toString();
    }
}
