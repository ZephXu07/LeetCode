package codetop;

/**
 * Title: 寻找重复数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-06
 */
public class 寻找重复数 {
//    public int findDuplicate(int[] nums) {
//        int len = nums.length;
//        if (len == 2) {
//            return 1;
//        }
//        int left = 1;
//        int right = len - 1;
//        int res = 0;
//        while (left <= right) {
//            int mid = (left + right + 1) / 2;
//            int count = 0;
//            for (int num : nums) {
//                if (num <= mid) {
//                    count++;
//                }
//            }
//            if (count <= mid) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//                res = mid;
//            }
//        }
//        return res;
//    }

//    public int findDuplicate(int[] nums) {
//        /*
//            数组长度
//         */
//        int len = nums.length;
//        /*
//            为 2 时一定为 1
//         */
//        if (len == 2) {
//            return 1;
//        }
//
//        int bit = 31;
//        while (((len - 1) >> bit) == 0) {
//            bit--;
//        }
//        /*
//            计算最大的二进制位数
//         */
//
//        int res = 0;
//        for (int i = 0; i <= bit; i++) {
//            int x = 0;
//            int y = 0;
//
//            for (int j = 0; j < len; j++) {
//                if ((nums[j] & (1 << i)) != 0) {
//
//                    x++;
//                }
//
//                if (j != 0 && (j & (1 << i)) != 0) {
//                    y++;
//                }
//            }
//
//            if (x > y) {
//                res |= 1 << i;
//            }
//        }
//        /*
//            统计数组中每一个二进制位上 1 的数量
//            再统计 1 , n - 1 的二进制位上 1 的数量
//
//            多的那个就是重复的数
//
//            如果重复的数只重复了一次，即数组中是 [1, n - 1]中的数，即比 [1, n - 1]
//            多了一个数，统计 1 的出现的位即是结果，因为 0 无贡献
//
//            如果重复的数出现了2次以上，它会替换另外一个数
//            如果此数某位上是 1 ， 重复的数是 1 ，由于有另外的重复数，所以 x > y
//            如果此数某位上是 0 ， 重复的数是 1，肯定 x > y
//            如果此数某位上是 1 ， 重复的数是 0，此时 x <= y，由于target此位的 0 对结果无贡献，不影响
//            如果此数某位上是 0 ， 重复的数是 0，此时 x <= y，同理
//
//         */
//
//        return res;
//    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    public static void main(String[] args) {
        寻找重复数 res = new 寻找重复数();
        System.out.println(res.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(res.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(res.findDuplicate(new int[]{1,1,2}));

    }
}
