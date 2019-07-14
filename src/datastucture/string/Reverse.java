package datastucture.string;

/***
 *@ClassName Reverse
 *@Description
 * @author sukbear
 * @create 2019-05-23 11:09
 */
public class Reverse {
    /**
     * leftReverse
     * */
    public String reverse(String s, int n){
        if(n>=s.length()){return s;}
        char[] chars = s.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,s.length()-1);
        reverse(chars,0,s.length()-1);
        return new String(chars);
    }
    /**
     * 翻转
     * */
    public void reverse(char[] chars,int i, int j){
        while(i<j){
            swap(chars,i++,j--);
        }
    }
    /**
     * 交换
     * */
    public void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j]=temp;
    }
public String reverseWord(String s){
        if(s==null||s.length()==0){return null;}
        char[] chars = s.toCharArray();
        int n = s.length();
        int i =0,j=0;
        //先反转每个单词，到最后或者空格开始翻转
        while(j<=n){
            if(j==n||chars[j]==' '){
                reverse(chars,i,j-1);
                i=j+1;
            }
            j++;
        }
        //翻转整个数组
        reverse(chars,0,n-1);
        return new String(chars);
}
    public static void main(String[] args) {
        Reverse obj = new Reverse();
        System.out.println(obj.reverse("abcXYZ",3));
        System.out.println(obj.reverseWord("I am a student."));
    }
}
