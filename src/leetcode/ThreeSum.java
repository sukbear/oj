package code.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *@ClassName ThreeSum
 *@Description
 * @author sukbear
 * @create 2019-04-18 10:04
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                    }
                }
            }
        }
        return ls;
    }
    String help(Character c){
        switch (c){
            case '2':return "abc";
            case '3':return "def";
            case '4':return "ghi";
            case '5':return "jkl";
            case '6':return "mno";
            case '7':return "pqrs";
            case '8':return "tuv";
            case '9':return "wxyz";
            default:return "";
        }
    }
    ArrayList<String> f(ArrayList<String> res, Character c) {
        if(c==1){return res;}
        else{
            String s = help(c);
            int len = s.length();
            ArrayList<String> temp = new ArrayList<>(res.size()*s.length());
            for(int i = 0;i<res.size();i++){
                for(int j = 0;j<len;j++){
                    temp.add(res.get(i)+s.charAt(j));
                }
            }
            res = temp;
        }
        return res;
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        String s = help(digits.charAt(0));
        for(int i =0;i<s.length();i++){
            res.add(String.valueOf(s.charAt(i)));
        }
        for (int i = 1; i < digits.length(); i++) {
            res = f(res, digits.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
