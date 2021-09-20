package 堆排序;

import java.util.Arrays;

/**
 * Title: Test
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-20
 */
public class Test {
    public static void main(String[] args) {
        MaxBinaryHeap<Integer> maxHeap = new MaxBinaryHeap<>();
        maxHeap.add(1);
        System.out.println(Arrays.toString(maxHeap.heapSort()));
        maxHeap.add(26);
        System.out.println(Arrays.toString(maxHeap.heapSort()));
        maxHeap.add(44);
        System.out.println(Arrays.toString(maxHeap.heapSort()));
    }
}
