package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 把字符串转换成整数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-20
 */
public class 把字符串转换成整数 {
//    public int strToInt(String str) {
//        if (str.length() == 0 ||
//                (str.length() == 1 && !(isNum(str, 0)))) {
//            return 0;
//            //长度为0或者长度为1但不是数字，返回0
//        }
//        int inx = 0;
//        //字符串下标，来得到字符，顺便计算空格数
//        boolean negative = false;
//        while (inx < str.length() && ((str.charAt(inx) == ' '))) {
//            inx ++;
//            //去除前导空格
//        }
//        if (inx == str.length()) {
//            return 0;
//            //发现整个字符串都是空格
//        }
//        if (str.charAt(inx) == '-' || str.charAt(inx) == '+') {
//            negative = str.charAt(inx) == '-';
//            //判断正负号
//            inx ++;
//        }
//        if (!isNum(str, inx)) {
//            return 0;
//            //存在不是数字，则整个字符串非法，返回0
//        }
//        long result = 0;
//        //结果
//        for (; inx < str.length() && isNum(str, inx);inx++) {
//            //当没遍历完字符串且字符是数字时，继续遍历
//            result = result * 10 + (str.charAt(inx) - '0');
//            //计算数值
//            if (result > Integer.MAX_VALUE) {
//                //大于int最大值
//                return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
//                //根据正负返回值
//            }
//        }
//        if (negative) {
//            //同理
//            return (-result) > Integer.MIN_VALUE?(int)(-result):Integer.MIN_VALUE;
//
//        } else {
//            return result < Integer.MAX_VALUE? (int) result :Integer.MAX_VALUE;
//        }
//    }
//
//    private boolean isNum (String s, int inx) {
//        return s.charAt(inx) >= '0' && s.charAt(inx) <= '9';
//    }

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
            res = sign == 1 ? Math.min(res, Integer.MAX_VALUE) : Math.min(res, -(long) Integer.MIN_VALUE);
        } else if ("sign".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    public int getRes() {
        return (int) (sign * res);
    }
}
