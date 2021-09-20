package labuladong;

/**
 * Title: labuladong.FirstUniqChar
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-09-14
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] tmp = new int[26];
        for (int i = 0; i < s.length(); i++) {
//            System.out.println(s.charAt(i) - 'a');
            tmp[s.charAt(i) - 'a'] ++;
        }
//        System.out.println(Arrays.toString(tmp));
        for (int i = 0; i < s.length(); i++) {
            if(tmp[s.charAt(i) - 'a']==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int i = new FirstUniqChar().firstUniqChar(s);
        System.out.println(i);
    }
}
