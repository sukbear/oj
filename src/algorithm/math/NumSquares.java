package algorithm.math;

/***
 *@ClassName NumSquares
 *@Description
 * @author sukbear
 * @create 2019-05-21 16:01
 */
public class NumSquares {
    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
     * 使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     * <p>
     * 四平方定理，任何一个整数都可以表示成不超过四个整数平方的和
     * so res = 1 2 3 4 中的一个
     * n = 4a * (8b+7)
     */
    public int numSquares(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        if(n%8==7){
            return 4;
        }
        int a = 0;
        while(a*a<=n){
            int b = (int)Math.pow((n-a*a),0.5);
            if(a*a+b*b==n){
                if(a!=0&&b!=0){
                    return 2;
                }else{
                    return 1;
                }
            }
            a++;
        }
        return 3;
    }
}
