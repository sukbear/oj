package getoffer;

/**
 * @author sukbear
 * @create 2019-02-27 9:30
 */
public class Power {
/**    因为 (x*x)n/2 可以通过递归求解，
    并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)。*/
    public static  double Power(double base, int exponent) {
        if (exponent == 0){
            return 1;}
        if (exponent == 1){
            return base;}
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0){
            pow = pow * base;}
        return isNegative ? 1 / pow : pow;
    }

    public static void main(String[] args) {
        System.out.println(Power.Power(3.0,-4));
    }
}
