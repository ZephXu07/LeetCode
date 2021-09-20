package codetop;

/**
 * Title: 山脉数组中查找目标值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-14
 */
public class 山脉数组中查找目标值 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int left = 0;
        int right = len - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int l = mountainArr.get(mid - 1);
            int m = mountainArr.get(mid);
            int r = mountainArr.get(mid + 1);
            if (l > m && m > r) {
                right = mid;
            } else if (l < m && m > r){
                left = mid;
            } else if (l < m && m < r) {
                left = mid;
            }
        }
        right = left;
        left = 0;
        int inx = binarySearchLeft(mountainArr, target, left, right);
        if (inx == -1) {
            inx = binarySearchRight(mountainArr, target, right, len - 1);
        }
        return inx;

    }

    private int binarySearchLeft (MountainArray mountainArr, int target, int left ,int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            int m = mountainArr.get(mid);
            if (m < target) {
                left = mid + 1;
            } else if (m > target){
                right = mid;
            } else {
                return mid;
            }
        }
        return mountainArr.get(left) == target ? left : -1;
    }

    private int binarySearchRight (MountainArray mountainArr, int target, int left ,int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            int m = mountainArr.get(mid);
            if (m < target) {
                right = mid - 1;
            } else if (m > target){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return mountainArr.get(left) == target ? left : -1;
    }

    public static void main(String[] args) {
        MountainArray mountainArray = new MountainArray(new int[] {0,1,2,4,2,1});
        山脉数组中查找目标值 res = new 山脉数组中查找目标值();
        System.out.println(res.findInMountainArray(3, mountainArray)+"\t-1");
        mountainArray = new MountainArray(new int[] {1,2,3,4,5,3,1});
        res = new 山脉数组中查找目标值();
        System.out.println(res.findInMountainArray(3, mountainArray) + "\t2");
        mountainArray = new MountainArray(new int[] {1,5,2});
        res = new 山脉数组中查找目标值();
        System.out.println(res.findInMountainArray(2, mountainArray)+ "\t2");
        MountainArray mountainArray2 = new MountainArray(new int[] {1,2,3,4,5,3,1});
        山脉数组中查找目标值 res2 = new 山脉数组中查找目标值();
        System.out.println(res2.findInMountainArray(2, mountainArray2)+ "\t1");
        MountainArray mountainArray1 = new MountainArray(new int[] {1,5,2});
        山脉数组中查找目标值 res1 = new 山脉数组中查找目标值();
        System.out.println(res1.findInMountainArray(5, mountainArray1)+ "\t1");
        MountainArray mountainArray3 = new MountainArray(new int[] {1,5,2});
        山脉数组中查找目标值 res3 = new 山脉数组中查找目标值();
        System.out.println(res3.findInMountainArray(0, mountainArray3)+ "\t-1");
    }


}
class MountainArray {
    private int[] nums;
    public MountainArray(int[] nums) {
        this.nums = nums;
    }

    public int get(int index) {
        return nums[index];
    };
    public int length() {
        return nums.length;
    };
}
