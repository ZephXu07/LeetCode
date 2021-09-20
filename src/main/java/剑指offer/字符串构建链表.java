package 剑指offer;

/**
 * Title: 字符串构建链表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-03
 */
public class 字符串构建链表 {
    private String value;
    public 字符串构建链表 (String value) {
        this.value = value;
    }

    public ListNode getList() {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode p = head;
        for (int i = 0; i < value.length(); i++) {
            p.next = new ListNode(value.charAt(i) - '0');
            p = p.next;
        }
        return head.next;
    }

}
