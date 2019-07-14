package getoffer;

/**
 * @author sukbear
 * @create 2019-03-02 11:17
 */
public class FindNumberWithSum {

    public static void main(String[] args) {
        int[] data={1,2,4,7,11,15};
         int[] a = findNumber(data, 12);
         for(int s : a){
             System.out.println(s);
         }
    }
    /**
     * 输入一个递增排序的数组和一个数字 s，
     * 在数组中查找两个数，使得它们的和正好是 s。
     * 如果有多对数字的和等于 s，输出任意一对即可
     * 双指针O(n)
     */
    private static int[] findNumber(int[] a, int num) {
        int d = 2;
        int i = 0;
        int j = a.length - 1;
        if (a[j] * d < num || num * d < a[0] || a.length < d) {
            return null;
        }
        while (i < j) {
            if (a[i] + a[j] == num) {
                return new int[]{a[i], a[j]};
            } else if (a[i] + a[j] < num) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
