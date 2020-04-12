package algorithm.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *@ClassName CombinationSum
 *@Description
 * @author sukbear
 * @create 2019-04-21 16:51
 */
public class CombinationSum {

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的数字可以无限制重复被选取。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     * List<List<Integer>> res = new ArrayList<>();
     * <p>
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     * [2,2,2,2],
     * [2,3,3],
     * [3,5]
     * ]
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        generationCombination(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void generationCombination(int[] candidates, int target, int index, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (index == candidates.length || target < candidates[index]) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                //相等元素跳过
                if(i>index&&candidates[i]==candidates[i-1]){
                    continue;
                }
                list.add(candidates[i]);
                //加一代表从剩下里面选，
                generationCombination(candidates, target - candidates[i], i+1, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        CombinationSum cs  = new CombinationSum();
        int[] a = {10,1,2,7,6,1,5};
        for(List<Integer> out: cs.combinationSum(a,8)){
            for(Integer val :out){
                System.out.print(val);
            }
            System.out.println();
        }
    }
}
