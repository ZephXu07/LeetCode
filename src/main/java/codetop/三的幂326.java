package codetop;

/**
 * Title: 三的幂326
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-21
 */
public class 三的幂326 {
    public boolean isPowerOfThree(int n) {
//        if (n == 0) {
//            return false;
//        }
//        while (n != 1) {
//            if (n % 3 != 0) {
//                return false;
//            }
//            n /= 3;
//        }
//        return true;

        return n > 0 && 1162261467 % n == 0;
        /*
            int 里面 3 的幂最大是 3^19 = 1162261467
            又 3 是质数，所以 3^19 的除数有 3^0,3^1......3^18,3^19
            则如果 3^19 取余 n 为 0，则说明是 3 的幂
         */
    }
}
