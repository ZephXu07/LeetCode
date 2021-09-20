package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: LRU缓存
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-07
 */
public class LRU缓存 {

}
class LRUCache {
    class Node {
        Node pre;
        Node next;
        int key;
        int value;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        head = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        tail = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node tar = map.get(key);
        disConnect(tar);
        addNode(tar);
        return tar.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            disConnect(node);
            addNode(node);
            return;
        }
        if (size < capacity) {
           Node node = addNode(key, value);
           map.put(key, node);
           size++;
        } else {
            Node tmp = deleteLast();
            map.remove(tmp.key);
            Node node = addNode(key, value);
            map.put(key, node);
        }
    }



    private Node addNode (int key, int value) {
        Node node = new Node(key, value);
        addNode(node);
        return node;
    }

    private void addNode (Node node) {
        Node tmp = head.next;
        node.pre = head;
        node.next = tmp;
        head.next = node;
        tmp.pre = node;
    }

    private Node deleteLast () {
        Node tar = tail.pre;
        disConnect(tar);
        return tar;
    }


    private void disConnect (Node tar) {
        Node pre = tar.pre;
        Node next = tar.next;
        pre.next = next;
        next.pre = pre;
        tar.next = null;
        tar.pre = null;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1) + "\t-1");
        System.out.println(cache.get(2) + "\t3");
    }
}
