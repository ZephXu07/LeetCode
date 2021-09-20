package 字节;

/**
 * Title: 删除排序数组中的重复项二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-27
 */
public class 删除排序数组中的重复项二 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 1;
        int count = 0;
        while (right < len) {
            if (nums[right] == nums[left]) {
                count++;
                //如果相邻的两个数相等，计数器+1
            } else {
                count = 0;
                // 如果不相等复位为0
            }
            if (count < 2) {
                //如果计数器小于2，则保留，当前符合条件的数组的长度
                nums[++left] = nums[right];
            }
            right++;
        }
        return left + 1;
        //nums[0...slow]就是符合条件的数，nums[slow + 1...fast]保存的就是多余的数
    }
}
