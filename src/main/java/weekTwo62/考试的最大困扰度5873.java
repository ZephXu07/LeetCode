package weekTwo62;

/**
 * Title: 考试的最大困扰度5873
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-02
 */
public class 考试的最大困扰度5873 {
//    private int res;
//    public int maxConsecutiveAnswers(String answerKey, int k) {
//        res = 0;
//        boolean[] visited = new boolean[answerKey.length()];
//        dfs(answerKey.toCharArray(), visited, k);
//        return res;
//    }
//
//    private void dfs (char[] answerKey, boolean[] visited, int k) {
//        if (k < 0) {
//            return;
//        }
//        res = Math.max(res, getMaxLen(answerKey));
//        for (int i = 0; i < answerKey.length; i++) {
//            if (visited[i]) {
//                continue;
//            }
//            char c = answerKey[i];
//            if (c == 'F') {
//                answerKey[i] = 'T';
//            } else {
//                answerKey[i] = 'F';
//            }
//            visited[i] = true;
//            dfs(answerKey, visited, k - 1);
//            answerKey[i] = c;
//            visited[i] = false;
//        }
//    }
//
//    private static int getMaxLen (char[] answerKey) {
//        int res = 0;
//        int len = answerKey.length;
//        for (int i = 0; i < len; i++) {
//            int inx = i + 1;
//            while (inx < len && answerKey[i] == answerKey[inx]) {
//                inx++;
//            }
//            res = Math.max(res, inx - i);
//        }
//        return res;
//    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        /*
            滑动窗口，统计窗口里面 T 和 F 的次数
            如果都小于 k 则可以
                T --> F 或 F --> T
                即窗口的长度
            如果 T =< k，则
                T --> F 则窗口里面都是 F，为窗口长度
            如果 F =< k，则
                F --> T 则窗口里面都是 T，为窗口长度
            如果 T > k 并且 F > k
                则不能把窗口的 T --> F 或者 F --> T
                需要缩减左边界，再变化 T、F 的次数
         */
        int res = 0;
        int tFreq = 0;
        int fFreq = 0;

        int right = 0;
        int left = 0;
        int len = answerKey.length();
        while (right < len) {
            if (answerKey.charAt(right) == 'T') {
                tFreq++;
            } else {
                fFreq++;
            }

            while (tFreq > k && fFreq > k) {
                if (answerKey.charAt(left) == 'T') {
                    tFreq--;
                } else {
                    fFreq--;
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;

    }

    public static void main(String[] args) {
        考试的最大困扰度5873 res = new 考试的最大困扰度5873();
        System.out.println(res.maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}
