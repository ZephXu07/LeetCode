package codetop;

/**
 * Title: 加油站
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-10
 */
public class 加油站 {
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int len = gas.length;
//        int x = 0;
//        /*
//            返回的站点，即起始站点，如果达到要求的话
//         */
//        while (x < len) {
//            int gasSum = 0;
//            /*
//                汽油总和
//             */
//            int costSum = 0;
//            /*
//                花费总和
//             */
//            int i = 0;
//            /*
//                经过多少站点
//             */
//            while (i < len) {
//                int y = (x + i) % len;
//                /*
//                    起始站点 + 经过站点 = 到达的站点，因为循环，所以取余
//                 */
//                gasSum += gas[y];
//                costSum += cost[y];
//                /*
//                    计算各自和
//                 */
//                if (costSum > gasSum) {
//                    /*
//                        花费大于汽油总和，不成立
//                     */
//                    break;
//                }
//                i++;
//                /*
//                    汽油 >= 花费 则可以尝试下一个站点
//                 */
//            }
//            if (i == len) {
//                /*
//                    经过站点数等于站点总数，说明此站点是结果
//                 */
//                return x;
//            } else {
//                x += i + 1;
//                /*
//                    否则重新寻找站点，从要到达的失败站点开始
//                    因为 x 可以到达 y，但 到达不了 y + 1，
//                    说明
//                        到达 y 的剩余汽油 + y 的补充汽油 < y 到 y + 1 的汽油花费
//
//                    如果从 y 开始，由上式已知
//                        y 的补充汽油 < y 到 y + 1 的汽油花费
//
//                    如果是 (x,y) 的站点，到达 y 的剩余汽油总是大于等于 0 的，
//                    同理到达上述 (x,y)的点剩余汽油也是大于等于 0 的
//
//                    一直到最开始的 x 开始由 0 + x 的汽油开始，
//                    到达下一个站点的剩余汽油只能不断减小，
//                    所以从 x 开始到达 y 的剩余汽油是不断减小的，
//                    而最大的剩余汽油 + y 的补充 都小于 y 到 y + 1 的花费
//                    比最大还小的怎么可能到达，所以下一个从 y + 1 开始试验
//                 */
//            }
//        }
//        return -1;
//        /*
//            每个站点都试了，不能则返回 - 1
//         */
//    }

    
}
