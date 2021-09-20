package 每日一题;

/**
 * Title: 设计哈希映射
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-14
 */
public class 设计哈希映射 {

}
class MyHashMap {
    private Node[] nodes;

    public MyHashMap() {
        nodes = new Node[10009];
    }

    public void put(int key, int value) {
        // 根据 key 获取哈希桶的位置
        int idx = getIndex(key);
        // 判断链表中是否已经存在
        Node loc = nodes[idx];
        Node tmp = loc;
        if (loc != null) {
            Node prev = null;
            while (tmp != null) {
                if (tmp.key == key) {
                    tmp.value = value;
                    return;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            tmp = prev;
        }
        Node node = new Node(key, value);

        // 尾插法
        if (tmp != null) {
            tmp.next = node;
        } else {
            nodes[idx] = node;
        }
    }

    public int get(int key) {
        int idx = getIndex(key);
        Node loc = nodes[idx];
        if (loc != null) {
            while (loc != null) {
                if (loc.key == key) {
                    return loc.value;
                }
                loc = loc.next;
            }
        }
        return -1;
    }

    public void remove(int key) {
        // 根据 key 获取哈希桶的位置
        int idx = getIndex(key);
        // 判断链表中是否已经存在
        Node loc = nodes[idx];
        Node tmp = loc;
        if (loc != null) {
            Node prev = null;
            while (tmp != null) {
                if (tmp.key == key) {
                    if (null == prev) {
                        nodes[idx] = loc.next;
                    } else {
                        prev.next = tmp.next;
                    }
                    tmp = null;
                    return;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            tmp = prev;
        }
    }

    private static class Node {
        private int key;
        private int value;
        private Node next;
        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }


    }

    private int getIndex(int key) {
        // 因为 nodes 的长度只有 10009，对应的十进制的 10011100011001（总长度为 32 位，其余高位都是 0）
        // 为了让 key 对应的 hash 高位也参与运算，这里对 hashCode 进行右移异或
        // 使得 hashCode 的高位随机性和低位随机性都能体现在低 16 位中
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        return hash % nodes.length;
    }
}
