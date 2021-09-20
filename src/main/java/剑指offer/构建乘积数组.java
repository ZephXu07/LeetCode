package 剑指offer;

/**
 * Title: 构建乘积数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-06
 */
public class 构建乘积数组 {
    public int[] constructArr(int[] a) {
        if (null == a || a.length == 0) {
            return new int[0];
        }
        int len = a.length;
        int[] left = new int[len];
        left[0] = 1;
//        int[] right = new int[len];
//        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        int tmp = 1;
        for (int i = len - 2; i >= 0; i--) {
//            right[i] = right[i + 1] * a[i + 1];
            tmp *= a[i + 1];
            left[i] *= tmp;
        }
//        for (int i = 0; i < len; i++) {
//            left[i] = left[i] * right[i];
//        }
        return left;
    }
}
