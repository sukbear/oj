package company;

import java.util.ArrayList;
import java.util.PriorityQueue;

/***
 *@ClassName TopK
 *@Description
 * @author sukbear
 * @create 2019-03-05 15:52
 *
 * 大根堆实现 topK 最小
 */
public class TopK {
    public ArrayList<Integer> getTopK(int[] input, int k) {
        //非法输入
        if (input.length == 0 || k < 1 || input.length < k) {
            return new ArrayList<>();
        }
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = input[i];
        }
        buildHeap(arr, k);
        for (int s : arr) {
            System.out.print(s);
        }
        System.out.println();
        //与堆顶元素比较，调整堆
        for (int j = k; j < input.length; j++) {
            if (input[j] < arr[0]) {
                arr[0] = input[j];
                adjustHeap(arr,0, k);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(k);
        for (int s : arr) {
            list.add(s);
        }
        return list;
    }

    public void buildHeap(int[] arr, int n) {
        //从倒数第一个不是叶子节点的位置开始
        for (int j = n / 2 - 1; j >= 0; j--) {
            adjustHeap(arr, j, n);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void adjustHeap(int[] arr, int index, int n) {
        int temp = arr[index];
        for (int i = 2 * index + 1; i < n; i = 2 * i + 1) {
            //找到子节点更大的那个
            if (i + 1 < n && arr[i] < arr[i + 1]) {
                i++;
            }
            //将更大的交换至父节点
            if (arr[i] > temp) {
                arr[index] = arr[i];
                //索引跟上。继续调整子树
                index = i;
            } else {
                break;
            }
        }
        arr[index] = temp;
    }

    /**
     * use  PriorityQueue
     */
    public int[] pqGetTopK(int[] input, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(k,(e1,e2)-> e2- e1);
        for (int num : input) {
            if (maxQueue.size() < k || maxQueue.peek() > num) {
                maxQueue.offer(num);
            }
            if (maxQueue.size() > k) {
                maxQueue.poll();
            }
        }
        int i = 0;
        for (Integer s : maxQueue) {
            res[i++] = s;
        }
        return res;
    }

    public static void main(String[] args) {
        TopK obj = new TopK();
        int[] a = {300, 40, 10, 10, 30, 60, 100, 44, 10, 50, 104};
        for(Integer s: obj.pqGetTopK(a,4)){
            System.out.println(s);
        }
    }
}
