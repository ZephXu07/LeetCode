package 二叉排序树;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Title: BinarySearchTree
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-16
 * https://blog.csdn.net/weixin_43767015/article/details/105793826
 */
public class BinarySearchTree<E> {
    /**
     * 外部保存根节点的引用
     */
    private BinaryTreeNode<E> root;

    /**
     * 自定义比较器
     */
    private Comparator<? super E> cmp;


    /**
     * 树节点的数量
     */
    private int size;

    /**
     * 内部节点对象
     *
     * @param <E> 数据类型
     */
    public static class BinaryTreeNode<E> {

        //数据域
        E data;
        //左子节点
        BinaryTreeNode<E> left;
        //右子节点
        BinaryTreeNode<E> right;

        public BinaryTreeNode(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }

    }

    /**
     * 指定比较器
     *
     * @param cmp 比较器
     */
    public BinarySearchTree(Comparator<? super E> cmp) {
        this.cmp = cmp;
    }

    /**
     * 空构造器
     */
    public BinarySearchTree() {
    }

    /**
     * 是否是空树
     *
     * @return true 是 ;false 否
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回节点数
     *
     * @return 节点数
     */
    public int size() {
        return size;
    }


    /**
     * 对元素进行比较大小的方法,如果传递了自定义比较器,则使用自定义比较器,否则则需要数据类型实现Comparable接口
     *
     * @param e1 被比较的第一个对象
     * @param e2 被比较的第二个对象
     * @return 0 相等 ;小于0 e1 < e2 ;大于0 e1 > e2
     */
    private int compare(E e1, E e2) {
        if (cmp != null) {
            return cmp.compare(e1, e2);
        } else {
            return ((Comparable<E>) e1).compareTo(e2);
        }
    }


    /**
     * 保存遍历出来的节点数据
     */
    List<BinaryTreeNode<E>> str = new ArrayList<>();

    /**
     * 中序遍历,提供给外部使用的api
     *
     * @return 遍历的数据
     */
    public String toInorderTraversalString() {

        //如果是空树,直接返回空
        if (isEmpty()) {
            return null;
        }
        //从根节点开始递归
        inorderTraversal(root);
        //获取遍历结果
        String s = str.toString();
        str.clear();
        return s;
    }

    /**
     * 中序遍历 内部使用的递归遍历方法,借用了栈的结构
     *
     * @param root 节点,从根节点开始
     */
    private void inorderTraversal(BinaryTreeNode<E> root) {

        BinaryTreeNode<E> left = getLeft(root);
        if (left != null) {
            //如果左子节点不为null,则继续递归遍历该左子节点
            inorderTraversal(left);
        }
        //添加数据节点
        str.add(root);
        //获取节点的右子节点
        BinaryTreeNode<E> right = getRight(root);
        if (right != null) {
            //如果右子节点不为null,则继续递归遍历该右子节点
            inorderTraversal(right);
        }
    }

    /**
     * 获取左子节点
     *
     * @param parent 父节点引用
     * @return 左子节点或者null--表示没有左子节点
     */
    public BinaryTreeNode<E> getLeft(BinaryTreeNode<E> parent) {
        return parent == null ? null : parent.left;
    }

    /**
     * 获取右子节点
     *
     * @param parent 父节点引用
     * @return 右子节点或者null--表示没有右子节点
     */
    public BinaryTreeNode<E> getRight(BinaryTreeNode<E> parent) {
        return parent == null ? null : parent.right;
    }

    /**
     * 获取根节点
     *
     * @return 根节点 ;或者null--表示空树
     */
    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    /**
     * 查找,开放给外部使用的api
     */
    public boolean contains(E e) {
        return contains(e, root);
    }

    /**
     * 查找,内部调用的方法,从根节点开始查找
     *
     * @param e    要查找的元素
     * @param root 节点
     * @return false 不存在 true 存在
     */
    private boolean contains(E e, BinaryTreeNode<E> root) {
        /*null校验*/
        if (root == null) {
            return false;
        }
        /*调用比较的方法*/
        int i = compare(e, root.data);
        /*如果大于0，则说明e>root.date 继续查询右子树*/
        if (i > 0) {
            return contains(e, root.right);
            /*如果小于0，则说明e<root.date 继续查询左子树*/
        } else if (i < 0) {
            return contains(e, root.left);
        } else {
            /*如果等于0，则说明e=root.date 即查询成功*/
            return true;
        }
    }

    /**
     * 插入,开放给外部使用的api
     *
     * @param e 要插入的元素
     */
    public void insert(E e) {
        //返回root,但此时新的节点可能已经被插入进去了
        root = insert(e, root);
    }

    /**
     * 插入,开放给外部使用的api
     *
     * @param es 要插入的元素的数组,注意,数组元素的顺序存储的位置将会影响二叉排序树的生成
     */
    public void insert(E[] es) {
        //返回root,但此时新的节点可能已经被插入进去了
        for (E e : es) {
            root = insert(e, root);
        }

    }

    /**
     * 插入,内部调用的方法,先从根节点开始递归查找要插入的位置,然后插入
     *
     * @param e    要插入的数据
     * @param root 节点
     * @return 原节点或者新插入的节点
     */
    private BinaryTreeNode<E> insert(E e, BinaryTreeNode<E> root) {
        /*没有查找到,那么直接构建新的节点返回,将会在上一层方法中被赋值给其父节点的某个引用,这个插入的位置肯定是该遍历路径上的最后一点
         * 即插入的元素节点肯定是属于叶子节点*/
        if (root == null) {
            size++;
            return new BinaryTreeNode<>(e);
        }
        /*调用比较的方法*/
        int i = compare(e, root.data);
        /*如果大于0，则说明e>root.date 继续查询右子树*/
        if (i > 0) {
            //重新赋值
            root.right = insert(e, root.right);
            /*如果小于0，则说明e<root.date 继续查询左子树*/
        } else if (i < 0) {
            //重新赋值
            root.left = insert(e, root.left);
        } else {
            /*如果等于0，则说明e=root.date 即存在节点 什么都不做*/
        }
        //没查询到最底层,则返回该节点
        return root;
    }

    /**
     * 查找最小的节点
     *
     * @param root 根节点
     * @return 最小的节点
     */
    private BinaryTreeNode<E> findMin(BinaryTreeNode<E> root) {
        if (root == null) {
            return null;
            /*如果该节点没有左右子节点，那么该节点就是最小的节点，返回*/
        } else if (root.left == null) {
            return root;
        }
        /*如果该节点存在左子节点，那么继续向左递归查找*/
        return findMin(root.left);
    }

    /**
     * 查找最大的节点
     *
     * @param root 根节点
     * @return 最大的节点
     */
    private BinaryTreeNode<E> findMax(BinaryTreeNode<E> root) {
        if (root == null) {
            return null;
            /*如果该节点没有右子节点，那么该节点就是最大的节点，返回*/
        } else if (root.right == null) {
            return root;
        }
        /*如果该节点存在右子节点，那么继续向右递归查找*/
        return findMax(root.right);
    }

    /**
     * 删除,开放给外部使用的api
     *
     * @param e 要删除的元素
     */
    public void delete(E e) {
        //返回root,但此时可能有一个节点已经被删除了
        root = delete(e, root);
    }

    /**
     * 删除,内部调用的方法,删除分为三种情况: 1、该节点没有子节点 2、该字节仅有一个子节点 3、该节点具有两个子节点
     *
     * @param e    要删除的数据
     * @param root 根节点
     * @return 该节点
     */
    private BinaryTreeNode<E> delete(E e, BinaryTreeNode<E> root) {
        /*没有查找到,那么什么都不做*/
        if (root == null) {
            return null;
        }
        /*调用比较的方法*/
        int i = compare(e, root.data);
        /*如果大于0，则说明e>root.date 继续查询右子树*/
        if (i > 0) {
            //从新赋值
            root.right = delete(e, root.right);
            /*如果小于0，则说明e<root.date 继续查询左子树*/
        } else if (i < 0) {
            //从新赋值
            root.left = delete(e, root.left);
        } else {
            /*如果等于0，则说明e=root.date 即查询成功 开始执行删除*/
            /*如果两个子节点都不为null*/
            if (root.left != null && root.right != null) {
                /*方法1、递归查找最小的节点，然后递归删除  该方法不推荐使用*/
                //root.data = findMin(root.right).data;
                //root.right = delete(root.data, root.right);
                /*方法2、递归查找并删除最小的节点 推荐*/
                root.data = findAndDeleteMin(root.right, root);
                size--;
            } else {
                /*如果一个子节点不为null，则返回该子节点；或者两个子节点都为null，则返回null
                 * 此时该root节点已经被"绕过了"*/
                root = (root.left != null) ? root.left : root.right;
                size--;
            }
        }
        //没查询到最底层,则返回该节点
        return root;
    }

    /**
     * 查找最小的节点并删除
     * 最小的节点肯定不存在两个字节点,有可能没有子节点,有可能存在右子节点
     *
     * @param root   节点
     * @param parent 节点的父节点
     * @return 被删除的最小的节点
     */
    private E findAndDeleteMin(BinaryTreeNode<E> root, BinaryTreeNode<E> parent) {
        //如果节点为null，返回
        if (root == null) {
            return null;
            /*如果节点的左子节点为null,那么该节点就是最小的节点*/
            /*1、该最小节点肯定没有左子节点，因为左子节点比父节点小，但是可能有右子节点*/
            /*2、此时该节点可能作为某个节点的左子节点，也可能作为原父节点的右子节点（即右子树是一颗右斜树），这里需要分开讨论*/
        } else if (root.left == null) {
            //如果该节点是父节点的右子节点,说明还没进行递归或者第一次递归就找到了最小节点.
            //那么此时,应该让该节点的父节点的右子节点指向该节点的右子节点,并返回该节点的数据，该节点由于没有了强引用，会被GC删除
            if (root == parent.right) {
                parent.right = root.right;
            } else {
                //如果该节点不是父节点的右子节点，说明进行了多次递归。
                //那么此时,应该让该节点的父节点的左子节点指向该节点的右子节点,并返回该节点的数据，该节点由于没有了强引用，会被GC删除
                parent.left = root.right;
            }
            //返回最小节点的数据
            return root.data;
        }
        //递归调用,注意此时是往左查找
        return findAndDeleteMin(root.left, root);
    }




}


