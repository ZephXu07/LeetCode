package 杂类;

/**
 * Title: 设计链表707
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-27
 */
public class 设计链表707 {

    public static void main(String[] args) {
//        MyLinkedList my = new MyLinkedList();
//        my.addAtHead(7);
//        my.addAtTail(7);
//        my.addAtHead(9);
//        my.addAtTail(8);
//        my.addAtHead(6);
//        my.addAtHead(0);
//        System.out.println(my.get(5));
//        my.addAtHead(0);
//        System.out.println(my.get(2));
//        System.out.println(my.get(5));
//        my.addAtTail(4);


        MyLinkedList my = new MyLinkedList();
        my.addAtHead(1);
        my.addAtTail(3);
        my.addAtIndex(1,2);
        System.out.println(my.get(1));
        my.deleteAtIndex(0);
        System.out.println(my.get(0));

    }
}
//class MyLinkedList {
//
//    class ListNode {
//        int val;
//        ListNode next;
//
//        public ListNode () {
//        }
//
//        public ListNode (int val) {
//            this.val = val;
//            next = null;
//        }
//
//    }
//
//    private int size;
//    private ListNode head;
//
//    public MyLinkedList() {
//        size = 0;
//        head = new ListNode(0);
//    }
//
//    public int get(int index) {
//        if (index < 0 || index >= size) {
//            return -1;
//        }
//        ListNode cur = head;
//        for (int i = 0; i <= index; i++) {
//            cur = cur.next;
//        }
//        return cur.val;
//    }
//
//    public void addAtHead(int val) {
//        addAtIndex(0, val);
//    }
//
//    public void addAtTail(int val) {
//        addAtIndex(size, val);
//    }
//
//    public void addAtIndex(int index, int val) {
//        if (index > size) {
//            return;
//        }
//        if (index < 0) {
//            index = 0;
//        }
//
//        ListNode pre = head;
//        ListNode cur = head.next;
//        for (int i = 0; i < index; i++) {
//            pre = cur;
//            cur = cur.next;
//        }
//        ListNode node = new ListNode(val);
//        pre.next = node;
//        node.next = cur;
//        size++;
//    }
//
//    public void deleteAtIndex(int index) {
//        if (index < 0 || index >= size) {
//            return;
//        }
//        ListNode cur = head;
//        ListNode pre = cur;
//        for (int i = 0; i <= index; i++) {
//            pre = cur;
//            cur = cur.next;
//        }
//        pre.next = cur.next;
//        cur.next = null;
//        cur = null;
//        size--;
//    }
//}

class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode pre;
        ListNode(int val) { this.val = val; }
    }


    int size;

    ListNode head, tail;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.pre = head;
    }


    public int get(int index) {

        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode cur = head;
        if (index + 1 < size - index) {
            /*
                head查找快
             */
            for (int i = 0; i < index + 1; ++i) {
                cur = cur.next;
            }
        } else {
            /*
                tail查找快
             */
            cur = tail;
            for (int i = 0; i < size - index; ++i){
                cur = cur.pre;
            }
        }

        return cur.val;
    }


    public void addAtHead(int val) {
        ListNode cur = head.next;
        size++;
        ListNode node = new ListNode(val);
        head.next = node;
        node.pre = head;
        node.next = cur;
        cur.pre = node;
    }


    public void addAtTail(int val) {
        size++;
        ListNode node = new ListNode(val);
        ListNode prev = tail.pre;
        prev.next = node;
        node.pre = prev;
        node.next = tail;
        tail.pre = node;
    }


    public void addAtIndex(int index, int val) {

        if (index > size) {
            return;
        }

        if (index < 0) {
            index = 0;
        }

        ListNode prev;
        ListNode cur;
        if (index < size - index) {
            /*
                head查找快
             */
            prev = head;
            for (int i = 0; i < index; ++i){
                prev = prev.next;
            }
            cur = prev.next;
        } else {
            /*
                tail 查找快
             */
            cur = tail;
            for (int i = 0; i < size - index; ++i) {
                cur = cur.pre;
            }
            prev = cur.pre;
        }

        size++;
        ListNode node = new ListNode(val);
        prev.next = node;
        node.pre = prev;
        node.next = cur;
        cur.pre = node;
    }


    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode prev;
        ListNode cur;
        if (index < size - index) {
            prev = head;
            for (int i = 0; i < index; ++i) {
                prev = prev.next;
            }
            cur = prev.next.next;
        } else {
            cur = tail;
            for (int i = 0; i < size - index - 1; ++i) {
                cur = cur.pre;
            }
            prev = cur.pre.pre;
        }
        size--;
        prev.next = cur;
        cur.pre = prev;
    }

}
