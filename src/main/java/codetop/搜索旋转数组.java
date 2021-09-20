package codetop;

/**
 * Title: 搜索旋转数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-18
 */
public class 搜索旋转数组 {
    public int search(int[] arr, int target) {
        if (null == arr) {
            return -1;
        }
        int len = arr.length;
        if (len == 1) {
            return arr[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[left] < arr[mid]) {
                if (arr[left] <= target && target <= arr[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            } else if (arr[left] > arr[mid]) {
                if (arr[left] <= target || target <= arr[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            } else if (arr[left] == arr[mid]) {
                if (arr[left] != target) {
                    left++;
                } else {
                    return left;
                }
            }

        }

        return arr[left] == target ? left : -1;

    }


    public static void main(String[] args) {
        搜索旋转数组 res = new 搜索旋转数组();
        System.out.println(res.search(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
    }
}
