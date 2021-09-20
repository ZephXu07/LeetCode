package codetop;

import javax.xml.soap.SAAJResult;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 括号生成
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-24
 */
public class 括号生成 {
    private List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        backtrack(builder, n, n);
        return res;
    }

    private void backtrack (StringBuilder builder, int left, int right) {
        /*
            有效的时候左右括号数量是相等了
            此处需要剩下的括号，即最后到达 n 对的时候剩下都为 0 才是正确的
            又有个条件，无论什么时候，剩下的左括号的数量是小于等于剩下的右括号的数量

         */
        if (left == 0 && right == 0) {
            //相等时是有效的，加入
            res.add(builder.toString());
            return;
        }
        if (left < 0 || right < 0) {
            //不符合，直接返回
            return;
        }
        if (left == right) {
            //剩下左右相等时，一定是左括号先使用
            builder.append("(");
            backtrack(builder, left - 1, right);
            builder.deleteCharAt(builder.length() - 1);
        } else if (left < right){
            //剩下的左括号的数量是小于等于剩下的右括号的数量
            if (left > 0) {
                //此时剩下的左括号大于 0 至少为 1 个时，还可以使用左括号
                builder.append("(");
                backtrack(builder, left - 1, right);
                builder.deleteCharAt(builder.length() - 1);
            }
            //使用右括号
            builder.append(")");
            backtrack(builder, left, right - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        括号生成 res = new 括号生成();
        int n = 3;
        long t1 = System.currentTimeMillis();
        List<String> list = res.generateParenthesis(n);
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        for (String s : list) {
            System.out.println(s);
        }
    }

}
