package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 直线上最多的点数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-24
 */
public class 直线上最多的点数 {
    public int maxPoints(int[][] points) {
        int len = points.length;
        // 多少个点
        if (len <= 2) {
            return len;
            /*
                1 - 2 个点数都可以用一条直线划分，因此多少点数直线上就最多多少
             */
        }
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            if (res >= len - i || res > len / 2) {
                //因为是枚举的，所以点只需要算一次，在前在后一样
                //此点是第 i 个，后面最多为 len - i，如果现在计算的red 大于等于 len - i了，可以不用再计算
                //同理，如果现在得到的 res 已经大于一半的数目了，后面的也不会比现在多
                break;
            }
            Map<String, Integer> map = new HashMap<>(len - i);
            /*
                枚举每一个点与后续的点的斜率， i < len - 1，j = i + 1，j < len
                为避免精度差，此处求出最简分式，即
                分子分母同除以最大公因数，得到最简表达式，斜率相同的话最简表达式也会相同，
             */
            int max = 0;
            for (int j = i + 1; j < len; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int a = x1 - x2;
                int b = y1 - y2;
                //得到分子与分母

                int g = gcd(a, b);
                //最大公因数

                String key = a / g + "_" + b / g;
                //最简表达式
                map.put(key, map.getOrDefault(key, 0) + 1);
                //记录多少个泄露相同
                max = Math.max(max, map.get(key));
                //取出记录最多的次数
            }
            res = Math.max(res, max + 1);
            //加上与起始点的次数再比较
        }

        return res;

    }

    private int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
        //辗转相除求最大公因数
        //https://baike.baidu.com/item/%E6%9C%80%E5%A4%A7%E5%85%AC%E7%BA%A6%E6%95%B0/869308?fromtitle=%E6%9C%80%E5%A4%A7%E5%85%AC%E5%9B%A0%E6%95%B0&fromid=869104&fr=aladdin
    }
}
