package getoffer;

/**
 * @author sukbear
 * @create 2019-02-27 9:02
 */

/**
 * 题目：请实现一个函数，输入一个整数，输出该整数二进制表示中1的个数。
 * 例如，把9表示成二进制是1001，有2位是1，该函数输出2
 * 解法：把整数减一和原来的数做与运算，会把该整数二进制表示中的最低位的1变成0,与运算进行多少次就有多少个1*/
public class GetNumberOne {

static int getNum(int n){
        int count = 0;
        while(n!=0){
            count++;
            n&=(n-1);
        }
        return count;
}


    public static void main(String[] args) {
        System.out.println(GetNumberOne.getNum(255));
    }
}
