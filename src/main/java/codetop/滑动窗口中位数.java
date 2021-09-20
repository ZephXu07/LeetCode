package codetop;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Title: 滑动窗口中位数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-02
 */
public class 滑动窗口中位数 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Window window = new Window(k);
        for (int i = 0; i < k; i++) {
            window.insert(nums[i]);
        }
        double[] res = new double[nums.length - k + 1];
        res[0] = window.getMedian();
        for (int i = k; i < nums.length; i++) {
            window.insert(nums[i]);
            window.delete(nums[i - k]);
            res[i - k + 1] = window.getMedian();
        }
        return res;
    }



    private class Window {
        private PriorityQueue<Integer> small;
        /*
            大根堆，[left,mid] 递增，需要时弹出的 poll 是最大的，mid
         */
        private PriorityQueue<Integer> large;
        /*
            小根堆，[mid + 1， right] 递增，需要时弹出的 poll 是最小的,mid + 1
         */
        private Map<Integer, Integer> delete;
        /*
            延迟删除
         */
        private int size;
        /*
            窗口长度
         */
        private int smallSize;
        /*
            前面部分长度
         */
        private int largeSize;
        /*
            后面部分长度
         */

        public Window (int size) {
            this.size = size;
            small = new PriorityQueue<>(Comparator.reverseOrder());
            large = new PriorityQueue<>(Integer::compareTo);
            smallSize = 0;
            largeSize = 0;
            delete = new HashMap<>();
            /*
                初始化
             */
        }

        private void insert(int val) {
            if (small.isEmpty() || val <= small.peek()) {
                /*
                    如果前面部分为空
                    或者新加的值小于 mid，则添加进前面，前面长度增加
                 */
                small.offer(val);
                smallSize++;
            } else {
                large.offer(val);
                largeSize++;
                /*
                    其他情况后面
                    长度增加
                 */
            }
            balance();
            /*
                平衡两个堆的数量，方便找中位数
             */
        }

        private void delete(int val) {
            delete.put(val, delete.getOrDefault(val, 0) + 1);
            /*
                每删除一个，就在哈希表记录删除的次数
             */
            if (val <= small.peek()) {
                /*
                    值小于等于 mid，说明在 [left, mid]
                 */
                smallSize--;
                /*
                    长度减小
                 */
                if (val == small.peek()) {
                    /*
                        当要删除的值在堆顶才真正删除
                     */
                    update(small);
                    /*
                        删除堆顶
                     */
                }
            } else {
                largeSize--;
                if (val == large.peek()) {
                    update(large);
                }
                /*
                    同理
                 */
            }
            balance();
            /*
                平衡两个堆的数量，方便找中位数
             */
        }

        private void update(PriorityQueue<Integer> heap) {
            /*
                删除堆顶元素
             */
            while (!heap.isEmpty()) {
                int tmp = heap.peek();
                if (delete.containsKey(tmp)) {
                    /*
                        堆顶元素是延迟删除元素，立即删除
                        同时延迟删除哈希表更新
                     */
                    int count = delete.get(tmp) - 1;
                    if (count == 0) {
                        delete.remove(tmp);
                    } else {
                        delete.put(tmp, count);
                    }

                    heap.poll();
                } else {
                    break;
                }
            }
        }

        private void balance() {
            if (smallSize > largeSize + 1) {
                /*
                    [left,mid] 数目大于 [mid+1,right] 数目 + 1
                    左边需要弹出最大的，右边需要添加，由于我们保证
                    [left,right]递增，所以右边直接添加
                    数目相应变化
                 */
                large.offer(small.poll());
                smallSize--;
                largeSize++;
                update(small);
                /*
                    左边有了新的堆顶，看是否为需要延迟删除的数
                 */
            } else if (smallSize < largeSize) {
                small.offer(large.poll());
                smallSize++;
                largeSize--;
                update(large);
                /*
                    同理
                 */
            }
        }

        private double getMedian() {
            return (size & 1) == 1 ? small.peek() : ( ((double)small.peek() + (double)large.peek()) / 2);
            /*
                返回中位数
             */
        }

    }
}
