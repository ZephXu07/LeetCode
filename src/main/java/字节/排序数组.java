package 字节;

import java.util.Arrays;

/**
 * Title: 排序数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-20
 */
public class 排序数组 {
//    public int[] sortArray(int[] nums) {
//        return buildHeap(nums);
//    }
//
//    private int[] buildHeap(int[] heap) {
//        /*i从最后一个非叶子节点的索引开始，递减构建，直到i=-1结束循环
//        这里元素的索引是从0开始的，所以最后一个非叶子节点array.length/2 - 1，这是利用了完全二叉树的性质*/
//        for (int i = heap.length / 2 - 1; i >= 0; i--) {
//            buildHeap(heap, i, heap.length);
//        }
//        return heapSort(heap);
//    }
//
//    /**
//     * 同通过一批数初始化大顶堆
//     *
//     * @param arr    数据数组
//     * @param i      非叶子节点的索引
//     * @param length 堆长度
//     */
//    private void buildHeap(int[] arr, int i, int length) {
//        //先把当前非叶子节点元素取出来，因为当前元素可能要一直移动
//        int temp;
//        //节点的子节点的索引
//        int childIndex;
//        /*循环判断父节点是否大于两个子节点,如果左子节点索引大于等于堆长度 或者父节点大于两个子节点 则结束循环*/
//        for (temp = arr[i]; (childIndex = 2 * i + 1) < length; i = childIndex) {
//            //childIndex + 1 < length 说明该节点具有右子节点,并且如果如果右子节点的值大于左子节点，那么childIndex自增1，即childIndex指向右子节点索引
//            if (childIndex + 1 < length && arr[childIndex] < arr[childIndex + 1]) {
//                childIndex++;
//            }
//            //如果发现最大子节点(左、右子节点)大于根节点，为了满足大顶堆根节点的值大于子节点，需要进行值的交换
//            //如果子节点更换了，那么，以子节点为根的子树会受到影响,所以，交换之后继续循环对子节点所在的树进行判断
//            if (arr[childIndex] >  temp) {
//                swap(arr, i, childIndex);
//            } else {
//                //走到这里,说明父节点大于最大的子节点，满足大顶堆的条件，直接终止循环
//                break;
//            }
//        }
//    }
//
//    /**
//     * 大顶堆排序(顺序)
//     * 实际上就是不断循环将堆顶元素与堆尾元素互换,然后移除堆尾元素,之后重构大顶堆的过程
//     */
//    public int[] heapSort(int[] arr) {
//        //使用大顶堆的副本进行排序输出
//        /*开始堆排序，i = arr.length - 1，即从大顶堆尾部的数开始，直到i=0结束循环*/
//        for (int i = arr.length - 1; i > 0; i--) {
//            //交换堆顶与堆尾元素顺序
//            swap(arr, 0, i);
//            //重新构建大顶堆
//            buildHeap(arr, 0, i);
//        }
//        return arr;
//    }
//
//    /**
//     * 交换元素
//     *  @param arr 数组
//     * @param a   元素的下标
//     * @param b   元素的下标
//     */
//    private static void swap(int[] arr, int a, int b) {
//        int temp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
//    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int low, int high) {
        if (high - low <= 7) {
            insertSort(nums, low, high);
            return;
        }
        int mid = partition(nums, low, high);
        sort(nums, low, mid - 1);
        sort(nums, mid + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int mid = low + (high - low) >> 1;
        if (nums[low] > nums[high]) {
            swap(nums, low, high);
        }
        if (nums[mid] > nums[high]) {
            swap(nums, mid, high);
        }
        if (nums[low] < nums[mid]) {
            swap(nums, low, mid);
        }
        int pivot = nums[low];
        int inx = low;
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high --;
            }
            while (low < high && nums[low] <= pivot)  {
                low++;
            }
            if (low >= high) {
                break;
            }
            swap(nums, low, high);
        }
        swap(nums, inx, low);
        nums[low] = pivot;
        return low;
    }

    private void insertSort(int[] nums, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int tmp = nums[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] > tmp) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = tmp;
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
