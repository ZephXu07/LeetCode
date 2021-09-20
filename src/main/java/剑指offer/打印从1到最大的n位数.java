package 剑指offer;

/**
 * Title: 打印从1到最大的n位数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-01
 */
public class 打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        n = (int) Math.pow(10, n) - 1;
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    private char[] num;
    private char[] base = {'0', '1', '2',
                            '3', '4', '5',
                            '6', '7', '8', '9'};
    private StringBuilder builder = new StringBuilder();
    public String printNumbersDfs(int n) {
        num = new char[n];
        for (int i = 1; i <= n; i++) {
            dfs(0, i);
        }
        return builder.toString();
    }

    private void dfs(int index, int len) {
        if (index == len) {
            builder.append(num).append("\t");
            return;
        }
        int start = index == 0 ? 1 : 0;
        for (; start < 10; start ++) {
            num[index] = base[start];
            dfs(index + 1, len);
        }
    }

    public static void main(String[] args) {
        打印从1到最大的n位数 res = new 打印从1到最大的n位数();
        System.out.println(res.printNumbersDfs(5));
    }
}
