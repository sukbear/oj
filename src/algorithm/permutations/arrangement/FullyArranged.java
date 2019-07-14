package algorithm.permutations.arrangement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/***
 *@ClassName FullyArranged
 *@Description
 * @author sukbear
 * @create 2019-05-09 17:02
 */
public class FullyArranged {
   static List<List<Character>> res = new ArrayList<>();
    public static List<List<Character>> permute(String s){
        char[] arr = s.toCharArray();
        //将元素进行字典排序，输出时也按照字典顺序。
        Arrays.sort(arr);
        process(arr,0);
        return res;
    }
    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;
    }
    /**
     *
     * 利用交换实现全排列
     * **/
    private static void process(char[] arr,int index){
        //长度达到数组长度时存储
        if(index==arr.length){
            //新建list循环添加
            List<Character> list = new ArrayList<>();
            for(char e: arr){
                list.add(e);
            }
            res.add(list);
        }
        //去重
        HashSet<Character> set = new HashSet<>();
        for(int j = index;j<arr.length;j++){
            if(!set.contains(arr[j])){
                //
                set.add(arr[j]);
                swap(arr,j,index);
                process(arr,index+1);
                swap(arr,j,index);
            }
        }
    }



    public static void main(String[] args) {
        String s = "cca";
        for(List<Character> list: permute(s)){
            for(Character ch:list){
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
