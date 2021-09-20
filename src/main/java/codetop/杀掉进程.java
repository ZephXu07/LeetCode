package codetop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: 杀掉进程
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-07
 */
public class 杀掉进程 {

    /**
     * 当一个进程被杀掉的时候，它所有的孩子进程和后代进程都要被杀掉。可以以任意顺序排列返回的 PID 序列。
     * pid[i] 的父进程为 ppid[i]
     *
     * @param pid  进程编号，只有一个进程的 PPID 是 0 ，意味着这个进程没有父进程
     * @param ppid 父进程编号
     * @param kill 待杀死的进程编号
     * @return 被杀死的进程的编号集合
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        /*
            key 为父进程编号，value 为该进程的子进程编号集合
         */
        Map<Integer, List<Integer>> map = new HashMap<>(pid.size());
        /*
            遍历父进程编号集合
         */
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                List<Integer> l = map.getOrDefault(ppid.get(i), new ArrayList<>());
                /*
                    取出子进程集合
                 */
                l.add(pid.get(i));
                /*
                    添加新的子进程编号

                 */
                map.put(ppid.get(i), l);
                /*
                    把子进程集合放回去
                 */
            }
        }
        List<Integer> l = new ArrayList<>();
        l.add(kill);
        getAllChildren(map, l, kill);
        return l;
    }

    /**
     * 获取进程 kill 的所有子孙进程并装入到 l 中
     * @param map
     * @param l
     * @param kill
     */
    public void getAllChildren(Map<Integer, List<Integer>> map, List<Integer> l, int kill) {
        if (map.containsKey(kill)) {
            /*
                如果存在被杀死的进程
             */
            for (int id : map.get(kill)) {
                /*
                    取出待杀死进程的子进程编号集合
                 */
                l.add(id);
                /*
                    自己也要被杀死

                 */
                getAllChildren(map, l, id);
                /*
                    dfs，子进程的子进程也要杀死
                 */
            }
        }
    }
}
