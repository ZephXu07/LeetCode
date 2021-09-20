package 每日一题;

import javafx.util.Pair;

/**
 * Title: 比较版本号
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-01
 */
public class 比较版本号 {
//     public int compareVersion(String version1, String version2) {
//         /*
//            '.' 切割，数组短的后面补 0
//            再一个个比较
//          */
//         String[] v1 = version1.split("\\.");
//         String[] v2 = version2.split("\\.");
//         if (v1.length > v2.length) {
//             String[] tmp = new String[v1.length];
//             for (int i = 0; i < v1.length; i++) {
//                 if (i < v2.length) {
//                     tmp[i] = v2[i];
//                 } else {
//                     tmp[i] = "0";
//                 }
//             }
//             v2 = tmp;
//         } else if (v1.length < v2.length) {
//             String[] tmp = new String[v2.length];
//             for (int i = 0; i < v2.length; i++) {
//                 if (i < v1.length) {
//                     tmp[i] = v1[i];
//                 } else {
//                     tmp[i] = "0";
//                 }
//             }
//             v1 = tmp;
//         }
//         int inx = 0;
//         int i1;
//         int i2;
//         while (inx < v1.length) {
//             i1 = Integer.parseInt(v1[inx]);
//             i2 = Integer.parseInt(v2[inx]);
//             if (i1 < i2) {
//                 return -1;
//             } else if (i1 > i2){
//                 return 1;
//             } else {
//                 inx++;
//             }
//         }
//         return 0;
//     }

//    private Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
//        if (p > n - 1) {
//            /*
//                当前下标超过字符串长度
//                返回 0 与 下标
//             */
//            return new Pair(0, p);
//        }
//        int i, pEnd = p;
//        while (pEnd < n && version.charAt(pEnd) != '.') {
//            /*
//                找到 '.'
//             */
//            ++pEnd;
//        }
//        if (pEnd != n - 1) {
//            i = Integer.parseInt(version.substring(p, pEnd));
//        } else {
//            i = Integer.parseInt(version.substring(p, n));
//        }
//        /*
//            根据是否超过长度进行值的判断
//         */
//        p = pEnd + 1;
//        /*
//            更新下标
//         */
//        return new Pair(i, p);
//        /*
//            返回值与下标
//         */
//    }
//
//    public int compareVersion(String version1, String version2) {
//        int r1 = 0, r2 = 0;
//        int len1 = version1.length();
//        int len2 = version2.length();
//
//        int i1, i2;
//        Pair<Integer, Integer> pair;
//        while (r1 < len1 || r2 < len2) {
//            pair = getNextChunk(version1, len1, r1);
//            /*
//                得到值与下标
//             */
//            i1 = pair.getKey();
//            r1 = pair.getValue();
//
//            pair = getNextChunk(version2, len2, r2);
//            i2 = pair.getKey();
//            r2 = pair.getValue();
//            if (i1 != i2) {
//                return i1 > i2 ? 1 : -1;
//                /*
//                    对比
//                 */
//            }
//        }
//        return 0;
//    }

    public int compareVersion(String v1, String v2) {
        int i = 0, j = 0;
        int n = v1.length(), m = v2.length();
        while(i < n || j < m) {
            int num1 = 0, num2 = 0;
            while(i < n && v1.charAt(i) != '.') {
                num1 = num1 * 10 + v1.charAt(i++) - '0';
            }
            while(j < m && v2.charAt(j) != '.') {
                num2 = num2 * 10 + v2.charAt(j++) - '0';
            }
            if(num1 > num2) {
                return 1;
            } else if( num1 < num2) {
                return -1;
            }
            i++; j++;
        }
        return 0;
    }

}
