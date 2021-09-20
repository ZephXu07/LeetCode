package codetop;

/**
 * Title: 分割连接字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-17
 */
public class 分割连接字符串 {
    public static String splitLoopedString(String[] strs) {
        /*
            遍历每个字符串，使单个成为最大
            然后对每一个进行切割组装在前后
            再对其翻转后也组装
            因为翻转可能使大小变化
         */
        for (int i = 0; i < strs.length; i++) {
            String tmp = new StringBuilder(strs[i]).reverse().toString();
            if (tmp.compareTo(strs[i]) > 0) {
                strs[i] = tmp;
            }
        }

        String res = "";
        for (int i = 0; i < strs.length; i++) {
            StringBuilder bui = new StringBuilder();
            for (int j = i + 1; j < strs.length; j++) {
                bui.append(strs[j]);
            }

            for (int j = 0; j < i; j++) {
                bui.append(strs[j]);
            }

            for (int j = 0; j < strs[i].length(); j++) {
                String cur = strs[i].substring(j) + bui + strs[i].substring(0, j);
                if (cur.compareTo(res) > 0) {
                    res = cur;
                }
            }

            String tmp = new StringBuilder(strs[i]).reverse().toString();
            for (int j = 0; j < tmp.length(); j++) {
                String cur = tmp.substring(j) + bui + tmp.substring(0, j);
                if (cur.compareTo(res) > 0) {
                    res = cur;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"abc","xyz"};
        System.out.println(splitLoopedString(strs));
    }
}
