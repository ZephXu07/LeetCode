package codetop;

import java.util.Arrays;

/**
 * Title: 俄罗斯套娃信封问题
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-30
 */
public class 俄罗斯套娃信封问题 {
    public int maxEnvelopes(int[][] envelopes) {
        /*
            固定宽度，即先把宽度排序，使宽度非递减
            当宽度相同时高度递减，而递增的话会出错
            因为我们固定好宽度后对高度进行最长上升子序列长度的查找
            当宽度相同，而高度因为递增会被我们选择，
            但此时是不合题意的，高度递增是正确的，但宽度相同无法放进一起
         */
        Arrays.sort(envelopes, (e1, e2)->{
            if (e1[0] == e2[0]) {
                return e2[1] - e1[1];
            }
            return e1[0] - e2[0];
        });

        int len = envelopes.length;
        int[] tail = new int[len + 1];
        /*
            tail[i] 表示长度为 i 的最长上升子序列末尾最小值
            tail[1] 初始值为 envelopes[0][1]
         */
        tail[1] = envelopes[0][1];
        /*
            end 表示当前数组找到的最大长度，初始值也为 1
         */
        int end = 1;
        for (int i = 1; i < len; i++) {
            if (envelopes[i][1] > tail[end]) {
                /*
                    envelopes[i][1] 大于现有的最大长度上升子序列的末尾的值，
                    直接加在后面，end先自增
                 */
                tail[++end] = envelopes[i][1];
            } else {
                /*
                    否则小于等于现有的最大长度上升子序列的末尾的值
                    因为定义是 长度为 i 的上升子序列的末尾的最小值，
                    如果随着长度增加，末尾最小值还可以更小，则表示在 i 之前能找到一个末尾的值将其代替

                    0 1 2 3 4
                    1 7 6 4 5

                    tail[1] = 1
                    tail[2] 在遍历到下标为 2 的时候有更小的值 6 更新前面的 7 ，
                    但还没有结束，后面还有下标为 3 的 4 所以 tail[2] = 4

                    tail[3] 只能为 5 ，而如果下标为 4 的值改为 3
                    此时 tail[2] 会有新的值 3
                    而tail[3] 将找不到长度为 3 的最长上升子序列

                    所以 tail[i] 是非递减的，可以使用二分法
                 */
                int l = 1;
                int r = end;
                while (l < r) {
                    int m = l + (r - l) / 2;
                    /*
                        [l,mid] tail[i] < envelopes[i][1]
                        r会收缩至 mid
                        [mid+1, r] > envelopes[i][1]
                        l 会扩张至 mid + 1

                        而 tail[mid] =  envelopes[i][1]
                        不能保证 tail[mid - 1] 是否小于 envelopes[i][1]
                        而如果等于的话，就要确定 mid - 2...
                        除非 l + 1 = r
                        此时  l == mid
                        已经无法收缩了
                        所以 r = mid

                     */
                    if (tail[m] < envelopes[i][1]) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                /*
                    到此处 tail[l-1]肯定小于 envelopes[i][1]
                    而等于将会继续，除非 l = 1 (长度为 0 的最长上升自序列不存在)
                    所以在这里存放相对左边更大的数
                 */
                tail[l] = envelopes[i][1];

            }

        }
        return end;
        /*
            返回最后的长度
         */


    }
}
