package se.annotation;

import java.lang.annotation.*;
/***
 1成员的返回值类型是有限制的，合法的有基本数据类型，String,Class,Annotation,Enurmeration
*/
//作用对象（ CONSTRUCTOR 构造方法

// FiELD 字段

// LOCAL_VERIABLE 局部变量

// METHOD 方法

// PACKAGE 包

// TYPE 类接口）
@Target({ElementType.METHOD,ElementType.TYPE})
//作用生命周期
@Retention(RetentionPolicy.RUNTIME)
//继承
@Inherited
@Documented
public @interface Description {
    String value() default "";
}
