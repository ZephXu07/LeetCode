package codetop;

import java.util.*;

/**
 * Title: 通过删除字母匹配到字典里最长单词
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-14
 */
public class 通过删除字母匹配到字典里最长单词 {
//    public String findLongestWord(String s, List<String> dictionary) {
//        /*
//            最长、字典序最大，
//            所以在判断 dict 中的 dic 是不是 s 的子序列，是的话则可以通过删除得到 dic
//            再进行比较，找到最长。字典序最大的
//         */
//        String res = "";
//        for (String d : dictionary) {
//            int i = 0;
//            int j = 0;
//            while (i < s.length() && j < d.length()) {
//                if (s.charAt(i) == d.charAt(j)) {
//                    j++;
//                }
//                i++;
//            }
//            if (j == d.length()) {
//                if (d.length() > res.length() ||
//                        (d.length() == res.length() && d.compareTo(res) < 0)) {
//                    res = d;
//                }
//            }
//        }
//        return res;
//    }

    public String findLongestWord(String s, List<String> dictionary) {
        /*
            最长、字典序最大，
            所以在判断 dict 中的 dic 是不是 s 的子序列，是的话则可以通过删除得到 dic
            再进行比较，找到最长。字典序最大的

            或者对dic 排序，长度大到小
            字典序小到大，如果 dic 的指针到达末尾，则找到最长字典序最小的
            立即返回
         */
        dictionary.sort((d1, d2) -> {
            if (d1.length() != d2.length()) {
                return d2.length() - d1.length();
            }
            return d1.compareTo(d2);
        });

        for (String d : dictionary) {
            int i = 0;
            int j = 0;
            while (i < s.length() && j < d.length()) {
                if (s.charAt(i) == d.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == d.length()) {
                return d;
            }
        }
        return "";
    }

    public static void main(String[] args) {


        通过删除字母匹配到字典里最长单词 res = new 通过删除字母匹配到字典里最长单词();
        System.out.println(res.findLongestWord("abpcplea", new ArrayList<>(Arrays.asList("ale", "apple", "monkey", "plea"))));
    }
}
