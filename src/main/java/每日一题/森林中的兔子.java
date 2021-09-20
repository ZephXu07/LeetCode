package 每日一题;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Title: 森林中的兔子
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-04
 */
public class 森林中的兔子 {
    public int numRabbits(int[] answers) {
        //贪心？
        int[] count = new int[1000];
        //题目范围，因此不选用哈希表而是数组
        int res = 0;
        //数量
        for (int inx : answers) {
            if (count[inx] == 0) {
                //此种颜色没有出现过
                count[inx] = inx;
                //计算剩下的数量
                res += inx + 1;
                //加入到总数中
            } else {
                count[inx]--;
                //在已经出现的颜色数量减去一
                if (count[inx] < 0) {
                    //小于负数则此种颜色的所有兔子已经出现，是新的颜色
                    res += inx + 1;
                    ////加入到总数中
                    count[inx] = inx;
                    //将其置为新的颜色剩余量
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        森林中的兔子 res = new 森林中的兔子();
        int[] answers = {1,1,2};
        //5
//        int[] answers = {10,10,10};
        //11
//        int[] answers = {1,0,1,0,0};
        //5
//        int[] answers = {0,0,1,1,1};
        //6
//        int[] answers = {0,1,0,2,0,1,0,2,1,1};
        //11
        System.out.println(res.numRabbits(answers));
    }
}
