package se.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***
 *@ClassName DynamicProxy
 *@Description
 * @author sukbear
 * @create 2019-09-07 10:41
 */
public class DynamicProxy implements InvocationHandler {
    /**
     * 动态代理类的创建
     * 要创建一个动态代理，只需要利用Java API提供的两个类：
     * <p>
     * java.lang.reflect.InvocationHandler： 这是调用处理器接口，它自定义了一个 invoke() 方法，
     * 我们就在这个方法里触发代理对象自己的方法，你可以在它的前后增加我们自己的增强方法。
     * java.lang.reflect.Proxy： 这是 Java 动态代理机制的主类，
     * 它提供了一组静态方法来为一组接口动态地生成代理类及其对象，也就是动态生成代理对象的方法。
     */
/**    https://blog.csdn.net/suifeng3051/article/details/51507475*/
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(proxy);
        Object res = method.invoke(target, args);
        after(proxy);
        return res;
    }

    private void before(Object obj) {
        System.out.println(obj.getClass().getName() + "开始执行");
    }

    private void after(Object obj) {
        System.out.println(obj.getClass().getName() + "执行完毕");
    }

    public static void main(String[] args) {
        SubjectA A = new RealA();
        SubjectB B = new RealB();
/**        1. ClassLoader ：负责加载动态代理类
 2. 接口数组
 3. InvocationHandler：把方法调用转到代理上*/
        SubjectA proxyA = (SubjectA) Proxy.newProxyInstance(SubjectA.class.getClassLoader(), new Class[]{SubjectA.class}, new DynamicProxy(A));
        proxyA.setUser("Tom", "admin");

        SubjectB proxyB = (SubjectB) Proxy.newProxyInstance(SubjectB.class.getClassLoader(), new Class[]{SubjectB.class}, new DynamicProxy(B));

        proxyB.sayHello("sb");
    }
}
