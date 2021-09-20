package labuladong;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: labuladong.NestedIterator
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-22
 */
public class NestedIterator {
    List<Integer> link = new LinkedList<>();
    public NestedIterator() {

        for (int i = 0; i < 10; i++) {
            link.add(i);
        }
        add(link);
        System.out.println("----------");
        for (int i:link) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("----------");

    }

    private void add(List<Integer> link) {
        for (int i = 0; i < 20; i++) {
            link.add(i * i);
        }
        System.out.println("************");
        for (int i:link) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("*********");
    }

    public static void main(String[] args) {
        NestedIterator nestedIterator = new NestedIterator();



    }
}
