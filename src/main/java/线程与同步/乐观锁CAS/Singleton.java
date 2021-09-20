package 线程与同步.乐观锁CAS;

/**
 * Title: Singleton
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-13
 */
public class Singleton {
    // 私有化构造函数
    private Singleton() {
    }
//    // 没有volatile修饰单例对象
//    private static Singleton instance = null;


    // volatile修饰单例对象
    private static volatile Singleton instance = null;


    // 对外提供的工厂方法
    public static Singleton getInstance() {
        if (instance == null) { // 第一次检测
            synchronized (Singleton.class) {    // 同步锁
                if (instance == null) { // 第二次检测
                    instance = new Singleton(); // 初始化
                }
            }
        }
        return instance;
    }
    /* https://blog.csdn.net/v123411739/article/details/79438066   例子*/
}
