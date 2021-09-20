package codetop;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Title: 会议室
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-07
 */
public class 会议室 {
    public boolean minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        /*
            排序，当前会议的开始时间早于上一个会议的结束时间
            则无法参加两个会议，即false
         */
        for(int i = 0;i < intervals.length-1;i++){
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}
