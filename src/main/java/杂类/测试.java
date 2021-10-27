package 杂类;

/**
 * Title: 测试
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-26
 */
public class 测试 {

    public static void main(String[] args) {
        short s = 1;
        s = (short) (s + 1);



        Integer f = new Integer(11);
        Integer g = new Integer(11);
        Integer h = 11;
        Integer i = Integer.valueOf(11);
        System.out.println(f == g);
        System.out.println(f == h);
        System.out.println(f == i);
        Integer j = 11;

        System.out.println(h == j);
        System.out.println(h == i);
    }
}
class LifeCycle {
    // 静态属性
    private static String staticField = getStaticField();
    // 静态块
    static {
        System.out.println(staticField);
        System.out.println("静态块");
    }
    // 普通属性
    private String field = getField();
    // 普通方法块
    {
        System.out.println(field);
    }
    // 构造方法
    public LifeCycle() {
        System.out.println("构造方法");
    }

    //静态方法
    public static String getStaticField() {
        String statiFiled = "静态属性";
        return statiFiled;
    }
    //静态方法
    public static String getField() {
        String filed = "静态属性";
        return filed;
    }
    //
    public static void main(String[] argc) {
        new LifeCycle();
    }
}

class TableSizeFor {
    public static int test (int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 1024; i++) {
            System.out.println(i + "----->" + test(i));
        }
        System.out.println(Math.pow(2, 30) + 1 + "----->" + test((int)Math.pow(2, 30) + 1));
    }
}
