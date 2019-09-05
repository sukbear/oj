package jianzhioffer.sisty;

/***
 *@ClassName MultiplyArray
 *@Description
 * @author sukbear
 * @create 2019-09-05 16:38
 */
public class MultiplyArray {
/**
 *  构建乘积数组
 *
 *  */
    public static int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        System.out.println(" ");
        for(int i = 0,product =1;i<n;product*=A[i],i++){
            B[i] = product;

            System.out.println(B[i]);
        }
        System.out.println(" ");
        for(int i = n-1,product =1;i>=0;product*=A[i],i--){
            B[i]*=product;
            System.out.println(B[i]);
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6};
        for(int e: multiply(A)){
            System.out.print(e);
            System.out.print(" ");
        }
    }
}
