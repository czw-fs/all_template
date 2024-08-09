package com.example.spring_source.demo.设计模式.创建者模式.单例模式;

/**
 * 懒汉式
 *  线程不安全
 */
public class LazySingleton {

    private LazySingleton() {}

    private static LazySingleton instance;

    public static LazySingleton getInstance() {

        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

/**
 * 懒汉式
 *  线程安全
 *
 *双重检查方式
 */
class Singleton2 {

    //私有构造方法
    private Singleton2() {}

    private static volatile Singleton2 instance;

    //对外提供静态方法获取该对象
    public static Singleton2 getInstance() {
        //第一次判断，如果instance不为null，不进入抢锁阶段，直接返回实际
        if(instance == null) {
            synchronized (Singleton2.class) {
                //抢到锁之后再次判断是否为空
                if(instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}