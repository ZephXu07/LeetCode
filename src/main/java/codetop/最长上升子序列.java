package codetop;

/**
 * Title: 最长上升子序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-28
 */
public class 最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        /*
            tail[i] 表示长度为 i 的最长上升子序列的末尾最小值
            end 表示长度，起始为 1，tail[1] = nums[0]

            因为tail[i]表示是长度为 i 的序列最小值，所以 tail 必定是递增的

            如果当前遍历的值大于 tail[end] 的值，
            说明我们可以找到更长的 end+1 长度的最长上升子序列

            如果小于tail[end] 的值，
            则说明 tail[x] 表示长度为 x 的最长上升子序列的末尾最小值仍可以变得更小
            此处即为找到左边界，使用二分法找左边界

            最终 end 的值即长度就是我们想要找到的最长上升子序列的长度
         */

        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int[] tail = new int[len + 1];
        tail[1] = nums[0];

        int end = 1;
        for (int i = 1; i < len; i++) {
            if (tail[end] < nums[i]) {
                tail[++end] = nums[i];
            } else {
                int l = 1;
                int r = end;
                while (l < r) {
                    int mid = l + (r - l) / 2;

                    if (tail[mid] < nums[i]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                tail[l] = nums[i];
            }
        }
        return end;
    }
}
