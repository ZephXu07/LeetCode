package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 移除最多的同行或同列石头
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-15
 */
public class 移除最多的同行或同列石头 {
    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for (int[] stone : stones) {
            unionFind.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - unionFind.count;
    }

    private class UnionFind {
        private Map<Integer, Integer> parent;
        private Map<Integer, Integer> rank;
        private int count;

        public UnionFind() {
            parent = new HashMap<>();
            rank = new HashMap<>();
            count = 0;
        }

        public int getCount() {
            return count;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            if (rank.get(rootP) > rank.get(rootQ)) {
                parent.put(rootQ, rootP);
                rank.put(rootP, rank.get(rootP) + rank.get(rootQ));
            } else {
                parent.put(rootP, rootQ);
                rank.put(rootQ, rank.get(rootP) + rank.get(rootQ));

            }
            count --;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                rank.put(x, rank.getOrDefault(x, 0) + 1);
                // 并查集集中新加入一个结点，结点的父亲结点是它自己，所以连通分量的总数 +1
                count++;
            }
            while (parent.get(x) != x) {
                parent.put(x, parent.get(x));
                x = parent.get(x);
            }
            return x;
        }
    }

//    public static void main(String[] args) {
//        移除最多的同行或同列石头 res = new 移除最多的同行或同列石头();
//        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
//        System.out.println(res.removeStones(stones));
//    }
}
