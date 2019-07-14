package getoffer;

/**
 * @author sukbear
 * @create 2019-02-27 11:44
 */
public class MaxSub {

    /**
     * 输入一个整型数组，数组里有正数，也有负数。
     * 数组中一个或连续的多个整数组成一个子数组。
     * 求所有子数组的和的最大值。要求时间复杂度为 O(n）
     */
    static int maxSub(int[] a){
        int max = 0;
        int sum = 0;
        for(int i = 0;i <a.length;i++){
            sum +=a[i];
            if(sum>max){
                max = sum;
            }
            if(sum<0){sum = 0;}
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={1,-2,3,10,-4,7,2,-5};
        System.out.println(maxSub(arr));
    }
}

