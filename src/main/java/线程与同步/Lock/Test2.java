package 线程与同步.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title: Test2
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-17
 */
public class Test2 {
    private Lock lock = new ReentrantLock();
    public static void main(String[] args)  {
        Test2 test2 = new Test2();
        MyThread thread1 = new MyThread(test2);
        MyThread thread2 = new MyThread(test2);
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }

    public void insert(Thread thread) throws InterruptedException{
        lock.lockInterruptibly();   //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
        try {
            System.out.println(thread.getName()+"得到了锁");
            long startTime = System.currentTimeMillis();
            for(    ;     ;) {
                if(System.currentTimeMillis() - startTime >= Integer.MAX_VALUE) {
                    break;

                    //插入数据
                }
            }
        }
        finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+"执行finally");
            System.out.println(thread.getName()+"释放了锁");
        }
    }
}

class MyThread extends Thread {
    private Test2 test2 = null;
    public MyThread(Test2 test2) {
        this.test2 = test2;
    }
    @Override
    public void run() {

        try {
            test2.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
