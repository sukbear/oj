package getoffer;

/**
 * @author sukbear
 * @create 2019-02-26 22:25
 */
public class One {
    /**回文数
     *  0 - 9是回文数，除零外能被10整除的不是；
     * 负数不是回文数
     *
     *while循环跳出条件是 x >= num 相等意味著是偶数个数字（如：11），大于是奇数个121。
     * 所以判断的时候考虑 当num == 1时， x==12 。此时12/10=num
     * */
    static boolean isHuiWen(int num) {
        if (num < 0 || num % 10 == 0) {
            return false;
        }
        if (num == 0) {
            return true;
        }
        int x = 0;
        while (num > x) {
            x = x * 10 + num % 10;
            num = num / 10;
        }
        return num==x || num == x/10;
    }
}
