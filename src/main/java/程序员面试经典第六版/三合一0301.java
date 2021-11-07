package 程序员面试经典第六版;

/**
 * Title: 三合一0301
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-06
 */
public class 三合一0301 {
    public static void main(String[] args) {
        TripleInOne t = new TripleInOne(18);
//        t.push(0, 1);
//        t.push(0, 2);
        System.out.println(t.peek(1));
        System.out.println(t.pop(2));
        System.out.println(t.pop(0));
        System.out.println(t.pop(0));

        System.out.println(t.isEmpty(0));
    }
}
class TripleInOne {
    private int[] stack;
    private int one;
    private int two;
    private int three;
    private int size;
    public TripleInOne(int stackSize) {
        stack = new int[3 * stackSize];
        one = 0;
        two = stackSize;
        three = 2 * stackSize;
        size = stackSize;
    }

    public void push(int stackNum, int value) {
        switch (stackNum) {
            case 0 :
                if (one < size) {
                    stack[one] = value;
                    one++;
                }
                break;
            case 1 :
                if (two < 2 * size) {
                    stack[two] = value;
                    two++;
                }
                break;
            default :
                if (three < 3 * size) {
                    stack[three] = value;
                    three++;
                }
                break;
        }
    }

    public int pop(int stackNum) {
        int res = -1;
        switch (stackNum) {
            case 0 :
                if (one != 0) {
                    res = stack[one - 1];
                    one--;
                }
                break;
            case 1 :
                if (two != size) {
                    res = stack[two - 1];
                    two--;
                }
                break;
            default :
                if (three != 2 * size) {
                    res = stack[three - 1];
                    three--;
                }
                break;
        }
        return res;
    }

    public int peek(int stackNum) {
        int res = -1;
        switch (stackNum) {
            case 0 :
                if (one != 0) {
                    res = stack[one - 1];
                }
                break;
            case 1 :
                if (two !=  size) {
                    res = stack[two - 1];
                }
                break;
            default :
                if (three != 2 * size) {
                    res = stack[three - 1];
                }
                break;
        }
        return res;
    }

    public boolean isEmpty(int stackNum) {
        switch (stackNum) {
            case 0 :
                return one == 0;
            case 1 :
                return two == size;
            default :
                return three == 2 * size;
        }
    }
}
