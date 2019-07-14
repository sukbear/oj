package getoffer;

/***
 *@ClassName SumSequense
 *@Description
 * @author sukbear
 * @create 2019-03-02 21:45
 *
 * 输出和为s的连续序列
 * 1+2+3+4+5 = 4+5+6 = 7+8 =15
 */
public class SumSequense {

    public static void main(String[] args) {
        printSumSequence(15);
        System.out.println(0<<1);
    }

    static void printSumSequence(int sum) {
        if (sum < 3) {
            return;
        }
        int small = 1;
        int big = 2;
        int curSum = small + big;
        int mid = (1 + sum) >> 1;
        while (small < mid) {
            if (curSum == sum) {
                print(small, big);
            }
            while (curSum > sum && small < mid) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    print(small, big);
                }
            }
            big++;
            curSum += big;
        }
    }

    static void print(int small, int big) {
        for (int i = small; i < big; i++) {
            System.out.print(i+"+");
        }
        System.out.print(big);
        System.out.println();
    }
}
