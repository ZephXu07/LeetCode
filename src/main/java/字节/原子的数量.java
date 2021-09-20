package 字节;

import java.util.*;

/**
 * Title: 原子的数量
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-20
 */
public class 原子的数量 {
    private int i;
    public String countOfAtoms(String formula) {
        StringBuilder ans = new StringBuilder();
        i = 0;
        Map<String, Integer> count = parse(formula);
        //解析完成
        for (String name: count.keySet()) {
            //遍历字母
            ans.append(name);
            int multiplicity = count.get(name);
            if (multiplicity > 1) {
                //数量大于1需要写明
                ans.append("" + multiplicity);
            }
        }
        return new String(ans);
    }

    public Map<String, Integer> parse(String formula) {
        int N = formula.length();
        Map<String, Integer> count = new TreeMap();
        while (i < N && formula.charAt(i) != ')') {
            //还没遍历结束或者没遇见右括号
            if (formula.charAt(i) == '(') {
                //遇到左括号，进入递归
                i++;
                for (Map.Entry<String, Integer> entry: parse(formula).entrySet()) {
                    //得到括号里的原子的map，添加进括号外的map里
                    count.put(entry.getKey(), count.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            } else {
                int iStart = i++;
                //肯定第一个字母为大写
                while (i < N && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                //判断多少个小写字母
                //无论是N 或者 Mg都算一个原子，数量为1或者更大都代表这个原子数目
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < N && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                int multiplicity = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                //数量大于1
                count.put(name, count.getOrDefault(name, 0) + multiplicity);
            }
        }
        //遍历结束或者遇到右括号
        int iStart = ++i;
        while (i < N && Character.isDigit(formula.charAt(i))){
            //遇到右括号，说明右边肯定是数目
            i++;
        }
        if (iStart < i) {
            //如果有数字则证明这是计算括号里面原子而不是一个没有括号的化学式，所以此方法计算的原子数全部乘以数目
            int multiplicity = Integer.parseInt(formula.substring(iStart, i));
            for (String key: count.keySet()) {
                count.put(key, count.get(key) * multiplicity);
            }
        }
        return count;
        //返回计算的原子数
    }


    public static void main(String[] args) {
        原子的数量 res = new 原子的数量();
        String formula = "Cl2";
        System.out.println(res.countOfAtoms(formula));
    }

}
