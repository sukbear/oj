package jianzhioffer.fifty;

/***
 *@ClassName FirstNotRepeatingChar
 *@Description
 * @author sukbear
 * @create 2019-09-06 10:49
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        char[] cnts = new char[256];
        for(int i=0;i<str.length();i++){
            cnts[str.charAt(i)]++;
        }
        for(int i = 0;i<str.length();i++){
            if(cnts[str.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }
}
