package 程序员代码面试指南.栈和队列.猫狗队列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title: Main
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-11
 */
public class Main {
    private Queue<Pet> queue;
    private Deque<Pet> stack;
    private int dogCount;
    private int catCount;
    public Main() {
        queue = new LinkedList<>();
        stack = new LinkedList<>();
        dogCount = 0;
        catCount = 0;
    }

    public List<Pet> pollAll() {
        Pet pet;
        List<Pet> pets = new LinkedList<>();
        while (!queue.isEmpty()) {
            pet = queue.poll();
            pets.add(pet);
        }
        return pets;
    }

    public void add(Pet pet) {
        queue.offer(pet);
        if ("dog".equals(pet.getType())) {
            dogCount++;
        } else {
            catCount++;
        }
    }

    public Dog pollDog() {
        return (Dog)poll("dog");
    }

    public Cat pollCat() {
        return (Cat) poll("cat");
    }

    private Pet poll(String type) {
        if ("dog".equals(type) && dogCount == 0) {
            return null;
        }
        if ("cat".equals(type) && dogCount == 0) {
            return null;
        }
        Pet pet = null;
        while (!queue.isEmpty()) {
            pet = queue.poll();
            if (type.equals(pet.getType())) {
                if ("dog".equals(type)) {
                    dogCount--;
                } else {
                    catCount--;
                }
                break;
            } else {
                stack.push(pet);
            }
        }
        while (!stack.isEmpty()) {
            Pet tmp = stack.pop();
            queue.offer(tmp);
        }
        return pet;
    }

    public boolean isDogEmpty() {
        return dogCount <= 0;
    }

    public boolean isCatEmpty() {
        return catCount <= 0;
    }

    public boolean isEmpty() {
        return  catCount > 0 || dogCount > 0;
    }


    public static void main(String[] args) throws IOException {
        Main queue = new Main();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringBuilder res = new StringBuilder();
        Pet pet;

        while (n-->0){
            String[] strArr = in.readLine().split(" ");
            String ops = strArr[0];
            switch (ops){
                case "add":
                    if ("dog".equals(strArr[1])){
                        queue.add(new Dog(Integer.parseInt(strArr[2])));
                    } else if ("cat".equals(strArr[1])){
                        queue.add(new Cat(Integer.parseInt(strArr[2])));
                    } else {
                        throw new RuntimeException("Invalid add.");
                    }
                    break;
                case "pollAll":
                    List<Pet> pets = queue.pollAll();
                    for (Pet p : pets) {
                        res.append(p.getType()).append(" ").append(p.getId()).append('\n');
                    }
                    break;
                case "pollDog":
                    while (queue.isDogEmpty()){
                        pet = queue.pollDog();
                        res.append("dog").append(" ").append(pet.getId()).append('\n');
                    }
                    break;
                case "pollCat":
                    while (queue.isCatEmpty()){
                        pet = queue.pollCat();
                        res.append("cat").append(" ").append(pet.getId()).append('\n');
                    }
                    break;
                case "isEmpty":
                    if (!queue.isEmpty()){
                        res.append("no").append('\n');
                    } else {
                        res.append("yes").append('\n');
                    }
                    break;
                case "isDogEmpty":
                    if(queue.isDogEmpty()){
                        res.append("no").append('\n');
                    } else {
                        res.append("yes").append('\n');
                    }
                    break;
                case "isCatEmpty":
                    if(queue.isCatEmpty()){
                        res.append("no").append('\n');
                    } else {
                        res.append("yes").append('\n');
                    }
                    break;
                default:
                    break;
            }
        }
        // 最后的输出只能由一个回车，所以是System.out.println(res.substring(0,res.length()-1));或者下面这个
        System.out.print(res);
    }
}
