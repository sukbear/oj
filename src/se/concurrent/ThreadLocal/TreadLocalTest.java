package se.concurrent.ThreadLocal;

/***
 *@ClassName TreadLocalTest
 *@Description
 * @author sukbear
 * @create 2019-03-04 15:10
 *
 *
 * ThreadLocal 为 每 一 个 线 程 维 护 变 量 的 副 本 ，
 * 把 共 享 数 据 的 可 见 范 围 限制 在 同 一 个 线 程 之 内 ，
 * 其 实 现 原 理 是 ， 在 ThreadLocal 类 中 有 一 个Map，
 * 用 于 存 储 每 一 个 线 程 的 变 量 的 副 本 。
 *
 * ThreadLocal内部的ThreadLocalMap键为弱引用，会有内存泄漏的风险，使用remove显示删除。
 *
 * 使用ThreadLocal的典型场景正如上面的数据库连接管理，线程会话管理等场景，
 * 只适用于独立变量副本的情况，如果变量为全局共享的，则不适用在高并发下使用。
 */
public class TreadLocalTest extends Thread{
    private Integer i;

    public TreadLocalTest(Integer i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        TreadLocalTest treadLocalTest = new TreadLocalTest(2);
        treadLocalTest.start();
    }
}
