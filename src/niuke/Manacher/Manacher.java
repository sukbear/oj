package niuke.Manacher;

/***
 *@ClassName Manacher
 *@Description
 * @author sukbear
 * @create 2019-05-08 16:11
 */
public class Manacher {
    /**
     * "123"
     * "#1#2#3#"
     */
    public static char[] manacherString(String str) {
        char[] arr = str.toCharArray();
        char[] res = new char[2 * str.length() + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : arr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        //处理后的数组
        char[] arr = manacherString(str);
        //每个字符的回文半径数组
        int[] len = new int[arr.length];
        //最长回文中心和回文最右边界
        int C = -1;
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            //R>i时，在Len[]和J-i中取小
            //否则取1；
            len[i] = R > i ? Math.min(R - i, len[2 * C - i]) : 1;
            while (i + len[i] < arr.length && i - len[i] > -1) {
                if (arr[i + len[i]] == arr[i - len[i]]) {
                    len[i]++;
                } else {
                    break;
                }
            }
            //若新计算的回文串右端点位置大于，要更新R和C的值
            if (i + len[i] > R) {
                R = i + len[i];
                C = i;
            }
            //记录最值
            max = len[i]>max?len[i]:max;
        }
        return max-1;
    }
}
