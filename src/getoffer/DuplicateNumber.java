package getoffer;

/**
 * @author sukbear
 * @create 2019-02-28 12:16
 */

/**
 * 长度为n的数组里的所有数字都在0-n-1范围内，数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道重复了几次，请输出一个任意重复的数字
 * 如{2，3，1，0，2，5，3}对应的输出是2或者3
 */
public class DuplicateNumber {
    static int duolicateNumber(int[] a) {
        int temp = a[0];
        int i = 0;
        while (i < a.length) {
            int j = a[i];
            if (j == i) {
                i++;
            } else {
                temp = a[j];
                if (a[temp] == temp) {
                    break;
                } else {
                    a[j] = j;
                    a[i] = temp;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(DuplicateNumber.duolicateNumber(a));
    }
}
