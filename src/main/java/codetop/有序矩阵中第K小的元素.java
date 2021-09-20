package codetop;

/**
 * Title: 有序矩阵中第K小的元素
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-21
 */
public class 有序矩阵中第K小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int min = matrix[0][0];
        /*
            最小
         */
        int max = matrix[row - 1][col - 1];
        /*
            最大
         */
        while (min < max) {
            /*
                保证 mid 在最大最小中[min,max]
                mid可能暂时不存在，但当[min,max]缩小到两个时即min就是所求的值
             */
            int mid = min + (max - min) / 2;
            int count = notGreater(matrix, mid);
            /*
                矩阵中比 mid 小的数
                此刻是[min,mid] [mid+1,max]
                count < k 说明 [min,mid] 的数小于 k ，则 结果在 [mid+1,max]中
                把 min 调到 mid+1
                否则[mid+1,max]的数 >= k，则结果在 [min,mid] 中，把 max 调到 mid 上
                所以第 k 小元素始终在 [min,max] 里
                而如果 count == k  时 mid 的值不一定在矩阵中存在
                所以我们使用缩小边界，直到 mid = min 或 max
                而我们取mid的取法是 mid = (min + max) / 2,
                当min < max时, mid 永远 取不到max, 想要mid取到max ,
                只有min == max. 但循环条件是 while(min < max),
                当 min == max时循环已经终止. 所以我们得到会是一个左边界.
                 还是用题目中的例子, 假设min = 13, max = 14 则 mid = (13 + 14) / 2 = 13
             */
            if (count < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private int notGreater (int[][] matrix, int value) {
        /*
            从第一列开始寻找，以列为单位
            题目说的每列递增，每行递增
         */
        int i = matrix.length - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] <= value) {
                /*
                    如果此值小于等于 val
                    则此列包含他及以上的数都小于等于
                    共有 i+1 个数
                 */
                count += i + 1;
                j++;
            } else {
                /*
                    大于 val
                    说明此列当行的值太大了，
                    把行减小，值也减小了，
                    再比较

                 */
                i--;
            }
        }
        return count;
    }
}
