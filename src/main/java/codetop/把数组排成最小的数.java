package codetop;

/**
 * Title: 把数组排成最小的数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-11
 */
public class 把数组排成最小的数 {
    public String minNumber(int[] nums) {
        String[] num = new String[nums.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = String.valueOf(nums[i]);
        }
        quickSort(num, 0, num.length - 1);
        StringBuilder res = new StringBuilder();
        for (String n : num) {
            res.append(n);
        }
        return res.toString();
    }

    private void quickSort (String[] num, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = partition(num, low, high);
        quickSort(num, low, mid - 1);
        quickSort(num, mid + 1, high);
    }

    private int partition(String[] num, int low, int high) {
        String pivot = num[low];
        int inx = low;
        while (low < high) {
            while (low < high && (num[high] + pivot).compareTo(pivot + num[high]) >= 0) {
                high --;
            }
            while (low < high && (num[low] + pivot).compareTo(pivot + num[low]) <= 0)  {
                low++;

            }
            if (low >= high) {
                break;
            }
            swap(num, low, high);
        }
        swap(num, inx, low);
        num[low] = pivot;
        return low;
    }

    private void swap(String[] num, int x, int y) {
        String tmp = num[x];
        num[x] = num[y];
        num[y] = tmp;
    }
}
