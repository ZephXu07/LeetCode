package 杂类;

import java.util.List;

/**
 * Title: 钥匙和房间841
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-02
 */
public class 钥匙和房间841 {
    private int res;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        res = 0;
        boolean[] visited = new boolean[len];
        dfs(0, visited, rooms);
        return res == len;
    }

    private void dfs (int inx, boolean[] visited, List<List<Integer>> rooms) {
        res++;
        visited[inx] = true;
        for (int r : rooms.get(inx)) {
            if (visited[r]) {
                continue;
            }
            dfs(r, visited, rooms);
        }
    }
}
