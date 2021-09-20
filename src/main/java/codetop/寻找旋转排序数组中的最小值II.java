package codetop;

/**
 * Title: 寻找旋转排序数组中的最小值II
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-18
 */
public class 寻找旋转排序数组中的最小值II {
    public int findMin(int[] nums) {
        /*
        最小值的左侧元素大于等于最小值
        右侧元素大于等于最小值
        如果以最右侧元素 right 为比较，
        最小值左侧的元素均大于等于 right
        最小值右侧的元素均小于等于 right

        于是可以进行对比
        left 0
        right len - 1

        在每次迭代中都保持此性质
        如果中间值 mid < right
            说明 mid 是最小值右侧的元素，忽略 mid 右侧的元素
            因为mid -> right 是递增的，
            万一 mid - 1 是最小值，迭代到最后剩两个数时只会选择坐标左边的，mid - 1 可能溢出范围
            于是 right = mid，
        如果中间值 mid > right
            说明 mid 是最小值左侧的元素，忽略 mid 左侧的元素
            因为left -> mid 是递增的，
            即使 mid + 1 是最小值，也会因为整数除法而取到 mid 为left坐标
            所以 left = mid + 1
        如果中间值 mid == right
            最小值左侧的元素均大于等于 right
            最小值右侧的元素均小于等于 right
            所以无法区分，选择 right = right - 1
            1.我们的条件有 right > left >= 0 ，不会发送越界
            2.因为 right 不是唯一的，如果唯一的话 right != mid，因为整数除法会取到左边的值
            所以最小值还在 [left,right-1]区间里

            举例
            0 1 2 3 4 5 6 7 8 9 10
            2 2 3 4 4 0 0 1 1 2 2
            left=0,right=10,mid=5
            n[mid] < n[right] right=5
            mid=2
            n[mid] > n[right] left=3
            n[mid] > n[right] left=5
            left == right 停止，刚好 0 是最小值

            0 1 2 3 4 5 6 7 8
            1 1 0 0 1 1 1 1 1
            l=0 r=8 m = 4
            n[m]=n[r]
            r=7
            m=3
            r=3
            m=1
            n[m] > n[r]
            left=2
            m=2
            n[m] < n[r]
            r=2=l
            停止，也是最小值


         */
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int left = 0;
        int right = len - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] == nums[right]) {
                right--;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
