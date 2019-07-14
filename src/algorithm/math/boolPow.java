package algorithm.math;

/***
 *@ClassName algorithm.math.boolPow
 *@Description
 * @author sukbear
 * @create 2019-05-11 13:52
 */
public class boolPow {
    /**
    * p判断一个数是否是n的幂，比如n=3;n==2
     * 找出数值范围里最大的数，看这个数是否能被其整除。
    * */
    public static boolean right(int n){
        // 1162261467为不超过类型范围最大的数
        return n>0&&1162261467%n==0;
    }

    public static boolean right_2(int n){
        // 1162261467为不超过类型范围最大的数
        return n>0&&((n&(n-1))==0);
    }
    public static void main(String[] args) {
        System.out.println(right_2(16));
    }
}
