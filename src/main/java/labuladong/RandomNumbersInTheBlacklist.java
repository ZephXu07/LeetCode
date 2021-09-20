package labuladong;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Title: labuladong.RandomNumbersInTheBlacklist
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-24
 */
public class RandomNumbersInTheBlacklist {
    private int size;
    private Map<Integer, Integer> mapping;
    private Random random;
    public RandomNumbersInTheBlacklist(int N, int[] blacklist) {
        random = new Random();
        mapping = new HashMap<>();
        this.size = N - blacklist.length;
        for (int b:blacklist) {
            mapping.put(b, b);
        }
        int last = N - 1;
        for (int b:blacklist) {
            if (b >= size) {
                continue;
            }
            while (mapping.containsKey(last)) {
                last --;
            }
            mapping.put(b, last);
            last --;
        }
    }

    public int pick() {
        int index = random.nextInt(size);
        return mapping.getOrDefault(index, index);
    }
}
