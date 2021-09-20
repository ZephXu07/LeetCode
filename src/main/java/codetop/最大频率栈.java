package codetop;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Deque;

/**
 * Title: 最大频率栈
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-08
 */
public class 最大频率栈 {
}
class FreqDeque {

    private int maxFreq;
    private Map<Integer, Integer> valFreq;
    /*
        值对应的频率
     */
    private Map<Integer, Deque<Integer>> freqDeque;
    /*
        频率对应的那些值（栈，栈底到栈顶）
     */

    public FreqDeque() {
        maxFreq = 0;
        valFreq = new HashMap<>();
        freqDeque = new HashMap<>();
    }

    public void push(int x) {
        int freq = valFreq.getOrDefault(x, 0) + 1;
        valFreq.put(x, freq);
        /*
            更新值的频率
         */
        Deque<Integer> tmp;
        if (!freqDeque.containsKey(freq)) {
            tmp = new LinkedList<>();
        } else {
            tmp = freqDeque.get(freq);
        }
        /*
            频率对应的栈是否存在，不在则new
         */
        tmp.push(x);
        freqDeque.put(freq, tmp);
        maxFreq = Math.max(freq, maxFreq);
        /*
            放进 值 - 频率 哈希表
            频率 - 栈 哈希表
            更新最大频率
         */
    }

    public int pop() {
        Deque<Integer> tmp = freqDeque.get(maxFreq);
        int val = tmp.pop();
        /*
            找到最大频率对应的栈，弹出栈顶元素
         */
        valFreq.put(val, maxFreq - 1);
        /*
            更新值对应的频率
         */
        if (tmp.isEmpty()) {
            /*
                如果最高的频率的对应栈只有一个元素
                则最高频率自减一
             */
            maxFreq --;
        }
        return val;
    }
}
