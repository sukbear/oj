package datastucture.string;


import java.util.Arrays;

/***
 *@ClassName LongestSubstringWithoutDuplication
 *@Description
 * @author sukbear
 * @create 2019-05-22 19:17
 */
public class LongestSubstringWithoutDuplication {
    public static int getLen(String s){
        int curLen = 0;
        int maxLen =0;
        int[] position = new int[26];
        Arrays.fill(position,-1);
        for(int i = 0;i<s.length();i++){
            int preIndex = position[s.charAt(i)-'a'];
            //该元素未出现或出现在当前最长的范围外。
            if(preIndex==-1||i-preIndex>curLen){
                curLen++;
            }else{
                maxLen=Math.max(maxLen,curLen);
                curLen=i-preIndex;
            }
            //记录上一次出现的位置
            position[s.charAt(i)-'a']=i;
        }
        maxLen=Math.max(maxLen,curLen);
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(getLen("arabcacfr"));
    }
}
