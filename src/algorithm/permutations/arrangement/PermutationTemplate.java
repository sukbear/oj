package algorithm.permutations.arrangement;

/***
 *@ClassName PermutationTemplate
 *@Description
 * @author sukbear
 * @create 2019-04-22 17:15
 */
public class PermutationTemplate {
    /**
     * 全排列递归算法
     */
    void perm(int[] arr, int k, int n) {
        //K==m 表示到达最后一个数，不能再交换，最终的排列的数需要输出
        if (k == n) {
            for (int i = 0; i < n; i++) {
                //变换好的数组进行保存或操作
                System.out.print(arr[i]);
            }
            System.out.println();
        } else {
            for (int i = k; i < n; i++) {
                swap(arr, i, k);
                //
                perm(arr, k + 1, n);
                swap(arr, i, k);
            }
        }
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 当我们对序列进行交换之后，就将交换后的序列除去第一个元素放入到下一次递归中去了，
     * 递归完成了再进行下一次循环。这是某一次循环程序所做的工作，这里有一个问题，
     * 那就是在进入到下一次循环时，序列是被改变了。
     * 可是，如果我们要假定第一位的所有可能性的话，
     * 那么，就必须是在建立在这些序列的初始状态一致的情况下,
     * 所以每次交换后，要还原，确保初始状态一致。
     */

    /***字符串操作*/
    void perm(char[] arr, int k, int n) {
        //K==m 表示到达最后一个数，不能再交换，最终的排列的数需要输出或存储
        if (k == n) {
            //存储或输出
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        } else {
            for (int i = k; i < n; i++) {
                charswap(arr, i, k);
                perm(arr, k + 1, n);
                charswap(arr, i, k);
            }
        }
    }
    void charswap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



    public static void main(String[] args) {

    }
}
