package se.other.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/***
 *@ClassName algorithm.dp.Gift
 *@Description
 * @author sukbear
 * @create 2019-03-04 13:07
 *
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        //强引用 只要引用存在，垃圾回收器永远不会回收
        Object obj = new Object();


        //软引用 非必须引用，内存溢出之前进行回收，可以通过以下代码实现
        SoftReference<Object> sf = new SoftReference<>(obj);
        //有时候会为空
        sf.get();


        //弱引用 第二次垃圾回收时回收，
        WeakReference<Object> wr = new WeakReference<>(obj);
        //有时候会返回null
        wr.get();
        //返回是否被垃圾回收器标记为即将回收的垃圾
        wr.isEnqueued();

        //虚引用
        //垃圾回收时回收，无法通过引用取到对象值.
        ThreadLocal <Object> var = new ThreadLocal<>();
    }
}
