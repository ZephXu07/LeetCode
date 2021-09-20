package labuladong;

import java.util.*;

/**
 * Title: labuladong.Solution
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-09-08
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] shortNums;
        int[] longNums;
        int[] temp;
        if (nums1.length > nums2.length) {
            shortNums = nums2;
            longNums = nums1;
        } else {
            shortNums = nums1;
            longNums = nums2;
        }
        temp = shortNums;
        int index = 0;
        for (int i = 0; i < shortNums.length; i++) {
            for (int j = 0; j < longNums.length; j++) {
                if (shortNums[i] == longNums[j]) {
                    temp[index] = shortNums[i];
                    longNums[j] = -1;
                    index ++;
                    break;
                }
            }
        }
        int[] result = new int[index];
        if (index >= 0) System.arraycopy(temp, 0, result, 0, index);
        return result;
    }
//    public int[] intersect(int[] nums1, int[] nums2) {
//        List<Integer> shortList;
//        List<Integer> longList;
//        if (nums1.length > nums2.length) {
//            shortList = Arrays.stream(nums2).boxed().collect(Collectors.toList());
//            longList = Arrays.stream(nums1).boxed().collect(Collectors.toList());
//        } else {
//            shortList = Arrays.stream(nums1).boxed().collect(Collectors.toList());
//            longList = Arrays.stream(nums2).boxed().collect(Collectors.toList());
//        }
//        List<Integer> resultList = new ArrayList<>();
//        for (int i = 0; i < shortList.size(); i++) {
//            for (int j = 0; j < longList.size(); j++) {
//                if (shortList.get(i).equals(longList.get(j))) {
//                    resultList.add(shortList.get(i));
//                    longList.remove(j);
//                    break;
//                }
//            }
//        }
//        return resultList.stream().mapToInt(Integer::valueOf).toArray();
//    }
    public int[] plusOne(int[] digits) {
        int carry = 0;
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] += 1;
            return digits;
        }//当末尾不为9时，直接加1
        if (digits[digits.length - 1] == 9) {
            carry = 1;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9 && carry == 1) {//末尾为9且有进位
                digits[i] = 0;
                carry = 1;
            } else if (digits[i] != 9 && carry == 1) {//末尾不为9但有进位
                digits[i] += 1;
                carry = 0;
            }
        }
        if (!(digits[0] == 0 && carry == 1)) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
    }

//    public void duplicateZeros(int[] arr) {
//        int length;
//        if (arr.length % 2 == 0) {
//            length = arr.length / 2 + 1;
//        } else {
//            length = arr.length / 2 + 2;
//        }
//        int[] index = new int[length];
//        length = arr.length;
//        int count = 0;
//        for (int i = 0; i < length; i++) {
//            if (arr[i] == 0) {
//                index[count] = count + i;
//                count ++;
//                length --;
//            }
//        }
//        index[count] = arr.length;
////        System.out.println(Arrays.toString(index));
//        int prior = 0;
//        int next = 0;
//        for (int j = 0; j < index.length; j++) {
//            count = index[j];
//            for (int i = count; i < index[j + 1]; i++) {
//                if (i == count + 1) {
//                    prior = arr[i + 1];
//                    next = arr[i];
//                    arr[i] = 0;
//                } else {
//                    arr[i] = next;
//                    next = prior;
//                    prior = arr[i + 1];
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution().twoSum(nums, target)));
        Map<Integer, Integer> map = new HashMap<>();
    }


    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length - 1; i++) {
            int tmp = target - nums[i];
            result[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (tmp == nums[j]) {
                    result[1] = j;
                    break;
                }
            }
            if (result[1] != -1) {
                break;
            }
        }
        return result;
    }



}
