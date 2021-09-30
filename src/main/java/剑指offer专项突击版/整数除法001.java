package 剑指offer专项突击版;

/**
 * Title: 整数除法001
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-30
 */
public class 整数除法001 {
//    public int divide(int a, int b) {
//        if (a == Integer.MIN_VALUE && b == -1) {
//            return Integer.MAX_VALUE;
//        }
//
//
//        int pos = 2;
//
//        if (a > 0) {
//            a = -a;
//            pos--;
//        }
//        if (b > 0) {
//            b = -b;
//            pos--;
//        }
//
//        int res = 0;
//        while (a <= b) {
//            res++;
//            a -= b;
//        }
//        return pos == 1 ? -res : res;
//    }


    public int divide(int a, int b) {
        //特殊情况-2^32/-1 会溢出
        if(a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        //记录负数的个数，并将两数都转为负数
        int neg = 2;
        if(a > 0) {
            neg--;
            a = -a;
        }
        if(b > 0) {
            neg--;
            b = -b;
        }
        //两个负数的除法
        int res = divideCore(a,b);
        //根据负号对商进行符号的修改
        return neg == 1 ? -res : res;
    }
    private int divideCore(int a, int b) {
        /*
            题目已经说明除数不为0，所以不用考虑除数为0的情况
            思路是：当被除数大于除数时，继续判断被除数是否大于除数的2倍，
                如果是，则继续判断被除数是否大于除数的4倍、8倍、16倍等；
                如果被除数最多大于除数的2的k次方，那么将被除数减去除数的2的k次方，
                然后将剩余的被除数重复前面的步骤；
            举例来说：15大于2，也大于2的2倍（也就是4），还大于2的4倍（也就是8），
                但是小于2的8倍（也就是16），先将15减去8（减去这部分对应的商是4），还剩余7
                接下来比较7和除数2，7最多大于2的2倍（也就是4），
                因为7小于2的4倍（也就是8），将7减去4（减去这部分对应的商是2），还剩余3
                3大于2但小于2的2倍（也就是4），所以将3减去2（减去这部分对应的商是1），
                还剩余1.比除数小，不能再减去除数了
                所以15/4的商是4+2+1，也就是7

                因为使用的是负数，所以需要进行调整
         */
        int res = 0;
        //注意是两个负数的比较大小
        while(a <= b){
            //value用来存储除数翻倍后的值
            int value = b;
            //count用来存储除数翻的倍数
            int count = 1;
            //除数每次从1倍开始翻倍。直到-2^31的一半-2^30
            int max = (int) -Math.pow(2, 30);
            /*
                (-2)^30 是正数，但这里是加法，只能是负数，所以注意
             */
            while(value >= max && a <= value + value) {
                count += count;
                value += value;
            }
            //倍数累加为商
            res += count;
            //被除数减去这部分除数翻倍后的值
            a -= value;
        }
        return res;
    }





    public static void main(String[] args) {
        整数除法001 res = new 整数除法001();
        System.out.println(res.divide(-2147483648 ,1));
        System.out.println((int)Math.pow(-2, 30));
        System.out.println(0xc0000000);
    }
}
