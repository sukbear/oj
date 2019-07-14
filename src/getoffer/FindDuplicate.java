package getoffer;

/**
 * @author sukbear
 * @create 2019-02-28 13:37
 *
 *
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *输入: [1,3,4,2,2]
 * 输出: 2
 *
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class FindDuplicate {
    /**快慢指针，fast两倍速度，slow一倍，相等后，fast置0，两个同时一倍速度走。*/
    public static int findDuplicate1(int[] nums){
        if(nums.length>1){
            int slow = nums[0];
            int fast = nums[nums[0]];
            while(slow!=fast){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while(fast!=slow){
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }

    public static int findDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int cnt = 0;
            //将小于等于mid的数加起来，
            for (int s : nums) {
                if (s <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
