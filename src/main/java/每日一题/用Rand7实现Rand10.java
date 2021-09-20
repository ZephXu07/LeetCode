package 每日一题;

import java.util.Random;

/**
 * Title: 用Rand7实现Rand10
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-13
 */
public class 用Rand7实现Rand10 {
    public int rand10() {
//        int row, col, idx;
//        do {
//            row = rand7();
//            col = rand7();
//            idx = col + (row - 1) * 7;
//        } while (idx > 40);
//        return 1 + idx % 10;


        while (true){
            int num = (rand7() - 1) * 7 + rand7();
            // 如果在40以内，那就直接返回
            //(1-49)
            if(num <= 40) {
                return 1 + num % 10;
            }
            // 说明刚才生成的在41-49之间，利用随机数再操作一遍
            num = (num - 40 - 1) * 7 + rand7();

            if(num <= 60) {
                return 1 + num % 10;
            }
            //(1-63)
            // 说明刚才生成的在61-63之间，利用随机数再操作一遍
            num = (num - 60 - 1) * 7 + rand7();

            //(1-21)
            if(num <= 20) {
                return 1 + num % 10;
            }
        }

    }

    public int rand7() {
        return new Random().nextInt(6) + 1;
    }

}
