package codetop;

/**
 * Title: 颜色分类
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-30
 */
public class 颜色分类 {
    public void sortColors0(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int n : nums) {
            switch (n) {
                case 0:
                    zero++;
                    break;
                case 1:
                    one++;
                    break;
                default:
                    two++;
                    break;
            }
        }
        int inx = 0;
        while (zero > 0) {
            nums[inx] = 0;
            inx++;
            zero--;
        }
        while (one > 0) {
            nums[inx] = 1;
            inx++;
            one--;
        }
        while (two > 0) {
            nums[inx] = 2;
            inx++;
            two--;
        }
    }

    public void sortColors1(int[] nums) {
        /*
            zero 是指向下一个在此坐标上填充 0 的指针
            同理 one
         */
        int zero = 0;
        int one = 0;
        /*
            初始化都为0
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                /*
                    如果遍历到的是 1
                    把 one 上指的2
                    （因为在 one 之前的已经是 1了，0更加不可能，所以只能是 2 ）
                    移到遍历到的地方，one 上指的值变为 1
                    one 再加一，成为符合定义
                 */
                nums[i] = nums[one];
                nums[one] = 1;
                one++;
            } else if (nums[i] == 0) {
                nums[i] = nums[zero];
                nums[zero] = 0;
                /*
                    这两步同 one
                 */

                if (zero < one) {
                    /*
                        zero == one 的情况是只有遍历到 0
                        遍历到 1 时 one 会自己先走一步
                        因为题目的要求

                        此时是 zero < one
                        所以 zero 上指的是 1
                        此时如果不进行这一步
                        1 会被移去后面，不合题意

                        0 1 2 3 4 5
                        0 1 1 2 2 0

                                  i
                          z   o
                          e   n
                          r   e
                          o

                        指针如上，此时将 1 移到最后的 0上
                        0 0 1 2 2 1
                        结束遍历，直接返回不合题意
                        所以需要将 one 指的和 i 指的进行交换
                        0 0 1 1 2 2
                        符合题意
                        one、zero 同时加一，如果没有遍历结束的话
                        如果是 one == zero 情况，当然同时加一
                        如果不是，按照上面的分析，0 与 1都重新填上了
                        需要确定下一个需要改变的坐标

                     */
                    nums[i] = nums[one];
                    nums[one] = 1;
                }
                zero++;
                one++;
            }
        }
    }

}
