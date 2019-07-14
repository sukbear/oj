package algorithm.sort;

import java.util.Arrays;

/***
 *@ClassName MergeSort
 *@Description
 * @author sukbear
 * @create 2019-04-21 9:41
 */
public class MergeSort {
    public int[] sort(int[] source) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(source, source.length);
        if (arr.length < 2) {
            return arr;
        }
        int mid = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(sort(left),sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                res[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                res[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            res[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            res[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return res;
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] a = {0, 2, 4, -10, 45, 2, 5, 8, 9, 10, 0, 2, 0, 1, 0};
        int[] b = ms.sort(a);
        for (int s :b) {
            System.out.println(s);
        }
    }
}
