package company.wangyi;

import java.util.Scanner;

/***
 *@ClassName wangyi005
 *@Description
 * @author sukbear
 * @create 2019-09-10 20:49
 */
public class wangyi005 {
/*    输入的第一行为数列的个数t(1 ≤ t ≤ 10),
    接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5)
    第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)

            2
            3
            1 10 100
            4
            1 2 3 4*/

    public static void  main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int t = in.nextInt();
            for(int i = 0;i<t;i++){
                int n = in.nextInt();
                int a[] = new int[n];
                for(int j = 0;j<n;j++){
                    a[j] = in.nextInt();
                }
                int mod4_num=0 , mod2_num=0,odd=0;
                for(int k = 0;k<a.length;k++){
                    if(a[k] % 4 ==0){
                        mod4_num++;
                    }else if(a[k] % 2 ==0){
                        mod2_num++;
                    }else{
                        odd++;
                    }
                }
                if(mod2_num > 0){
                    if(mod4_num >= odd){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No");
                    }
                }else{
                    if(mod4_num >=(odd-1)){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No");
                    }
                }
            }
        }

    }
}
