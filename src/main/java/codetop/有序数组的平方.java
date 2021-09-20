package codetop;

/**
 * Title: 有序数组的平方
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-02
 */
public class 有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        /*
            找到第一个大于等于 0 的数的下标
            左右指针
            如果全为负数，则将left = len - 1，right = len
            全为负数不用处理
         */
        int len = nums.length;
        int mid = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                mid = i;
                break;
            }
        }
        int INF = (int) (1e8 + 1);
        int[] res = new int[len];
        int right;
        int left;
        if (mid == -1) {
            left = len - 1;
            right = len;
        } else {
            right = mid;
            left = mid - 1;
        }
        for (int i = 0; i < len; i++) {
            int l = left >= 0 ? nums[left] * nums[left] : INF;
            int r = right < len ? nums[right] * nums[right] : INF;
            if (l <= r) {
                res[i] = l;
                left--;
            } else {
                res[i] = r;
                right++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        有序数组的平方 res = new 有序数组的平方();
        int[] num = res.sortedSquares(new int[]{-4,-1,0,3,10});
        for (int n : num) {
            System.out.print(n + "\t");
        }
        System.out.println();
        int[] num1 = res.sortedSquares(new int[]{-7,-3,2,3,11});
        for (int n : num1) {
            System.out.print(n + "\t");
        }
        System.out.println();
        int[] num2 = res.sortedSquares(new int[]{1,2,3,4,5,6,7});
        for (int n : num2) {
            System.out.print(n + "\t");
        }
        System.out.println();
        int[] num3 = res.sortedSquares(new int[]{-5,-3,-2,-1});
        for (int n : num3) {
            System.out.print(n + "\t");
        }
    }
}
