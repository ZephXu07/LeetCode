package codetop;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 简化路径
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-28
 */
public class 简化路径 {
    public String simplifyPath(String path) {
        /*
            分割 "/"
            "" 与 "." 忽略
            ".."  当双端队列不为空弹出
            其他情况添加
            最后头部移出
         */
        String[] split = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for (String s : split) {
            if ("".equals(s) || ".".equals(s)) {
                continue;
            }
            if ("..".equals(s)) {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else {
                deque.addLast(s);
            }
        }

        StringBuilder res = new StringBuilder("/");
        while (!deque.isEmpty()) {
            res.append(deque.removeFirst());
            if (!deque.isEmpty()) {
                res.append("/");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        简化路径 res = new 简化路径();
        System.out.println(res.simplifyPath("/a/./b/../../c/"));
    }
}
