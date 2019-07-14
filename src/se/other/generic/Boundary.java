package se.other.generic;

/**
 * @author sukbear
 * @create 2018-12-17 9:57
 */
public class Boundary {
    public static <T extends Comparable<T>> int countGreatorThan(T[] array,T elem){
        int count =0;
        for(T e: array){
            if(e.compareTo(elem)>0){
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Double[] d = new Double[]{1.12,3.14};
        int count = Boundary.countGreatorThan(a,5);
        System.out.println(count);
        count = Boundary.countGreatorThan(d,3.139);
        System.out.println(count);
    }
}
