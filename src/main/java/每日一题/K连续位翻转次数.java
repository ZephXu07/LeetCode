package 每日一题;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: K连续位翻转次数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-18
 */
public class K连续位翻转次数 {
    public int minKBitFlips(int[] A, int K) {
        int res = 0;
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            //que.peek()的下标开始的K个数已经翻转了，弹出去，进行下一个翻转
            if (que.size() > 0 && i > que.peek() + K - 1) {
                que.removeFirst();
            }

            //单数次翻转==1次翻转
            //双数次翻转==2次翻转

            //队列中数量为1表示将要翻转1次，此时若值为0，表示将要翻转1次为1，不需要再加入翻转队列
            //队列中数量为1表示将要翻转1次，此时若值为1，表示将要翻转1次为0，需要再加入翻转队列

            //队列中数量为2表示将要翻转2次，此时若值为0，表示将要翻转2次为0，需要再加入翻转队列
            //队列中数量为2表示将要翻转2次，此时若值为1，表示将要翻转2次为1，不需要再加入翻转队列
            if (que.size() % 2 == A[i]) {
                if (i + K > A.length) {
                    return -1;
                    //当 i + K > N 时，说明需要翻转大小为 K 的子区间，但是后面剩余的元素不到 K 个了，所以返回 -1。
                }
                que.add(i);
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,1,0};
        int K = 2;
        K连续位翻转次数 res = new K连续位翻转次数();
        System.out.println(res.minKBitFlips(A, K));
    }
}
