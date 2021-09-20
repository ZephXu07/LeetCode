package 每日一题;


import java.util.*;

/**
 * Title: 笨阶乘
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-01
 */
public class 笨阶乘 {
//    public int clumsyMy(int N) {
//        int count = 0;
//        int tmp = N;
//        Queue<Character> queue = new LinkedList<>();
//        while (count < N) {
//            StringBuilder builder = intToChar(tmp);
//            for (int i = builder.length() - 1; i >= 0; i--) {
//                queue.offer(builder.charAt(i));
//            }
//            int i = count % 4;
//            switch (i) {
//                case 0:
//                    queue.offer('*');
//                    break;
//                case 1:
//                    queue.offer('/');
//                    break;
//                case 2:
//                    queue.offer('+');
//                    break;
//                case 3:
//                    queue.offer('-');
//                    break;
//                default:
//                    break;
//            }
//            count++;
//            tmp--;
//        }
//        return compute(queue);
//    }
//
//
//    private StringBuilder intToChar (int N) {
//        StringBuilder builder = new StringBuilder();
//        while (N != 0) {
//            builder.append(N % 10);
//            N /= 10;
//        }
//        return builder;
//    }
//
//    private int compute(Queue<Character> queue) {
//        int num = 0;
//        Deque<Integer> stack = new LinkedList<>();
//        char sign = '+';
//        char c;
//        while (!queue.isEmpty()) {
//            c = queue.poll();
//            if (c == '(') {
//                num = compute(queue);
//            } else if (Character.isDigit(c)){
//                num = 10 * num + c - '0';
//            } else {
//                switch (sign) {
//                    case '+':
//                        stack.push(num);
//                        break;
//                    case '-':
//                        stack.push(-num);
//                        break;
//                    case '*':
//                        stack.push(stack.pop() * num);
//                        break;
//                    case '/':
//                        stack.push(stack.pop() / num);
//                        break;
//                    default:
//                        break;
//                }
//                sign = c;
//                num = 0;
//                if (c == ')') {
//                    break;
//                }
//            }
//        }
//        int res = 0;
//        while (!stack.isEmpty()) {
//            res += stack.pop();
//        }
//        return res;
//    }


    public int clumsy(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        } else if (N % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
        //具体看
        //https://leetcode-cn.com/problems/clumsy-factorial/solution/ben-jie-cheng-by-leetcode-solution-deh2/
    }

    public static void main(String[] args) {
        笨阶乘 res = new 笨阶乘();
//        int N = 4;
        int N = 10;
        System.out.println(res.clumsy(N));
    }
}
