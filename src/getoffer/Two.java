package getoffer;

/**
 * @author sukbear
 * @create 2019-02-26 22:29
 */
public class Two {
    /**青蛙每次可以跳一步或两步，考虑到第N阶的台阶，那么它只能从（N-1）阶或（N-2）阶台阶跳过来，递归处理*/
    static int getFrogJumpNumber(int n){
        if(n==0){return 0;}
        if(n==1){return 1;}
        if(n==2){return 2;}
        return getFrogJumpNumber(n-1)+getFrogJumpNumber(n-2);
    }
    /**非递归
     * a,b作为临时变量。
     * */
    static int getFrogJumpNumber2(int n){
        if(n==0){return 0;}
        int a = 0;
        int b = 1;
        int num = 0;
        for(int i = 1;i <= n;i++){
            num = a + b;
            a = b;
            b = num;
        }
        return num;
    }
    public static void main(String[] args) {
        System.out.println(Two.getFrogJumpNumber(10));
        System.out.println(Two.getFrogJumpNumber2(10));
    }
}
