package getoffer;

/**
 * @author sukbear
 * @create 2019-02-27 8:51
 */
public class Fibonacci {
    /** 非递归实现 */
    static long fibonacci(int n){
        long[] a = {0,1};
        if(n < 2){return a[n];}
        long fib1 = 0;
        long fib2 = 1;
        long fibN = 0;
        for(int i = 2;i <= n;i++){
            fibN = fib1+fib2;
            fib1 = fib2;
            fib2 = fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci.fibonacci(3));
    }
}
