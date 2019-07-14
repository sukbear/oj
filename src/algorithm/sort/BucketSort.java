package algorithm.sort;

import java.util.Arrays;

/***
 *@ClassName BucketSort
 *@Description
 * @author sukbear
 * @create 2019-04-20 16:57
 */
public class BucketSort {
    public int[] bucketSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        bucketSort(arr,5);
        return arr;
    }

    private int[] bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0) {
            return arr;
        }
        //确定数据范围，已有范围可省略
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int val : arr) {
            if (val > maxValue) {
                maxValue = val;
            }
            if (val < minValue) {
                minValue = val;
            }
        }
        //按照元素范围确定桶的个数
        int bucketCount = (int) Math.floor((maxValue - minValue)) / bucketSize;
        //初始
        int[][] buckets = new int[bucketCount][0];
        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] =atomicResize(buckets[index],arr[i]);
        }
        int arrIndex = 0;
        for(int[] bucket:buckets){
            if(bucket.length<=0){continue;}
            //进行桶内排序（采用最优的排序 插入排序或快排，堆排序？）
             Arrays.sort(bucket);
            for(int val:bucket){
                arr[arrIndex++]=val;
            }
        }
        return arr;
    }
    /** 自动扩展大小*/
    private int[] atomicResize(int[] arr, int val){
        arr = Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1]=val;
        return arr;
    }
}
