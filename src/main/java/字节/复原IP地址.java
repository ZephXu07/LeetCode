package 字节;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 复原IP地址
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-21
 */
public class 复原IP地址 {
    private List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        LinkedList<String> track = new LinkedList<>();
        backtrack(s, track, 0, 4);
        return res;
    }

    private void backtrack(String s, LinkedList<String> track, int start, int remain) {
        if (start == s.length() && remain == 0) {
            res.add(String.join(".", track));
            return;
        }
        for (int i = start; i < start + 3; i++) {
            if (i >= s.length()) {
                break;
            }
            if (remain * 3 < s.length() - i) {
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

    public static void main(String[] args) {
        复原IP地址 res = new 复原IP地址();
        String s = "010010";
        List<String> strings = res.restoreIpAddresses(s);
        for (String l : strings){
            System.out.println(l);
        }
    }
}
