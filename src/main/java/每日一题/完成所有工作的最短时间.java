package 每日一题;

/**
 * Title: 完成所有工作的最短时间
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-08
 */
public class 完成所有工作的最短时间 {
    private int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] count = new int[k];
        dfs(jobs, count, 0, 0, 0);
        return res;
    }


    private void dfs (int[] jobs, int[] count, int cur, int max, int init) {
        if (max >= res) {
            return;
        }
        if (cur == jobs.length) {
            res = max;
            return;
        }

        if (init < count.length) {
            count[init] = jobs[cur];
            dfs(jobs, count, cur + 1, Math.max(max, count[init]), init + 1);
            count[init] = 0;
        }


        for (int i = 0; i < init; i++) {
            count[i] += jobs[cur];
            dfs(jobs, count, cur + 1, Math.max(max, count[i]), init);
            count[i] -= jobs[cur];
        }
    }

    public static void main(String[] args) {
        完成所有工作的最短时间 res = new 完成所有工作的最短时间();
//        int[] jobs = {3,2,3};
//        int k = 3;
        int[] jobs = {1,2,4,7,8};
        int k = 2;
//        int[] jobs = {254,256,256,254,251,256,254,253,255,251,251,255};
//        int k = 10;


        System.out.println(res.minimumTimeRequired(jobs, k));
    }
}
