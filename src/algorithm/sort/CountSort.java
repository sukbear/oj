package algorithm.sort;

/***
 *@ClassName CountSort
 *@Description
 * @author sukbear
 * @create 2019-04-20 11:17
 */

public class CountSort {
    //计数排序 时间O(n+m) 不考虑输出结果的为O（m）;

    // 1.当数列最大最小值差距过大时，并不适用计数排序。
    // 2.当数列元素不是整数，并不适用计数排序。

    static int[] countSort(int[] nums) {
        //1.得到数列的最大值和最小值.确定数据范围
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        //2.创建统计数组并统计对应元素个数
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }
        //3.统计数组做变形，后面的元素等于前面的元素之和
        //3-4确保数据相对顺序和存储
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            count[i] = sum;
        }
        //4.倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int[] sorted = new int[nums.length];
        for(int i =nums.length-1;i>=0;i--){
            //count[nums[i]-min]第几位 -1对应数组index
            sorted[count[nums[i]-min]-1] = nums[i];
            //
            count[nums[i]-min]--;
        }
        return sorted;
    }

    public static void main(String[] args) {
        //int[] nums = {9, 3, 5, 4, 9, 1, 2, 7, 8, 1, 3, 6, 5, 3, 4, 0, 10, 9, 7, 9};
        int[] nums = {90,99,95,94,95};

        for (int num : countSort(nums)) {
            System.out.print(num);
        }
    }
}
