package codetop;

/**
 * Title: 旋转字符串796
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-22
 */
public class 旋转字符串796 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            /*
                长度不等直接返回
             */
            return false;
        }
        s += s;
        /*
            s 加上自身，在 s 中寻找 goal
         */
        int[] next = getNext(s);
        /*
            得到next数组（前缀表）
         */
        int j = -1;
        /*
            next数组里记录的起始位置为-1
         */
        for (int i = 0; i < s.length(); i++) {
            /*
                s[i] 与 goal[j + 1] 比较
                （因为j == -1 开始）
             */
            while (j >= 0 && s.charAt(i) != goal.charAt(j + 1)) {
                /*
                     s[i] 与 goal[j + 1] 不相同，j
                     就要从next数组里寻找下一个匹配 s[i] 的位置
                     不断回溯
                     直到找到相同的前缀的位置 或者 j == -1
                      goal 串从 0 下标再开始
                 */
                j = next[j];
            }
            if (s.charAt(i) == goal.charAt(j + 1)) {
                 /*
                    相同的前缀末尾，j++
                     i的增加在for循环里
                 */
                j++;
            }
            if (j == goal.length() - 1) {
                /*
                    j指向了模式串 goal 的末尾
                    说明模式串 goal 完全匹配文本串 sk 里的某个子串了
                    文本串 s 里出现了模式串 goal
                    返回 true
                 */
                return true;
            }
        }
        return false;
        /*
            完全没匹配到，返回 false
         */
    }
    private int[] getNext (String s) {
        int j = -1;
        /*
            在next数组中记录的起始位置是-1
            下面的操作都是 j + 1 使不会溢出范围
         */
        int[] next = new int[s.length()];
        next[0] = j;
        /*
            next[i] 表示 i（包括i）之前最长相等的前后缀长度（其实就是j）
            所以初始化next[0] = j
         */
        for (int i = 1; i < s.length(); i++) {
            /*
                next[0] 已经确定为 - 1
                从下标 1 开始
             */
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                /*
                    前后缀不相同了，向前回溯
                    此处是 s[j + 1] 所以从 j 开始即可

                    当 s[i] == s[j+1] 了，即前后缀末尾相同了即可继续新的前后缀计算最长长度
                    或者全部回溯完， j == -1，没有找到相同的前缀后缀，结束
                 */
                j = next[j];
                /*
                    回溯到包括前一个字符的字符串的最长相等前后缀长度
                 */
            }

            if (s.charAt(i) == s.charAt(j + 1)) {
                /*
                    当 s[i] == s[j+1] 了，
                    找到相同的前后缀
                    继续新的前后缀计算最长长度
                 */
                j++;
            }

            next[i] = j;
            /*
                记录 i（包括i）之前最长相等的前后缀长度（其实就是j）
             */
        }

        return next;
    }


    public static void main(String[] args) {
        旋转字符串796 res = new 旋转字符串796();
        System.out.println(res.rotateString("bbbacddceeb", "ceebbbbacdd"));
    }
}
