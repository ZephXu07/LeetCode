package codetop;

/**
 * Title: 翻转单词顺序
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-07
 */
public class 翻转单词顺序 {
    public String reverseWords(String s) {
        s = s.trim();
        /*
            删除首尾空格
         */
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
                /*
                 搜索首个空格

                 */
            }
            res.append(s, i + 1, j + 1).append(" ");
            /*
                添加单词
             */
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
                /*
                    跳过单词间空格
                 */
            }
            j = i;
            /*
                j 指向下个单词的尾字符
             */
        }
        return res.toString().trim();
        /*
            转化为字符串并返回
         */
    }

}
