package 每日一题;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Title: 二叉树寻路
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-29
 */
public class 二叉树寻路 {
    public List<Integer> pathInZigZagTree(int label) {
        /*
                          1
                     3           2
                 4      5     6      7
               15 14  13 12  11 10  9  8

               求14，计算出第四层
               先把 14 加入结果
               偶数层 4
               计算出正规完全二叉树时节点的值
               2^4 - 14 + 2^(4-1)-1 = 9
               求出父结点  9 / 2 = 4

               再把 4 加入结果
               奇数层 3
               计算父结点 4 / 2 = 2
               2 是完全二叉树的节点，需要求出此时二叉树的真正节点
               2^(3-1) - 2 + 2^(3-2)-1=3

               再把 3 加入结果
               偶数层 2
               计算出正规完全二叉树时节点的值
               2^2 - 3 + 2^(3-2) - 1 = 1

               结束循环，把 1 加入结果

               反序





         */
        List<Integer> res = new ArrayList<>();
        int level = getLevel(label);
        while (level > 1) {
            res.add(label);
            if ((level % 2) == 1) {
                /*
                    奇数层
                 */
                int tmp = label / 2;
                label = (int) (Math.pow(2, level - 1) - tmp + Math.pow(2, level - 2) - 1);
            } else {
                /*
                    偶数层
                 */
                int real = (int) (Math.pow(2, level) - label + Math.pow(2, level - 1) - 1);
                label = real / 2;
            }
            level--;
        }
        res.add(1);
        Collections.reverse(res);
        return res;
    }

    private int getLevel (int point) {
        /*
            求出节点在的层数，从 1 开始
            每层增加 += 2^level
         */
        int level = 1;
        int sum = 1;
        while (sum < point) {
            sum += Math.pow(2, level);
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        二叉树寻路 res = new 二叉树寻路();
        List<Integer> integers = res.pathInZigZagTree(1);
        for (int i : integers) {
            System.out.print(i + '\t');
        }
        res.pathInZigZagTree(2);
        res.pathInZigZagTree(3);
        res.pathInZigZagTree(4);
        res.pathInZigZagTree(5);
        res.pathInZigZagTree(6);
        res.pathInZigZagTree(7);
        res.pathInZigZagTree(8);
        res.pathInZigZagTree(9);
        res.pathInZigZagTree(10);
        res.pathInZigZagTree(11);
        res.pathInZigZagTree(12);
        res.pathInZigZagTree(13);
        res.pathInZigZagTree(14);
        res.pathInZigZagTree(15);
    }
}
