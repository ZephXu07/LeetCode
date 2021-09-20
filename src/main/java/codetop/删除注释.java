package codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 删除注释
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-04
 */
public class 删除注释 {
    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for (String line: source) {
            /*
                遍历每一行
             */
            int i = 0;
            /*
                line 字符串的下标
             */
            char[] chars = line.toCharArray();
            if (!inBlock) {
                /*
                    是否注释开始
                 */
                newline = new StringBuilder();
            }
            while (i < line.length()) {
                /*
                    遍历行
                 */
                if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    /*
                        不是注释，因为第一个注释优先级高
                        忽略后面的 "//" "* /" （中间无空字符，否则我自己的注释结束了！！！）
                        ，且出现 "/*" 注释
                        则注释开始
                     */
                    inBlock = true;
                    i++;
                } else if (inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    /*
                        之前已经进入注释
                        遇到 "* /" （中间无空字符，否则我自己的注释结束了！！！）
                        注释结束
                     */
                    inBlock = false;
                    i++;
                } else if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    /*
                        不是注释，且 "//" 出现的当行直接忽略
                        所以break
                     */
                    break;
                } else if (!inBlock) {
                    /*
                        不在注释里面，添加到结果
                     */
                    newline.append(chars[i]);
                }
                i++;
            }
            if (!inBlock && newline.length() > 0) {
                /*
                    行遍历结束，且不在注释里
                    并且有字符串而不是空
                 */
                ans.add(new String(newline));
            }
        }
        return ans;
    }
}
