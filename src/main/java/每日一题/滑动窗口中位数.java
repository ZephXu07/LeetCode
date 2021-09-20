package 每日一题;

import java.util.*;

/**
 * Title: 滑动窗口中位数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-03
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

    public static void main(String[] args) {


        滑动窗口中位数 window = new 滑动窗口中位数();
        int[] nums = {2147483647,2147483647};
        int k = 2;
        System.out.println(Arrays.toString(window.medianSlidingWindow(nums, k)));
    }

    private class Window {
        private PriorityQueue<Integer> small;
        private PriorityQueue<Integer> large;
        private Map<Integer, Integer> delete;
        private int size;
        private int smallSize;
        private int largeSize;

        public Window (int size) {
            this.size = size;
            small = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer num1, Integer num2) {
                    return num2.compareTo(num1);
                }
            });
            large = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer num1, Integer num2) {
                    return num1.compareTo(num2);
                }
            });
            smallSize = 0;
            largeSize = 0;
            delete = new HashMap<>();
        }

        private void insert(int val) {
            if (small.isEmpty() || val <= small.peek()) {
                small.offer(val);
                smallSize++;
            } else {
                large.offer(val);
                largeSize++;
            }
            balance();
        }

        private void delete(int val) {
            delete.put(val, delete.getOrDefault(val, 0) + 1);
            if (val <= small.peek()) {
                smallSize--;
                if (val == small.peek()) {
                    update(small);
                }
            } else {
                largeSize--;
                if (val == large.peek()) {
                    update(large);
                }
            }
            balance();
        }

        private void update(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty()) {
                int tmp = heap.peek();
                if (delete.containsKey(tmp)) {
//                    int count = delete.get(tmp) - 1;
//                    if (count == 0) {
//                        delete.remove(tmp);
//                    } else {
//                        delete.put(tmp, count);
//                    }
                    delete.put(tmp, delete.get(tmp) - 1);
                    if (delete.get(tmp) == 0) {
                        delete.remove(tmp);
                    }
                    heap.poll();
                } else {
                    break;
                }
            }
        }

        private void balance() {
            if (smallSize > largeSize + 1) {
                large.offer(small.poll());
                smallSize--;
                largeSize++;
                update(small);
            } else if (smallSize < largeSize) {
                small.offer(large.poll());
                smallSize++;
                largeSize--;
                update(large);
            }
        }

        private double getMedian() {
            return (size & 1) == 1 ? small.peek() : ( ((double)small.peek() + (double)large.peek()) / 2);
        }

    }
}
