package 每日一题;

/**
 * Title: 情侣牵手
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-14
 */
public class 情侣牵手 {
//    public int minSwapsCouples(int[] row) {
//        int len = row.length;
//        UnionFind uF = new UnionFind(len / 2);
//        for (int i = 0; i < len; i += 2) {
//            uF.union(row[i] / 2, row[i + 1] / 2);
//        }
//        return len / 2 - uF.count;
//    }
//
//    class UnionFind {
//        private int[] parent;
//        private int[] size;
//        private int count;
//        public UnionFind(int len) {
//            parent = new int[len];
//            size = new int[len];
//            count = len;
//            for (int i = 0; i < len; i++) {
//                parent[i] = i;
//                size[i] = 1;
//            }
//        }
//
//        public void union(int p, int q) {
//            int rootP = find(p);
//            int rootQ = find(q);
//            if (rootP == rootQ) {
//                return;
//            }
//            if (size[rootP] > size[rootQ]) {
//                parent[rootQ] = rootP;
//                size[rootP] += size[rootQ];
//            } else {
//                parent[rootP] = rootQ;
//                size[rootQ] += size[rootP];
//            }
//            count--;
//        }
//
//        public int find(int x) {
//            while (parent[x] != x) {
//                parent[x] = parent[parent[x]];
//                x = parent[x];
//            }
//            return x;
//        }
//    }

    public int minSwapsCouples(int[] row) {
        int ans = 0;
        int[] pos = new int[row.length];

        for (int i = 0; i < pos.length; i++) {
            pos[row[i]] = i;  //每个人对应的位置
        }

        for (int i = 0; i < pos.length; i += 2) {
            int pairPerson = row[i] ^ 0x1;  //i号位置的情侣应该是谁
            if (row[i + 1] == pairPerson) {
                continue;  //右边是情侣，直接继续处理下一个。
            }

            int nextPerson = row[i + 1]; //右边不是情侣，得到右边的人是谁
            int changePos = pos[pairPerson]; //得到情侣的位置在哪

            row[changePos] = nextPerson; //交换后，情侣位置坐上了右边的人nextPerson
            pos[nextPerson] = changePos; //交换后，右边人nextPerson的位置发生了改变，记录下来。
            ans++;
        }

        return ans;
    }

}
