package 线程与同步.Synchronized;

/**
 * Title: Main6
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class Main6  {

    public void method1() {
        System.out.println("method1 start");
        synchronized(this) {
            try {
                System.out.println("method1 exec");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("method1 completion");
    }

    public void method2() {
        System.out.println("method2 start");
        synchronized (this) {
            try {
                System.out.println("method2 exec");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("method2 completion");
    }

    public static void main(String[] args) {
        Main6 m1 = new Main6();
        new Thread(new Runnable() {
            @Override
            public void run() {
                m1.method1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                m1.method2();
            }
        }).start();

    }
}
