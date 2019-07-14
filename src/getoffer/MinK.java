package getoffer;

/**
 * @author sukbear
 * @create 2019-02-27 10:39
 */
public class MinK {
    public static void main(String[] args) {
      /*  int[] krr = {2, 3, 4, 2, 7, 8, 9, 10, 14, 16};
        int[] arr = minK(krr, 4);
        for(int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }*/
        int[] krr = {1, 3, 4, 2};
        bulidHeap(krr,4);
        for(int s:krr){
            System.out.println(s);
        }
    }

    /**
     * 题目：输入 n 个整数，输出其中最小的 k 个。
     * 例如输入 1，2，3，4，5，6，7 和 8 这 8 个数字，则最小的 4 个数字为 1，2，3 和 4。
     * 这道题最简单的思路莫过于把输入的 n 个整数排序，这样排在最前面的 k 个数就是最小的 k 个
     * 数。只是这种思路的时间复杂度为 O(nlogn)。
     * 题目并没有要求要查找的 k 个数，甚至后 n-k 个数是有序的，既然如此，咱们又何必对所有的
     * n 个数都进行排序列?
     * 这时，咱们想到了用选择或插入排序，即遍历 n 个数，先把最先遍历到得 k 个数存入大小为
     * k 的数组之中，对这 k 个数，进行排序，找到 k 个数中的最大数 kmax，
     * k1<k2,K3<…<kmax（kmax 设为 k 个元素的数组中最大元素），用时 O（k），后再继续遍历后
     * n-k 个数，x 与 kmax 比较，如果 x<kmax，则 x 代替 kmax，并再次排序 k 个元素的数组。如果
     * x>kmax，则不更新数组。
     * 这样，每次更新或不更新数组的所用的时间为 O（k）或 O（0），整趟下来，总的时间复杂
     * 度平均下来为：n*O（k）=O（n*k）。
     * 3、 当然，更好的办法是维护 k 个元素的最大堆，原理与上述第 3 个方案一致，即用容量为 k 的
     * 最大堆存储最小的 k 个数，此时，k1<k2<...<kmax（kmax 设为大顶堆中最大元素）。
     * 遍历一次数列，n，每次遍历一个元素 x，与堆顶元素比较，x<kmax，更新堆（用时 logk），否则
     * 不更新堆。这样下来，总费时 O（n*logk）。此方法得益于在堆中，查找等各项操作时间复杂度均
     * 为 logk（不然，就如上述思路 2 所述：直接用数组也可以找出前 k 个小的元素，用时 O（n*k））。
     */
    static int[] minK(int[] a, int k) {
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = a[i];
        }
        bulidHeap(arr,k);
        for (int j = k; j < a.length; j++) {
            if (arr[0] > a[j]) {
                arr[0] = a[j];
                adjustHeap(a, 0, k);
            }
        }
        return arr;
    }

    /**
     *
     * */
    public static void bulidHeap(int[] a,int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustHeap(a, i, n);
        }
    }


    public static void adjustHeap(int[] a, int index, int n) {
        int temp = index;
        for (int i = 2 * index + 1; i < n-1; i = i * 2 + 1) {
            if (i + 1 < n && a[i] < a[i + 1]) {
                i++;
            }
            if (temp < a[i]) {
                a[index] = a[i];
                index = i;
            } else {
                break;
            }
        }
        a[index] = temp;
    }
}

