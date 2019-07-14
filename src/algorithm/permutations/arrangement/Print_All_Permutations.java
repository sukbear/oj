package algorithm.permutations.arrangement;

import java.util.HashSet;

/***
 *@ClassName Print_All_Permutations
 *@Description
 * @author sukbear
 * @create 2019-05-08 22:51
 */
public class Print_All_Permutations {
    /**
     * 不去重的全排列
     * */
    public static void printAllPermutations(String str){
        process(str.toCharArray(),0);
    }

    private static void process(char[] chs, int i){
        if(i==chs.length){
            System.out.println(String.valueOf(chs));
        }else{
            for(int j = i;j<chs.length;j++){
                swap(chs,i,j);
                process(chs,i+1);
                swap(chs,i,j);
            }
        }
    }
    public static void printAllPermutations2(String str) {
        char[] chs = str.toCharArray();
        process2(chs, 0);
    }
    /**
     * 去重的全排列
     * */
    public static void process2(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++) {
            if (!set.contains(chs[j])) {
                set.add(chs[j]);
                swap(chs, i, j);
                process2(chs, i + 1);
                swap(chs, i, j);
            }
        }
    }



    private static void swap(char[] chs, int i,int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j]=temp;
    }
    public static void main(String[] args) {
        String test1 = "acc";
        //printAllPermutations(test1);
        System.out.println("================");
        printAllPermutations2(test1);
    }
}
