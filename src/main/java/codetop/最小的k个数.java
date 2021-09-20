package codetop;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Title: 最小的k个数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-30
 */
public class 最小的k个数 {
    public int[] getLeastNumbers0(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2)->i2 - i1);
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        int inx = 0;
        for (int i : queue) {
            res[inx++] = i;
        }
        return res;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (null == arr || arr.length == 0 || k == 0) {
            return new int[0];
        }
        if (arr.length == k) {
            return arr;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = partion(arr, low, high);
            if (mid < k - 1) {
                low = mid + 1;
            } else if (mid > k - 1) {
                high = mid - 1;
            } else {
                break;
            }
        }
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    private int partion (int[] arr, int start, int end) {
        if (start == end) {
            return start;
        }
        int pivot = arr[start];
        int left = start;
        int right = end + 1;
        while (true) {
            while (arr[++left] < pivot) {
                /*
                    从左到右寻找第一个比pivot小的
                 */
                if (left == end) {
                    /*
                        此时说明 [start, end] 区间 pivot 最大
                     */
                    break;
                }
            }
            while (arr[--right] > pivot) {
                /*
                    从右到左寻找第一个比 pivot 小的
                 */
                if (right == start) {
                    /*
                        如果成立说明 [start, end] 区间 pivot 最小
                     */
                    break;
                }
            }
            if (left >= right) {
                /*
                    当上面两种情况之一出现直接停止循环；
                    或者当两个指针相遇甚至超过时停止循环
                 */
                break;
            }
            /*
                在上面的条件不成立时说明此时从左到右找到一个大于 pivot 和从右到左小于 pivot 的数
                直接交换这两个的位置
             */
            swap(arr, left, right);
        }
        /*
            交换 pivot 和 right 位置上的数
            right的取值可能是等于 left，可能小于 left，所以 arr[right] 是小于等于 pivot 之间的数
            交换后，right 位置上的数是分割点，左边 <= right上的数  <= 右边
            所以直接返回right
         */
        swap(arr, start, right);
        return right;
    }

    private void shuffle (int[] arr) {
        /*
            随机洗牌，达到随机需要 arr.length 的阶乘
            假设 len == arr.length = 5
            第一次循环，
            i = 0, j = [0,7)
            1   [0,6)
            2   [0,5)
            依次类推
         */
        int len = arr.length;
        int j;
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            j = i + random.nextInt(len - i);
            swap(arr, i, j);
        }
    }

    private void swap (int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    
}
