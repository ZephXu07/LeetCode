package labuladong;

/**
 * Title: labuladong.CountAndSay
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-09-18
 */
public class CountAndSay {
    public String countAndSay(int n) {
//        // 递归终止条件
//        if (n == 1) {
//            return "1";
//        }
//        StringBuffer res = new StringBuffer();
//        // 拿到上一层的字符串
//        String str = countAndSay(n - 1);
//        int length = str.length();
//        // 开始指针为0
//        int start = 0;
//        // 注意这从起始条件要和下面长度统一
//        for (int i = 1; i < length + 1; i++) {
//            // 字符串最后一位直接拼接
//            if (i == length) {
//                res.append(i - start).append(str.charAt(start));
//                // 直到start位的字符串和i位的字符串不同，拼接并更新start位
//            } else if (str.charAt(i) != str.charAt(start) ) {
//                res.append(i - start).append(str.charAt(start));
//                start = i;
//            }
//        }
//        return res.toString();
        if (n == 1) {
            return "1";
        }
        StringBuilder oldSB = new StringBuilder();
        StringBuilder newSB = new StringBuilder();
        newSB.append(1);
        for (int p = 0, q; p < n - 1; p++) {
            oldSB = newSB;
            q = p;
            for (int i = 1; i < oldSB.length() + 1; i++) {
                // 字符串最后一位直接拼接
                newSB = new StringBuilder();
                if (i == oldSB.length()) {
                    newSB.append(i - q).append(oldSB.charAt(q));
                    // 直到start位的字符串和i位的字符串不同，拼接并更新start位
                } else if (oldSB.charAt(i) != oldSB.charAt(q)) {
                    newSB.append(i - q).append(oldSB.charAt(q));
                    q = i;
                }
            }
        }
        return newSB.toString();
    }

    public static void main(String[] args) {
        String s = new CountAndSay().countAndSay(4);
        System.out.println(s);
    }
}
