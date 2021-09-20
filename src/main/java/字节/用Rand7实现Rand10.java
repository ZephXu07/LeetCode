package 字节;

import java.util.Random;

/**
 * Title: 用Rand7实现Rand10
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-08
 */
public class 用Rand7实现Rand10 {
//    public int rand10() {
//
//         int row, col, idx;
//         do {
//             row = rand7();
//             col = rand7();
//             idx = col + (row - 1) * 7;
//                 /*
//                    row (1 - 7) ,减1就是 （0-6），乘以7再加（1 - 7），范围就是1-49
//                    取 [0,40]
//                    大于则继续计算
//                  */
//         } while (idx > 40);
//         return 1 + idx % 10;
//        /*
//            1-40取余10得到的数 [0,9]概率一样
//            加一就是1-10
//         */
//
//
//    }

    public int rand10() {
        while (true){
            int num = (rand7() - 1) * 7 + rand7();
            /*
                同理上面
                如果在[1,40]以内，那就直接返回
                (1-49)
            */
            if(num <= 40) {
                return 1 + num % 10;
            }

            /*
                说明刚才生成的在41-49之间，利用随机数再操作一遍
                (41-49）-40 - 1 得到（0-8）
             */
            num = (num - 40 - 1) * 7 + rand7();
            /*
                得到[1,63]
             */

            if(num <= 60) {
                return 1 + num % 10;
                //同理
            }
            /*
                [61-63]
                 说明刚才生成的在61-63之间，利用随机数再操作一遍
                （61-63）- 60 -1 得到（0-2）
            */
            num = (num - 60 - 1) * 7 + rand7();
            /*
                [1,21]
             */
            if(num <= 20) {
                return 1 + num % 10;
                //同理
            }
            /*
                剩余1扔掉
                不能再计算出一个范围了
                进行下一个大循环
             */
        }
    }

    public int rand7() {
        return new Random().nextInt(6) + 1;
    }
}
