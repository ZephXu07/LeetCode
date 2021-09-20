package 每日一题;

/**
 * Title: 替换隐藏数字得到的最晚时间
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-24
 */
public class 替换隐藏数字得到的最晚时间 {
    public String maximumTime(String time) {
        char[] t = time.toCharArray();
        StringBuilder res = new StringBuilder();
        if (t[1] == '?') {
            if (t[0] == '?' || t[0] == '2') {
                res.append('2').append('3');
            } else {
                res.append(t[0]).append('9');
            }
        } else {
            if (t[0] != '?') {
                res.append(t[0]).append(t[1]);
            } else {
                if ('0' <= t[1] && t[1] <= '3') {
                    res.append('2').append(t[1]);
                } else {
                    res.append('1').append(t[1]);
                }
            }
        }
        res.append(':');

        if (t[3] == '?') {
            res.append('5');
        } else {
            res.append(t[3]);
        }

        if (t[4] == '?') {
            res.append('9');
        } else {
            res.append(t[4]);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        替换隐藏数字得到的最晚时间 res = new 替换隐藏数字得到的最晚时间();
        System.out.println(res.maximumTime("2?:?0"));
    }
}
