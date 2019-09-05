package jianzhioffer.sisty;

/***
 *@ClassName Add
 *@Description
 * @author sukbear
 * @create 2019-09-05 16:34
 */
public class Add {
    public static int add(int a,int b){
        return b==0?a:add(a^b,(a&b)<<1);
    }

    public static void main(String[] args) {
        System.out.println(add(3,5));
    }
}
