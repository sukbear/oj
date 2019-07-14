package getoffer;

import java.util.Arrays;

/***
 *@ClassName Array2Min
 *@Description
 * @author sukbear
 * @create 2019-05-22 17:09
 */
public class Array2Min {
    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。例如输入数组 {3，32，321}，
     * 则打印出这三个数字能排成的最小数字为 321323。
     * */
    public String PrintMinNumber(int[] numbers) {
        if(numbers==null||numbers.length==0){
            return "";
        }
        int n = numbers.length;
        String[] nums = new String[n];
        for(int i =0;i<n;i++){
            nums[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(nums,(s1,s2)->(s1+s2).compareTo(s2+s1));
        StringBuilder sb =new StringBuilder();
        for(String str:nums){
            sb.append(str);
        }
        return sb.toString();
    }
}
