package 字节.LFU缓存;

import java.util.HashMap;

/**
 * Title: LFUCache3
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-08
 */
public class LFUCache3 {

    HashMap<Integer, Node> cache;
    Node head;
    Node tail;
    int capacity;
    int size;
    //从小到大频率排列

    public LFUCache3(int capacity) {
        cache = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        //虚拟节点
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        node.freq++;
        //频率添加
        moveToNewPosition(node);
        //调整位置
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            node.freq++;
            //频率添加，调整位置
            moveToNewPosition(node);
        } else {
            if (size == capacity) {
                cache.remove(head.next.key);
                //删除哈希表，虚拟头节点的下一个即是最久最少使用
                removeNode(head.next);
                //删除节点
                size--;
            }
            Node newNode = new Node(key, value);
            addNode(newNode);
            //添加节点到头再内部调整
            cache.put(key, newNode);
            //放入哈希表
            size++;
        }
    }

    private void moveToNewPosition(Node node) {
        //调整位置
        Node nextNode = node.next;
        //需要调整节点的下一个节点
        removeNode(node);
        //删除此节点
        while (nextNode.freq <= node.freq && nextNode != tail) {
            nextNode = nextNode.next;
        }
        //寻找第一个比此节点频率大的节点
        nextNode.pre.next = node;
        node.pre = nextNode.pre;
        node.next = nextNode;
        nextNode.pre = node;
        //前后连接起来
    }

    private void addNode(Node node) {
        //添加到头再调整
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        moveToNewPosition(node);
    }

    private void removeNode(Node node) {
        //断了此节点的前后连接
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}

class Node {
    int key;
    int value;
    int freq = 1;
    Node pre;
    Node next;

    public Node() {}
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
