package 每日一题;

import java.util.Arrays;

/**
 * Title: 减小和重新排列数组后的最大元素
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-15
 */
public class 减小和重新排列数组后的最大元素 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        Arrays.sort(arr);
        int len = arr.length;
        arr[0] = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1] + 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[len - 1];
    }

    public int maximumElementAfterDecrementingAndRearranging1(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int len = arr.length;
        /*
            记录 1 - len 中各个数的个数，大于 len 的数视为 len 由题目的要求知道最后最大的是len，最小是 1
            因为可能多个 1 不断重复直到最后
            或者 [1, len]，其间其他数重复
         */
        int[] count = new int[len + 1];
        for (int a : arr) {
            if (a > len) {
                count[len]++;
            } else {
                count[a]++;
            }
        }
        int miss = 0;
        for (int i = 1; i <= len; i++) {
            if (count[i] == 0) {
                /*
                    i 这个数缺失了，缺失的数增加了，
                    因为是从前往后遍历，如果是前面的数缺失了，由后面的大的数来减小补上
                    如果是中间的数缺少，同理由后面大的数来减小补上
                    如果是后面的数缺少了，证明前面数重复了，或者重复的数减小补上之后还重复，不能补了
                 */
                miss++;
            } else {
                /*
                    由上面知道此处是来补上的，
                    后面大的来补前面少的，
                    大的补上自己的全部或者补上缺少之后还有剩余，取小的
                 */
                miss -= Math.min(count[i] - 1, miss);
                /*
                    此处减 1 是因为我们最后求的是最终长度减去缺失的数就是最大的长度，而不是求数组最后的不为 1 的下标
                    例如 12225，5 不会被用去填补 3 ，我们计算了缺失了3 4 两个位置，最后是长度5 - 2 = 3
                 */
            }
        }
        /*
            miss == 0 则是刚好缺失的都由后面重复的都补上了
            miss != 0 则表示前面的补上了仍有重复的，或者前面没有缺失，存在很多重复的，
            计算之后则是最大值
         */
        return len - miss;
    }

    public static void main(String[] args) {
        减小和重新排列数组后的最大元素 res = new 减小和重新排列数组后的最大元素();
//        int[] arr = {2,2,1,2,1};
//        int[] arr = {100,1,1000};
        int[] arr = {1,2,3,4,5};
        System.out.println(res.maximumElementAfterDecrementingAndRearranging(arr));
    }
}
