package codetop;

/**
 * Title: 重构字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-30
 */
public class 重构字符串 {
    public String reorganizeString(String S) {
        // /*
        //     计算字符串次数，不符合要求的肯定不能重构
        //     假设长度为6时字符串
        //     0 1 2 3 4 5
        //     *   *   *
        //     0 2 4坐标放置次数最多的字符，其余位放置剩下的字符，当此字符次数再加一时便不合要求
        //     长度6，次数最多3

        //     假设长度为7时字符串
        //     0 1 2 3 4 5 6
        //     *   *   *   *
        //     0 2 4 6坐标放置次数最多的字符，其余位放置剩下的字符，当此字符次数再加一时便不合要求
        //     长度7，次数最多4

        //     即
        //     max：某一字符重复的最多次
        //     len；字符串长度
        //     max > (len + 1) / 2 （整数除法）
        //     时直接返回空字符串

        //     重构字符串，最大堆，将上述的字符放到堆里，按次数排序
        //     每次取2个字符，最大与次大，加入结果
        //     重新计算这两个字符的次数，次数大于 0 再加入最大堆里

        //     不断重复，直到堆里字符剩下 一个 或者 零个
        //     一个是因为字符串长度为奇数，需要将其加入结果
        //     零个是偶数

        //  */
        // int[] freq = new int[26];

        // int len = S.length();

        // int max = 0;
        // for (int i = 0; i < len; i++) {
        //     freq[S.charAt(i) - 'a']++;
        //     max = Math.max(max, freq[S.charAt(i) - 'a']);
        // }

        // if (max > (len + 1) / 2) {
        //     return "";
        // }

        // PriorityQueue<Character> heap = new PriorityQueue<>(
        //         (c1, c2)-> freq[c2 - 'a'] - freq[c1 - 'a']);

        // for (char c = 'a'; c <= 'z'; c++) {
        //     if (freq[c - 'a'] != 0) {
        //         heap.offer(c);
        //     }
        // }
        // StringBuilder res = new StringBuilder();

        // while (heap.size() > 1) {
        //     char c1 = heap.poll();
        //     char c2 = heap.poll();

        //     res.append(c1).append(c2);

        //     if (--freq[c1 - 'a'] > 0) {
        //         heap.offer(c1);
        //     }

        //     if (--freq[c2 - 'a'] > 0) {
        //         heap.offer(c2);
        //     }
        // }

        // if (heap.size() == 1) {
        //     res.append(heap.poll());
        // }


        // return res.toString();


        /*

            如果字母的出现次数大于 0 且小于或等于 n/2，且 oddIndex （奇数）没有超出数组下标范围，
            则将字母放置在oddIndex，然后将oddIndex 的值加 2。

            如果字母的出现次数大于 n/2，或 oddIndex 超出数组下标范围，
            则将字母放置在 evenIndex（偶数），然后将 evenIndex 的值加 2。
            012
            aab

            0 1 2
            a
            a   a
            a b a

            0 1 2 3 4
            z h m y o

              h
              h   m
            o h y m z
         */
        int[] freq = new int[26];

        int len = S.length();

        int max = 0;
        for (int i = 0; i < len; i++) {
            int inx = S.charAt(i) - 'a';
            freq[inx]++;
            max = Math.max(max, freq[inx]);
        }

        if (max > (len + 1) / 2) {
            return "";
        }

        char[] res = new char[len];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = len / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (freq[i] > 0 && freq[i] <= halfLength && oddIndex < len) {
                res[oddIndex] = c;
                freq[i]--;
                oddIndex += 2;
            }
            while (freq[i] > 0) {
                res[evenIndex] = c;
                freq[i]--;
                evenIndex += 2;
            }
        }
        return new String(res);
    }
}
