package datastucture.string;

/***
 *@ClassName PalindromeString
 *@Description
 * @author sukbear
 * @create 2019-04-19 16:57
 */
public class PalindromeString {
    /**回文串判断 双指针
     * */
    public static  boolean yes(String s){
        char[] chs = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        // 循环终止条件:两个指针相向移动，当start超过end时，完成判断
        while(end>start){
            if(chs[start]!=chs[end]){
                return false;
            }else{
                end--;
                start++;
            }
        }
        return true;
    }

    static  void swap(char[] ch,int i,int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
    static String reverse(String s){
        if(s==null){return s;}
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while(j>i){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            j--;
            i++;
        }
        return String.valueOf(chars);
    }
    public static void main(String[] args) {
        System.out.println(reverse("abs"));
    }
}
