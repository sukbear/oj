package java_characteristic;

import java.math.BigDecimal;

/***
 *@ClassName BigData
 *@Description
 * @author sukbear
 * @create 2019-04-12 16:01
 */
public class BigData {
     /*
 2 大数的加减运算不同于普通整数的加减乘除运算
 BigDecimal
 3 加—— a+b: a=a.add(b);
 4 减—— a-b: a=a.subtract(b);
 5 乘—— a*b: a=a.multiply(b);
 6 除—— a/b: a=a.divide(b);
 7 求余—a%b: a=a.mod(b);
 8 转换—a=b: b=BigInteger.valueOf(a);
 9 比较 if (ans.compareTo(x) == 0)//比较
10     System.out.println("相等");
11 System.out.println("a + b = "+ans_add); // 这里的‘+’ （第二个） 是连接的意思
12 */


     public static void main(String[] args) {
         BigDecimal a = new BigDecimal(30);
         BigDecimal b= new BigDecimal(20);
         System.out.println(a.compareTo(b));

        /* Scanner sc = new Scanner(System.in);
         while (sc.hasNext()){
             // 计算a^b 注意是小数
             BigDecimal b = sc.nextBigDecimal();
             int n = sc.nextInt();
             b = b.pow(n);
             // 去掉尾部零，转换成非科学计数法字符串
             String ans  = b.stripTrailingZeros().toPlainString();
             if(ans.charAt(0)=='0'){
                 ans = ans.substring(1);
             }
             System.out.println(ans);
         }*/
     }
}
