package codetop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: 最多能完成排序的块二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-19
 */
public class 最多能完成排序的块二 {
//    public int maxChunksToSorted(int[] arr) {
//        int len = arr.length;
//        if (len == 1) {
//            return 1;
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//        int[] sort = new int[len];
//        System.arraycopy(arr, 0, sort, 0, len);
//        Arrays.sort(sort);
//        int res = 0;
//        int count = 0;
//        /*  0 1 2 3 4
//
//            5,4,3,2,1
//            1 2 3 4 5
//
//            0，[5,1] [1,-1] count = 2
//            1, [5,1][4,1] [1,-1][2,-1] count = 4
//            2, [5,1][4,1][3,1] [1,-1][2,-1][3,0] count = 4 + 1 - 1 = 4
//            3, [5,1][4,1][3,1][2,0] [1,-1][2,0][3,0][4,0] count = 4 - 1 - 1 = 2
//            4, [5,1][4,1][3,1][2,0][1,0] [1,0][2,0][3,0][4,0][5,0] count = 2 - 1 - 1 = 0    res++  = 1
//
//            0 1 2 3 4
//
//            2,1,3,4,4
//            1 2 3 4 4
//
//            0   [2,1]   [1,-1]      count = 2
//            1   [2,1][1,0]      [1,0][2,0]      count = 2 - 1 - 1 = 0   res ++ = 1
//            2   [1,0][2,0][3,1]     [1,0][2,0][3,0] count = 0 + 1 - 1 = 0   res ++ == 2
//            3   [1,0][2,0][3,0][4,1]        [1,0][2,0][3,0][4,0]    count = 0 + 1 - 1 = 0   res ++  = 3
//            4   [1,0][2,0][3,0][4,1]        [1,0][2,0][3,0][4,0]    count = 0 + 1 - 1 = 0   res ++  = 4
//
//
//         */
//        for (int i = 0; i < len; i++) {
//            int x = arr[i];
//            int y = sort[i];
//
//            int xFreq = map.getOrDefault(x, 0) + 1;
//            map.put(x, xFreq);
//
//            if (xFreq == 0) {
//                count--;
//            } else if (xFreq == 1) {
//                count++;
//            }
//
//            int yFreq = map.getOrDefault(y, 0) - 1;
//            map.put(y, yFreq);
//
//            if (yFreq == 0) {
//                count--;
//            } else if (yFreq == -1) {
//                count++;
//            }
//
//            if (count == 0) {
//                res++;
//            }
//
//
//        }
//        return res;
//    }


    public int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return 1;
        }

        int[] sort = new int[len];
        System.arraycopy(arr, 0, sort, 0, len);
        Arrays.sort(sort);
        int res = 0;
        int sum = 0;
        /*  0 1 2 3 4

            5,4,3,2,1
            1 2 3 4 5

            0，sum=0+5=5   sum=5-1=4
            1, sum=4+4=8    sum=8-2=6
            2, sum=6+3=9    sum=9-3=6
            3, sum=6+2=8    sum=8-4=4
            4, sum=4+1=5    sum=5-5=0   res++  = 1

            0 1 2 3 4

            2,1,3,4,4
            1 2 3 4 4

            0  sum=0+2=2    sum=2-1=1
            1  sum=1+1=2    sum=2-2=0    res ++ = 1
            2  sum=0+3=3    sum=3-3=0    res ++ == 2
            3  sum=0+4=4    sum=4-4=0    res ++  = 3
            4  sum=0+4=4    sum=4-4=0       res ++  = 4


         */
        for (int i = 0; i < len; i++) {
            int x = arr[i];
            int y = sort[i];

            sum += x;
            sum -= y;

            if (sum == 0) {
                res++;
            }


        }
        return res;
    }
}
