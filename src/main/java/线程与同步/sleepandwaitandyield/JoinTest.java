package 线程与同步.sleepandwaitandyield;

public class JoinTest implements Runnable{
    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName() + " start-----");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread[] test = new Thread[5];
        for (int i=0;i<5;i++) {
            test[i] = new Thread(new JoinTest());
            test[i].start();

        }
        for (int i=0;i<5;i++) {
            try {
                test[i].join(); //调用join方法
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Finished~~~");


//        for (int i=0;i<5;i++) {
//            Thread test = new Thread(new JoinTest());
//            test.start();
//            try {
//                test.join(); //调用join方法
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("Finished~~~");
    }
}
