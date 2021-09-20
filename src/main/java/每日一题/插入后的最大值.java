package 每日一题;

/**
 * Title: 插入后的最大值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-01
 */
public class 插入后的最大值 {
    public String maxValue(String n, int x) {
        int inx;
        StringBuilder sb = new StringBuilder();
        if (n.charAt(0) == '-') {
            inx = 1;
            sb.append("-");
            while (inx < n.length() && n.charAt(inx) - '0' <= x) {
                sb.append(n.charAt(inx));
                inx++;
            }
        } else {
            inx = 0;
            while (inx < n.length() && n.charAt(inx) - '0' >= x) {
                sb.append(n.charAt(inx));
                inx++;
            }
        }
        sb.append(x);
        sb.append(n.substring(inx));
        return sb.toString();
    }


    public static void main(String[] args) {
        插入后的最大值 res = new 插入后的最大值();
//        String n = "99";
//        int x = 9;
//        String n = "-13";
//        int x = 2;
//        String n = "73";
//        int x = 6;
        String n = "-55";
        int x = 2;
        System.out.println(res.maxValue(n, x));
    }
}
