package 字节;

import javafx.util.Pair;

/**
 * Title: 比较版本号
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-17
 */
public class 比较版本号 {
    public int compareVersion1(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        if (v1.length > v2.length) {
            String[] tmp = new String[v1.length];
            for (int i = 0; i < v1.length; i++) {
                if (i < v2.length) {
                    tmp[i] = v2[i];
                } else {
                    tmp[i] = "0";
                }
            }
            v2 = tmp;
        } else if (v1.length < v2.length) {
            String[] tmp = new String[v2.length];
            for (int i = 0; i < v2.length; i++) {
                if (i < v1.length) {
                    tmp[i] = v1[i];
                } else {
                    tmp[i] = "0";
                }
            }
            v1 = tmp;
        }
        int inx = 0;
        int i1;
        int i2;
        while (inx < v1.length) {
            i1 = Integer.parseInt(v1[inx]);
            i2 = Integer.parseInt(v2[inx]);
            if (i1 < i2) {
                return -1;
            } else if (i1 > i2){
                return 1;
            } else {
                inx++;
            }
        }

        return 0;
    }

    private Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
        if (p > n - 1) {
            return new Pair(0, p);
        }
        int i, pEnd = p;
        while (pEnd < n && version.charAt(pEnd) != '.') {
            ++pEnd;
        }
        if (pEnd != n - 1) {
            i = Integer.parseInt(version.substring(p, pEnd));
        } else {
            i = Integer.parseInt(version.substring(p, n));
        }
        p = pEnd + 1;

        return new Pair(i, p);
    }

    public int compareVersion(String version1, String version2) {
        int r1 = 0, r2 = 0;
        int len1 = version1.length();
        int len2 = version2.length();

        int i1, i2;
        Pair<Integer, Integer> pair;
        while (r1 < len1 || r2 < len2) {
            pair = getNextChunk(version1, len1, r1);
            i1 = pair.getKey();
            r1 = pair.getValue();

            pair = getNextChunk(version2, len2, r2);
            i2 = pair.getKey();
            r2 = pair.getValue();
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        比较版本号 res = new 比较版本号();
        String version1 = "7.5.2.4", version2 = "7.5.3";
        System.out.println(res.compareVersion1(version1, version2));
    }
}
