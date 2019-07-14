package getoffer;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author sukbear
 * @create 2019-02-28 15:45
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 *
 *
 *
 * 滑动窗口法+查找表，注意整形溢出问题就OK了
 */
public class ContainsNearbyAlmostDuplicate {
    /**利用treeSet的排序*/
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k < 1) {
            return false;
        }
        SortedSet<Long> binSet = new TreeSet<>();
        int start = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            SortedSet<Long> sub = binSet.subSet((long) nums[i] - t, (long) nums[i] + t + 1);
            if (!sub.isEmpty()) {
                return true;
            }
            if (i - start >= k) {
                binSet.remove((long) nums[start++]);
            }
            binSet.add((long) nums[i]);
        }
        return false;
    }
}
