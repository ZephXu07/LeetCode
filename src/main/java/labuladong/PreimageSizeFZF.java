package labuladong;

/**
 * Title: labuladong.PreimageSizeFZF
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-22
 */
public class PreimageSizeFZF {
    public int preimageSizeFZF(int K) {
        return (int)(rightBound(K) - leftBound(K) + 1);
    }

    public int preimageSizeFZF1(int K) {
        return (int)(rightBound1(K) - leftBound1(K) + 1);
    }

    private long trsailingZeros(long value) {
        long res = 0;
        for (long d = value; d / 5 > 0; d = d / 5){
            res += d / 5;
        }
        return res;
    }

    private long trsailingZeros1(long value) {
        if (value == 0) {
            return 0;
        }
        return value / 5 + trsailingZeros1(value / 5);
    }


    private long leftBound(int target) {
        long low = 0;
        long high = Long.MAX_VALUE;
        long mid;
        long tmp;
        while (low < high) {
            mid = low + (high - low) / 2;
            tmp = trsailingZeros(mid);
            if (tmp < target) {
                low = mid + 1;
            } else if (tmp > target) {
                high = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private long leftBound1(int target) {
        long low = 0;
        long high = Long.MAX_VALUE;
        long mid;
        long tmp;
        while (low < high) {
            mid = low + (high - low) / 2;
            tmp = trsailingZeros1(mid);
            if (tmp < target) {
                low = mid + 1;
            } else if (tmp > target) {
                high = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private long rightBound(int target) {
        long low = 0;
        long high = Long.MAX_VALUE;
        long mid;
        long tmp;
        while (low < high) {
            mid = low + (high - low) / 2;
            tmp = trsailingZeros(mid);
            if (tmp < target) {
                low = mid + 1;
            } else if (tmp > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
    }
    private long rightBound1(int target) {
        long low = 0;
        long high = Long.MAX_VALUE;
        long mid;
        long tmp;
        while (low < high) {
            mid = low + (high - low) / 2;
            tmp = trsailingZeros1(mid);
            if (tmp < target) {
                low = mid + 1;
            } else if (tmp > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        int i = new PreimageSizeFZF().preimageSizeFZF(50);
        System.out.println(i);
        long t2 = System.currentTimeMillis();
        System.out.println(t1 - t2);

        long t3 = System.currentTimeMillis();
        int v = new PreimageSizeFZF().preimageSizeFZF1(50);
        System.out.println(v);
        long t4 = System.currentTimeMillis();
        System.out.println(t3 - t4);
    }
}
