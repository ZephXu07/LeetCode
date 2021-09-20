package 字节.LFU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: LFUCache2
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-08
 */
public class LFUCache2{

    Map<Integer, Point2> cache;
    // 存储缓存的内容，Node中除了value值外，
    // 还有key、freq、所在doublyLinkedList、
    // 所在doublyLinkedList中的nextNode、
    // 所在doublyLinkedList中的preNode，具体定义在下方。

    DoublyLinkedList firstLinkedList;
    // 此链表是由一个个Point2组成的链表，存入Point2链表的头尾，以一个整体再存入大链表头尾
    // firstLinkedList.next 是频次最大的双向链表

    DoublyLinkedList lastLinkedList;
    // lastLinkedList.pre 是频次最小的双向链表，
    // 满了之后删除 lastLinkedList.pre.tail.pre 这个Node即为频次最小且访问最早的Node
    //同理
    int size;

    int capacity;



    public LFUCache2(int capacity) {

        cache = new HashMap<>(capacity);

        firstLinkedList = new DoublyLinkedList();

        lastLinkedList = new DoublyLinkedList();

        firstLinkedList.next = lastLinkedList;

        lastLinkedList.pre = firstLinkedList;

        //两个大双链表相连

        this.capacity = capacity;

    }



    public int get(int key) {

        Point2 point2 = cache.get(key);

        if (point2 == null) {

            return -1;

        }

        // 该key访问频次+1

        freqInc(point2);

        return point2.value;

    }



    public void put(int key, int value) {

        if (capacity == 0) {

            return;

        }

        Point2 point2 = cache.get(key);

        // 若key存在，则更新value，访问频次+1

        if (point2 != null) {

            point2.value = value;

            freqInc(point2);

        } else {

            // 若key不存在

            if (size == capacity) {

                // 如果缓存满了，删除lastLinkedList.pre这个链表（即表示最小频次的链表）中的tail.pre这个Node（即最小频次链表中最先访问的Node），如果该链表中的元素删空了，则删掉该链表。

                cache.remove(lastLinkedList.pre.tail.pre.key);

                lastLinkedList.removeNode(lastLinkedList.pre.tail.pre);

                size--;

                if (lastLinkedList.pre.head.next == lastLinkedList.pre.tail) {

                    removeDoublyLinkedList(lastLinkedList.pre);

                }

            }

            // cache中put新Key-Node对儿，并将新node加入表示freq为1的DoublyLinkedList中，若不存在freq为1的DoublyLinkedList则新建。

            Point2 newNode = new Point2(key, value);

            cache.put(key, newNode);

            if (lastLinkedList.pre.freq != 1) {

                DoublyLinkedList newDoublyLinedList = new DoublyLinkedList(1);

                addDoublyLinkedList(newDoublyLinedList, lastLinkedList.pre);

                newDoublyLinedList.addNode(newNode);

            } else {

                lastLinkedList.pre.addNode(newNode);

            }

            size++;

        }

    }


    /**
     * node的访问频次 + 1
     */
    void freqInc(Point2 point2) {

        // 将node从原freq对应的双向链表里移除, 如果链表空了则删除链表。

        DoublyLinkedList linkedList = point2.doublyLinkedList;
        //节点存入哪个大链表节点的引用

        DoublyLinkedList preLinkedList = linkedList.pre;


        linkedList.removeNode(point2);
        //在大链表中删除

        if (linkedList.head.next == linkedList.tail) {
            //大链表没有节点则删除

            removeDoublyLinkedList(linkedList);

        }


        // 将node加入新freq对应的双向链表，若该链表不存在，则先创建该链表。

        point2.freq++;

        if (preLinkedList.freq != point2.freq) {
            //前面一个频率链表不存在

            DoublyLinkedList newDoublyLinedList = new DoublyLinkedList(point2.freq);
            //新建频率链表，例如3和1链表中少了2，新建2

            addDoublyLinkedList(newDoublyLinedList, preLinkedList);


            newDoublyLinedList.addNode(point2);
            //添加进去

        } else {

            preLinkedList.addNode(point2);
            //存在，则直接添加

        }

    }


    /**
     * 增加代表某频次的双向链表，例如3和1新加2
     */
    void addDoublyLinkedList(DoublyLinkedList newDoublyLinedList, DoublyLinkedList preLinkedList) {

        newDoublyLinedList.next = preLinkedList.next;

        newDoublyLinedList.next.pre = newDoublyLinedList;

        newDoublyLinedList.pre = preLinkedList;

        preLinkedList.next = newDoublyLinedList;

    }


    /**
     * 当某频率链表不存在，删除代表某频次的双向链表
     */
    void removeDoublyLinkedList(DoublyLinkedList doublyLinkedList) {

        doublyLinkedList.pre.next = doublyLinkedList.next;

        doublyLinkedList.next.pre = doublyLinkedList.pre;

    }

}



class Point2 {

    int key;

    int value;

    int freq = 1;

    Point2 pre; // Ponit2所在频率双向链表的前继Node

    Point2 next; // Ponit2所在频率的双向链表的后继Node

    DoublyLinkedList doublyLinkedList;
    // Node所在频率双向链表



    public Point2() {}



    public Point2(int key, int value) {

        this.key = key;

        this.value = value;

    }

}



class DoublyLinkedList {

    int freq; // 该双向链表表示的频次

    DoublyLinkedList pre;  // 该双向链表的前继链表（pre.freq < this.freq）

    DoublyLinkedList next; // 该双向链表的后继链表 (next.freq > this.freq)

    Point2 head; // 该双向链表的头节点，新节点从头部加入，表示最近访问

    Point2 tail; // 该双向链表的尾节点，删除节点从尾部删除，表示最久访问

    //头尾为虚拟节点

    public DoublyLinkedList() {

        head = new Point2();

        tail = new Point2();

        head.next = tail;

        tail.pre = head;

    }



    public DoublyLinkedList(int freq) {

        head = new Point2();

        tail = new Point2();

        head.next = tail;

        tail.pre = head;

        this.freq = freq;

    }



    void removeNode(Point2 point2) {

        point2.pre.next = point2.next;

        point2.next.pre = point2.pre;

    }



    void addNode(Point2 point2) {

        point2.next = head.next;

        head.next.pre = point2;

        head.next = point2;

        point2.pre = head;

        point2.doublyLinkedList = this;

    }



}

