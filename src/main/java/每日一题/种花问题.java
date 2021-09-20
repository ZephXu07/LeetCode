package 每日一题;

/**
 * Title: 种花问题
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-01
 */
public class 种花问题 {
//    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        int len = flowerbed.length;
//        if ((len + 1) / 2 < n ) {
//            return false;
//        }
//        if (n == 0) {
//            return true;
//        }
//        if (len == 1) {
//            return flowerbed[0] == 0 && n == 1;
//        }
//        int pre = 1;
//        int cur = 0;
//        while (pre < len) {
//            if (flowerbed[cur] == 1 && flowerbed[pre] == 0) {
//                cur = pre + 1;
//                pre = pre + 2;
//            } else if (flowerbed[cur] == 0 && flowerbed[pre] == 0) {
//                n --;
//                cur = pre + 1;
//                pre = pre + 2;
//            } else if (flowerbed[cur] == 0 && flowerbed[pre] == 1) {
//                cur = pre + 2;
//                pre = pre + 3;
//            }
//        }
//        if (cur == len - 1 && flowerbed[cur] == 0) {
//            n --;
//        }
//        return n <= 0;
//    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if ((len + 1) / 2 < n ) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        if (len == 1) {
            return flowerbed[0] == 0 && n == 1;
        }
        // 每次跳两格
        for (int i = 0; i < len; i += 2) {
            // 如果当前为空地
            if (flowerbed[i] == 0) {
                // 如果是最后一格或者下一格为空
                if (i == len - 1 || flowerbed[i + 1] == 0) {
                    n--;
                } else {
                    i++;
                }
            }
        }
        return n <= 0;
    }


    public static void main(String[] args) {
        种花问题 res = new 种花问题();
        int[] flowerbed = {1,0,0,0,1};
        int n = 1;
        System.out.println(res.canPlaceFlowers(flowerbed, n));
    }
}
