package 线程与同步.乐观锁CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description
 * @date 2019-04-12 9:57
 * 1.什么是CAS ? ===> compareAndSet
 *  比较并交换
 **/
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current:"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2014)+"\t current:"+atomicInteger.get());
    }
}
