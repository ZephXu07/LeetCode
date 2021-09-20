package codetop;

/**
 * Title: 有序数组中的单一元素
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-01
 */
public class 有序数组中的单一元素 {
    public int singleNonDuplicate(int[] nums) {
//        int res = 0;
//        for (int n : nums) {
//            res ^= n;
//        }
//        return res;

        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            boolean rightEven = ((right - mid) & 1) == 0;
            /*
                rightEven 右端数字数目是不是个数

                [left,right] 始终是奇数，所以 mid - 1 和 mid + 1 都不会溢出
             */
            if (nums[mid - 1] == nums[mid]) {
                if (rightEven) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
                /*
                    0 1 2 3 4 5 6 7 8
                    1 1 4 5 5 6 6 8 8
                    右边界是偶数，nums[mid - 1] == nums[mid]
                    调整到   搜索    right = mid - 2;
                    0 1 2
                    1 1 4   最后 left = right = 2 nums[2] = 4

                    0 1 2 3 4 5 6 7 8 9 10
                    1 1 4 4 5 5 6 6 8 9 9
                    右边界是奇数，nums[mid - 1] == nums[mid]
                    调整到     搜索      left = mid + 1;
                    6 7 8 9 10
                    6 6 8 9 9   最后 nums[mid - 1] != nums[mid], nums[mid + 1] != nums[mid]直接返回
                 */
            } else if (nums[mid + 1] == nums[mid]) {
                if (rightEven) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
                /*
                    0 1 2 3 4 5 6 7 8
                    1 1 4 4 5 5 6 8 8
                    右边界是偶数，nums[mid + 1] == nums[mid]
                    调整到 6 8 8  left = mid + 2;  最后 right = left = 0 nums[0] = 6

                    0 1 2 3 4 5 6 7 8 9 10
                    1 1 4 5 5 6 6 8 8 9 9
                    右边界是奇数，nums[mid + 1] == nums[mid]
                    调整到 1 1 4 5 5 right = mid - 1;  最后 nums[mid - 1] != nums[mid] ,nums[mid + 1] != nums[mid]直接返回
                 */
            } else {
                return nums[mid];
                /*
                    1 1 2 3 3
                    直接返回 2
                 */
            }
        }
        return nums[left];

    }

    public static void main(String[] args) {
        有序数组中的单一元素 res = new 有序数组中的单一元素();
        System.out.println(res.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}
