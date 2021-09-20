package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 罗马数字转整数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-17
 */
public class 罗马数字转整数 {
    public int romanToInt(String s) {
        Map<Character, Integer> mapping = new HashMap<>(7);
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);

        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int val = mapping.get(s.charAt(i));
            if (i < len - 1 && val < mapping.get(s.charAt(i + 1))) {
                res -= val;
            } else {
                res += val;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        罗马数字转整数 res = new 罗马数字转整数();
        System.out.println(res.romanToInt("III"));
    }
}
