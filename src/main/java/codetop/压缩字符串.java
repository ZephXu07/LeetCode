package codetop;

/**
 * Title: 压缩字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-08
 */
public class 压缩字符串 {
    public int compress(char[] chars) {
        int len = chars.length;
        if (len == 1) {
            return 1;
        }

        char pre = chars[0];
        int count = 1;
        int inx = 0;
        /*
            填充的位置
         */
        for (int i = 1; i < len; i++) {
            if (chars[i] == pre) {
                /*
                    统计相同字符
                 */
                count++;
            } else {
                /*
                    字符不一样了
                 */
                chars[inx++] = pre;
                /*
                    填充字符
                 */
                if (count > 1) {
                    /*
                        计数，大于 1 时填充数字
                     */
                    inx = fillNum(chars, count, inx);
                }
                pre = chars[i];
                /*
                    记录新字符
                 */
                count = 1;
                /*
                    归位计数
                 */
            }
        }
        if (count == 1) {
            chars[inx++] = chars[len - 1];
        } else {
            chars[inx++] = pre;
            inx = fillNum(chars, count, inx);
        }
        /*
            最后字符的填充
         */
        return inx;
        /*
            返回长度
         */
    }

    private int fillNum (char[] chars, int count, int inx) {
        /*
            数字填充，再翻转
         */
        int index = inx;
        while (count > 0) {
            int tmp = count % 10;
            chars[index++] = (char) (tmp + '0');
            count /= 10;
        }
        int len = index - inx;
        for (int i = 0; i < len / 2; i++) {
            char tmp = chars[inx + i];
            chars[inx + i] = chars[index - 1 - i];
            chars[index - 1 - i] = tmp;
        }
        return index;
    }

    public static void main(String[] args) {
        压缩字符串 res = new 压缩字符串();
        System.out.println(res.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(res.compress(new char[]{'a'}));
        System.out.println(res.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}
