package 剑指offer;

/**
 * Title: 数组中重复的数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-28
 */
public class 数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        int temp;
        for(int i = 0; i < nums.length; i++){
            while (nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        数组中重复的数字 数组中重复的数字 = new 数组中重复的数字();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(数组中重复的数字.findRepeatNumber(nums));
    }
}
