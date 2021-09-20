package codetop;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Title: 两个数组的交集
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-03
 */
public class 两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> n1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i : nums1) {
            n1.add(i);
        }
        for (int i : nums2) {
            if (n1.contains(i)) {
                res.add(i);
            }
        }

        int[] ans = new int[res.size()];
        int inx = 0;
        for (int i : res) {
            ans[inx] = i;
            inx++;
        }

        return ans;
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int num : set) {
            res[index++] = num;
        }
        return res;
    }

}
