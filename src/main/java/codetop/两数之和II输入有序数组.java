package codetop;

/**
 * Title: 两数之和II输入有序数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-19
 */
public class 两数之和II输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
            } else if (sum > target){
                right--;
                while (right > left && numbers[right] == numbers[right + 1]) {
                    right--;
                }

            } else {
                return new int[] {left + 1, right + 1};
            }
        }
        return new int[] {left + 1, right + 1};
    }
}
