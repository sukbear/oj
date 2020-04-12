package se.collection.list;

import java.util.Collections;
import java.util.LinkedList;

/***
 *@ClassName Linked
 *@Description
 * @author sukbear
 * @create 2019-09-20 18:47
 */
public class Linked {
  /**  https://www.jianshu.com/p/ea5b7dd7dc01
   *  本身底层采用 双向链表 实现，有first和last两个指针可以得到O(1)第一和最后一个元素
   *  平均查找时间o（n/2）
   *  LinkedList是一个功能很强大的类，可以被当作List集合，双端队列和栈来使用。
   *  LinkedList底层使用链表来保存集合中的元素，
   *  因此随机访问的性能较差，但是插入删除时性能非常的出色。
   *  LinkedList在1.8版本有添加了一点新的内容
   *  ，添加了一个static final 修饰的内部类LLSpliterator 并实现了Spliterator
   * */
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        Collections.reverse(list);
        for(String s: list){
            System.out.println(s);
        }
        System.out.println(list.size());
    }
/*    private static class Node<E> {
        E item;//节点值
        Node<E> next;//后继节点
        Node<E> prev;//前驱节点

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }*/
}
