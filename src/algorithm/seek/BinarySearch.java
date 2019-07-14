package algorithm.seek;

/***
 *@ClassName BinarySearch
 *@Description
 * @author sukbear
 * @create 2019-03-03 21:45
 */
public class BinarySearch {
    int binarySearch(int[] nums, int key) {
        if (nums == null || nums.length <= 0) {
            throw new IllegalArgumentException("参数错误");
        }
        int left = 0;
        int right = nums.length - 1;
        //此处一定要相等
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == key) {
                return key;
            }
            if (nums[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    /**
     * 数字在排序数组中出现的次数
     * <p>
     * Input:
     * nums = 1, 2, 3, 3, 3, 3, 4, 6
     * K = 3
     * <p>
     * Output:
     * 4
     */
    private  static int search(int[] nums, int k) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= k) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static int getNumberOfK(int[] nums, int k) {
        int first = search(nums, k);
        int last = search(nums, k + 1);
        return (first == nums.length || nums[first] != k) ? 0 : last - first;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,3,4,6};
        System.out.println(getNumberOfK(nums,3));
    }
}
