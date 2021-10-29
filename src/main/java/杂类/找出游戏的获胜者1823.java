package 杂类;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 找出游戏的获胜者1823
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-29
 */
public class 找出游戏的获胜者1823 {
    public int findTheWinner(int n, int k) {
//        Deque<Integer> deque = new LinkedList<>();
//        for (int i = 1; i <= n; i++) {
//            deque.offerFirst(i);
//            /*
//                初始化参赛者
//             */
//        }
//        while (deque.size() > 1) {
//            /*
//                只要还有超过一个以上参赛者，那就继续赛
//             */
//            int x = ((k - 1) % deque.size()) + 1;
//            /*
//                取模，看每次数几个，轮到哪个幸运儿。
//             */
//            while (x > 0) {
//                int lukier = deque.pollLast();
//                if (--x > 0) {
//                    deque.offerFirst(lukier);
//                }
//                /*
//                    不是刚好撞***口的幸运儿就继续装到队列的尾巴上参与下一次。
//
//                 */
//            }
//        }
//        return deque.poll();
//        /*
//            n-1轮下来后只剩最后一个欧皇。
//         */

        int res = 0;
        /*
            最后一轮剩下2个人，所以从2开始反推
         */
        for (int i = 2; i <= n; i++) {
            res = (res + k) % i;
        }
        return res;
    }
}
