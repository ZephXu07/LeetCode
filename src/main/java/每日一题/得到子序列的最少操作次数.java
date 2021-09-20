package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 得到子序列的最少操作次数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-29
 */
public class 得到子序列的最少操作次数 {
    public int minOperations(int[] target, int[] arr) {
        /*
            arr 中存在不属于 target 的直接忽略
            因为我们求的是 target 是 arr 的子序列

            将 target 的每个值映射到坐标上，即 target 是上升递增的
            再将 arr 中存在 target 的值对应改变
            因此求的是新 arr 的最长上升子序列
            因为我们可以在任何地方添加 target 的值
            求的是最少添加次数
            所以最长上升序列即是部分完成的子序列
            所以 target 的长度减去最长上升序列的长度即是最少操作数

         */
        Map<Integer, Integer> map = new HashMap<>(target.length);
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }

        int[] arrays = new int[arr.length];
        int len = 0;
        for (int a : arr) {
            if (map.containsKey(a)) {
                arrays[len++] = map.get(a);
            }
        }
        return target.length - lengthOfLIS(arrays, len);

    }

    public int lengthOfLIS(int[] nums, int len) {
        /*
            tail[i] 表示长度为 i 的最长上升子序列的末尾最小值
            end 表示长度，起始为 1，tail[1] = nums[0]

            因为每一个元素都是长度为 i 的序列最小值，所以 tail 必定是递增的

            如果当前遍历的值大于 tail[end] 的值，
            说明我们可以找到更长的 end+1 长度的最长上升子序列

            如果小于tail[end] 的值，
            则说明 tail[x] 表示长度为 x 的最长上升子序列的末尾最小值仍可以变得更小
            此处即为找到左边界，使用二分法找左边界

            最终 end 的值即长度就是我们想要找到的最长上升子序列的长度
         */
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


    public static void main(String[] args) {
        得到子序列的最少操作次数 res = new 得到子序列的最少操作次数();
        int[] target = {1,3,8};
        int[] arr = {2,6};
        System.out.println(res.minOperations(target, arr));
    }
}
