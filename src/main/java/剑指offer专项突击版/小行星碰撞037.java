package 剑指offer专项突击版;

import java.util.*;

/**
 * Title: 小行星碰撞037
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-04
 */
public class 小行星碰撞037 {
    public int[] asteroidCollision(int[] asteroids) {
        int inx = 0;
        int len = asteroids.length;
        List<Integer> res = new ArrayList<>(len);
        /*
            添加前面的负数
         */
        while (inx < len && asteroids[inx] < 0) {
            res.add(asteroids[inx]);
            inx++;
        }
        if (inx == len) {
            /*
                全部都是负数，直接返回
             */
            return asteroids;
        }
        Deque<Integer> stack = new LinkedList<>();
        stack.push(asteroids[inx++]);
        /*
            遇到了正数，存入栈
         */
        while (inx < len) {
            boolean dir = asteroids[inx] > 0;

            if (dir) {
                /*
                    正数存栈
                 */
                stack.push(asteroids[inx]);
            } else {
                /*
                    负数，与栈中比较绝对值
                    相等两个一起消失
                    大于则负数消失
                    小于则栈中下一个数
                    直到栈空或者负数为 0

                    如果栈为空，负数不为 0
                    加入前面的存负数的地方
                 */
                while (!stack.isEmpty() && asteroids[inx] != 0) {
                    int tmp = stack.pop();
                    int sum = tmp + asteroids[inx];
                    if (sum > 0) {
                        asteroids[inx] = 0;
                        stack.push(tmp);
                    } else if (sum == 0) {
                        asteroids[inx] = 0;
                    }
                }
                if (stack.isEmpty() && asteroids[inx] != 0) {
                    res.add(asteroids[inx]);
                }
            }
            inx++;
        }
        len = res.size();
        int[] ans = new int[len + stack.size()];
        for (int i = 0; i < len; i++) {
            /*
                负数正序存储
             */
            ans[i] = res.get(i);
        }
        inx = len + stack.size() - 1;
        while (!stack.isEmpty()) {
            /*
                栈先进先出，逆序存储
             */
            ans[inx--] = stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        小行星碰撞037 res = new 小行星碰撞037();
        System.out.println(Arrays.toString(res.asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(res.asteroidCollision(new int[]{8,-8})));
        System.out.println(Arrays.toString(res.asteroidCollision(new int[]{10,2,-5})));
        System.out.println(Arrays.toString(res.asteroidCollision(new int[]{-2,-1,1,2})));
    }
}
