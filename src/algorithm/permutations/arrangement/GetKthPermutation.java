package algorithm.permutations.arrangement;

import java.util.ArrayList;
import java.util.List;

/***
 *@ClassName GetKthPermutation
 *@Description
 * @author sukbear
 * @create 2019-04-22 16:54
 */
public class GetKthPermutation {
    /**
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     * <p>
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * <p>
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     * <p>
     * 说明：
     * 给定 n 的范围是 [1, 9]。
     * 给定 k 的范围是[1,  n!]。
     * 输入: n = 3, k = 3
     * 输出: "213"
     */
    public String getPermutation(int n, int k) {
       // 从左往右添加数字，每次添加余下的数value都会改变，但索引按顺序保持相同
        StringBuilder stringBuilder = new StringBuilder();
        //从0开始计数
        k--;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        while (!list.isEmpty()) {
            //确定一位剩下n-1个排列，不断减
            int fun = func(n-- - 1);
            stringBuilder.append(list.get(k / fun));
            list.remove(k / fun);
            k %= fun;
        }
        return stringBuilder.toString();

    }
    public int func(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return func(n - 1) * n;
    }

    public static void main(String[] args) {
        GetKthPermutation obj = new GetKthPermutation();
        System.out.println(obj.getPermutation(3,3));
    }
}
