package 每日一题;

/**
 * Title: 山峰数组的峰顶索引
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-15
 */
public class 山峰数组的峰顶索引 {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
                high = mid;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]){
                low = mid;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                low = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        山峰数组的峰顶索引 res = new 山峰数组的峰顶索引();
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
//        int[] arr = {3,4,5,1};
//        int[] arr = {0,10,5,2};
//        int[] arr = {0,2,1,0};
//        int[] arr = {0,1,0};
//        int[] arr = {18,29,38,59,98,100,99,98,90};
        System.out.println(res.peakIndexInMountainArray(arr));
    }
}
