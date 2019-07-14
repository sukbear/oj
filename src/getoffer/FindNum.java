package getoffer;

/**
 * @author sukbear
 * @create 2019-02-27 10:18
 */
public class FindNum {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，
     * 请找出这个数字。例如输入一个长度为 9 的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2。
     */
    static Integer findNum(int[] a) {
        if (a == null) {
            return null;
        }
        int count = 1, result = a[0];
        for (int i = 1; i < a.length; i++) {
            if (count == 0) {
                result = a[i];
                count = 1;
            } else if (a[i] == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,2,2,2,5,4,2};
        System.out.println(findNum(arr));
    }
}
