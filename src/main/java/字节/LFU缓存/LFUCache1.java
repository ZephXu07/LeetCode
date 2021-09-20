package 字节.LFU缓存;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Title: LFUCache1
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-08
 */
public class LFUCache1{
    private Map<Integer, Point1> cache;
    // 存储缓存的内容：存储键，与键对应的键值对

    private Map<Integer, LinkedHashSet<Point1>> freqMap;
    // 存储每个频次对应的双向链表，按插入顺序
    int size;
    //当前数量
    int capacity;
    //容量
    int min;
    // 存储当前最小频次

    public LFUCache1(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Point1 point2 = cache.get(key);
        //哈希表获得
        if (point2 == null) {
            return -1;
            //不存在
        }
        freqInc(point2);
        //get次数加一，调整
        return point2.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
            //无容量，放弃操作
        }
        Point1 point2 = cache.get(key);
        //获得对应键值对
        if (point2 != null) {
            //不为空，已存在，修改值
            point2.value = value;
            //put次数+1，修改次数
            freqInc(point2);
        } else {
            if (size == capacity) {
                //容量满了
                Point1 deadNode = removeNode();
                //删除最久没使用且次数最低那个
                cache.remove(deadNode.key);
                //从键-（键值对）哈希表删除
                size--;
                //容量减一
            }
            Point1 newNode = new Point1(key, value);
            //新键值对
            cache.put(key, newNode);
            //存入键-（键值对）哈希表
            addNode(newNode);
            //添加键值对到对应频率链表
            size++;
        }
    }

    private void freqInc(Point1 point2) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = point2.freq;
        //得到要调整的键值对的次数
        LinkedHashSet<Point1> set = freqMap.get(freq);
        //得到要调整的键值对的次数的对应链表
        set.remove(point2);
        //从链表里删除
        if (freq == min && set.size() == 0) {
            min = freq + 1;
            //当此链表唯有一个节点，且是最小次数时，最低频率增加，
            // 即使第二低是后面第二个，也会因为put，get次数增加
        }
        // 加入新freq对应的链表
        point2.freq++;
        LinkedHashSet<Point1> newSet = freqMap.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>());
        //如果不存在则创建，频率为freq+1的链表
        newSet.add(point2);
    }

    private void addNode(Point1 point2) {
        //因为是需要添加新节点，所以此节点的次数最低为1
        LinkedHashSet<Point1> set = freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>());
        //如果此链表不存在则创建
        set.add(point2);
        min = 1;
        //修改最低为1
    }

    private Point1 removeNode() {
        //以上种种保证此链表会存在
        LinkedHashSet<Point1> set = freqMap.get(min);
        //移除次数最低的节点
        Point1 deadNode = set.iterator().next();
        //获得迭代器，迭代器下一个即是数据的真正第一个
        set.remove(deadNode);
        //从链表里删除
        return deadNode;
        //返回要删除的键值对来删除对应的键-（键值对）哈希表的键
    }
}

class Point1 {
    int key;
    int value;
    int freq = 1;

    public Point1() {}

    public Point1(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
