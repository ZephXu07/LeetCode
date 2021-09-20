package codetop;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 文本左右对齐
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-09
 */
public class 文本左右对齐 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        int len = words.length;
        int right = 0;
        /*
            已经遍历到的单词位置
         */
        while (true) {
            int left = right;
            /*
                当前行单词起始位置
             */
            int sum = 0;
            /*
                当前行的单词的总长度
                不包含单词间的空格
                已计算长度 + 新单词的长度 + (right+1)-left个单词的至少一个空格的间隔，总 right - left 个
                必须小于等于给定的长度
             */
            while (right < len && sum + words[right].length() + right - left <= maxWidth) {
                sum += words[right].length();
                right++;
            }

            if (right == len) {
                /*
                    到最后一个单词了，
                    即到了最后一行
                    左对齐，单词间一个空格
                 */
                StringBuilder builder = fillLine(words, left, right, " ");
                /*
                    fillLine 左闭右开
                 */
                builder.append(fillBlank(maxWidth - builder.length()));
                /*
                    填充剩余长度的空格
                 */
                res.add(builder.toString());

                return res;
                /*
                    最后的单词，返回
                 */
            }

            int totalWord = right - left;
            int totalBlank = maxWidth - sum;
            /*
                单词数与空格总数
             */
            if (totalWord == 1) {
                /*
                    当前行只有一个单词，右侧填充空格
                 */
                res.add(words[left] + fillBlank(totalBlank));
                continue;

            }

            int wordBlank = totalBlank / (totalWord - 1);
            String blank = fillBlank(wordBlank);
            /*
                单词间空格
             */
            int remainBlank = totalBlank % (totalWord - 1);
            /*
                额外的空格
                即有此数的空格长度应该加一
                所以左侧部分空格比右侧多
             */
            StringBuilder builder = new StringBuilder();
            builder.append(fillLine(words, left, left + remainBlank + 1, blank + " "));
            /*
                fillLine 左闭右开
                且右边界没有空格，需额外添加
            */
            builder.append(blank);
            builder.append(fillLine(words, left + remainBlank + 1, right, blank));

            res.add(builder.toString());


        }

    }

    private String fillBlank(int len) {
        /*
            生成 n 个空格
         */
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            res.append(' ');
        }
        return res.toString();
    }

    private StringBuilder fillLine (String[] words, int left, int right, String blank) {
        /*
            [left, right)
         */
        StringBuilder res = new StringBuilder(words[left]);
        for (int i = left + 1; i < right; i++) {
            res.append(blank).append(words[i]);
            /*
                填充完整一行的，末尾没有空格
                这样写方便处理
             */
        }
        return res;
    }


    public static void main(String[] args) {
        文本左右对齐 res = new 文本左右对齐();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        res.fullJustify(words ,16).forEach(System.out::println);
    }
}
