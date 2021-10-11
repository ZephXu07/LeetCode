package 每日一题;

/**
 * Title: 整数转换英文表示273
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-11
 */
public class 整数转换英文表示273 {
    private static final String[] SMALL = {
        "Zero",
        "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] MEDIUM = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    private static final String[] LARGE = {
            "Billion", "Million", "Thousand", "", "Hundred"
    };
    public String numberToWords(int num) {
        if (num == 0) {
            return SMALL[0];
        }
        StringBuilder res = new StringBuilder();
        for (int i = (int) 1e9, j = 0; i > 0; i /= 1000, j++) {
            if (num < i) {
                continue;
            }
            res.append(numToStr(num / i)).append(LARGE[j]).append(' ');
            num %= i;
        }
        while (res.charAt(res.length() - 1) == ' ') {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }

    private String numToStr (int num) {
        StringBuilder res = new StringBuilder();
        if (num >= 100) {
            res.append(SMALL[num / 100]).append(' ').append(LARGE[4]).append(' ');
            num %= 100;
        }
        if (num >= 20) {
            res.append(MEDIUM[num / 10]).append(' ');
            num %= 10;
        }
        if (num != 0) {
            res.append(SMALL[num]).append(' ');
        }
        return res.toString();
    }

    public static void main(String[] args) {
        整数转换英文表示273 res = new 整数转换英文表示273();
        System.out.println(res.numberToWords(123));
        System.out.println("One Hundred Twenty Three");
        System.out.println(res.numberToWords(12345));
        System.out.println("Twelve Thousand Three Hundred Forty Five");
        System.out.println(res.numberToWords(1234567));
        System.out.println("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven");
        System.out.println(res.numberToWords(1234567891));
        System.out.println("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One");
    }
}
