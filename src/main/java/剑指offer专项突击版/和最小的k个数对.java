package 剑指offer专项突击版;

import java.util.*;

/**
 * Title: 和最小的k个数对
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-09
 */
public class 和最小的k个数对 {
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        /*
//            大顶堆，比较器使用lambda表达式，更简洁
//         */
//        PriorityQueue<List<Integer>> queue =
//                new PriorityQueue<>(k, (o1, o2)-> (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1)));
//
//        /*
//            遍历所有可能的集合
//            A、B 长度与 k 比较是因为
//            极端情况下可能是 A[0] 然后取 B[0,k-1]
//            或者 A[0,k-1] B[0]
//         */
//        for(int i = 0; i < Math.min(nums1.length, k); i++){
//            for(int j = 0; j < Math.min(nums2.length, k); j++){
//                /*
//                    剪枝，如果当前的两个数之和超过了堆顶元素，
//                    由于数组已经升序，后面的元素只会更大，因此无需继续遍历
//                 */
//                if(queue.size() == k && nums1[i] + nums2[j] > queue.peek().get(0) + queue.peek().get(1)){
//                    break;
//                }
//
//                /*
//                    若比堆顶小，则弹出堆顶元素，把当前数对加入
//                 */
//                if(queue.size() == k){
//                    queue.poll();
//                }
//                List<Integer> pair = new ArrayList<>();
//                pair.add(nums1[i]);
//                pair.add(nums2[j]);
//                queue.add(pair);
//            }
//        }
//
//        /*
//            最后将元素弹出，倒序插入数组即可
//         */
//        List<List<Integer>> res = new LinkedList<>();
//        for(int i =0; i < k && !queue.isEmpty(); i++){
//            res.add(0, queue.poll());
//        }
//        return res;
//    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        /*
            小顶堆
            类似合并 k 个有序链表
            先存入 A[0]...A[len-1] 与 B[0]
            一定是 A[0]B[0]更小，继而合理范围内存入 A[0]B[1]与其他的 A[1]B[0]对比
            假如 A[1]B[0]更小，存入 A[1]B[1] ，再进行新的对比
         */
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt(o -> (nums1[o[0]] + nums2[o[1]])));
        List<List<Integer>> res = new LinkedList<>();


        /*
            将假想的每个数组的第一项加入小顶堆
         */
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            queue.add(new int[] { i, 0 });
            /*
                加入的是坐标，小顶堆的比较器也是基于坐标比较
             */
        }

        /*
            循环K次或者堆空
         */
        while (k > 0 && !queue.isEmpty()) {
            /*
                弹出堆顶元素
             */
            int[] pair = queue.poll();
            List<Integer> item = new ArrayList<>();
            item.add(nums1[pair[0]]);
            item.add(nums2[pair[1]]);

            /*
                若我们假想的数组有下一个元素，则加入小顶堆
             */
            if (pair[1] < nums2.length - 1) {
                queue.add(new int[] { pair[0], pair[1] + 1 });
            }
            res.add(item);
            k--;
        }
        return res;
    }
}
