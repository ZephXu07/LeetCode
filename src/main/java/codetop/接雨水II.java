package codetop;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Title: 接雨水II
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-06
 */
public class 接雨水II {
    public int trapRainWater(int[][] heightMap) {
        /*
            木桶效应
            先把最外一圈放进去
            最小堆找出最小的点A，其向四周扩散
            扩散的点B如果合法且没访问过
            比较大小，
            A > B比它小的话计算差值加入结果
                （B的另外三个方面可能比B大或等于或小
                但是因为一开始枚举的是最小的，所以在一个方向上已经形成了高边界
                其他两个方向如果大于的话直接围成一个木桶，
                如果小于的话，那两个位置会在后面被填上雨水，于是B处也可以填上雨水）
            A == B如果等于则差值为 0 ，对结果没影响
            A < B，则没法计算，但 B成为新的高边界，继续围住

         */
        int[] DIR = {-1, 0, 1, 0, -1};
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> i[2]));
        int m = heightMap.length;
        int n = heightMap[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == m - 1) {
                    minHeap.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }


        int res = 0;
        while (!minHeap.isEmpty()) {
            int[] tmp = minHeap.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + DIR[i];
                int ny = tmp[1] + DIR[i + 1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if (heightMap[nx][ny] < tmp[2]) {
                        res += tmp[2] - heightMap[nx][ny];
                    }

                    minHeap.offer(new int[]{nx, ny, Math.max(tmp[2], heightMap[nx][ny])});
                    visited[nx][ny] = true;
                }

            }
        }

        return res;
    }
}
