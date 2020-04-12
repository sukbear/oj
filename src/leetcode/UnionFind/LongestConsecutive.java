package leetcode.UnionFind;

import java.util.HashSet;

/***
 *@ClassName LongestConsecutive
 *@Description
 * @author sukbear
 * @create 2019-09-07 15:03
 */
public class LongestConsecutive {
    public static  int getMaxLen(int[] nums){
        if(nums==null||nums.length==0){
            return 0;
        }
        //所有元素添加至集合
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int longest = 1;
        //遍历集合
        for(int num :set){
            //当该元素是作为序列第一个元素师
            if(!set.contains(num-1)){
                int curr = num;
                int currLen = 1;
                //计算序列长度
                while(set.contains(curr+1)){
                    curr++;
                    currLen++;
                }
                longest = Math.max(longest,currLen);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,7,10,12,15};
        System.out.println(getMaxLen(nums));
    }
}
