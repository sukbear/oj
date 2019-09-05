package jianzhioffer.sisty;

/***
 *@ClassName DicesSum
 *@Description
 * @author sukbear
 * @create 2019-09-05 20:21
 */
public class DicesSum {
 /** 递归的方式
  * f(n,s)表示n哥骰子和为s的情况总数
  * f(n,s) = f(n-1,1)+...+f(n-1,face)
  * 一个骰子时每个面出现的情况都是1
  * s>=n s<=face*n
  * */
    int face =6;
    int getNSumCount(int n, int sum){
        if(n<1||sum<n||sum>face*n){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int resCount = 0;
        for(int i = 1;i<=face;i++){
            resCount+=getNSumCount(n-1,sum-i);
        }
        return resCount;
    }
    public double[] getRet(int n){
        long total = (long) Math.pow(face,n);
        double[] tmp = new double[face*n-n+1];
        for(int i = n;i<=face*n;i++){
            tmp[i-n] = (double) getNSumCount(n,i)/total;
        }
        return tmp;
    }

    public static void main(String[] args) {
        DicesSum obj = new DicesSum();
       /* double[] res = obj.getRet(6);
        for(double d : res){
            System.out.println(d);
        }*/
        obj.printProbability(6);
    }


    /**
     * 把n个骰子仍在地上，全部骰子朝上一面的点数之和为s,输入n,打印出s的全部可能出现的概率
     * 能够换一个思路来解决问题，我们能够考虑用两个数组来存储骰子点数的每个综述出现的次数。在一次循环中。每个数组中的第n个数字表示骰子和为n出现的次数。

     在下一轮循环中，我们加上一个新的骰子，此时和为n出现的次数。
     下一轮中，我们加上一个新的骰子，
     此时和为n的骰子出现的次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3,n-4,n-5的次数之和，
     所以我们把还有一个数组的第n个数字设为前一个数组相应的第n-1。n-2。n-3，n-4，n-5
     */
    public void printProbability(int number) {
        if (number < 1)
            return;
        int g_maxValue = 6;
        int[][] probabilities = new int[2][];
        probabilities[0] = new int[g_maxValue * number + 1];
        probabilities[1] = new int[g_maxValue * number + 1];
        int flag = 0;
        for (int i = 1; i <= g_maxValue; i++)
            probabilities[0][i] = 1;
        for (int k = 2; k <= number; ++k) {
            for (int i = 0; i < k; ++i)
                probabilities[1 - flag][i] = 0;
            for (int i = k; i <= g_maxValue * k; ++i) {
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= g_maxValue; ++j)
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
            }
            flag = 1 - flag;
        }
        double total = Math.pow(g_maxValue, number);
        for (int i = number; i <= g_maxValue * number; i++) {
            double ratio = (double) probabilities[flag][i] / total;
            System.out.println(i);
            System.out.println(ratio);
        }
    }
}
