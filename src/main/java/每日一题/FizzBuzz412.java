package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: FizzBuzz412
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-13
 */
public class FizzBuzz412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
