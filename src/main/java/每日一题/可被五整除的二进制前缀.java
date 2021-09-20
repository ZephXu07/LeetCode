package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 可被五整除的二进制前缀
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-18
 */
public class 可被五整除的二进制前缀 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int sum = 0;
        for (int x : A) {
            sum = ((sum * 2) + x) % 5;
            res.add(sum == 0);
        }
        return res;
    }
}
