package codetop;



/**
 * Title: 有序链表转换二叉搜索树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-01
 */
public class 有序链表转换二叉搜索树 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }


    public TreeNode sortedListToBST(ListNode head) {
        int len = length(head);
        /*
            获得长度
         */
        int[] array = toArray(head, len);
        /*
            获得数组
         */
        return build(array, 0, len - 1);

    }

    private TreeNode build (int[] array, int left, int right) {
        if (left > right) {
            /*
                数组节点遍历完
             */
            return null;
        }
        int mid = (left + right + 1) / 2;
        /*
            取中点，因为是二叉搜索树，不加一取的会是左值，在剩两个数时会出错
         */
        TreeNode root = new TreeNode(array[mid]);
        root.left = build(array, left, mid - 1);
        root.right = build(array, mid + 1, right);
        return root;
    }

    private int[] toArray (ListNode head, int len) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = head.val;
            head = head.next;
        }
        return array;
    }

    private int length (ListNode head) {
        int len = 0;
        while (null != head) {
            len++;
            head = head.next;
        }
        return len;
    }
}
