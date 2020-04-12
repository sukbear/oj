package se.collection.map;

/***
 *@ClassName HashMap_
 *@Description
 * @author sukbear
 * @create 2019-09-18 11:06
 */
public class HashMap_ {
    public static void main(String[] args) {
        //HashMap为什么不安全
        //put方法
        // 1、（key发生碰撞）这两个 key 会添加到数组的同一个位置，这样最终就会发生其中一个线程的 put 的数据被覆盖。
        //2、就是如果多个线程同时检测到元素个数超过数组大小* loadFactor ，这样就会发生多个线程同时对 Node 数组进行扩容，都在重新计算元素位置以及复制数据，
        // 但是最终只有一个线程扩容后的数组会赋给 table，也就是说其他线程的都会丢失，并且各自线程 put 的数据也丢失。
        //key的hash值必须是不可变的（否则get将访问不到


        // loadFactor加载因子是控制数组存放数据的疏密程度
        //threshold = capacity * loadFactor
/**        // 当桶(bucket)上的结点数大于这个值时会转成红黑树
        static final int TREEIFY_THRESHOLD = 8;
        // 当桶(bucket)上的结点数小于这个值时树转链表
        static final int UNTREEIFY_THRESHOLD = 6;
        // 桶中结构转化为红黑树对应的table的最小大小（超过64才会树化）原因：（扩容和链化 元素多时大量树化）直接扩容
        static final int MIN_TREEIFY_CAPACITY = 64;*/

/**put方法
 *
 *
 * ①如果定位到的数组位置没有元素 就直接插入。
 ②如果定位到的数组位置有元素就和要插入的key比较，如果key相同就直接覆盖，
 如果key不相同，就判断p是否是一个树节点，
 如果是就调用e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value)将元素添加进入。
 如果不是就遍历链表插入(插入的是链表尾部)。

 若桶中链表元素个数大于等于8时，链表转换成树结构；若桶中链表元素个数小于等于6时，
 树结构还原成链表。因为红黑树的平均查找长度是log(n)，长度为8的时候，平均查找长度为3，
 如果继续使用链表，平均查找长度为8/2=4，这才有转换为树的必要。
 链表长度如果是小于等于6，6/2=3，虽然速度也很快的，但是转化为树结构和生成树的时间并不会太短。

 还有选择6和8，中间有个差值7可以有效防止链表和树频繁转换。
 假设一下，如果设计成链表个数超过8则链表转换成树结构，链表个数小于8则树结构转换成链表，
 如果一个HashMap不停的插入、删除元素，链表个数在8左右徘徊，就会频繁的发生树转链表、链表转树，效率会很低。
 */
    }
}
