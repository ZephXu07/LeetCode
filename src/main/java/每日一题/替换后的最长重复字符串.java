package 每日一题;

/**
 * Title: 替换后的最长重复字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-02
 */
public class 替换后的最长重复字符串 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int res = 0;
        int[] count = new int[26];
        int maxCount = 0;
        while (right < len) {
            int inx = chars[right] - 'A';
            count[inx] ++;
            maxCount = Math.max(maxCount, count[inx]);
            right++;
            if (right - left > maxCount + k) {
                count[chars[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }

        return res;
    }
}
