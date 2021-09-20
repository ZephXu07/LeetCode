package codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Title: 二十四点游戏
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-02
 */
public class 二十四点游戏 {
    private static final int TAREGT = 24;

    private static final double PRECISION = 1e-6;

    private static final char[] SIGN = {'+', '-', '*', '/'};

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new LinkedList<>();
        for (int c : cards) {
            list.add((double)c);
        }
        return backtrack(list);
    }

    private boolean backtrack (List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TAREGT) < PRECISION;
            /*
                只剩一个数，判断是否与24一样，差小于 10^(-6)
             */
        }

        int len = list.size();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                /*
                    枚举两个数，相同则跳过
                 */
                if (i == j) {
                    continue;
                }

                List<Double> next = new LinkedList<>();
                /*
                    装剩下的数与这两个数的计算结果
                 */
                for (int k = 0; k < len; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    next.add(list.get(k));
                }

                for (char s : SIGN) {
                    /*
                        枚举两个数之间的运算
                     */
                    if (i > j && (s == '+' || s == '*')) {
                        /*
                            加法、乘法交换律
                            i > j
                            一开始是 i 固定，j 增加，所以当 i > j 时已经计算过这种情况
                            所以跳过
                         */
                        continue;
                    }

                    switch (s) {
                        case '+':
                            next.add(list.get(i) + list.get(j));
                            break;
                        case '-':
                            next.add(list.get(i) - list.get(j));
                            break;
                        case '*':
                            next.add(list.get(i) * list.get(j));
                            break;
                        case '/':
                            if (Math.abs(list.get(j)) < PRECISION) {
                                /*
                                    当一个数小于 10^(-6) 时默认为 0
                                    除数为 0 跳过
                                 */
                                continue;
                            } else {
                                next.add(list.get(i) / list.get(j));
                            }
                            break;
                        default:
                            break;
                    }

                    if (backtrack(next)) {
                        /*
                            收集了计算结果后
                            进入下一层，且后续的计算成功了直接返回成功
                         */
                        return true;
                    }

                    next.remove(next.size() - 1);
                    /*
                        回溯，删除i ,j 两个数某种情况，
                        枚举下面运算的情况
                     */

                }


            }
        }

        return false;
    }

    public static void main(String[] args) {
        二十四点游戏 res = new 二十四点游戏();
        System.out.println(res.judgePoint24(new int[]{4, 1, 8, 7}));
    }
}
