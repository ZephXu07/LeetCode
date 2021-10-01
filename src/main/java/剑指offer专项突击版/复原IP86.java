package 剑指offer专项突击版;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 复原IP86
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-01
 */
public class 复原IP86 {
    private List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new LinkedList<>();
        LinkedList<String> track = new LinkedList<>();
        backtrack(s, track, 0, 4);
        return res;
    }

    private void backtrack(String s, LinkedList<String> track, int start, int remain) {
        /*
            remain 剩下的 ip 字段多少个
         */
        if (start == s.length() && remain == 0) {
            res.add(String.join(".", track));
            return;
        }
        for (int i = start; i < start + 3; i++) {
            if (i >= s.length()) {
                break;
            }
            if (remain * 3 < s.length() - i) {
                /*
                    s.length() - i 截取 [start,i] 后剩下的长度
                    remain * 3 剩下的 IP 段最长长度
                    如果还有剩余表示此处不能截取
                 */
                continue;
            }
            if (isValid(s, start, i)) {
                String tmp = s.substring(start, i + 1);
                track.addLast(tmp);
                backtrack(s, track, i + 1, remain - 1);
                track.removeLast();
            }
        }

    }

    private boolean isValid(String s, int start, int end) {
        if (end - start + 1 > 1 && s.charAt(start) == '0') {
            return false;
        }
        int val = Integer.parseInt(s.substring(start, end + 1));
        return val >= 0 && val <= 255;
    }
}
