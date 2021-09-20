package codetop;

/**
 * Title: 最多能完成排序的块
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-19
 */
public class 最多能完成排序的块 {
    public int maxChunksToSorted(int[] arr) {
        /*
            值是下标 [0,len-1] 的排列
            贪心
            找到更大的数，如果此时数与下标相同即表示 [0,max]是一个块的
            如 0 1 2 3 4
               1 0 3 2 4
               [0,3] 的最大值是 3 ,其出现在下标 3 之前，
               所以[0,3]乱序了，直接为一块

         */
        int len = arr.length;
        int res = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, arr[i]);
            res += max == i ? 1 : 0;
        }
        return res;
    }


    public static void main(String[] args) {
        最多能完成排序的块 res = new 最多能完成排序的块();
        System.out.println(res.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(res.maxChunksToSorted(new int[]{1,0,2,3,4}));
        System.out.println(res.maxChunksToSorted(new int[]{1,0,2,3}));
    }
}
