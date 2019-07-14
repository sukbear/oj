package getoffer;

import java.util.HashMap;

/**
 * @author sukbear
 * @create 2019-02-28 14:45
 *
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 1、利用hashMap的put()
 * 2、滑动窗口
 */
public class ContainsNearbyDuplicate {

    public static  boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                int sub = i - hm.get(nums[i]);
                if(sub<=k){return true;}
                else{
                    hm.put(nums[i],i);
                }
            }else{
                hm.put(nums[i],i);
            }
        }
        return false;
    }
}
