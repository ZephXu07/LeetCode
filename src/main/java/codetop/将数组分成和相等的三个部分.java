package codetop;


/**
 * Title: 将数组分成和相等的三个部分
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-04
 */
public class 将数组分成和相等的三个部分 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int s = 0;
        for (int num : arr) {
            s += num;
        }
        if (s % 3 != 0) {
            return false;
        }
        int target = s / 3;
        int n = arr.length, i = 0, cur = 0;
        while (i < n) {
            /*
                找第一部分
             */
            cur += arr[i];
            if (cur == target) {
                break;
            }
            ++i;
        }
        if (cur != target) {
            /*
                判断第一部分是否存在
             */
            return false;
        }
        int j = i + 1;
        while (j + 1 < n) {
            /*
                需要满足最后一个数组非空
                且是前缀和，第一部分和第二部分的和
                所以是两倍
             */
            cur += arr[j];
            if (cur == target * 2) {
                /*
                    剩下的一定是 sum / 3 = target
                 */
                return true;
            }
            ++j;
        }
        return false;
        /*
            否则
         */
    }
}
