package 每日一题;

/**
 * Title: 黑板异或游戏
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-22
 */
public class 黑板异或游戏 {

    public boolean xorGame(int[] nums) {
        /*
            设长度为 n，偶数
            则整个数组异或结果 S = nums[0]^...nums[n - 1]
            假如 S == 0，由于 A 先手，直接返回 true
            所以 假设 S ！= 0
                假设擦掉 nums[i] (0 <= i <= n - 1)后 异或结果是 Si
                则有 Si ^ nums[i] = S

                两边同时异或 nums[i]
                    Si = S ^ nums[i]

                假设擦掉任何一个数字异或结果都为 0 ，且长度为偶数
                则   S0 ^ ... Sn - 1 = 0

                将上式代入，则
                    (S ^ nums[0]) ^ ... ^ (S ^ nums[n - 1]) = 0
                    (S ^ ... ^ S) ^ (nums[0]^...^nums[n - 1]) = 0
                    (偶数个）           (S的展开式)

                    0 ^ S = 0
                    S = 0

               与假设 S ！= 0矛盾

               所以 A 先手总能找到一个数擦掉，使 剩下的数异或结果不为 0
               到 B时奇数，他不可能使自己擦掉后为 0 直接失败，所以 B 擦掉后肯定不为 0，此时轮到 A，再由于是偶数，
               所以继续算下去 A 是不可能输的

               同理 奇数个时，A 先手最后总是 B 胜

               综上，所有数异或结果为 0 ，A 先手，此时就获胜
               否则是数组的长度为偶数



         */

        if ((nums.length & 1) == 0) {
            return true;
        }

        int sum = 0;
        for (int n : nums){
            sum ^= n;
        }

        return sum == 0;

    }


}
