package algorithm.permutations.arrangement;

/***
 *@ClassName NextPermutation
 *@Description
 * @author sukbear
 * @create 2019-04-21 12:11
 */
public class NextPermutation {
/**    实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

 必须原地修改，只允许使用额外常数空间。
 */
    /**
     * 从右边找到第一对两个连续的数字 a[i]a[i] 和 a[i-1]a[i−1]，
     * 它们满足 a[i]>a[i-1]。现在，没有对 a[i-1]a[i−1] 右侧的重新排列可以创建更大的排列，
     * 因为该子数组由数字按降序组成。
     * 因此，我们需要重新排列 a[i-1]a[i−1] 右边的数字，包括它自己。
     */
    public void nextPermutation(int[] nums) {
        //从倒数第二个开始
        int i = nums.length - 2;
        //找到第一个小于后一个元素的元素
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        //从右找第一个大于nums[i]的元素
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            //交换
            swap(nums, i, j);
        }
        //i+1之后的逆转（根据上面，右部分为降序）
        reverse(nums, i + 1);
    }

    void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
