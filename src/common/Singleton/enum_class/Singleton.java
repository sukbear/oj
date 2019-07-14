package common.Singleton.enum_class;
/**优点：枚举本身是线程安全的，且能防止通过反射和反序列化创建多实例。
        缺点：使用的是枚举，而非类。*/
public enum Singleton {
    //对象实例
    INSTANCE;

    /**该方法非必须，只是为了保证与其它方案一样使用静态方法得到实例*/
    public static Singleton getInstance() {
        return INSTANCE;
    }
}
