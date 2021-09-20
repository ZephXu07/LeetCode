package codetop;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 拼接最大数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-07
 */
public class 拼接最大数 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;
        int[] res = new int[len];
        for (int i = 0; i <= k; i++) {
            /*
                一个选出 i ，另一个 k - i
             */
            int[] tmp1 = removeKdigits(nums1, Math.min(i, nums1.length));
            int[] tmp2 = removeKdigits(nums2, Math.min(k - i, nums2.length));
            int[] merge = merge(tmp1, tmp2);
            if (i == 0) {
                /*
                    res初始化
                 */
                res = merge;
            } else {
                if (res.length < merge.length) {
                    /*
                        长度大的更大
                     */
                    res = merge;
                } else if (res.length == merge.length && !compare(res, 0, merge, 0)) {
                    /*
                        长度相同时则比较字典序
                     */
                    res = merge;
                }
            }
        }
        return res;
    }

    /*
        在数组中选出 k 个数，使其组成的数字最大
     */
    private int[] removeKdigits(int[] num, int k) {
        /*
            选出 k 个
         */
        Deque<Integer> deque = new LinkedList<>();
        int len = num.length;
        /*
            52a621
            52b621
            如果 a > b，即 52a621 > 52b621
            因为是要更大的数字，于是抛弃 b
            于是使用单调栈，栈底到栈顶单调递增
         */
        int n = len - k;
        for (int digit : num) {
            while (!deque.isEmpty() && n > 0 && deque.peekLast() < digit) {
                /*
                    此处不可以等于
                 */
                deque.pollLast();
                n--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < n; ++i) {
            /*
                移除的数字不够 n 位
                继续从后面移除直到 n
             */
            deque.pollLast();
        }

        int[] res = new int[deque.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = deque.pollFirst();
        }
        return res;
    }


    /*
        合并两个数组，使其组成的数字最大
     */
    private int[] merge (int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] res = new int[len1 + len2];

        int inx1 = 0;
        int inx2 = 0;
        int inx = 0;
        while (inx1 < len1 || inx2 < len2) {
            int n1 = inx1 < len1 ? nums1[inx1] : -1;
            int n2 = inx2 < len2 ? nums2[inx2] : -1;

            if (n1 > n2) {
                res[inx] = n1;
                inx1++;
            } else if (n2 > n1){
                res[inx] = n2;
                inx2++;
            } else {
                /*
                    相同时，就要看当前数字及以后数字组成的字典序的比较
                 */
                if (compare(nums1, inx1, nums2, inx2)) {
                    res[inx] = n1;
                    inx1++;
                } else {
                    res[inx] = n2;
                    inx2++;
                }
            }
            inx++;
        }

        return res;
    }

    /*
        数组当前数字及以后数字组成的字典序的比较
     */
    private boolean compare (int[] nums1, int inx1, int[] nums2, int inx2) {
        int diff;
        while (inx1 < nums1.length && inx2 < nums2.length) {
            diff = nums1[inx1] - nums2[inx2];
            if (diff != 0) {
                return diff >= 0;
            }
            inx1++;
            inx2++;
        }
        return nums1.length - inx1 >= nums2.length - inx2;
    }


    public static void main(String[] args) {
        拼接最大数 res = new 拼接最大数();
        System.out.println(Arrays.toString(res.maxNumber(new int[]{3, 4, 6, 5},
                new int[]{9, 1, 2, 5, 8, 3}, 5)) + "\t[9, 8, 6, 5, 3]");
        System.out.println(Arrays.toString(res.maxNumber(new int[]{6, 7},
                new int[]{6,0,4}, 5)) + "\t[6, 7, 6, 0, 4]");
        System.out.println(Arrays.toString(res.maxNumber(new int[]{3, 9},
                new int[]{8, 9}, 3)) + "\t[9, 8, 9]");


        System.out.println(Arrays.toString(res.maxNumber(new int[]{2,5,6,4,4,0},
                new int[]{7,3,8,0,6,5,7,6,2}, 15)) + "\t[7,3,8,2,5,6,4,4,0,6,5,7,6,2,0]");

        System.out.println(Arrays.toString(res.maxNumber(new int[]{5,5,1},
                new int[]{4,0,1}, 3)) + "\t[5,5,4]");


    }
}
