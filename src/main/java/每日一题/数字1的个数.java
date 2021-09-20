package 每日一题;

/**
 * Title: 数字1的个数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-13
 */
public class 数字1的个数 {
    public int countDigitOne(int n) {
        /*
            5678
         个位    cur = 8
                low = 0
                high = 567
                res = 0
                pow = 1
                [0001, 5671]
                固定最后一位，[000,567]一共有 568 个选择，
                因为 cur = 8，属于情况 3
                即 (high + 1) * pow = 568 * 1 = 568

      十位       res += 568
                low += cur * pow = 8
                cur = high % 10 = 7
                high /= 567 / 10 = 56
                pow = 10
                [0010,5619]
                因为 cur = 7 属于其他情况
                固定十位，[000,569]一共有 570 个选择
                即 (high + 1) * pow = 57 * 10 = 570

       百位      res += 570 = 1138
                low += cur * pow = 87
                cur = high % 10 = 6
                high /= 10 = 5
                pow = 100
                [0100,5199]
                固定百位，[000,599]一共有 600 个选择
                因为 cur = 7 属于其他情况
                即 (high + 1) * 100 = 600

        千位     res += 1738
                low += cur * pow = 687
                cur = 5
                high = 0
                pow = 1000
                [1000,1999]
                固定千位，[000,999]一共 1000 个选择
                因为 cur = 5 属于其他情况
                即 (high + 1) * 1000 = 1000

        最后 cur = 0, high = 0，结束运行，此时 res = 2738


        举例情况 0
            2304 求十位
             low = 4
             high = 23
             pow = 10
             [0010, 2219]
             固定十位，[000,229] 一共 230 个选择
             cur = 0，情况 0
             high * pow = 230

        举例情况 1
            7186  求百位
            low = 86
            high = 7
            pow = 100
            [0100,7186]
             固定百位，[000,786] 一共 787 选择
             cur = 1，情况 1
             high * pow + low + 1 = 7 * 100 + 86 + 1 = 787
         */
        int cur = n % 10;
        int low = 0;
        int high = n / 10;
        int res = 0;
        int pow = 1;

        while (cur != 0 || high != 0) {
            switch (cur) {
                case 0:
                    res += high * pow;
                    break;
                case 1:
                    res += high * pow + low + 1;
                    break;
                default:
                    res += (high + 1) * pow;
                    break;
            }
            low += cur * pow;
            cur = high % 10;
            high /= 10;
            pow *= 10;
        }
        return res;

    }

    public static void main(String[] args) {
        数字1的个数 res = new 数字1的个数();
        System.out.println(res.countDigitOne(5678));
    }
}
