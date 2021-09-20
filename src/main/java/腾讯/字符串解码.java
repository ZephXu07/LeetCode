package 腾讯;

/**
 * Title: 字符串解码
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-11
 */
public class 字符串解码 {
    private int start;
    public String decodeString(String s) {
        start = 0;
        return decode(s);
    }

    private String decode (String s) {
        int multiple = 0;
        char c;
        StringBuilder res = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        while (start < s.length()) {
            c = s.charAt(start);
            start++;
            if (Character.isDigit(c)) {
                multiple = multiple * 10 + c - '0';
            } else if (c == '['){
                String str = decode(s);
                while (multiple > 0) {
                    tmp.append(str) ;
                    multiple--;
                }

            } else if (c == ']') {
                break;
            } else {
                tmp.append(c);

            }
        }
        String str = tmp.toString();
        if (multiple == 0) {
            res.append(str);
        } else {
            while (multiple > 0) {
                res.append(str);
                multiple--;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        字符串解码 res = new 字符串解码();
        String s = "10[a]10[bc]";
//        String s = "3[a2[c]]";
//        String s = "2[abc]3[cd]ef";
//        String s = "abc3[cd]xyz";
        System.out.println(s + "---> " + res.decodeString(s));
    }
}
