package 每日一题;




import java.util.*;

/**
 * Title: 一三二模式
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-24
 */
public class 一三二模式 {
    public boolean find132pattern3(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        TreeMap<Integer, Integer> rightAll = new TreeMap<>();
        for (int i = 2; i < len; i++) {
            rightAll.put(nums[i], rightAll.getOrDefault(nums[i], 0) + 1);
        }
        int left = nums[0];
        for (int i = 1; i < len - 1; i++) {
            if (left < nums[i]) {
                Integer right = rightAll.ceilingKey(left + 1);
                if (null != right && right < nums[i]) {
                    return true;
                }
            }
            left = Math.min(left, nums[i]);
            int count = rightAll.get(nums[i + 1]);
            rightAll.put(nums[i + 1], --count);
            if (count == 0) {
                rightAll.remove(nums[i + 1]);
            }
        }
        return false;
    }

    public boolean find132pattern1(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        Deque<Integer> stack = new LinkedList<>();
        stack.push(nums[len - 1]);
        Integer max2 = Integer.MIN_VALUE;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < max2) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                max2 = stack.pop();
            }
            if (nums[i] > max2) {
                stack.push(nums[i]);
            }
        }
        return false;
    }


    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        List<Integer> candidateI = new ArrayList<Integer>();
        candidateI.add(nums[0]);
        List<Integer> candidateJ = new ArrayList<Integer>();
        candidateJ.add(nums[0]);

        for (int k = 1; k < n; ++k) {
            int idxI = binarySearchFirst(candidateI, nums[k]);
            int idxJ = binarySearchLast(candidateJ, nums[k]);
            if (idxI >= 0 && idxJ >= 0) {
                if (idxI <= idxJ) {
                    return true;
                }
            }

            if (nums[k] < candidateI.get(candidateI.size() - 1)) {
                candidateI.add(nums[k]);
                candidateJ.add(nums[k]);
            } else if (nums[k] > candidateJ.get(candidateJ.size() - 1)) {
                int lastI = candidateI.get(candidateI.size() - 1);
                while (!candidateJ.isEmpty() && nums[k] > candidateJ.get(candidateJ.size() - 1)) {
                    candidateI.remove(candidateI.size() - 1);
                    candidateJ.remove(candidateJ.size() - 1);
                }
                candidateI.add(lastI);
                candidateJ.add(nums[k]);
            }
        }

        return false;
    }

    public int binarySearchFirst(List<Integer> candidate, int target) {
        int low = 0, high = candidate.size() - 1;
        if (candidate.get(high) >= target) {
            return -1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int num = candidate.get(mid);
            if (num >= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int binarySearchLast(List<Integer> candidate, int target) {
        int low = 0, high = candidate.size() - 1;
        if (candidate.get(low) <= target) {
            return -1;
        }
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            int num = candidate.get(mid);
            if (num <= target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        int[] nums = {3,5,0,3,4};
        一三二模式 res = new 一三二模式();
        System.out.println(res.find132pattern3(nums));
        System.out.println(res.find132pattern1(nums));


    }
}
