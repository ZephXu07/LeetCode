package 剑指offer专项突击版;

/**
 * Title: 省份数量547
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-05
 */
public class 省份数量547 {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int res = 0;
        boolean[] visited = new boolean[len];

        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            res++;
            visited[i] = true;
            dfs(isConnected, len, i, visited);
        }

        return res;
    }


    private void dfs (int[][] isConnected, int len, int cur, boolean[] visited) {
        for (int i = 0; i < len; i++) {
            if (visited[i] || isConnected[cur][i] == 0) {
                continue;
            }
            visited[i] = true;
            dfs(isConnected, len, i, visited);
        }
    }


}
