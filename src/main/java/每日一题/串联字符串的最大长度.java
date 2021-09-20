package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 串联字符串的最大长度
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-19
 */
public class 串联字符串的最大长度 {
    private int res;
    public int maxLength(List<String> arr) {
        // 26 字母，32位来记录
        res = 0;
        List<Integer> bits = new ArrayList<>();
        for (String s : arr) {
            int bit = 0;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                //第几位
                if (((bit >> c) & 1) != 0) {
                    //存在这个字母，即单独 s 有重复字母，此刻 s 完全不能选，结束
                    bit = 0;
                    break;
                }
                bit |= 1 << c;
                //单独 s 没有重复字母，记录字母在二进制的位置
            }
            bits.add(bit);
            //添加到二进制数组
        }
        backtrack(bits, 0, 0);
        //回溯
        return res;
    }

    private void backtrack (List<Integer> bits, int inx, int bit) {
        if (inx == bits.size()) {
            res = Math.max(res, Integer.bitCount(bit));
            return;
        }
        if ((bits.get(inx) & bit) == 0) {
            //先前已经选的和新的没有重复，选择下去，下一个二进制数
            backtrack(bits, inx + 1, bits.get(inx) | bit);
        }
        backtrack(bits, inx + 1, bit);
        //重复了或者直接就不选
    }


}
