package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 表示数值的字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-30
 */
public class 表示数值的字符串 {
    public boolean isNumberStateMachine(String s) {
        Map[] states = {
                new HashMap() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap() {{ put('d', 3); }},                                        // 4.
                new HashMap() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap() {{ put('d', 7); }},                                        // 6.
                new HashMap() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') {
                t = 'd';
            }
            else if(c == '+' || c == '-') {
                t = 's';
            }
            else if(c == 'e' || c == 'E'){
                t = 'e';
            }
            else if(c == '.' || c == ' '){
                t = c;
            }
            else {
                t = '?';
            }
            if(!states[p].containsKey(t)) {
                return false;
            }
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }

    /*https://leetcode-cn.com/problems/
    biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
    solution/zui-jian-dan-si-lu-xiang-xi-zhu-shi-zheng-shu-xiao/
     */

    private int index = 0;

    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        s = s.trim() + '|';
        char[] chars = s.toCharArray();
        System.out.println(s);
        boolean isNum = isSignedNumber(chars);
        if (chars[index] == '.') {
            index ++;
            isNum = isUnsignedNumber(chars) || isNum;
        }
        if (chars[index] == 'E' || chars[index] == 'e') {
            index ++;
            isNum = isSignedNumber(chars) && isNum;
        }
        return isNum && index == chars.length - 1;

    }

    private boolean isUnsignedNumber(char[] chars) {
        int start = index;
        while (chars[index] >= '0' && chars[index] <= '9') {
            index ++;
        }
        return index > start;
    }

    private boolean isSignedNumber(char[] chars) {
        if (chars[index] == '+' || chars[index] == '-') {
            index ++;
        }
        return isUnsignedNumber(chars);
    }


    public static void main(String[] args) {
        String s = "1 ";
        表示数值的字符串 res = new 表示数值的字符串();
        System.out.println(res.isNumber(s));
    }
}
