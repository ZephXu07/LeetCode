package labuladong;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Title: labuladong.ExamRoom
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-18
 */
public class ExamRoom {
    private Map<Integer, int[]> leftSeats;
    private Map<Integer, int[]> rightSeats;
    private TreeSet<int[]> seats;
    private int maxSize;
    public ExamRoom(int N) {
        this.maxSize = N;
        leftSeats = new HashMap<>();
        rightSeats = new HashMap<>();
        seats = new TreeSet<>((left, right) -> {
            int leftLen = getDistance(left);
            int rightLen = getDistance(right);
            if (leftLen == rightLen) {
                return right[0] - left[0];
            }
            return leftLen - rightLen;
        });
        addSegment(new int[]{-1, N});
    }


    private void removeSegment(int[] segment) {
        seats.remove(segment);
        leftSeats.remove(segment[1]);
        rightSeats.remove(segment[0]);

    }


    private void addSegment(int[] segment) {
        seats.add(segment);
        leftSeats.put(segment[1], segment);
        rightSeats.put(segment[0], segment);
    }

    private int getDistance(int[] segment) {
        int x = segment[0];
        int y = segment[1];
        if (x == -1) {
            return y;
        }
        if (y == maxSize) {
            return maxSize - 1 - x;
        }
        return (y - x) / 2;
    }

    public int seat() {
        int[] max = seats.last();
        int start = max[0];
        int end = max[1];
        int ans;
        if (-1 == start) {
            ans = 0;
        } else if (maxSize == end) {
            ans = maxSize - 1;
        } else {
            ans = (end - start) / 2 + start;
        }
        int[] left = {start, ans};
        int[] right = {ans, end};
        removeSegment(max);
        addSegment(left);
        addSegment(right);
        return ans;
    }

    public void leave(int p) {
        int[] left = leftSeats.get(p);
        int[] right = rightSeats.get(p);
        int[] merge = {left[0], right[1]};

        removeSegment(left);
        removeSegment(right);
        addSegment(merge);
    }











}
