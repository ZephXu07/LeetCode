package 每日一题;

/**
 * Title: 猜数字游戏299
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-08
 */
public class 猜数字游戏299 {
    public String getHint(String secret, String guess) {
        int[] sec = new int[10];
        int[] gue = new int[10];
        int[] rig = new int[10];
        int right = 0;
        int len = secret.length();
        for (int i = 0; i < len; i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            sec[s]++;
            gue[g]++;
            if (s == g) {
                right++;
                rig[s]++;
            }
        }
        int y = 0;
        for (int i = 0; i < 10; i++) {
            if (sec[i] > 0 && gue[i] > 0) {
                y += Math.min(sec[i], gue[i]) - rig[i];
            }
        }
        return right + "A" + y + "B";
    }

    public static void main(String[] args) {
        猜数字游戏299 res = new 猜数字游戏299();
        System.out.println(res.getHint("1807", "7810"));
        System.out.println(res.getHint("1123", "0111"));
        System.out.println(res.getHint("1", "0"));
        System.out.println(res.getHint("1", "1"));
        System.out.println(res.getHint("11", "10"));
    }
}
