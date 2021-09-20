package 剑指offer;

/**
 * Title: 翻转单词的顺序
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-05
 */
public class 翻转单词的顺序 {
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return "";
        }
        int j = 0;
        while (s.charAt(j) == ' ') {
            j++;
            if (j == s.length()) {
                return "";
            }
        }
        String[] tmp = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = tmp.length - 1; i >= 0; i--) {
            if (tmp[i].length() != 0) {
                builder.append(tmp[i]).append(" ");
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static void main(String[] args) {
        翻转单词的顺序 res = new 翻转单词的顺序();
        System.out.println(res.reverseWords("the sky is blue"));
        System.out.println("------");
        System.out.println(res.reverseWords("  hello world!  "));
        System.out.println("------");
        System.out.println(res.reverseWords("a good   example"));
        System.out.println("------");
    }
}
