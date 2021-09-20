package codetop;

/**
 * Title: 一次编辑
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-13
 */
public class 一次编辑 {
//    public boolean oneEditAway(String first, String second) {
//        return dfs(first, 0, second, 0, true);
//    }
//
//    private boolean dfs (String first, int i, String second, int j, boolean edit) {
//        if (i == first.length() && j == second.length()) {
//            return true;
//        }
//
//        if ((i == first.length() || j == second.length())) {
//            if (!edit) {
//                return false;
//            } else {
//                return i + 1 == first.length() || j + 1 == second.length();
//            }
//        }
//
//        if (first.charAt(i) == second.charAt(j)) {
//            return dfs(first, i + 1, second, j + 1, edit);
//        } else {
//            if (!edit) {
//                return false;
//            } else {
//                return dfs(first, i + 1, second, j + 1, false) ||
//                        dfs(first, i, second, j + 1, false) ||
//                        dfs(first, i + 1, second, j, false);
//            }
//        }
//    }


    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();

        if (Math.abs(len1 - len2) > 1) {
            return false;
        }

        if (first.equals(second)) {
            return true;
        }

        int count = 0;
        int i = 0;
        int j = 0;

        while (i < len1 && j < len2) {
            if (first.charAt(i++) == second.charAt(j++)) {
                /*
                    提前进入下一个字符
                 */
                continue;
            }

            count++;

            if (count > 1) {
                return false;
            }

            if (len1 == len2) {
                /*
                    只能修改
                 */
                continue;
            }
            if (len1 > len2) {
                /*
                    first > second
                    上一个字符不同
                    即 f[i-1] != s[i-1]
                    插入或删除
                    如果 first 删除，则 j-- ，second 回退
                    如果 second 插入，也 j--，second 回退

                    同理 first < second
                 */
                j--;
            } else {
                i--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        一次编辑 res = new 一次编辑();
        System.out.println(res.oneEditAway("teacher", "bleacher"));
    }
}
