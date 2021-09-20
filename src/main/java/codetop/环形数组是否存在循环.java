package codetop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Title: 环形数组是否存在循环
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-07
 */
public class 环形数组是否存在循环 {
    public boolean circularArrayLoop(int[] nums) {
        /*
            快慢指针找环，已经走过的不成环的点排除，即不以它开始，遇到他也结束此处遍历
         */
        int len = nums.length;
        if (len == 1) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = nextIndex(nums, i);
            while (nums[slow] * nums[fast] > 0
                    && nums[slow] * nums[nextIndex(nums, fast)] > 0) {
                /*
                 nums[slow] * nums[fast] > 0
                 slow 与 fast当前位置方向一致且非零
                 0 slow 的下一个位置是 1 fast

                 nums[slow] * nums[nextIndex(nums, fast)]
                 而 1 slow 的下一个位置是 2,
                 1 fast 的下一个位置是 3，跳过了2， 所以此处需要看 2 的情况
                 */
                if (slow == fast) {
                    /*
                        找到环点，但 1 - 5 - 5 - 5 不是题目要求的
                        此处进行判断
                     */
                    if (slow == nextIndex(nums, slow)) {
                        break;
                    }
                    return true;
                }
                slow = nextIndex(nums, slow);
                fast = nextIndex(nums, nextIndex(nums, fast));
            }

            slow = i;
            while (nums[slow] * nums[nextIndex(nums, slow)] > 0) {
                /*
                    将这一趟不成环的置 0 ，降低时间复杂度
                 */
                int tmp = slow;
                slow = nextIndex(nums, slow);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    private int nextIndex (int[] nums, int inx) {
        int tmp = inx + nums[inx];
        if (tmp < 0) {
            tmp = nums.length - (-tmp % nums.length);
        } else if (tmp >= nums.length){
            tmp %= nums.length;
        }
        return tmp;
    }


    public static void main(String[] args) {
        环形数组是否存在循环 res = new 环形数组是否存在循环();
        System.out.println(res.circularArrayLoop(new int[]{2, -1, 1, 2, 2}) + "\ttrue");
        System.out.println(res.circularArrayLoop(new int[]{-1,2}) + "\tfalse");
        System.out.println(res.circularArrayLoop(new int[]{-2,1,-1,-2,-2}) + "\tfalse");
        System.out.println(res.circularArrayLoop(new int[]{-1,-2,-3,-4,-5}) + "\tfalse");
        System.out.println(res.circularArrayLoop(new int[]{-2,-3,-9}) + "\tfalse");
    }
}
