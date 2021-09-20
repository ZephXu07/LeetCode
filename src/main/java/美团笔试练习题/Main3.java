package 美团笔试练习题;

import java.util.*;

/**
 * Title: Main3
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-17
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        while (sum > 0) {
            int desNum = in.nextInt();
            in.nextLine();
            String desNow = in.nextLine();
            int peoNum = in.nextInt();
            in.nextLine();
            String gender = in.nextLine();
            System.out.print(solve(desNum, desNow, peoNum, gender));
            sum--;
        }

//        int desNum = 5;
//        String desNow = "01102";
//        int peoNum = 6;
//        String gender = "MFMMFF";
//        solve(desNum, desNow, peoNum, gender);
    }

    private static String solve(int desNum, String desNow, int peoNum, String gender) {
        StringBuilder builder = new StringBuilder();
        int inx = 0;

        PriorityQueue<Integer>[] queue = new PriorityQueue[2];
        queue[0] = new PriorityQueue<Integer>();
        queue[1] = new PriorityQueue<Integer>();
        for (int i = 0; i < desNum; i++) {
            char c = desNow.charAt(i);
            if (c == '2') {
                continue;
            }
            queue[c - '0'].offer(i);
        }



        while (inx < peoNum) {
            if (gender.charAt(inx) == 'M') {
                if (!queue[1].isEmpty()) {
                    builder.append(queue[1].poll() + 1).append("\n");
                } else {
                    int tmp = queue[0].poll();
                    queue[1].offer(tmp);
                    builder.append(tmp + 1).append("\n");
                }
            } else {
                if (!queue[0].isEmpty()) {
                    int tmp = queue[0].poll();
                    queue[1].offer(tmp);
                    builder.append(tmp + 1).append("\n");
                } else {
                    builder.append(queue[1].poll() + 1).append("\n");
                }
            }
            inx++;
        }
        return builder.toString();
    }
}
