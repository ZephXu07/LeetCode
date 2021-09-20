package 每日一题;

import java.util.PriorityQueue;

/**
 * Title: 数据流的中位数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-27
 */
public class 数据流的中位数 {
}
class MedianFinder {
    private PriorityQueue<Integer> small;
    /*
        小根堆，正放，最顶是最小的，放在下面
     */

    private PriorityQueue<Integer> big;
    /*
        大根堆，倒放，最顶是最大的，放在上面
     */

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>();
        big = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (small.size() >= big.size()) {
            /*
                说明下面的数量大于等于上面的
                先加入下面，再弹出处理后的最小的
                上面的再接收他，再处理
                还是形成两个三角形
                ****   小       大根堆      小
                 **
                 *     大
                 *     小
                **
               ****     大       小根堆      大
             */
            small.offer(num);
            big.offer(small.poll());
        } else {
            /*
                说明上面的数量小于下面的
                先加入上面，再弹出处理后的最大的
                下面的再接收他，再处理
                还是形成两个三角形
             */
            big.offer(num);
            small.offer(big.poll());
        }
    }

    public double findMedian() {
        if (small.size() > big.size()) {
            return small.peek();
        } else if (small.size() < big.size()) {
            return big.peek();
        } else {
            return (small.peek() + big.peek() ) / 2.0;
        }
    }
}
