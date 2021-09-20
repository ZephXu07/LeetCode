package 每日一题;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * Title: 最大频率栈
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-22
 */
public class 最大频率栈 {

}
class FreqStack {
    private int maxFreq;
    private Map<Integer, Integer> valFreq;
    private Map<Integer, Stack<Integer>> freqStack;

    public FreqStack() {
        maxFreq = 0;
        valFreq = new HashMap<>();
        freqStack = new HashMap<>();
    }

    public void push(int x) {
        int freq = valFreq.getOrDefault(x, 0) + 1;
        valFreq.put(x, freq);
        Stack<Integer> tmp;
        if (!freqStack.containsKey(freq)) {
            tmp = new Stack<Integer>();
        } else {
            tmp = freqStack.get(freq);
        }
        tmp.push(x);
        freqStack.put(freq, tmp);
        maxFreq = Math.max(freq, maxFreq);

    }

    public int pop() {
        Stack<Integer> tmp = freqStack.get(maxFreq);
        int val = tmp.pop();
        valFreq.put(val, maxFreq - 1);
        if (tmp.empty()) {
            maxFreq --;
        }
        return val;
    }
}
