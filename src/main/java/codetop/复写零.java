package codetop;

/**
 * Title: 复写零
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-13
 */
public class 复写零 {
    public void duplicateZeros(int[] arr) {
        int count = 0;
        int i = 0;
        while (i + count < arr.length) {
            /*
                统计 0 个数
                与从右往左遍历的起始位置
                其右方的值就被抛弃与覆盖
             */
            if (arr[i] == 0) {
                count ++;
            }
            i ++;
        }
        i --;
        /*
            因为不符合的时候 i 多了一位
         */
        int j = arr.length - 1;
        /*
            复写的起始位置
         */
        if (count + i + 1 > arr.length ) {
            /*
                在边界的 0 不能再复写一次
                更新相应下标和需要复写 0 的个数
             */
            arr[j] = 0;
            j--;
            i--;
            count--;
        }
        while (count > 0) {
            /*
                直到复写的 0 结束
             */
            arr[j] = arr[i];
            j--;
            if (arr[i] == 0) {
                /*
                    i 位置是 0，复写一次，j已经往左了
                    arr[j] 再为 0，更新 j 与 count
                 */
                arr[j] = arr[i];
                j--;
                count--;
            }
            i--;
        }
    }

    public static void main(String[] args) {
        复写零 res = new 复写零();
        res.duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
    }
}
