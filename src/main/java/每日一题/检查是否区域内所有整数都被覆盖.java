package 每日一题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Title: 检查是否区域内所有整数都被覆盖
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-23
 */
public class 检查是否区域内所有整数都被覆盖 {
    public  boolean isCovered(int[][] ranges, int left, int right) {
//        Arrays.sort(ranges, Comparator.comparingInt(r -> r[0]));
//        /*
//            不必管理区间是否重叠，判断左端点是否在某个区间内，是则直接等于右端点+1
//            而我刚开始没想到区间的重叠，直接不属于情况返回 false，所以才需要合并区间
//            此个方法的重点是合法则左端点增大，再看最后是否大于右端点，如果刚好包含时左端点也会比右端点+1
//         */
//        for (int[] range : ranges) {
//            if (range[0] <= left && left <= range[1]) {
//                left = range[1] + 1;
//            }
//        }
//        return left > right;

//        /*
//            举例 [1,2]
//            1 << 1 是 2 ，
//            1 << (2+1) 是 8 ,
//            8 - 2 = 6，二进制是 0110
//            表示了[1,2]存在
//            使用或并起来，
//            [left,right] 同理
//            最后如果一样的话按位与肯定为自身，不是则不和题意
//         */
//        long data = 0;
//        for (int[] range : ranges) {
//            data |= (1L << (range[1] + 1)) - (1L << range[0]);
//        }
//
//        long tmp = (1L << (right + 1)) - (1L << left);
//        return (data & tmp) == tmp;


        int[] diff = new int[52];
        //对差分数组进行处理
        for (int i = 0; i < ranges.length; i++){
            diff[ranges[i][0]]++;
            diff[ranges[i][1]+1]--;
        }
        //根据差分数组处理前缀和，为理解方便单独定义sum，可以原地做
        int[] pre = new int[52];
        for(int i = 1; i <= 51; i++){
            pre[i] = pre[i-1] + diff[i];
        }
        //从left到right判断是否满足pre > 0
        for(int i = left; i <= right; i++){
            if (pre[i] <= 0) {
                return false;
            }
        }
        return true;

    }



    public static void main(String[] args) {
        检查是否区域内所有整数都被覆盖 res = new 检查是否区域内所有整数都被覆盖();
//        int[][] ranges = {{1,2},{3,4},{5,6}};
        int left = 2;
        int right = 5;
//        System.out.println(res.isCovered(ranges, left, right) + "\ttrue");
//        int[][] ranges1 = {{1,10},{10,20}};
//        left = 21;
//        right = 21;
//        System.out.println(res.isCovered(ranges1, left, right) + "\tfalse");
        int[][] ranges2 = {{13,43},{19,20},{32,38},{26,33},{3,38},{16,31},{26,48},{27,43},{12,24}};
        left = 36;
        right = 45;
        System.out.println(res.isCovered(ranges2, left, right) + "\ttrue");

        System.out.println(1 << 1);
        System.out.println(1 << 3);
    }
}
