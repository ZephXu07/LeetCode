package 线程与同步.乐观锁CAS;

/**
 * Title: VolatileTest
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-13
 */

public class VolatileTest {

    public static volatile int race = 0;

    private static final int THREADS_COUNT = 20;

    public static void increase() {
        race++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
