package 字节;

/**
 * Title: 字符串相加
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-20
 */
public class 字符串相加 {
    public String addStrings(String num1, String num2) {
//        StringBuilder sum = new StringBuilder();
//        int carry = 0;
//        int inx1 = num1.length() - 1;
//        int inx2 = num2.length() - 1;
//        while (inx1 >= 0 && inx2 >= 0) {
//            int n1 = num1.charAt(inx1) - '0';
//            int n2 = num2.charAt(inx2) - '0';
//            int tmp = n1 + n2 + carry;
//            if (tmp >= 10) {
//                tmp = tmp % 10;
//                carry = 1;
//            } else {
//                carry = 0;
//            }
//            sum.append(tmp);
//            inx1--;
//            inx2--;
//        }
//        while (inx1 >= 0) {
//            int tmp = num1.charAt(inx1) - '0' + carry;
//            if (tmp >= 10) {
//                tmp = tmp % 10;
//                carry = 1;
//            } else {
//                carry = 0;
//            }
//            sum.append(tmp);
//            inx1--;
//        }
//        while (inx2 >= 0) {
//            int tmp = num2.charAt(inx2) - '0' + carry;
//            if (tmp >= 10) {
//                tmp = tmp % 10;
//                carry = 1;
//            } else {
//                carry = 0;
//            }
//            sum.append(tmp);
//            inx2--;
//        }
//        if (carry == 1) {
//            sum.append(1);
//        }
//        StringBuilder res = sum.reverse();
//        int end = 0;
//        while (end < res.length() && res.charAt(end) == '0'){
//            end++;
//        }
//        res.delete(0, end);
//        if (res.length() == 0) {
//            return "0";
//        }
//        return res.toString();
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        字符串相加 res = new 字符串相加();
        String num1 = "109";
        String num2 = "9";
        System.out.println(res.addStrings(num1, num2));
    }
}
