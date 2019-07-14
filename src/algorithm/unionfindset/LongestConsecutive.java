package algorithm.unionfindset;

import java.util.Arrays;
import java.util.HashMap;

/***
 *@ClassName algorithm.DisjointSet.LongestConsecutive
 *@Description
 * @author sukbear
 * @create 2019-05-08 17:18
 */




public class LongestConsecutive {
/**先排序 在处理**/
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){return 0;}
        Arrays.sort(nums);
        int maxLen = 1;
        int len = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                len++;
            }else if(nums[i]!=nums[i-1]){
                len=1;
            }
            maxLen=len>maxLen?len:maxLen;
        }
        return maxLen;
    }
    public int _longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){return 0;}
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int e:nums){
            if(map.containsKey(e)){
                continue;
            }
            int left = map.getOrDefault(e-1,0);
            int right = map.getOrDefault(e+1,0);
            int len = left+right+1;
            res = res>len?res:len;
            map.put(e,1);
            //左边端点
            map.put(e-left,left);
            //右边端点
            map.put(e+right,right);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = { 3, 2, 3, 1, 1, 4 };
    }

}
