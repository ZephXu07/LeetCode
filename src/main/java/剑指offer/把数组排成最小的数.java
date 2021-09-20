package 剑指offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 把数组排成最小的数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-05
 */
public class 把数组排成最小的数 {
    //超时的
//    private List<String> res;
//    public String minNumber(int[] nums) {
//        res = new LinkedList<>();
//        LinkedList<Integer> track = new LinkedList<>();
//        getAllNumber(nums, track);
//        String min = res.get(0);
//        for (String re : res) {
//            if (compareSize(re, min)) {
//                min = re;
//            }
//        }
//        return min;
//    }
//
//    private void getAllNumber(int[] nums, LinkedList<Integer> track) {
//        if (track.size() == nums.length) {
//            StringBuilder builder = new StringBuilder();
//            for (Integer i : track) {
//                builder.append(nums[i]);
//            }
//            for (int i = 0; i < builder.length(); i++) {
//                if (builder.charAt(i) == '0') {
//                    builder.deleteCharAt(i);
//                } else {
//                    break;
//                }
//            }
//            res.add(builder.toString());
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (track.contains(i)) {
//                continue;
//            }
//            track.add(i);
//            getAllNumber(nums, track);
//            track.removeLast();
//        }
//    }
//
//    private boolean compareSize(String s, String p) {
//        char[] sChar = s.toCharArray();
//        char[] pChar = p.toCharArray();
//        for (int i = 0; i < sChar.length; i++) {
//            if (sChar[i] > pChar[i]) {
//                return false;
//            } else if (sChar[i] < pChar[i]) {
//                return true;
//            }
//        }
//        return true;
//    }


    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        fastSort(strs, 0, nums.length - 1);
        StringBuilder builder = new StringBuilder();
        for (String s : strs) {
            builder.append(s);
        }
        return builder.toString();
    }

    private void fastSort(String[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(nums, low, high);
        fastSort(nums, low, pivot - 1);
        fastSort(nums, pivot + 1, high);
    }

    private int partition(String[] nums, int low, int high) {
        if (low == high) {
            return low;
        }
        String pivot = nums[low];
        int i = low;
        int j = high + 1;
        while (true) {
            while ((nums[++i] + pivot).compareTo(pivot + nums[i]) < 0) {
                if (i == high) {
                    break;
                }
            }
            while ((nums[--j] + pivot).compareTo(pivot + nums[j]) > 0) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, j, low);
        return j;
    }

    private void swap(String[] nums, int i, int j) {
        String tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        把数组排成最小的数 res = new 把数组排成最小的数();
        int[] nums = {3,30,34,5,9};
        System.out.println(res.minNumber(nums));
    }
}
