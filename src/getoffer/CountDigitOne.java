package getoffer;

/***
 *@ClassName CountDigitOne
 *@Description
 * @author sukbear
 * @create 2019-05-23 10:26
 */
public class CountDigitOne {
/**    输入: 13
    输出: 6
    解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。

 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。*/
    public static  int countDigitOne(int n) {
        int num = n,i=1,cnt = 0;
        while(num>0){
            int mod = num%10;
            if(mod==0){
                cnt+=(num/10)*i;
            }
            if(mod==1){
                cnt+=(num/10)*i+(n%i)+1;
            }
            if(mod>1){
                cnt+=Math.ceil(num/10.0)*i;
            }
            num/=10;
            i*=10;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
    }
}
