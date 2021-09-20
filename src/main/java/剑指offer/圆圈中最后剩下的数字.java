package 剑指offer;

/**
 * Title: 圆圈中最后剩下的数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-07
 */
public class 圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        // ArrayList<Integer> list = new ArrayList<>(n);
        // for (int i = 0; i < n; i++) {
        //     list.add(i);
        // }
        // int index = 0;
        // while (n > 1) {
        //     index = (index + m - 1) % n;
        //     list.remove(index);
        //     n--;
        // }
        // return list.get(0);

        int res = 0;
        for (int i = 2; i <= n; ++i) {
            res = (res + m) % i;
        }
        return res;
    }
}
