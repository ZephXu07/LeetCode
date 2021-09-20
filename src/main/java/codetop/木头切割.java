package codetop;

/**
 * Title: 木头切割
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-30
 */
public class 木头切割 {
    public int woodCutting (int[] wood, int k) {
        int high = 1;
        for (int w : wood) {
            high = Math.max(w, high);
        }
        /*
            有解，即最小是 1
            最大是木头的最大长度
            [low, mid] [mid + 1, high]
            [low, high] 中 x 越小，切分的数量越多，
            即 x 增大，count 减小
              x 减小，count 增大

             当 count(mid) > k ，表明 [low, mid] > k，
             high = mid - 1缩小，在 [low,mid] 继续搜索
             当 count(mid) < k ，表明 [mid + 1, high] < k
             low = mid + 1，在 [mid+1,high]搜索
             当 count(mid) == k ，low = mid ，以防 mid + 1 < k
             所以 low = mid

             且有求的是 mid 最大值，所以需要右边界
             当 low + 1 = high 时，mid === low
             而 low = mid 会死循环，所以 mid = (low + high + 1) / 2

         */
        int low = 1;
        while (low < high) {
            int mid = (low + high + 1 )/ 2;
            int count = check(wood, mid);
            if (count < k) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return low;

    }


    private int check (int[] wood, int len) {
        int count = 0;
        for (int w : wood) {
            count += w / len;
        }
        return count;
    }

    public static void main(String[] args) {
        木头切割 res = new 木头切割();
        System.out.println(res.woodCutting(new int[]{4, 7, 2, 10, 5}, 5));
    }
}
