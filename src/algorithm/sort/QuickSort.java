package algorithm.sort;

/***
 *@ClassName QuickSort
 *@Description
 * @author sukbear
 * @create 2019-04-20 19:09
 */
public class QuickSort {

    /**
     * 若文件的初始状态是正序的,冒泡排序最好的时间复杂度为 O(n) 。
     * 稳定
     */
    public static void bubbleSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            //外循环每次能确定一个值的最终位置，内循环范围每次减小一个。两个for循环，最坏情况为O(n2).
            for (int j = a.length - 1; j > i; j--) {
                //改变if的条件即可（原地置换，相对有序）
                if (a[j].compareTo(a[j - 1]) < 0) {
                    Comparable temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 快排
     * 1．先从数列中取出一个数作为基准数。
     * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * 3．再对左右区间重复第二步，直到各区间只有一个数。
     */
    private int partition(int[] arr, int left, int right) {
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
    }

    /**
     * 三向切分
     * 对于有大量重复元素的数组，可以将数组切分为三部分，
     * 分别对应小于、等于和大于切分元素。
     */
    public void threeWayQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int lt = left, i = left + 1, rt = right;
        int key = arr[left];
        while (i <= rt) {
            if (arr[i] < key) {
                //swap l i;
                swap(arr, lt++, i++);
            } else if (arr[i] > key) {
                swap(arr, i, rt--);
            } else {
                i++;
            }
        }
        threeWayQuickSort(arr, left, lt - 1);
        threeWayQuickSort(arr, rt + 1, right);
    }
/**
 * 数组的第k个数
 * 利用快排的patition (0...j-1) j (j+1..n)返回数组下标  a[j]
 * */
public int KthNumber(int[] nums,int k){
    int left = 0,right = nums.length-1;
    k--;
    while (right>left){
        int index = partition(nums,left,right);
        if(index==k){
            return nums[index+1];
        }else if(index>k){
            right = index-1;
        }else{
            left=index+1;
        }
    }
    return nums[k];
}
/**
 *（选一个好的划分值）
 * BFPRT算法求第k个元素
 * 1. 分组（5个一组）
 * 2、组内排序
 * 3、取组内中位数（偶数取上中位数）N/5 形成数组  newarr
 * 4、找到newarr的中位数（作为枢轴）
 * 5、再去求k个数
 **/
public int BFPRT_KthNumber(int[] nums,int k){

    return 0;

}
    /**
     * 元素个数小的时候用插排
     */
    public void quickInsertSort(int[] a, int left, int right) {
        for (int i = 1; i <= right; i++) {
            int j = i;
            while (j > 0 && a[j] < a[j - 1]) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                j--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort ob = new QuickSort();
        int[] a = { 0, 1, 4, -4, 1, 5, 7, 9, 10, -7};
        System.out.println(ob.KthNumber(a,2));
       /* int j = ob.partition(a,0,a.length-1);
        System.out.println(j);
        for (int i : a) {
            System.out.println(i);
        }*/
    }
}
