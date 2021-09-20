package 每日一题;

/**
 * Title: 删除字符串中的所有相邻重复项
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-09
 */
public class 删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String S) {
        StringBuilder builder = new StringBuilder(S);
        int cur = 0;
        while (cur < builder.length() - 1) {
            if (builder.charAt(cur) == builder.charAt(cur + 1)) {
                builder.delete(cur, cur + 2);
                cur = cur == 0 ? 0 : cur - 1;
            } else {
                cur++;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        删除字符串中的所有相邻重复项 res = new 删除字符串中的所有相邻重复项();
        String S = "abbaca";
        System.out.println(res.removeDuplicates(S));
    }
}
