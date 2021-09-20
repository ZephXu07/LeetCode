package 每日一题;

import java.util.*;

/**
 * Title: 前K个高频单词
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-20
 */
public class 前K个高频单词 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
                (e1,e2)-> {
                    if (!e1.getValue().equals(e2.getValue())) {
                        return e1.getValue() - e2.getValue();
                    } else {
                        return e2.getKey().compareTo(e1.getKey());
                    }
                }
        );

        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            if (heap.size() < k) {
                heap.offer(e);
            } else {
                if (heap.peek().getValue() < e.getValue()) {
                    heap.poll();
                    heap.offer(e);
                } else if (heap.peek().getValue().equals(e.getValue())) {
                    if (e.getKey().compareTo(heap.peek().getKey()) < 0) {
                        heap.poll();
                        heap.offer(e);
                    }
                }
            }
        }

        List<String> res = new ArrayList<>(heap.size());
        while (!heap.isEmpty()) {
            res.add(heap.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }


    public static void main(String[] args) {
        前K个高频单词 res = new 前K个高频单词();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 1;
        final List<String> list = res.topKFrequent(words, k);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
