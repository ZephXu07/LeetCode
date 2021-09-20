package 每日一题;

import java.util.*;

/**
 * Title: 字符串的排列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-22
 */
public class 字符串的排列 {
//    private List<String> res;
//    private boolean[] visited;
//    public String[] permutation(String s) {
//        res = new LinkedList<>();
//        visited = new boolean[s.length()];
//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        StringBuilder builder = new StringBuilder();
//        backtrack(chars, builder, 0);
//        int len = res.size();
//        String[] ans = new String[len];
//        for (int i = 0; i < len; i++) {
//            ans[i] = res.get(i);
//        }
//        return ans;
//    }
//
//    private void backtrack(char[] chars, StringBuilder builder, int len) {
//        if (len == chars.length) {
//            res.add(builder.toString());
//            return;
//        }
//
//        for (int i = 0; i < chars.length; i++) {
//            /*
//                排序后相同的字符一定相邻
//                visited[i] 为当前字符出现过，直接跳过
//                i > 0 && !visited[i - 1] && chars[i - 1] == chars[i]
//                表示相邻字符是相同的，此时前一个字符没有被使用，这不符合，
//                因为从前往后遍历的，前一个字符应该被使用过，而此时没有被使用则就是出现重复的情况
//             */
//            if (visited[i] || (i > 0 && !visited[i - 1] && chars[i - 1] == chars[i])) {
//                continue;
//            }
//            visited[i] = true;
//            builder.append(chars[i]);
//            backtrack(chars, builder, len + 1);
//            builder.deleteCharAt(builder.length() - 1);
//            visited[i] = false;
//        }
//    }

    public String[] permutation(String s) {
        List<String> res = new LinkedList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        res.add(new String(chars));
        while (nextPermutation(chars)) {
            res.add(new String(chars));
        }
        int len = res.size();
        String[] ans = new String[len];
        for (int i = 0; i < len; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public boolean nextPermutation(char[] chars) {
        int pre = chars.length - 2;
        while (pre >= 0 && chars[pre] >= chars[pre + 1]) {
            pre--;
        }
        if (pre < 0) {
            return false;
        }
        int cur = pre + 1;
        while (cur < chars.length && chars[cur] > chars[pre]) {
            cur++;
        }
        cur --;
        swap(chars, pre, cur);
        reverse(chars, pre + 1);
        return true;
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void reverse(char[] arr, int i) {
        int j = arr.length - 1;
        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }

    }
}
