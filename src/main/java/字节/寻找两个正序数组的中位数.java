package 字节;

/**
 * Title: 寻找两个正序数组的中位数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-29
 */
public class 寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                //当nums1未遍历完时，nums2遍历完或者nums1[aStart] < nums2[bStart]，则是用num1[]的元素填充
                right = nums1[aStart++];
            } else {
                //同理，nums1遍历完或者nums1[aStart] >= nums2[bStart]，则是用num2[]的元素填充
                //由于是中位数，不可能出现nums1和nums2同时结束的情况
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0) {
            //为偶数，取中间
            return (left + right) / 2.0;
        } else {
            //奇数则刚好
            return right;
        }
    }
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) +
                getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }



    public static void main(String[] args) {
        寻找两个正序数组的中位数 res = new 寻找两个正序数组的中位数();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(res.findMedianSortedArrays(nums1, nums2));
    }
}
