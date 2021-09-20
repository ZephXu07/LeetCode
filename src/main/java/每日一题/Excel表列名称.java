package 每日一题;

/**
 * Title: Excel表列名称
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-29
 */
public class Excel表列名称 {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (0 != columnNumber) {
            columnNumber--;
            char val = (char) (columnNumber % 26 + 'A');
            res.append(val);
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Excel表列名称 excel = new Excel表列名称();
        System.out.println(excel.convertToTitle(701));
    }
}
