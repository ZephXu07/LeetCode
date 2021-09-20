package 剑指offer;

/**
 * Title: 数组中的逆序对
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-04
 */
public class 数组中的逆序对 {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] shadow = new int[len];
        System.arraycopy(nums, 0, shadow, 0, len);
        int[] tmp = new int[len];
        return pairs(shadow, 0, len - 1, tmp);
    }

    private int pairs(int[] shadow, int left, int right, int[] tmp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = pairs(shadow, left, mid, tmp);
        int rightPairs = pairs(shadow, mid + 1, right, tmp);
        if (shadow[mid] < shadow[mid + 1]) {
            return leftPairs + rightPairs;
        }
        int crossPairs = mergeAndCount(shadow, left, mid, right, tmp);
        return crossPairs + leftPairs + rightPairs;
    }

    private int mergeAndCount(int[] shadow, int left, int mid, int right, int[] tmp) {
        if (right + 1 - left >= 0) {
            System.arraycopy(shadow, left, tmp, left, right + 1 - left);
        }
        int l = left;
        int r = mid + 1;
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (l == mid + 1) {
                shadow[i] = tmp[r];
                r ++;
            } else if (r == right + 1) {
                shadow[i] = tmp[l];
                l ++;
            } else if (tmp[l] <= tmp[r]) {
                shadow[i] = tmp[l];
                l++;
            } else {
                shadow[i] = tmp[r];
                r ++;
                res += mid - l + 1;
            }
        }
        return res;
    }


}
