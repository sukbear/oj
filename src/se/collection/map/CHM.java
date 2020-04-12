package se.collection.map;

/***
 *@ClassName CHM
 *@Description
 * @author sukbear
 * @create 2019-09-18 15:18
 */
public class CHM {
    public static void main(String[] args) {
        //https://juejin.im/post/5ca89afa5188257e1d4576ff
      /* // ConcurrentHashMap 1.7的分段segment加锁技术
        分段锁的思想就是：锁的时候不锁整个hash表，而是只锁一部分。
        如何实现呢？这就用到了ConcurrentHashMap中最关键的Segment。
        ConcurrentHashMap中维护着一个Segment数组，每个Segment可以看做是一个HashMap。
        而Segment本身继承了ReentrantLock，它本身就是一个锁。
        在Segment中通过HashEntry数组来维护其内部的hash表。
        每个HashEntry就代表了map中的一个K-V，用HashEntry可以组成一个链表结构，通过next字段引用到其下一个元素。*/
        //
        //只要我们的hash值足够分散，那么每次put的时候就会put到不同的segment中去。
       // 而segment自己本身就是一个锁，put的时候，当前segment会将自己锁住，
       // 此时其他线程无法操作这个segment，
       // 但不会影响到其他segment的操作。这个就是锁分段带来的好处。
      //  ConcurrentHashMap


/*        ConcurrentHashMap是如何解决HashMap并发问题这一疑问进行简要说明。

        首先new一个新的hash表(nextTable)出来，大小是原来的2倍。
        后面的rehash都是针对这个新的hash表操作，不涉及原hash表(table)。
        然后会对原hash表(table)中的每个链表进行rehash，此时会尝试获取头节点的锁。
        这一步就保证了在rehash的过程中不能对这个链表执行put操作。
        通过sizeCtl控制，使扩容过程中不会new出多个新hash表来。
        最后，将所有键值对重新rehash到新表(nextTable)中后，用nextTable将table替换。这就避免了HashMap中get和扩容并发时，可能get到null的问题。
        在整个过程中，共享变量的存储和读取全部通过volatile或CAS的方式，保证了线程安全。*/
    }
}
