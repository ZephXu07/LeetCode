package codetop;

import labuladong.Solution;

/**
 * Title: 比较含退格的字符串844
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-03
 */
public class 比较含退格的字符串844 {
//    public static boolean backspaceCompare(String s, String t) {
//        int sInx = s.length() - 1;
//        int tInx = t.length() - 1;
//        while (sInx >= 0 && tInx >= 0) {
//            if (s.charAt(sInx) != '#' &&  t.charAt(tInx) != '#') {
//                if (s.charAt(sInx) == t.charAt(tInx)) {
//                    sInx--;
//                    tInx--;
//                } else {
//                    return false;
//                }
//                continue;
//            }
//            int tmp = 0;
//            while (sInx >= 0 && s.charAt(sInx) == '#') {
//                tmp++;
//                sInx--;
//            }
//            while (sInx >= 0 && tmp > 0) {
//                if (s.charAt(sInx) != '#') {
//                    tmp--;
//                } else {
//                    tmp++;
//                }
//                sInx--;
//            }
//            tmp = 0;
//            while (tInx >= 0 && t.charAt(tInx) == '#') {
//                tmp++;
//                tInx--;
//            }
//            while (tInx >= 0 && tmp > 0) {
//                if (t.charAt(tInx) != '#') {
//                    tmp--;
//                } else {
//                    tmp++;
//                }
//                tInx--;
//            }
//        }
//        while (sInx >= 0 && s.charAt(sInx) == '#') {
//            int tmp = 0;
//            while (sInx >= 0 && s.charAt(sInx) == '#') {
//                tmp++;
//                sInx--;
//            }
//            while (sInx >= 0 && tmp > 0) {
//                if (s.charAt(sInx) != '#') {
//                    tmp--;
//                } else {
//                    tmp++;
//                }
//                sInx--;
//            }
//        }
//        while (tInx >= 0 && t.charAt(tInx) == '#') {
//            int tmp = 0;
//            while (tInx >= 0 && t.charAt(tInx) == '#') {
//                tmp++;
//                tInx--;
//            }
//            while (tInx >= 0 && tmp > 0) {
//                if (t.charAt(tInx) != '#') {
//                    tmp--;
//                } else {
//                    tmp++;
//                }
//                tInx--;
//            }
//        }
//        return sInx == -1 && tInx == -1;
//    }

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
//        System.out.println(backspaceCompare("ab#c", "ad#c"));
//        System.out.println(backspaceCompare("ab##", "c#d#"));
//        System.out.println(backspaceCompare("a##c", "#a#c"));
//        System.out.println(backspaceCompare("a#c", "b"));
//        System.out.println(backspaceCompare("bxj##tw", "bxo#j##tw"));
//        System.out.println(backspaceCompare("bxj##tw", "bxj###tw"));
//        System.out.println(backspaceCompare("du###vu##v#fbtu","du###vu##v##fbtu"));
    }
}
