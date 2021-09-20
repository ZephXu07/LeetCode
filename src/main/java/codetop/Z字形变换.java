package codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Title: Z字形变换
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-29
 */
public class Z字形变换 {
//    public String convert(String s, int numRows) {
//        int len = s.length();
//        if (len == 1 || numRows == 1) {
//            return s;
//        }
//        if (numRows == 2) {
//            StringBuilder res = new StringBuilder();
//            for (int i = 0; i < s.length(); i += 2) {
//                res.append(s.charAt(i));
//            }
//            for (int i = 1; i < s.length(); i += 2) {
//                res.append(s.charAt(i));
//            }
//            return res.toString();
//        }
//
//        int c = 0;
//        boolean flag = true;
//        while (len > 0) {
//            if (flag) {
//                len -= numRows;
//                flag = false;
//            } else {
//                len = len - Math.min(numRows - 2, 0);
//                flag = true;
//            }
//            c += numRows - 2;
//        }
//
//        char[][] board = new char[numRows][c];
//        int inx = 0;
//        flag = true;
//        boolean finish = false;
//        int j = 0;
//        while (!finish) {
//            if (flag) {
//                for (int i = 0; i < numRows; i++) {
//                    if (inx < s.length()) {
//                        board[i][j] = s.charAt(inx++);
//                    } else {
//                        finish = true;
//                        break;
//                    }
//                }
//                flag = false;
//                j++;
//            } else {
//                int k = j;
//                for (int i = numRows - 2; i > 0; i--, k++) {
//                    if (inx < s.length()) {
//                        board[i][k] = s.charAt(inx++);
//                    } else {
//                        finish = true;
//                        break;
//                    }
//                }
//                j = k;
//                flag = true;
//            }
//        }
//        StringBuilder res = new StringBuilder();
//        for (int i = 0; i < numRows; i++) {
//            for (int k = 0; k < c; k++) {
//                if (board[i][k] != 0) {
//                    res.append(board[i][k]);
//                }
//            }
//        }
//        return res.toString();
//    }



    public static void main(String[] args) {
        Z字形变换 res = new Z字形变换();
//        System.out.println("PAHNAPLSIIGYIR".equals(res.convert("PAYPALISHIRING", 3)));
//        System.out.println("PINALSIGYAHRPI".equals(res.convert("PAYPALISHIRING", 4)));
//        System.out.println("A".equals(res.convert("A", 1)));
        System.out.println("AB".equals(res.convert("AB", 2)));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ans.add(new StringBuilder());
        }

        int row = 0;
        int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            ans.get(row).append(s.charAt(i));
            if (row == 0 || row == numRows - 1) {
                flag = - flag;
            }
            row += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : ans) {
            res.append(sb);
        }
        return res.toString();
    }
}
