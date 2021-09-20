package codetop;

/**
 * Title: 跳跃游戏
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-15
 */
public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        int max = 0;
        /*
            能到达的最大距离的下标
         */
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                /*
                    当前遍历的数的下标超过前面跳跃能到达的最大距离的下标，表示无法到达

                 */
                return false;
            }
            max = Math.max(nums[i] + i, max);
            /*
                计算从左到右能到达的最大距离下标
             */
        }
        return true;
        /*
            能够全部遍历表示可以全部到达
         */
    }

    public static void main(String[] args) {
        跳跃游戏 res = new 跳跃游戏();
//        System.out.println(res.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(res.canJump(new int[]{3,2,1,0,4}));
    }
}
