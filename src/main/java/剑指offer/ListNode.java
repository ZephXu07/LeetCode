package 剑指offer;

/**
 * Title: ListNode
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-29
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
