package codetop;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Title: 生存人数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-19
 */
public class 生存人数 {
    public int maxAliveYear(int[] birth, int[] death) {
        Arrays.sort(birth);
        Arrays.sort(death);
        int inx = 0;
        int m = birth.length;
        int n = death.length;
        int live = 0;
        /*
            从前到当前遍历活过的人
         */
        int dead = 0;
        /*
            从前到当前遍历已经死亡的人
         */
        int res = 0;
        /*
            活着的人最多的年份
         */
        int count = 0;
        /*
            当前年代活着的人
         */
        for (int i = 0; i < m; i++) {
            /*
                遍历完存在出生的年代后的那些存在死亡的年代一定是当前活着的人减少
             */
            live++;
            /*
                如果当前遍历的存在死亡的年份是当前存在出生的年份的同一年还是之后
                均不会对从以前到当前的已死亡的人数有影响
             */
            if (birth[i] > death[inx]) {
                /*
                    如果当前存在出生的年份是当前遍历的存在死亡的年份之后
                    则从以前到当前年份的已死亡的人数需要增加
                    自然 death 数组下标移动
                    而题目 birth[i] <= death[i] 则说明了存在死亡的最大年份
                    大于等于存在出生的年份
                    所以不用担心会溢出
                */
                dead++;
                inx++;
            }
            if (count < live - dead) {
                /*
                    如果遍历到更多人当前还活着的年份
                    则进行替换
                 */
                count = live - dead;
                res = birth[i];
            }
        }
        return res;
    }
}
