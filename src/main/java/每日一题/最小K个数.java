package 每日一题;

/**
 * Title: 最小K个数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-03
 */
public class 最小K个数 {
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        KthSmallest kthSmallest = new KthSmallest(k, arr);
        return kthSmallest.getHeap();
    }
}
class KthSmallest {
    /*
        堆排序解法 - 维护一个大小为k的大根堆,
         若当前要插入的数大于等于堆顶元素, 则丢弃;
         否则插入, 可以直接插入到堆顶, 在进行调整.
         堆顶元素保存了第k小元素.
     */
    // 创建一个大根堆
    int[] heap;
    int size = 0;
    int count = 0;
    public KthSmallest(int k, int[] nums) {
        heap = new int[k];
        count = k;

        // 初始化一个大小为k的大根堆
        for (int num : nums) {
            add(num);
            /*
                add 会判断大小是否超过
             */
        }

    }

    public int add(int val) {
        /*
            还没满，直接放末尾
         */
        if (size < count) {
            heap[size] = val;
            up(size);
            /*
                自下向上调整
             */
            size++;
        } else if (heap[0] > val) {
            /*
                新加元素小于堆顶第 k 大元素才需要换新值
                直接放堆顶
                再进行自上向下调整
             */
            heap[0] = val;
            down(0);
        }

        return heap[0];
        /*
            返回堆顶的最大元素
         */
    }

    /*
        自上向下调整堆
     */
    public void down (int u) {
        int t = u;
        int left = 2 * u + 1;
        if (left < size && heap[left] > heap[t]) {
            t = left;
        }
        int right = 2 * u + 2;
        if (right < size && heap[right] > heap[t]) {
            t = right;
        }
        /*
            找到其左、右节点最小
         */
        if (t != u) {
            swap(u, t);
            /*
                交换子、父节点
             */
            down (t);
            /*
                再对子节点进行向下的调整
             */
        }
    }

    /*
        自下向上调整堆
     */
    public void up (int u) {
        /*
         存在父亲节点, 并且父亲节点的值小于当前值, 则进行交换
         */
        while ((u - 1) / 2 >= 0 && heap[(u - 1) / 2 ] < heap[u]) {
            /*
                u 在变化
             */
            int p = (u - 1) / 2;
            swap(u, p);
            u = p;
            /*
                父、子节点交换，向上继续
             */
        }
    }

    public int[] getHeap() {
        return heap;
    }

    private void swap (int t, int u) {
        int temp = heap[u];
        heap[u] = heap[t];
        heap[t] = temp;
    }
}
