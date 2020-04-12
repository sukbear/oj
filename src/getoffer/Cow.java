package getoffer;

import java.math.BigInteger;

/***
 *@ClassName Cow
 *@Description
 * @author sukbear
 * @create 2019-09-06 12:55
 */
public class Cow {
    /**
     * 题目描述
     * <p>
     * 假设每只母牛出生后，次年后的每一年年初会生下两只母牛，并且随着年份的增加
     * 每年成倍的死亡，第一年死1*2，第二年2*2，第三年3*2
     * 假设第一年年初有10投母牛，第二年后有28头，问100年后有多少只母牛
     * 核心就是一句话：假设今年的母牛有n头，那么下一年有n*3 - 2 * year头。其中year表示第几年。
     * 注意，这里用了Java的BigInteger，因为需要做大数处理。
     */
    static final BigInteger a = new BigInteger("3");

    static BigInteger getCount(int n, int year, BigInteger num) {
        if (year <= n) {
            num = num.multiply(a);
            BigInteger b = new BigInteger(String.valueOf((year - 1) << 1));
            num = num.subtract(b);
            return getCount(n, ++year, num);
        }
        return num;
    }

    static BigInteger Count(int n) {
        if(n<1){return null;}
        BigInteger a = new BigInteger("3");
        if (n == 1) {
            return new BigInteger("10");
        }
        return Count(n-1).multiply(a).subtract(new BigInteger(String.valueOf(2*(n-1))));
    }

    public static void main(String[] args) {

        System.out.println(Count(100));
    }
}
