package 每日一题;

/**
 * Title: 尽可能使字符串相等
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-05
 */
public class 尽可能使字符串相等 {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] cost = new int[len];
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (int i = 0; i < len; i++) {
            cost[i] = Math.abs(sArray[i] - tArray[i]);
        }
        int left = 0;
        int right = 0;
        int tmp = maxCost;
        int res = 0;
        while (right < len) {
            if (tmp - cost[right] >= 0) {
                tmp -= cost[right];
                right++;
            } else {
                tmp += cost[left];
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        尽可能使字符串相等 res = new 尽可能使字符串相等();
        String s = "krpgjbjjznpzdfy";
        String t = "nxargkbydxmsgby";
        int maxCost = 14;
        System.out.println(res.equalSubstring(s, t, maxCost));
    }
}
