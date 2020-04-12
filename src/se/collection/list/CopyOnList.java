package se.collection.list;

import java.util.concurrent.CopyOnWriteArrayList;

/***
 *@ClassName CopyOnList
 *@Description
 * @author sukbear
 * @create 2019-09-21 12:31
 */
public class CopyOnList {
    /**写时复制
     * 所有元素都存储在数组里面, 只有当数组进行 remove, update时才在方法上加上 ReentrantLock ,
     * 拷贝一份 snapshot 的数组, 只改变 snapshot 中的元素, 最后再赋值到 CopyOnWriteArrayList 中
     所有的 get方法只是获取数组对应下标上的元素(无需加锁控制)

     CopyOnWriteArrayList 是使用空间换时间的方式进行工作
     它主要适用于 读多些少,
     并且数据内容变化比较少的场景(最好初始化时就进行加载数据到CopyOnWriteArrayList 中)
     */
    public static void main(String[] args) {
        CopyOnWriteArrayList cowList = new CopyOnWriteArrayList();
    }
}
