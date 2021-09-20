package 线程与同步.乐观锁CAS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;


public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User zs = new User("zs", 22);
        User ls = new User("ls", 22);
        AtomicReference<User> userAtomicReference = new AtomicReference<>();

        userAtomicReference.set(zs);

        // 第一次比较交换成功，因为主内存中的值跟期望值一致（zs == zs）

        System.out.println(userAtomicReference.compareAndSet(zs,ls)+"\t"+userAtomicReference.get().toString());

        // 第二次比较交换失败，因为主内存中的值跟期望值不一致（ls != zs）

        System.out.println(userAtomicReference.compareAndSet(zs,ls)+"\t"+userAtomicReference.get().toString());


    }

}
@Data
@NoArgsConstructor
@AllArgsConstructor
class User{
    private String name;
    private int age;

}
