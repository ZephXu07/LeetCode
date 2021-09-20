package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 有效数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-17
 */
public class 有效数字 {
    private Map<Character, Integer>[] maps;
    private static final Character A = 'N';
    private static final Character B = '+';
    private static final Character C = 'C';
    private static final Character D = '.';
    private static final Character E = 'a';

    public 有效数字 () {
        maps = new Map[10];
        for (int i = 0; i < 10; i++) {
            maps[i] = new HashMap();
        }
        maps[0].put(A, 1);
        maps[0].put(B, 4);
        maps[0].put(C, -1);
        maps[0].put(D, 7);
        maps[0].put(E, -1);

        maps[1].put(A, 1);
        maps[1].put(B, -1);
        maps[1].put(C, 2);
        maps[1].put(D, 6);
        maps[1].put(E, -1);

        maps[2].put(A, 3);
        maps[2].put(B, 9);
        maps[2].put(C, -1);
        maps[2].put(D, -1);
        maps[2].put(E, -1);

        maps[3].put(A, 3);
        maps[3].put(B, -1);
        maps[3].put(C, -1);
        maps[3].put(D, -1);
        maps[3].put(E, -1);

        maps[4].put(A, 5);
        maps[4].put(B, -1);
        maps[4].put(C, -1);
        maps[4].put(D, 7);
        maps[4].put(E, -1);

        maps[5].put(A, 5);
        maps[5].put(B, -1);
        maps[5].put(C, 2);
        maps[5].put(D, 6);
        maps[5].put(E, -1);

        maps[6].put(A, 6);
        maps[6].put(B, -1);
        maps[6].put(C, 2);
        maps[6].put(D, -1);
        maps[6].put(E, -1);

        maps[7].put(A, 8);
        maps[7].put(B, -1);
        maps[7].put(C, -1);
        maps[7].put(D, -1);
        maps[7].put(E, -1);

        maps[8].put(A, 8);
        maps[8].put(B, -1);
        maps[8].put(C, 2);
        maps[8].put(D, -1);
        maps[8].put(E, -1);

        maps[9].put(A, 3);
        maps[9].put(B, -1);
        maps[9].put(C, -1);
        maps[9].put(D, -1);
        maps[9].put(E, -1);
    }
    public boolean isNumber(String s) {
        int inx = 0;
        Character c = null;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (Character.isDigit(c)) {
                c = A;
            } else if (65 <= c && c <= 172) {
                if (c == 'e' || c == 'E') {
                    c = C;
                } else {
                    c = E;
                }
            } else if ('.' == c) {
                c = D;
            } else {
                c = B;
            }
            inx = maps[inx].get(c);
            if (inx == -1) {
                return false;
            }
        }
        if (inx == 2 || inx == 4 || inx == 7 || inx == 9) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        有效数字 res = new 有效数字();
        String s = "0";
        System.out.println(s + "\t" + res.isNumber(s));
        s = "e";
        System.out.println(s + "\t" + res.isNumber(s));
        s = ".";
        System.out.println(s + "\t" + res.isNumber(s));
        s = ".1";
        System.out.println(s + "\t" + res.isNumber(s));
        s = "11";
        System.out.println(s + "\t" + res.isNumber(s));
        s = "3.";
        System.out.println(s + "\t" + res.isNumber(s));
        s = "005047e+6";
        System.out.println(s + "\t" + res.isNumber(s));
    }
}
