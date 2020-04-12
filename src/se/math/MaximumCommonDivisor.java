package se.math;

/***
 *@ClassName MaximumCommonDivisor
 *@Description
 * @author sukbear
 * @create 2019-05-20 17:59
 */
public class MaximumCommonDivisor {
    /**
     *
     *
     * */
   static int gcd(int a, int b) {
       /**
        * 辗转相除法求最大公约数
        *
        * */
        return b == 0 ? a : gcd(b, a % b);
    }
static int gbd(int a,int b){
       /**
        *
        * 最大公倍数等于相乘的数除以最大公约数
        * */
       return a*b/gcd(a,b);
}
    public static void main(String[] args) {
        System.out.println(gcd(4,18));
        System.out.println(gbd(3,5));
    }
}
