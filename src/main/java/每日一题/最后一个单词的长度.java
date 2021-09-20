package 每日一题;

/**
 * Title: 最后一个单词的长度
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-21
 */
public class 最后一个单词的长度 {
    public static int lengthOfLastWord(String s) {
        int res = 0;
        int inx = s.length() - 1;
        while (inx >= 0 && s.charAt(inx) == ' ') {
            inx--;
        }
        if (inx == -1) {
            return 0;
        }
        while (inx >= 0 && s.charAt(inx) != ' ') {
            res++;
            inx--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a"));
    }
}
