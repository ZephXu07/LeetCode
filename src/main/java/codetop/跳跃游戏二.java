package codetop;

/**
 * Title: 跳跃游戏二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-29
 */
public class 跳跃游戏二 {
    public int jump(int[] nums) {
        int len = nums.length;
        /*
            数组长度
         */
        int max = 0;
        /*
            每一次跳跃的最大下标
         */
        int end = 0;
        /*
            当前跳的最大范围
         */
        int res = 0;
        /*
            计数
         */
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max, nums[i] + i);
            /*
                计算每一跳的最大下标
                nums[i]为在此下标上跳跃的长度
                i 为下标
                之和是在此地方能跳到的最远
             */
            if (i == end) {
                /*
                    尝试在每个地方跳
                    而此时在这一跳的范围里，这里是边界了
                    需要真正把这一跳跳出去
                    跳到哪里我们不知道，我们只知道一个大概的最大范围
                    是这一跳的最远地方，因为题目求的是最少跳数
                    使用的是贪心
                    当 i 到 len - 1就可以结束了
                    因为题目说一定能跳到，所以我们在 len - 1之前能跳到
                    所以 end 大于等于 len - 1，即 i 小于 len - 1 可以停了
                    所以我们在 len - 1 之前就可以停了，把这一跳加上就够了
                 */
                end = max;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        跳跃游戏二 res = new 跳跃游戏二();
        System.out.println(res.jump(new int[]{2, 3, 1, 1, 4}));
    }
}
