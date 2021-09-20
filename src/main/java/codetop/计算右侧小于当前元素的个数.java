package codetop;

import labuladong.Solution;

import java.util.*;

/**
 * Title: 计算右侧小于当前元素的个数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-29
 */
public class 计算右侧小于当前元素的个数 {
//    public List<Integer> countSmaller(int[] nums) {
//        int len = nums.length;
//        if (len < 1) {
//            return new ArrayList<>();
//        }
//        int[] counts = new int[len];
//        int[] N = simply(nums);
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 1; i <= N.length; i++) {
//            map.put(N[i - 1], i);
//        }
//        int[] C = new int[N.length + 1];
//
//        int i = 0;
//        for (int j = nums.length - 1; j >= 0; j--) {
//            i = map.get(nums[j]);
//            update(i, C);
//            if (i != 1) {
//                query(i - 1, j, C, counts);
//            } else {
//                counts[j] = 0;
//            }
//        }
//        List<Integer> res = new ArrayList<>(len);
//        for (int c : counts) {
//            res.add(c);
//        }
//        return res;
//    }
//
//    private int[] simply (int[] nums) {
//        int[] copy = new int[nums.length];
//        System.arraycopy(nums, 0, copy, 0, nums.length);
//        Arrays.sort(copy);
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < copy.length; i++) {
//            list.add(copy[i]);
//            while (i + 1 < copy.length && copy[i + 1] == copy[i]) {
//                i++;
//            }
//        }
//        int[] res = new int[list.size()];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = list.get(i);
//        }
//        return res;
//
//    }
//
//    private int lowBit (int x) {
//        return x & (-x);
//    }
//
//    private void update (int inx, int[] C) {
//        while (inx < C.length) {
//            C[inx]++;
//            inx += lowBit(inx);
//        }
//    }
//
//    public void query (int i, int j, int[] C, int[] counts) {
//        while (i >= 1) {
//            counts[j] += C[i];
//            i -= lowBit(i);
//        }
//    }


    public List<Integer> countSmaller(int[] nums) {
       int len = nums.length;
       List<Integer> res = new ArrayList<>();
       if (len == 0) {
           return res;
       }
       int[] tmp = new int[len];
       /*
            暂时存储 nums 元素的在新的排序数组的下标
        */
       int[] index = new int[len];
       /*
            存储 nums 元素的在新的排序数组的下标
            假设 b 为新数组的 a 元素的下标
            index[i] 则为 a 元素的在 nums 数组的下标
            nums[index[i]] = a ，即找到 a 元素的值
        */
       int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            index[i] = i;
        }

        merge(nums, 0, len - 1, index, tmp, ans);

        for (int i = 0; i < len; i++) {
            res.add(ans[i]);
        }


        return res;

    }

    private void merge (int[] nums, int left ,int right, int[] index, int[] tmp, int[] ans) {
        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        merge(nums, left, mid, index, tmp, ans);
        merge(nums, mid + 1, right, index, tmp, ans);
        if (nums[index[mid]] <= nums[index[mid + 1]]) {
            /*
                得到新的排序数组 [left, mid] [mid+1,right]两段
                此时两段分别有序
                nums[index[mid]] 是新排序左数组的右边界
                nums[index[mid + 1] 是新排序右数组的左边界
                此时大小正确即说明已经完全有序，在某个值其右边找不到比它小的数
             */
            return;
        }
        count(nums, left, mid, right, index, tmp, ans);
        /*
            整合虚拟的排序数组，并且计算
            不会有多余比较，在两个数组内部已经比较玩计数了
            现在是左右数组的比较
            在这一步之前两边数组内部已经是有序了
         */
    }

    private void count (int[] nums, int left, int mid, int right, int[] index, int[] tmp, int[] ans) {
        for (int i = left; i <= right; i++) {
            tmp[i] = index[i];
            /*
                得到一个暂时的排序数组的值在 nums 数组的下标
             */
        }

        int i = left;
        /*
            左数组的左边界
         */
        int j = mid + 1;
        /*
            右数组的左边界
         */
        for (int k = left; k <= right; k++) {
            /*
                整合两段数组
             */
            if (i > mid) {
                /*
                    左边数组遍历完了
                 */
                index[k] = tmp[j];
                /*
                    把虚拟数组的值其下标赋值回去
                 */
                j++;
            } else if (j > right) {
                /*
                    右边数组遍历完，同理把虚拟数组的值下标赋值回去
                    此时右边数组遍历完，说明 [mid + 1, right] 的值都小于 左数组下标 k 代表的在 nums 中的元素
                    index[k] 虚拟数组的值在 nums 中的下标
                    即统计 此值右边小于它的数

                 */
                index[k] = tmp[i];
                i++;
                ans[index[k]] += (right - mid);
            } else if (nums[tmp[i]] <= nums[tmp[j]]) {
                /*
                    注意：这里是 <= ，保证稳定性
                    左边数组 tmp[i] 代表的值 小于等于 tmp[j] 的值
                    说明右边数组 [mid+1,j) 的值均小于 tmp[i] 代表的值
                    所以 tmp[i] 代表的值要添加统计
                 */
                index[k] = tmp[i];
                i++;
                ans[index[k]] += (j - mid - 1);
            } else {
                index[k] = tmp[j];
                /*
                    左边数组 tmp[i] 代表的值 大于 tmp[j] 的值
                    回填 右数组的值，此时不急于计算，在上述步骤中直接计算一段的值
                 */
                j++;
            }
        }
    }



    public static void main(String[] args) {
        计算右侧小于当前元素的个数 res = new 计算右侧小于当前元素的个数();
//        System.out.println(res.countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(res.countSmaller(new int[]{1,6, 2, 5}));
    }
}
