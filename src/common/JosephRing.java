package common;


/**
 * 约瑟夫问题
 * 约瑟夫问题是个著名的问题：N个人围成一圈，第一个人从1开始报数，报M的将被杀掉，
 * 下一个人接着从1开始报。如此反复，最后剩下一个，求最后的胜利者。
 * 例如只有三个人，把他们叫做A、B、C，他们围成一圈，从A开始报数，假设报2的人被杀掉。
 * <p>
 * 首先A开始报数，他报1。侥幸逃过一劫。
 * 然后轮到B报数，他报2。非常惨，他被杀了
 * C接着从1开始报数
 * 接着轮到A报数，他报2。也被杀死了。
 * 最终胜利者是C
 * <p>
 *     记录每一次弹出的元素 用list实现
 * <p>
 * <p>
 * 现在改为人数改为N，报到M时，把那个人杀掉，那么数组是怎么移动的？
 * 答：每杀掉一个人，下一个人成为头，相当于把数组向前移动M位。若已知N-1个人时，
 * 胜利者的下标位置位f(N−1,M)f(N−1,M)，则N个人的时候，就是往后移动M为，
 * (因为有可能数组越界，超过的部分会被接到头上，所以还要模N)，
 * 既f(N,M)=(f(N−1,M)+M)%n
 */

import java.util.ArrayList;

/***
 * @ClassName JosephRing
 * @Description JosephRing
 * @author sukbear
 * @create 2019-04-10 14:46
 */
public class JosephRing {

    static long f(long n, long m) {
        if (n == 1) {
            return 0;
        }
        return (f(n - 1, m) + m) % n;
    }

    static void print(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() != 1) {

            index = (index + m - 1) % (list.size());
            if (list.size() == 2) {
                System.out.println(list.get(index));
            } else {
                System.out.print(list.get(index) + " ");
            }
            list.remove(index);
        }
    }

    static long cir(long n, long m) {
        long p = 0;
        for (long i = 2; i <= n; i++) {
            p = (p + m) % i;
        }
        return p + 1;
    }

    public static void main(String[] args) {
        System.out.println("dddddddddddddd");
        print(2,1);
    }
}
