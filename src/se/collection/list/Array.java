package se.collection.list;

import java.util.ArrayList;
import java.util.List;

/***
 *@ClassName Array
 *@Description
 * @author sukbear
 * @create 2019-09-20 19:21
 */
public class Array {
    /**
     * https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/collection/ArrayList.md
     * 它继承于 AbstractList，实现了 List, RandomAccess, Cloneable, java.io.Serializable 这些接口。
     * 支持随机访问、
     * 学数据结构的时候就知道了线性表的顺序存储，插入删除元素的时间复杂度为O（n）,
     * 求表长以及增加元素，取第 i 元素的时间复杂度为O（1）
     * <p>
     * <p>
     * DEFAULT_CAPACITY = 10; gorw = 1.5倍 默认是个空数组，add方法开始添加
     * 底层实现Object[] elementData;
     * 利用Arrays.copyOf(ori,newLength)增加数组长度；
     * <p>
     * <p>
     * //下面是ArrayList的扩容机制grow方法 最低1.5倍 或者 minCapacity
     * ensureCapacity方法可以直接创建一个给定（大于1.5）大小的数组
     * Arrays.copyOf(ori,newLength)增加数组长度；
     * //ArrayList的扩容机制提高了性能，如果每次只扩充一个，
     * //那么频繁的插入会导致频繁的拷贝，降低性能，而ArrayList的扩容机制避免了这种情况。
     * /**
     * 如有必要，增加此ArrayList实例的容量，以确保它至少能容纳元素的数量
     */

    public static void main(String[] args) {

        // toArray用法
        List<Integer> list = new ArrayList<>(7);
        Integer[] integer = list.toArray(new Integer[0]);
    }
}
