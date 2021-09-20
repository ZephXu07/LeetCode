package 每日一题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: 与数组中元素的最大异或值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-23
 */
public class 与数组中元素的最大异或值 {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        /*
            采用贪心和前缀树
            对nums进行排序，对queries的[1]排序
            因为题目要求是按原来queries的顺序，所以需要用hashmap进行坐标保存

            遍历排序后的queries，在nums中寻找小于等于 queries[i][1]的值，加入前缀树中，
            再在前缀树中寻找和queries[i][0]异或的值最大，因为异或是不同取1，取1则使值更大
            所以使用遍历的方法，有与queries[i][0]某个位相反的则取相反的节点，没有只能那样选择
         */
        Arrays.sort(nums);
        int len = queries.length;
        Map<int[],Integer> mapping = new HashMap<>(len);

        for (int i = 0; i < len; i++) {
            mapping.put(queries[i], i);
        }

        Arrays.sort(queries, Comparator.comparingInt(q -> q[1]));
        int inx = 0;

        Trie trie = new Trie();

        int[] res = new int[len];
        for (int[] q : queries) {
            while (inx < nums.length && nums[inx] <= q[1]) {
                trie.add(nums[inx]);
                inx++;
            }

            if (inx == 0) {
                //在nums中寻找不到小于等于 queries[i][1]的值，且由于是排序，所以是0
                res[mapping.get(q)] = -1;
            } else {
                res[mapping.get(q)] = trie.getMax(q[0]);
            }
        }

        return res;


    }


    /**
     * 前缀树
     */
    static class Trie {
        //前缀树俩个节点,一个0,一个1
        Trie[] next;

        public Trie() {
            this.next = new Trie[2];
        }

        //向前缀树中添加元素
        public void add(int num) {
            Trie root = this;
            //保留31位整数的状态到前缀树中
            for (int i = 30; i >= 0; i--) {
                //取出num中第 i 位的状态 0 或 1（从0数起）
                int index = num >> i & 1;
                /*
                 * 如果原来有,就不需要new新的,不然会覆盖原来的，
                 * 因为new新的后此位原本有存在不会变，但其接下里来的其他位会消失
                 */
                if (null == root.next[index]) {
                    root.next[index] = new Trie();
                }
                root = root.next[index];
                //进入下一层的位
            }
        }

        //查找前缀树中与当前数异或最大的元素
        public int getMax(int num) {
            Trie root = this;
            //当前前缀树
            int res = 0;
            for (int i = 30; i >= 0; i--) {
                //取出num中第 i 位的状态（从0数起）
                int index = num >> i & 1;

                //如果这位为1,那么他希望异或0,如果为0,希望异或1
                //所以把期望坐标取反
                index ^= 1;

                //如果有期望的值,肯定走期望
                if (null != root.next[index]) {
                    //结果加上这个值
                    res |= (1 << i);
                    //因为是不同，所以异或结果是 1 ，直接计算到结果上
                } else {
                    //说明没有期望的值,只能走另一条路
                    //说明两个相同，为0，因为res 原先是0，所以不需要计算上
                    index ^= 1;
                    //得到现在在的节点上，进入下一层
                }
                root = root.next[index];
                //进入下一层
            }
            return res;
        }
    }
}
