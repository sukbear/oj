package jianzhioffer.sisty;

/***
 *@ClassName MinNumberInRotateArray
 *@Description
 * @author sukbear
 * @create 2019-08-26 16:10
 */
public class MinNumberInRotateArray {
/**    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。*/
    public static void main(String[] args) {
        MinNumberInRotateArray obj= new MinNumberInRotateArray();
        int[] a = {2,3,4,1};
        int[] b = {1,1,1,0,1};
        System.out.println(obj.min(b));
    }
    public int min(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[l] == nums[m] && nums[m] == nums[h]) {
                return minNumber(nums, l, h);
            } else if (nums[m] < nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }

    private int minNumber(int[] nums, int l, int h) {
        for (int i = 0; i < h; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[l];
    }
}
