package codetop;


import java.util.LinkedList;
import java.util.List;

/**
 * Title: 字典序排数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-02
 */
public class 字典序排数 {
    private List<Integer> res;
    private int n;

    public List<Integer> lexicalOrder(int n) {
        res = new LinkedList<>();
        this.n = n;
        for (int i = 1; i <= 9; i++) {
            /*
                枚举 i 开头的数字
             */
            dfs(i);
        }
        return res;
    }

    private void dfs(int sum) {
        if (sum > n) {
            /*
                数超过 n 停止
             */
            return;
        }
        res.add(sum);
        for (int i = 0; i <= 9; i++) {
            /*
                枚举下一位
             */
            dfs(sum * 10 + i);
        }
    }
}


