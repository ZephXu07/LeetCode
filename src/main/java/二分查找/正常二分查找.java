package 二分查找;

/**
 * Title: 正常二分查找
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-04
 */
public class 正常二分查找 {
    public int binarySearch (int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        正常二分查找 res = new 正常二分查找();
        System.out.println(res.binarySearch(new int[]{1, 2, 3, 4, 5}, 2));


    }
}
