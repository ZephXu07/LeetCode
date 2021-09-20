package 字节;

/**
 * Title: 一比特与二比特字符
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-17
 */
public class 一比特与二比特字符 {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        if (len == 1) {
            return true;
        }
        int cur = 0;
//        boolean flag = false;
        do {
            if (bits[cur] == 1) {
                cur += 2;
//                flag = false;
            } else {
                cur++;
//                flag = true;
            }
        } while (cur < len - 1);
//        if (flag) {
//            return true;
//        } else {
            return cur == len - 1;
//        }
    }


    public static void main(String[] args) {
        一比特与二比特字符 res = new 一比特与二比特字符();
        int[] bits = {1, 1,0, 1, 0};
        System.out.println(res.isOneBitCharacter(bits));
    }
}
