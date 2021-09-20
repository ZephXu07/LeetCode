package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 把字符串转换成整数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-07
 */
public class 把字符串转换成整数 {
    public int strToInt(String str) {
        FiniteStateMachine machine = new FiniteStateMachine();
        for (int i = 0; i < str.length(); i++) {
            machine.setState(str.charAt(i));
        }
        return machine.getRes();
    }
}
class FiniteStateMachine {
    private long res;
    private String state;
    private int sign;
    private Map<String, String[]> table;
    public FiniteStateMachine () {
        res = 0;
        sign = 1;
        state = "start";
        table = new HashMap<String, String[]>() {
            {
                put("start", new String[]{"start", "sign", "number", "end"});
                put("sign", new String[]{"end", "end", "number", "end"});
                put("number", new String[]{"end", "end", "number", "end"});
                put("end", new String[]{"end", "end", "end", "end"});
            }
        };
    }

    private int getStateIndex(char c) {
        if (' ' == c) {
            return 0;
        }
        if ('+' == c || '-' == c) {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }

    public void setState(char c) {
        state = table.get(state)[getStateIndex(c)];
        if ("number".equals(state)) {
            res = res * 10 + c - '0';
            res = sign == 1 ? Math.min(res, (long)Integer.MAX_VALUE) : Math.min(res, -(long) Integer.MIN_VALUE);
        } else if ("sign".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    public int getRes() {
        return (int) (sign * res);
    }
}