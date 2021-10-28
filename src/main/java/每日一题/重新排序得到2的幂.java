package 每日一题;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Title: 重新排序得到2的幂
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-28
 */
public class 重新排序得到2的幂 {
//    public boolean reorderedPowerOf2(int n) {
//        if ((n & (n - 1)) == 0) {
//            return true;
//        }
//        List<Integer> nums = new LinkedList<>();
//        while (n != 0) {
//            nums.add(n % 10);
//            n /= 10;
//        }
//
//        return dfs(nums, 0, 0);
//
//    }
//
//    private boolean dfs (List<Integer> nums, int sum, int len) {
//        if (len == nums.size()) {
//            return (sum & (sum - 1)) == 0;
//        }
//        for (int i = 0; i < nums.size(); i++) {
//            if ((len == 0 && nums.get(i) == 0)
//                    || nums.get(i) == -1) {
//                continue;
//            }
//            int tmp = nums.get(i);
//            nums.set(i, -1);
//            if (dfs(nums, sum * 10 + tmp, len + 1)) {
//                return true;
//            }
//            nums.set(i, tmp);
//        }
//        return false;
//    }


    private Set<String> set = new HashSet<>();
    public boolean reorderedPowerOf2(int n) {
        if (set.size() == 0) {
            init();
        }
        return set.contains(new String(getString(n)));
    }

    private void init () {
        for (int i = 1; i <= 1e9; i <<= 1) {
            set.add(new String(getString(i)));
        }
    }
    private char[] getString (int n) {
        char[] chars = new char[10];
        while (n != 0) {
            chars[n % 10]++;
            n /= 10;
        }
        return chars;
    }

    public static void main(String[] args) {
        重新排序得到2的幂 res = new 重新排序得到2的幂();
        System.out.println(res.reorderedPowerOf2(1) + "\tT");
        System.out.println(res.reorderedPowerOf2(10) + "\tF");
        System.out.println(res.reorderedPowerOf2(16) + "\tT");
        System.out.println(res.reorderedPowerOf2(24) + "\tF");
        System.out.println(res.reorderedPowerOf2(46) + "\tT");
    }
}
