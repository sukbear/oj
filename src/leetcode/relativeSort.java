package leetcode;

/***
 *@ClassName relativeSort
 *@Description
 * @author sukbear
 * @create 2019-04-20 10:22
 */
public class relativeSort {
    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     * <p>
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     */
    static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * 计数排序
     */
    public static void sortColorsContSort(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            int k = i;
            while (k-- > 0) {
                nums[index++] = count[i];
            }
        }
    }

    // [0, i),   [i, j),  [unprocess), [k, nums.size())
    // [<pivot], [=pivot],             [>pivot]
    // partion 3-ways

    public static void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        int pivot = 1;
        while (j <= k) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] > pivot) {
                swap(nums, j, k);
                k--;
            } else {
                j++;
            }
        }
    }


    /**
     * 一个未排序整数数组，有正负数和零，重新排列使负数排在正数前面（[负数-0-正数]），
     * 并且要求不改变原来的相对顺序。
     * 比如：
     * 输入：[1,7,-5,9,0,-12,15]
     * 输出：[-5,-12,0,1,7,9,15]
     * 要求时间复杂度O(N),空间O(1) 。
     */
    public static void relativeSort(int[] nums) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                a++;
            } else if (nums[i] == 0) {
                b++;
            } else {
                c++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, -5, 9, 0, -12, 15};
        sortColors(nums);
        for (int k : nums) {
            System.out.print(k);
        }
    }
}
