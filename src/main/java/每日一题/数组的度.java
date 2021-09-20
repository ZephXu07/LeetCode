package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 数组的度
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-20
 */
public class 数组的度 {
    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        Map<Integer, int[]> memo = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            if (!memo.containsKey(nums[i])) {
                memo.put(nums[i], new int[]{1,i,i});
            } else {
                memo.get(nums[i])[0]++;
                memo.get(nums[i])[2] = i;
            }
        }
        int maxCount = 0;
        int minLen = 0;
        for (int[] arr : memo.values()){
            if (maxCount < arr[0]) {
                maxCount = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxCount == arr[0]) {
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }
}
