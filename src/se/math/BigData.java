package se.math;

import java.math.BigDecimal;
import java.math.BigInteger;

/***
 *@ClassName BigData
 *@Description
 * @author sukbear
 * @create 2019-09-14 14:07
 */
public class BigData {
    public static void main(String[] args) {
        /**BigInteger适用于整数*/
        BigInteger a = new BigInteger("123456789");
        BigInteger b = new BigInteger("987654321");
        System.out.println("加法： "+a.add(b));
        System.out.println("减法： "+a.subtract(b));
        System.out.println("乘法： "+a.multiply(b));
        System.out.println("除法： "+a.divide(b));

        BigDecimal m = new BigDecimal("12.25");
        BigDecimal n = new BigDecimal("12.35");
        System.out.println("加法： "+m.add(n));
        System.out.println("减法： "+m.subtract(n));
        System.out.println("乘法： "+m.multiply(n));
        //保留小数
        System.out.println("除法m： "+m.divide(n,6,BigDecimal.ROUND_HALF_UP));
    }
}
