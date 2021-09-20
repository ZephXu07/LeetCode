package 线程与同步.乐观锁CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title: Test
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-13
 */
public class Test {
    public static int count1 = 0;
    public static AtomicInteger count2 = new AtomicInteger(0);
    public static void main(String[] args) {
        test1();
        test2();

    }

    private static void test1 () {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            for (int j = 0; j < 1000000; j++) {
                                synchronized (Test.class) {
                                    count1++;
                                }
                            }
                        }
                    }
            ).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("count：" + count1);
        System.out.println((t2 - t1) + "ms");
    }

    private static void test2 () {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            for (int j = 0; j < 1000000; j++) {
                                count2.incrementAndGet();
                            }
                        }
                    }
            ).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("count：" + count2);
        System.out.println((t2 - t1) + "ms");
    }
}
