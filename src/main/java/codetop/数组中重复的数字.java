package codetop;

/**
 * Title: 数组中重复的数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-21
 */
public class 数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        int temp;
        for(int i = 0; i < nums.length; i++){
            /*
                把值放回和下标一致的地方，循环直到这几个数字归位，
                然后在进行下一个位置试，最多情况下除了最后的数其他都是正常的
                直到有一个重复的位置
             */
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
        数组中重复的数字 res = new 数组中重复的数字();
        System.out.println(res.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
