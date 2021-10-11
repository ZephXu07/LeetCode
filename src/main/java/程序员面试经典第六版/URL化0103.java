package 程序员面试经典第六版;

/**
 * Title: URL化0103
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-11
 */
public class URL化0103 {
    public String replaceSpaces(String S, int length) {
        char[] res = S.toCharArray();
        int blank = 0;
        for (int i = 0; i < length; i++) {
            if (res[i] == ' ') {
                blank++;
            }
        }
        int inx = length + 2 * blank - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (res[i] == ' ') {
                res[inx--] = '0';
                res[inx--] = '2';
                res[inx--] = '%';
            } else {
                res[inx--] = res[i];
            }
        }
        return new String(res, 0, length + 2 * blank);
    }

    public static void main(String[] args) {
        URL化0103 res = new URL化0103();
        System.out.println(res.replaceSpaces("Mr John Smith    ", 13));
        System.out.println(res.replaceSpaces("               ", 5));
    }
}
