package codetop;

/**
 * Title: 数组中两个数的最大异或值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-01
 */
public class 数组中两个数的最大异或值 {
    public int findMaximumXOR(int[] nums) {
        //构建前缀树
        Trie trie = new Trie();
        //最大的异或结果
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            //向树中添加数
            trie.add(nums[i]);
            //从树中查找与当前数的 异或和最大的数，如果有两个数以上，肯定找得到其他数
            //因为只有一个数,则他只能异或自己,一定为0
            max = Math.max(max, trie.findMax(nums[i]));
        }
        return max;
    }


    /**
     * 前缀树
     */
    static class Trie {
        //前缀树两个节点,一个0,一个1
        Trie[] next;

        public Trie() {
            this.next = new Trie[2];
        }

        //向前缀树中添加元素
        public void add(int num) {
            Trie root = this;
            //保留31位整数的状态到前缀树中，题目提供的都是整数，忽略开始的 0
            for (int i = 30; i >= 0; i--) {
                //int类型非负数，第一位的符号位可忽略
                //取出num中第 i 位的状态 0 或 1（从0数起）
                int index = (num >> i) & 1;
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
        public int findMax(int num) {
            Trie root = this;
            //当前前缀树
            int res = 0;
            for (int i = 30; i >= 0; i--) {
                //取出num中第 i 位的状态（从0数起）
                int index = (num >> i) & 1;

                //如果这位为1,那么他希望异或0,如果为0,希望异或1
                //所以把期望坐标取反
                index ^= 1;

                //如果有期望的值,肯定走期望
                if (null != root.next[index]) {
                    //结果加上这个值
                    res |= (1 << i);
                    //因为使用异或，所以与 index 不同，所以异或结果是 1 ，这一位上的 1 直接计算到结果上
                } else {
                    //说明没有期望的值,只能走另一条路
                    //说明两个相同，为0，index 异或回去，
                    // 原来 0 期望 1， 1期望 0
                    // 所以回去，因为res 第 i 位上 原先是0，所以不需要计算上
                    index ^= 1;
                    //得到现在在的节点上，进入下一层
                }
                root = root.next[index];
                //进入下一层
            }
            return res;
            /*
                返回最终结果
             */
        }
    }
}
