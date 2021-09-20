package 剑指offer;

/**
 * Title: 旋转数组的最小数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-29
 */
public class 旋转数组的最小数字 {
    public int minArray1(int[] numbers) {
        int tmp = numbers[0];
        for(int i = 0; i < numbers.length; i++) {
            if (tmp > numbers[i]) {
                return numbers[i];
            }
            tmp = numbers[i];
        }
        return numbers[0];
    }

    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]){
                low = mid + 1;
            } else {
                high --;
            }
        }
        return numbers[mid];
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 3};
        旋转数组的最小数字 res = new 旋转数组的最小数字();
        System.out.println(res.minArray(nums));
        System.out.println(res.minArray1(nums));
    }
}
