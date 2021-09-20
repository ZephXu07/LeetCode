package 每日一题;

import java.util.*;

/**
 * Title: 账户合并
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-18
 */
public class 账户合并 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //每个邮箱的数字下标
        Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
        //每个邮箱对应的用户名
        Map<String, String> emailToName = new HashMap<String, String>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }
        //同一个用户名下的邮箱用并查集连接在一起
        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }

        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        //得到邮箱集合（此方式得到的邮箱没有重复）
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            //得到一个邮箱在并查集中的父节点的邮箱的下标
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            //将同一父节点的邮箱集合起来，即同一账户
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            //排序
            String name = emailToName.get(emails.get(0));
            //获得同一账户的用户名
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            //重新排序，用户名放最前面，准备放进结果集
            merged.add(account);
        }
        return merged;
    }



    private class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int index1, int index2) {
            parent[find(index2)] = find(index1);
        }

        public int find(int index) {
            if (parent[index] != index) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
    }
}
