package 二叉排序树;

/**
 * Title: BinarySearchTreeTest
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-16
 */
public class BinarySearchTreeTest {
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

    public static void main(String[] args) {
        BinarySearchTreeTest test = new BinarySearchTreeTest();
        test.test();
    }

    public void test() {
        //首先要插入根节点47，然后是第二层的节点16,73，然后是第三层的节点1,24,59,88，然后是第四层的节点20,35,62,77。
        // 每一层内部节点的顺序可以不一致，但是每一层之间的打顺序一定要保持一致，否则虽然中序遍历输出的时候能够正常输出,但是树的结构不能保证。
        Integer[] es = new Integer[]{47, 16, 73, 1, 24, 59, 88, 20, 35, 62, 77};
        binarySearchTree.insert(es);
        //中序遍历输出
        System.out.println(binarySearchTree.toInorderTraversalString());

        //查找是否存在
        System.out.println(binarySearchTree.contains(1));
        System.out.println(binarySearchTree.contains(2));

        //移除
        binarySearchTree.delete(73);
        //中序遍历输出
        System.out.println(binarySearchTree.toInorderTraversalString());
    }
}


