package 每日一题;

import java.util.*;

/**
 * Title: 猜字谜
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-26
 */
public class 猜字谜 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (String word : words) {
            int bit = getBit(word);
            memo.put(bit, memo.getOrDefault(bit, 0) + 1);
        }
        List<Integer> res = new LinkedList<>();
        for (String puzzle : puzzles) {
            int pBit = getBit(puzzle);
            int first = puzzle.charAt(0) - 'a';
            int n = pBit;
            int count = 0;

            while (n > 0) {
                //((1 << first) & n)得出n第first位的值，即首字母的次数
                if (((1 << first) & n) == 1 && memo.getOrDefault(n, 0) > 0) {
                    count += memo.get(n);
                }
                n = (n - 1) & pBit;
                //得出pBit的所有子集
            }
            res.add(count);
        }
        return res;
    }

    private static int getBit(String str) {
        char[] arr = str.toCharArray();
        int res = 0;
        for (char c : arr) {
            int t = c - 'a';
            res = res | (1 << t);
            //就是这么写，我也不懂，状态压缩，存在字母则为1，z - a, 26位，int
        }
        return res;
    }

}
