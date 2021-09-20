package 每日一题;

/**
 * Title: 分割平衡字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-07
 */
public class 分割平衡字符串 {
    public int balancedStringSplit(String s) {
        /*
            s 字符串已经平衡了
            如果从左到右找到已经平衡的最短字符串了
            剩下的也是平衡字符串
            贪心
            计数 ，L == R 时 count = 0 res++
         */
        int res = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == 'L' ? 1 : -1;
            res += count == 0 ? 1 : 0;
        }
        return res;

    }
}
