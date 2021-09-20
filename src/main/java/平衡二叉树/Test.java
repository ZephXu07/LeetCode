package 平衡二叉树;

import java.util.Arrays;
import java.util.List;

/**
 * Title: Test
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-16
 */
public class Test {
    public static void main(String[] args) {
        AvlTree<Integer> avlTree = new AvlTree<>();
        Integer[] es = new Integer[]{3, 2, 1, 4, 5, 6, 7, 16, 15, 14};
        //批量插入
        avlTree.insert(es);



        List<List<Integer>> lists = avlTree.levelOrder();
        for (List<Integer> list : lists) {
            for (int l : list) {
                System.out.print(l + "\t");
            }
            System.out.println();
        }

        es = new Integer[]{20,13,27,52,42,63,51};
        avlTree.insert(es);
        avlTree.delete(42);
        lists = avlTree.levelOrder();
        for (List<Integer> list : lists) {
            for (int l : list) {
                System.out.print(l + "\t");
            }
            System.out.println();
        }
    }
}
