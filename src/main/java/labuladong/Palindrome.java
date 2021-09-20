package labuladong;

/**
 * Title: labuladong.Palindrome
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-09-26
 */
public class Palindrome {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;
        Palindrome palindrome = new Palindrome();
        boolean result = palindrome.isPalindrome(one);
        System.out.println(result);

    }

    //1->2->2->1
    public  boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode front = findMidpoint(head);
        ListNode back = reverseList(front.next);

        ListNode p1 = head;
        ListNode p2 = back;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        front.next = reverseList(back);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    private ListNode findMidpoint(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private String printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (null != head) {
            sb.append(head.val);
            head = head.next;
        }
        return sb.toString();
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
