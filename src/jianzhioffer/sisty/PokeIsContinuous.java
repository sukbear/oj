package jianzhioffer.sisty;

import java.util.Arrays;

/***
 *@ClassName PokeIsContinuous
 *@Description
 * @author sukbear
 * @create 2019-09-05 20:15
 */
public class PokeIsContinuous {
    public static boolean Continuous(int[] nums) {
        if (nums.length < 5) {
            return false;
        }
        Arrays.sort(nums);
        // 癞子的个数
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt++;
            } else {
                break;
            }
        }
        for(int i = cnt;i<nums.length-1;i++){
            if(nums[i+1]==nums[i]){
                return false;
            }
            cnt -= nums[i+1]-nums[i]-1;
        }
        return cnt>=0;
    }

    public static void main(String[] args) {
        int[] a = {1,0,3,4,5};
        int[] b = {1,2,4,6,7};
        System.out.println(Continuous(a));
        System.out.println(Continuous(b));
    }
}
