package 每日一题;

/**
 * Title: Excel表列序号
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-30
 */
public class Excel表列序号 {
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int res = 0;
        int mul = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            res += mul * (chars[i] - 'A' + 1);
            mul *= 26;
        }
        return  res;
    }

    public static void main(String[] args) {
        Excel表列序号 res = new Excel表列序号();
        String s = "AB";
        System.out.println(res.titleToNumber(s));
        s = "AA";
        System.out.println(res.titleToNumber(s));
        s = "ZY";
        System.out.println(res.titleToNumber(s));
    }
}
