package codetop;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 将数组拆分成斐波那契序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-08
 */
public class 将数组拆分成斐波那契序列 {
    public List<Integer> splitIntoFibonacci(String S) {
        int len = S.length();
        if (len < 3) {
            return new LinkedList<>();
        }
        List<Integer> res = new LinkedList<>();
        if (backtrack(S, 0, 0, 0, res)) {
            /*
               当res 里面是空或者只有一个数时，
               pre,sum是没有用的
             */
            return res;
        } else {
            return new LinkedList<>();
        }

    }

    private boolean backtrack (String s, int inx, int pre, int sum, List<Integer> res) {
        if (inx == s.length()) {
            /*
                如果遍历完字符串了
                结果集里面的长度需要至少为3才正确
             */
            return res.size() > 2;
        }

        long num = 0;
        /*
            当前的数
            因为可能会溢出 int 范围，所以使用 long
         */
        for (int i = inx; i < s.length(); i++) {
            if (i > inx && s.charAt(inx) == '0') {
                /*
                    假如 01
                        inx 指向了0
                        i 指向了 1 ，不符合题目的除 0 外无前导 0
                    结束此次遍历，inx 不能是正在寻找的数的第一个字符
                 */
                break;
            }

            num = num * 10 + s.charAt(i) - '0';

            if (num > Integer.MAX_VALUE) {
                /*
                    题目要求的没超过 int 最大值
                 */
                break;
            }

            int tmp = (int) num;

            if (res.size() >= 2) {
                if (tmp > sum) {
                    /*
                        tmp 大于前面两个数的和
                        说明无法构成，停止遍历
                        因为是从左到右，小到大的顺序
                     */
                    break;
                } else if (tmp < sum) {
                    continue;
                    /*
                        当前数还小，再向右遍历一次
                     */
                }
                /*
                    剩下的情况是相等了
                 */
            }
            res.add(tmp);
            /*
                到这里两种情况：
                    res里面没有数或者只有一个数
                    tmp的值等于前两个的和
             */
            if (backtrack(s, i + 1, tmp, tmp + pre, res)) {
                /*
                    后续的数成功构成了，返回
                 */
                return true;
            } else {
                /*
                    后续的数无法构成，删去当前的最后一个数，回溯
                    继续搜索
                 */
                res.remove(res.size() - 1);
            }
        }
        return false;
        /*
            走完还没有找到一个方案
         */
    }

    public static void main(String[] args) {
        将数组拆分成斐波那契序列 res = new 将数组拆分成斐波那契序列();
        res.splitIntoFibonacci("123456579").
                forEach((i) -> System.out.print(i + "\t"));
    }



}
