package getoffer;

/**
 * @author sukbear
 * @create 2019-02-27 22:02
 */
public class LastRemaining {
    /**
     * 18.n个数字（0,1,…,n-1）形成一个圆圈，从数字0开始，
     * 每次从这个圆圈中删除第m个数字（第一个为当前数字本身，第二个为当前数字的下一个数字）。
     * 当一个数字删除后，从被删除数字的下一个继续删除第m个数字。 求出在这个圆圈中剩下的最后一个数字。
     */
    static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    private int lastRemain(int n, int m) {
        if (n == 1) {
            return 0;
        } else {
            return (lastRemain(n - 1, m) + m) % n;
        }
    }

    public static void main(String[] args) {
        int x = LastRemaining.lastRemaining(17, 5);
        System.out.println(x);
    }
}
