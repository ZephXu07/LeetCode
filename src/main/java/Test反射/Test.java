package Test反射;

/**
 * Title: Test
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class Test {

    public static void main(String[] args) {
        test1();
    }

    public static void test1 () {
        String s = "aaa";
        Class clazz = s.getClass();
        System.out.println(clazz.getName());
    }
    
}
