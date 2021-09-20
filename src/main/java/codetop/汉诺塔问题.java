package codetop;

import java.util.List;

/**
 * Title: 汉诺塔问题
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-19
 */
public class 汉诺塔问题 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        helper(A.size(), A, B, C);
    }
    /*
        1 通过 2 的帮助移到 3
     */
    private void helper (int sum, List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        if (sum == 0) {
            /*
                运完了，直接结束
             */
            return;
        }
        helper(sum - 1, list1, list3, list2);
        /*
            1 把 sum - 1 个通过 3 移到 2 上
            此时剩下一个了，直接移到 3 上
         */
        int tmp = list1.remove(list1.size() - 1);
        list3.add(tmp);
        /*
            再把剩下的 sum - 1 个从 2 上通过 1 移到 3 上
         */
        helper(sum - 1, list2, list1, list3);

    }
}
