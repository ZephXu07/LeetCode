package codetop;

/**
 * Title: 逃脱阻碍者
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-22
 */
public class 逃脱阻碍者 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        /*
            人从[0,0] 到达目的地的走的路径没有多余
            鬼从其自身地点到达目的地同样也没有多余

            如果人距离均小于鬼距离（距离指其出发点到目的地距离）
            则可以到达目的地，否则鬼可以直接在目的地等候

            而假设人距离小于鬼距离，但鬼在人的途中拦截呢？
            即鬼提前到达人的路径上，这不可能，因为鬼能到达人的路径上表明
            鬼能比人先到达目的地，即鬼距离小于人距离，与题目假设相反
         */
        int dist = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] g : ghosts) {
            int tmp = Math.abs(g[0] - target[0]) + Math.abs(g[1] - target[1]);
            if (tmp < dist) {
                return false;
            }
        }
        return true;
    }
}
