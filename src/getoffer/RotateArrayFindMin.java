package getoffer;

/**
 * @author sukbear
 * @create 2019-02-28 20:51
 *
 * /**
 * 把一个数组最开始的若干个元素搬到数组的末尾，
 * 我们称之为数组的旋转。输入一个递增排序的数组
 * 的一个旋转，输出旋转数组的最小元素。例如数组
 * {3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为 1。
 *
 *利用指针的位置作为循环条件while（low < high)，当两个指针相邻时结束循环。
 * 对于{1,0,1,1,1}之类的特殊处理
 * if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
 * return searchMin(nums,low,high);}考虑特殊情型。
 *
 * 最后一个元素一定是小于或等于第一个元素的。
 */

public class RotateArrayFindMin {
    public static void main(String[] args) {
        int[] arr={3,4,5,1,2};
        int[] arr1={1,0,1,1,1};
        int[] arr2={1,2,3,4,5};
        System.out.println(minNumberInRotateArray(arr1));
    }
  /**  采用二分法解答这个问题，
    mid = low + (high - low)/2
    需要考虑三种情况：
            (1)array[mid] > array[high]:
    出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
    low = mid + 1
            (2)array[mid] == array[high]:
    出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
    还是右边,这时只好一个一个试 ，
    high = high - 1
            (3)array[mid] < array[high]:
    出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左
    边。因为右边必然都是递增的。
    high = mid
    注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
    比如 array = [4,6]
    array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
    如果high = mid - 1，就会产生错误， 因此high = mid
    但情形(1)中low = mid + 1就不会错误*/
    public static int minNumberInRotateArray(int [] array) {
        if(array.length==0){return 0;}
        int left = 0,right = array.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(array[mid]>array[right]){
                left = mid+1;
            }else if(array[mid]==array[right]){
                right = right-1;
            }else{
                right = mid;
            }
        }
        return array[left];
    }
    static int searchMin(int[] nums, int left, int right) {
        int result = nums[left];
        for (int j = left + 1; j <= right; j++) {
            if (result > nums[j]) {
                result = nums[j];
            }
        }
        return result;
    }

    static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        //把indexMid初始化为low的原因:当最后一个元素大于第一个元素时，第一个元素最小,可以直接返回第一个元素。
        if (nums[low] < nums[high]) {
            return nums[low];
        }
        while (low < high) {
            int mid = (low + high) / 2;
            //对于{1,0,1,1,1}之类的特殊处理
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                return searchMin(nums,low,high);
            }
            if(high-low==1){break;}
            if(nums[mid]>=nums[low]){
                low = mid;
            }else{
                high = mid;
            }
        }
        return nums[high];
    }
}
