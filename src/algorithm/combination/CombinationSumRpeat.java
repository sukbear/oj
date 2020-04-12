package algorithm.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *@ClassName CombinationSumRpeat
 *@Description
 * @author sukbear
 * @create 2019-04-22 17:44
 */
public class CombinationSumRpeat {
    /**
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     * [7],
     * [2,2,3]
     * ]
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     * [2,2,2,2],
     * [2,3,3],
     * [3,5]
     * ]
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        generationCombination(candidates, target, 0, new ArrayList<>());
        return res;
    }
    private void generationCombination(int[] candidates,int target,int index, List<Integer> list){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (index == candidates.length || target < candidates[index]) {
            return;
        }else{
            for(int i = index;i<candidates.length;i++){
                list.add(candidates[i]);
                generationCombination(candidates, target - candidates[i], i, list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer >>  res = cs.combinationSum(candidates,target);
        System.out.println(res.size());
    }
}
