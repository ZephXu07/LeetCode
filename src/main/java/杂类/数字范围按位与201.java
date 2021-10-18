package 杂类;

/**
 * Title: 数字范围按位与201
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-18
 */
public class 数字范围按位与201 {
    public int rangeBitwiseAnd(int left, int right) {
        /*
            求 left 与 right 的二进制最长公共前缀
            在这个前缀之后的右边每一位的值必定有 0 与 1 两种
            相与为 0
            因为 left 与 right 不等于
            等于直接返回 right
            所以要找到最长公共二进制前缀
            所以 right & (right - 1) 是消去最右边的 1
            直到 left >= right
            此时便有了最长公共前缀

            如果一开始 left == right 不满足条件也直接返回 right
         */
        while (left < right) {
            right &= (right - 1);
        }
        return right;
    }
}
