package 程序员代码面试指南.栈和队列.猫狗队列;

/**
 * Title: Pet
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-11
 */
public class Pet {
    private String type;
    private int id;
    public Pet(String type, int id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }
}
