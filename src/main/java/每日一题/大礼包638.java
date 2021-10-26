package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: 大礼包638
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-24
 */
public class 大礼包638 {


    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();

        /*
            过滤不需要计算的大礼包，
            只保留需要计算的大礼包
         */
        List<List<Integer>> filterSpecial = new ArrayList<>(special.size());
        for (List<Integer> sp : special) {
            int totalCount = 0, totalPrice = 0;
            for (int i = 0; i < n; ++i) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if (totalCount > 0 && totalPrice > sp.get(n)) {
                /*
                    礼包存在物品
                    且物品的日常购买价格大于礼包价格
                 */
                filterSpecial.add(sp);
            }
        }
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(price, needs, filterSpecial, n, memo);
    }

    /*
        记忆化搜索计算满足剩下清单所需花费的最低价格
     */
    public int dfs(List<Integer> price, List<Integer> curNeeds,
                   List<List<Integer>> filterSpecial, int n, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(curNeeds)) {
            return memo.get(curNeeds);
        }
        int minPrice = 0;
        for (int i = 0; i < n; ++i) {
            minPrice += curNeeds.get(i) * price.get(i);
            /*
                不购买任何大礼包，原价购买剩下清单中的所有物品
             */
        }

        for (List<Integer> curSpecial : filterSpecial) {
            int specialPrice = curSpecial.get(n);
            List<Integer> nxtNeeds = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                if (curSpecial.get(i) > curNeeds.get(i)) {
                    /*
                        不能购买超出购物清单指定数量的物品
                        否则跳过此礼包
                     */
                    break;
                }
                nxtNeeds.add(curNeeds.get(i) - curSpecial.get(i));
            }
            if (nxtNeeds.size() == n) {
                /*
                    大礼包可以购买
                 */
                minPrice = Math.min(minPrice,
                        dfs(price, nxtNeeds, filterSpecial, n, memo) + specialPrice);
            }
        }
        memo.put(curNeeds, minPrice);
        return memo.get(curNeeds);
    }
}

