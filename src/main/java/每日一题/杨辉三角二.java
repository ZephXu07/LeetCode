package 每日一题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 杨辉三角二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-12
 */
public class 杨辉三角二 {
    public List<Integer> getRow(int rowIndex) {
        // List<List<Integer>> res = new LinkedList<>();
        // for (int i = 0; i <= rowIndex; i++) {
        //     List<Integer> row = new LinkedList<>();
        //     for (int j = 0; j <= i; j++) {
        //         if (j == 0 || j == i) {
        //             row.add(1);
        //         } else {
        //             row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
        //         }
        //     }
        //     res.add(row);
        // }
        // return res.get(rowIndex);

//        List<Integer> pre = new LinkedList<>();
//        for (int i = 0; i <= rowIndex; i++) {
//            List<Integer> row = new LinkedList<>();
//            for (int j = 0; j <= i; j++) {
//                if (j == 0 || j == i) {
//                    row.add(1);
//                } else {
//                    row.add(pre.get(j - 1) + pre.get(j));
//                }
//            }
//            pre = row;
//        }
//        return pre;

//        List<Integer> row = new ArrayList<Integer>();
//        row.add(1);
//        for (int i = 1; i <= rowIndex; ++i) {
//            row.add(0);
//            for (int j = i; j > 0; --j) {
//                row.set(j, row.get(j) + row.get(j - 1));
//            }
//        }
//        return row;


        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;

    }
}
