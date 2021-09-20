package 每日一题;

/**
 * Title: 柠檬水找零
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-10
 */
public class 柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    ten++;
                    five--;
                } else {
                    return false;
                }
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five > 2) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        柠檬水找零 res = new 柠檬水找零();
        int[] bills = {5,5,10};
        System.out.println(res.lemonadeChange(bills));
    }
}
