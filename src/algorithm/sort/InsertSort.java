package algorithm.sort;

/**
 * @author sukbear
 * @create 2019-02-23 14:27
 * 在将一个新元素插入已排好序的数组的过程中，寻找插入点时，将待插入区域的首元素设置为a[low]，
 * 末元素设置为a[high]，则轮比较时将待插入元素与a[m]，其中m=(low+high)/2相比较,如果比参考元素小，
 * 则选择a[low]到a[m-1]为新的插入区域(即high=m-1)，否则选择a[m+1]到a[high]为新的插入区域（即low=m+1），
 * 如此直至low<=high不成立，即将此位置之后所有元素后移一位，并将新元素插入a[high+1]。
 *
 * 折半插入排序算法是一种稳定的排序算法，比直接插入算法明显减少了关键字之间比较的次数，
 * 因此速度比直接插入排序算法快，但记录移动的次数没有变，所以折半插入排序算法的时间复杂度仍然为O(n^2)，
 */
public class InsertSort {
    public static void binaryInsertionSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            Comparable temp = a[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (temp.compareTo(a[mid]) < 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (int j = i; j >= low + 1; j--) {
                a[j] = a[j - 1];
            }
            a[low] = temp;
        }
    }

/**    直接插入排序基本思想是每一步将一个待排序的记录，
            * 插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
            * i从1到length-1，j=i 用来在排序中找到位置。
            * 稳定*/

    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j > 0 && (a[j] < a[j-1])) {
                //swap(i,j)
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                j--;
            }
        }
    }
/**    希尔排序
    基本思想是：希尔排序是在插入排序的基础上进行发展的，通过一个希尔增量先排序一定间隔的数据。
    待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。*/
    public static void shellSort(Comparable[] a){
        int len = 2;
        //进行分组，开始的增量（gap）为数组的长度的一半
        for(int gap = a.length/len; gap>0;gap/=len){
            //对各个分组进行插入排序
            for(int i = gap;i<a.length;i++){
                Comparable insertNum = a[i];
                int j;
                //将a[i]插入到分组的正确位置上 ... a[i-gap],a[i],a[i+gap]..
                for(j = i-gap;j>=0;j-=gap){
                    if(a[j].compareTo(insertNum)>0){
                        a[j+gap]= a[j];
                    }else{
                        break;
                    }
                }
                a[j+gap] = insertNum;
            }
        }
    }
}
