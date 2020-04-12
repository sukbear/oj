package se.math;

import java.math.BigInteger;

/***
 *@ClassName Factorial
 *@Description
 * @author sukbear
 * @create 2019-05-28 10:42
 */
public class Factorial {
    /**
     * 1. 给定一个整数N，那么N的阶乘N！末尾有多少个0呢？例如：N＝10，N！＝3 628 800，
     * N！的末尾有两个0。
     * 首先考虑，如果 N！= K×10M，且 K 不能被 10 整除，那么 N！末尾有 M 个 0。再考虑
     * 对 N！进行质因数分解，N！=（2x）×（3y）×（5z）…，由于 10 = 2×5，所以 M 只跟 X 和 Z
     * 相关，每一对 2 和 5 相乘可以得到一个 10，于是 M = min（X, Z）。不难看出 X 大于等于 Z，
     * 因为能被 2 整除的数出现的频率比能被 5 整除的数高得多，所以把公式简化为 M = Z。
     */
    /**
     * n 是n的阶乘
     */
    static int getCountZeros(int n) {
        /**要计算 Z，最直接的方法，就是计算 i（i =1, 2, …, N）的因式分解中 5 的指数，然后求
         和：*/
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j % 5 == 0) {
                ret++;
                j /= 5;
            }
        }
        return ret;
    }

    static int getCountZeros1(int n) {
        /**公式：Z = [N/5] +[N/52] +[N/53] + …（不用担心这会是一个无穷的运算，因为总存在一
         个 K，使得 5K > N，[N/5K]=0。）
         公式中，[N/5]表示不大于 N 的数中 5 的倍数贡献一个 5，[N/52]表示不大于 N 的数中 52
         的倍数再贡献一个 5，……代码如下： */
        int ret = 0;
        while (n > 0) {
            ret += n / 5;
            n /= 5;
        }
        return ret;
    }

    static int factorial(int a) {
        if (a == 0 || a == 1) {
            return 1;
        }
        return a * factorial(a - 1);
    }

    /**
     * 求的是 N！的二进制表示中最低位 1 的位置。给定一个整数 N，求 N！二进制表
     * 示的最低位 1 在第几位？例如：给定 N = 3，N！= 6，那么 N！的二进制表示（1 010）的最低
     * 位 1 在第二位。
     */
    static int lowestOne(int n) {
        int ret = 0;
        while (n > 0) {
            n >>= 1;
            ret += n;
        }
        return ret+1;
    }
    /**get last not zero        Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int i =1;
            long  c=1;
            for(i =1;i<=a;i++){
                c=c*i%1000000000;
                while (c%10==0){
                    c = c/10;
                }
            }
            System.out.println(c%10);*/
    public static void main(String[] args) {
      /*  System.out.println(factorial(5));
        System.out.println(getCountZeros1(100));
        System.out.println(getCountZeros(100));
        System.out.println(lowestOne(1));*/
        System.out.println(f(100000));
    }
   static String f(int n){
        BigInteger one= new BigInteger("1");
        BigInteger ans = new BigInteger("1");
        for(int i =1;i<=n;i++){
            BigInteger val = new BigInteger(String.valueOf(i));
            ans = ans.multiply(val);
        }
       return ans.toString();

    }
}
