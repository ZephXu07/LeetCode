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
    private int res;
    public int maxConsecutiveAnswers(String answerKey, int k) {
        res = 0;
        boolean[] visited = new boolean[answerKey.length()];
        dfs(answerKey.toCharArray(), visited, k);
        return res;
    }

    private void dfs (char[] answerKey, boolean[] visited, int k) {
        if (k < 0) {
            return;
        }
        res = Math.max(res, getMaxLen(answerKey));
        for (int i = 0; i < answerKey.length; i++) {
            if (visited[i]) {
                continue;
            }
            char c = answerKey[i];
            if (c == 'F') {
                answerKey[i] = 'T';
            } else {
                answerKey[i] = 'F';
            }
            visited[i] = true;
            dfs(answerKey, visited, k - 1);
            answerKey[i] = c;
            visited[i] = false;
        }
    }

    private static int getMaxLen (char[] answerKey) {
        int res = 0;
        int len = answerKey.length;
        for (int i = 0; i < len; i++) {
            int inx = i + 1;
            while (inx < len && answerKey[i] == answerKey[inx]) {
                inx++;
            }
            res = Math.max(res, inx - i);
        }
        return res;
    }

    public static void main(String[] args) {
        考试的最大困扰度5873 res = new 考试的最大困扰度5873();
        System.out.println(res.maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}
