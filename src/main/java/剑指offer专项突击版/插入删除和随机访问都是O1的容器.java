package 剑指offer专项突击版;

import java.util.*;

/**
 * Title: 插入删除和随机访问都是O1的容器
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-02
 */
public class 插入删除和随机访问都是O1的容器 {
}
class RandomizedSet {

    /** Initialize your data structure here. */
    private ArrayList<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int inx = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(inx, last);
        map.put(last, inx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
