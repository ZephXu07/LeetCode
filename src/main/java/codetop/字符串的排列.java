package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 字符串的排列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-04
 */
public class 字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        /*
            s1的排列是s2的子串，
            所以使用滑动窗口
            统计窗口里字符的种类
            s1原本的种类与个数
            然后进行对比
         */
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
            /*
                统计s1原本的种类与个数
             */
        }
        int valid = 0;
        /*
            窗口中有效的长度，即种类和次数都一样才算一个有效
            再与 need 对比
         */
        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            /*
                遍历 s2
             */
            char c = s2.charAt(right);
            right ++;
            if (need.containsKey(c)) {
                /*
                    是组成 s1z需要的字符种类，如果不是的话没必要添加

                 */
                window.put(c, window.getOrDefault(c, 0) + 1);
                /*
                    添加进窗口
                 */
                if (window.get(c).equals(need.get(c))) {
                    /*
                        字符次数一致，
                        有效长度增加
                     */
                    valid ++;
                }
            }
            while (right - left >= s1.length()) {
                /*
                    当窗口的长度大于等于 s1 的长度
                 */
                if (valid == need.size()) {
                    /*
                        有效长度 == need长度
                        即窗口中字符的种类与次数都与 s1 一致
                     */
                    return true;
                }
                char d = s2.charAt(left);
                left ++;
                /*
                    移除左边界
                 */
                if (need.containsKey(d)) {
                    /*
                        左边界的字符是组成s1需要的，且窗口次数与need一致
                        要更新 valid 值
                     */
                    if (window.get(d).equals(need.get(d))) {
                        valid --;
                    }
                    int count = window.get(d) - 1;
                    if (count == 0) {
                        window.remove(d);
                    } else {
                        window.put(d, count);
                    }
                    /*
                        更新窗口
                     */
                }
            }
        }
        return false;
    }
}
