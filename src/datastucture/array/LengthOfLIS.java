package datastucture.array;

/***
 *@ClassName LengthOfLIS
 *@Description
 * @author sukbear
 * @create 2019-05-28 17:18
 */

import java.util.ArrayList;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class LengthOfLIS {


    /**
     * 方法一：动态规划，用dp[i]表示以nums[i]结尾的最长上升子序列。
     * 那么如何求dp[i]呢，只要看nums[i]之前的元素，哪个元素比nums[i]要小，
     * 并且它的dp[]值最大，那么dp[i]就在它dp值的基础上加1即可。
     * 最后求所有dp数组的最大值。
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int maxDp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxDp = maxDp > dp[j] ? maxDp : dp[j];
                }
            }
            dp[i] = maxDp + 1;
            len = Math.max(len, dp[i]);
        }
        return len;
    }

    /***
     * 方法二：首先将第一个元素存入vec数组，然后依次看后面的元素。
     * 若后面的元素大于vec数组的最后一个元素，则将其加入到vec末尾，
     * 否则将它替换掉vec数组中第一个大于等于它的元素。
     * 最后返回vec的大小即可。
     例如说，原数组：[10,9,2,5,3,7,101,18]
     1. 将10加入到vec数组中，vec[] = [10]

     2.9<10, 用9替换掉数组中大于等于9的元素，vec[] = [9]

     3. vec[] = [2]

     4.vec[] = [2,5]

     5.vec[] = [2,3]

     6.vec[] = [2,3,7]

     7.vec[] = [2,3,7,101]

     8.vec[] = [2,3,7,18]

     返回vec的数组个数4

     *
     * */
    public static int lengthOfLIS_(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums.length == 0) {
            return 0;
        }
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) >= nums[i]) {
                        binaryReplace(list, nums[i]);
                        break;
                    }
                }
            }
            for(int e:list){
                System.out.print(e);
            }
            System.out.println();
        }
        return list.size();
    }
/**
 *二叉插入
 *
 * */
    static void binaryReplace(ArrayList<Integer> list, int val) {
        int left = 0, high = list.size() - 1;
        while (left < high) {
            int mid = left + (high - left) / 2;
            if (list.get(mid) == val) {
                list.set(mid, val);
            }
            if (list.get(mid) < val) {
                left = mid + 1;
            } else {
                high = mid;
            }
        }
        list.set(left, val);
    }

    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] b = {3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(lengthOfLIS_(b));
    }
}
