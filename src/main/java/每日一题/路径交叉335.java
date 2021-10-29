package 每日一题;

import java.util.HashSet;
import java.util.Set;

/**
 * Title: 路径交叉335
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-29
 */
public class 路径交叉335 {
    public boolean isSelfCrossing(int[] distance) {
        int len = distance.length;
        if (len < 4) {
            return false;
        }
        int inx = 2;

        /*
            一直向外卷
         */
        while (inx < len && distance[inx] > distance[inx - 2]) {
            inx++;
        }
        /*
            如果走完了，直接就可以返回不相交
         */
        if (inx == len) {
            return false;
        }


        /*
            如果向外卷转成了向内卷，i-1的长度减i-3的长度
         */
        if (distance[inx] >= distance[inx - 2] - (inx < 4 ? 0 : distance[inx - 4])) {
            distance[inx - 1] -= inx < 3 ? 0 : distance[inx - 3];
        }
        inx++;

        while (inx < len && distance[inx] < distance[inx - 2]) {
            inx++;
        }
        return inx != len;

    }

    public static void main(String[] args) {
        路径交叉335 res = new 路径交叉335();
//        System.out.println(res.isSelfCrossing(new int[]{2, 1, 1, 2}) + "\tT");
//        System.out.println(res.isSelfCrossing(new int[]{1,2,3,4}) + "\tF");
//        System.out.println(res.isSelfCrossing(new int[]{1,1,1,1}) + "\tT");
//        System.out.println(res.isSelfCrossing(new int[]{1,1,2,2,1,1}) + "\tT");
//        System.out.println(res.isSelfCrossing(new int[]{3,3,3,2,1,1}) + "\tF");
        System.out.println(res.isSelfCrossing(new int[]{1,1,2,1,1}) + "\tT");
    }
}
