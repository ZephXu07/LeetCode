package 剑指offer;

/**
 * Title: 左旋转字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-05
 */
public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
//        StringBuilder res = new StringBuilder();
//        for (int i = n; i < s.length(); i++) {
//            res.append(s.charAt(i));
//        }
//        for (int i = 0; i < n; i++) {
//            res.append(s.charAt(i));
//        }
//        return res.toString();
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }
}
