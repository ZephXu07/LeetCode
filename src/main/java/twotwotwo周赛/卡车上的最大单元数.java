package twotwotwo周赛;

import java.util.*;

/**
 * Title: 卡车上的最大单元数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-03
 */
public class 卡车上的最大单元数 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        if (null == boxTypes || boxTypes.length == 0 || truckSize == 0){
            return 0;
        }
        Arrays.sort(boxTypes, (i1,i2)->i2[1]-i1[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            if (truckSize <= 0) {
                break;
            }
            if (truckSize <= boxType[0]) {
                res += truckSize * boxType[1];
                return res;
            }
            res += boxType[0] * boxType[1];
            truckSize -= boxType[0];
        }
        return res;
    }

    public static void main(String[] args) {
        卡车上的最大单元数 sum = new 卡车上的最大单元数();
        int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9}} ;
        int truckSize = 10;
        System.out.println(sum.maximumUnits(boxTypes, truckSize));
    }
}
