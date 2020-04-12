package algorithm.combination;

import java.util.ArrayList;
import java.util.List;

/***
 *@ClassName Combination
 *@Description
 * @author sukbear
 * @create 2019-04-21 11:41
 */

public class Combination {
    /**
     * 给定一个没有重复数字的序列，返回其所有可能的组合。
     * 当组合个数k==n时此时为全排列。
     * 输入数组保持字典顺序，输出结果也保持字典顺序。
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     */
    public static List<List<Integer>> permute(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList list = new ArrayList();
        backtrack(res, list, nums, k, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int k, int index) {
        if (index == k) {
            ArrayList<Integer> temp = new ArrayList<>(list);
            res.add(temp);
        } else {
            for (int e:nums) {
                if (!list.contains(e)) {
                    list.add(e);
                    backtrack(res, list,  nums,  k,index + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        for (List<Integer> e : permute(nums, 2)) {
            for (Integer ch : e) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
