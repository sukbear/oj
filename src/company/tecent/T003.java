package company.tecent;

import java.util.Arrays;
import java.util.Scanner;

/***
 *@ClassName T003
 *@Description
 * @author sukbear
 * @create 2019-09-10 10:24
 */
public class T003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            String[] in = sc.nextLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(in[i]);
            }
            int[] res = new int[2];
            res = f(nums);
            System.out.print(res[0]);
            System.out.print(" ");
            System.out.print(res[1]);
        }
    }

    static int[] f(int[] nums) {
        int[] res = new int[2];
        if (nums.length == 1) {
            res[0] = 0;
            res[1] = 0;
        }
        int minValue = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int min = nums[i + 1] - nums[i];
            if (min < minValue) {
                minValue = min;
                res[0] = 1;
            } else if (min == res[0]) {
                res[0]++;
            }
        }
        int m = 0;
        int n = nums.length - 1;
        int index = 0;
        int indexj = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[0]) {
                m++;
                index = i;
            } else {
                break;
            }
        }
        for (int j = nums.length - 1; j > index; j--) {
            if (nums[j] == nums[nums.length - 1]) {
                n++;
                indexj = j;
            } else {
                break;
            }
        }
        if(nums[index]==nums[indexj]){
          res[1] =  nums.length-indexj+index+1;
        }else{
            res[1] = (nums.length-indexj)*(index+1);
        }
        return res;
    }
}
