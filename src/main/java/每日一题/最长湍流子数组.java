package 每日一题;

/**
 * Title: 最长湍流子数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-08
 */
public class 最长湍流子数组 {
    public int maxTurbulenceSize(int[] arr) {
        if (null == arr) {
            return 0;
        }
        int len = arr.length;
        if (1 == len) {
            return 1;
        }
        int left = 0;
        int right = 0;
        int res = 1;
        while (right < len - 1) {
            if (left == right) {
                right++;
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
            } else {
                if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        最长湍流子数组 res = new 最长湍流子数组();
        int[] arr = {100,100,100};
        System.out.println(res.maxTurbulenceSize(arr));
    }
}
