package algorithm.sort;

import java.util.PriorityQueue;

/***
 *@ClassName HeapSort
 *@Description
 * @author sukbear
 * @create 2019-04-20 19:21
 */
public class HeapSort {
    /**
     * 每一次找到最小的索引min，然后和i交换
     * */
    public void selectSort(int [] a){
        int n = a.length;
        for(int i = 0;i<n-1;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(a[min]>a[j]){
                    min = j;
                }
            }
            //交换i 和min的值
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
    public static void adjustHeap(int[] a, int index, int n) {
        int temp = a[index];
        for (int i = 2 * index + 1; i < n; i = 2 * i + 1) {
            // 让i先指向子节点中最大的节点
            if (i + 1 < n && a[i] < a[i + 1]) {
                i++;
            }
            if (temp < a[i]) {
                //如果子节点大于父节点，将子节点值赋给父节点
                a[index] = a[i];
                //索引跟上
                index = i;
            } else {
                break;
            }
        }
        a[index] = temp;
    }

    public static void heapSort(int[] a, int n) {
        //初始化堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustHeap(a, i, n);
        }
        //每次弹出一个元素
        for (int j = n - 1; j > 0; j--) {
            swap(a, 0, j);
            adjustHeap(a, 0, j);
        }
    }
    static void swap(int[] a,int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public int pqGetTopK(int[] input, int k) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(k);
        //不断地入堆
        for (int num : input) {
            if (maxQueue.size() < k || maxQueue.peek() < num) {
                maxQueue.offer(num);
            }
            if (maxQueue.size() > k) {
                maxQueue.poll();
            }
        }
        return maxQueue.peek();
    }
    public static void main(String[] args) {
        int[] a = {1,2,-7,9,10,4,2,1,0,0,5,65};
        heapSort(a,a.length);
        for(int s: a){
            System.out.println(s);
        }
    }
}
