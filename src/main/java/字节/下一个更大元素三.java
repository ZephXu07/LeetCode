package 字节;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 下一个更大元素三
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-17
 */
public class 下一个更大元素三 {
    public  int nextGreaterElement(int n) {
        char[] copy = ("" + n).toCharArray();
        //转化为char数组方便操作  158476531
        int pre = copy.length - 2;
        //倒数第二个
        while (pre >= 0 && copy[pre] >= copy[pre + 1]) {
            pre--;
            //从后往前比较，找到递减序列的前一个值A，即这个值后续都是递减的
            //158476531 中的4
        }
        if (pre < 0) {
            return -1;
        }
        //整个数组都是递减，没有下一个最大的数
        int cur = pre + 1;
        while (cur < copy.length && copy[cur] > copy[pre]) {
            //在递减序列中找到第一个比A小的数B
            //158476531 中的5
            cur++;
        }
        cur --;
        //B的坐标
        swap(copy, pre, cur);
        //交换A、B
        //158576431
        reverse(copy, pre + 1);
        //把原递减序列（A、B交换后不递减）逆转
        //158513467
        long res = Long.parseLong(new String(copy));
        //转化为整数，可能超出int范围

        if (res > Integer.MAX_VALUE) {
            return -1;
            //超出范围返回1
        } else {
            return (int)res;
            //转化为int
        }

    }

    /**
     * Title:
     * Description: 交换i，j位置在数组中的值
     *
     * @author zephxu
     * @version V1.0
     * @date 2021-04-19 10:40
     */

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Title:
     * Description: 反转数组i下标到末尾的值
     *
     * @author zephxu
     * @version V1.0
     * @date 2021-04-19 10:41
     */

    private void reverse(char[] arr, int i) {
        int j = arr.length - 1;
        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }

    }

    public static void main(String[] args) {
        int n = 12443322;
        下一个更大元素三 res = new 下一个更大元素三();
        System.out.println(res.nextGreaterElement(n));
    }
}
