package codetop;

import java.util.*;

/**
 * Title: 迷路的机器人
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-07
 */
public class 迷路的机器人 {
//    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
//        LinkedList<List<Integer>> list = new LinkedList<>();
//        dfs(obstacleGrid, list, 0, 0);
//        return list;
//    }
//    private boolean dfs(int[][] obstacleGrid,LinkedList<List<Integer>> list, int x, int y){
//        if(x < 0 || x >= obstacleGrid.length ||
//                y < 0 || y >= obstacleGrid[0].length ||
//                obstacleGrid[x][y] != 0){
//            return false;
//        }
//        obstacleGrid[x][y] = 1;
//        /*
//            设置为访问过
//         */
//        list.add(Arrays.asList(x,y));
//        /*
//            添加这个点
//         */
//        if(x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1){
//            return true;
//            /*
//                到终点了
//             */
//        }
//        if(dfs(obstacleGrid, list, x + 1, y)){
//            /*
//                是否这条路径可以到终点
//             */
//            return true;
//        }
//        if(dfs(obstacleGrid, list, x, y + 1)){
//            /*
//                是否这条路径可以到终点
//             */
//            return true;
//        }
//        list.removeLast();
//        /*
//            从这个点出发无法到达终点，移除这个点
//         */
//        return false;
//    }


    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new LinkedList<>();
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) {
            /*
                起点或重点障碍直接返回
             */
            return res;
        }

        boolean[][] dp = new boolean[row][col];
        /*
            是否能从 (0,0) 到达 (i,j)
         */
        dp[0][0] = true;

        for (int i = 0; i < row; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0) && dp[i - 1][0];
        }

        for (int i = 0; i < col; i++) {
            dp[0][i] = (obstacleGrid[0][i] == 0) && dp[0][i - 1];
        }

        /*
            初始化行和列
         */

        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                /*
                    这里把两种情况都合并在一起了
                    先判断是否为 0
                    再判断上一次位置是否可达
                 */
                dp[i][j] = (obstacleGrid[i][j] == 0) && (dp[i-1][j] || dp[i][j-1]);
            }
        }

        if (!dp[row - 1][col - 1]) {
            /*
                不能到达
             */
            return res;
        }
        /*
            逆推
         */
        int i = row - 1;
        int j = col - 1;
        while (i > 0 || j > 0) {
            res.add(Arrays.asList(i, j));
            /*
                加入当前所在点
             */
            if (i > 0 && dp[i - 1][j]) {
                /*
                    是否可以向上走
                 */
                i--;
            } else {
                /*
                    不能向上必有向左走
                    因为可以从起点到终点，
                    也一定可以从终点到起点
                 */
                j--;
            }
        }
        res.add(Arrays.asList(0, 0));
        Collections.reverse(res);
        /*
            逆序
         */
        return res;
    }


}
