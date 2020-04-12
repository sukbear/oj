package se.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/***
 *@ClassName NumberDeal
 *@Description
 * @author sukbear
 * @create 2019-09-14 13:44
 */
public class NumberDeal {
   /** Java四舍五入保留1位小数、2位小数...*/
   public static void main(String[] args) {
       //保留两位小数
       double data = 3.49576;
       //使用字符串格式化实现四舍五入(支持float和double类型)
       String res = String.format("%.2f",data);
       System.out.println(res);
       //使用BigDecimal实现四舍五入(支持float和double类型)
       double ans = new BigDecimal(data).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
       System.out.println(ans);
       DecimalFormat decimalFormat=new DecimalFormat("#.##");
       //保留2位小数，.后面的#代表小数点后面的位数,保留3位小数就是#.###
       System.out.println(decimalFormat.format(data));
   }
}
