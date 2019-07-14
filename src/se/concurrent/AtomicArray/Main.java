package se.concurrent.AtomicArray;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author sukbear
 * @create 2018-12-15 14:07
 */
public class Main {
    public static void main(String[] args) {
        int tempValue = 0;
        int[] nums = {1,2,3,4,5,6};
        AtomicIntegerArray integerArray = new AtomicIntegerArray(nums);
        for(int i = 0;i <integerArray.length();i++){
            System.out.println(integerArray.get(i));
        }
        System.out.println("----");
        System.out.println(integerArray.incrementAndGet(0));
        System.out.println(integerArray.incrementAndGet(0));
    }
}
