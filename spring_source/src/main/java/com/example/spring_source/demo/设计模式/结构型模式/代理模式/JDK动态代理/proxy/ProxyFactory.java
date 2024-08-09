package com.example.spring_source.demo.设计模式.结构型模式.代理模式.JDK动态代理.proxy;

import com.example.spring_source.demo.设计模式.结构型模式.代理模式.JDK动态代理.service.SellTickets;
import com.example.spring_source.demo.设计模式.结构型模式.代理模式.JDK动态代理.service.impl.TrainStation;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理工厂，用来创建代理对象
public class ProxyFactory {

    private TrainStation station = new TrainStation();

    public SellTickets getProxyObject() {

        /**
         ClassLoader loader ： 类加载器，用于加载代理类，使用真实对象的类加载器即可
         Class<?>[] interfaces ： 真实对象所实现的接口，代理模式真实对象和代理对象实现相同的接口
         InvocationHandler h ： 代理对象的调用处理程序
         */
        SellTickets sellTickets = (SellTickets) Proxy.newProxyInstance(station.getClass().getClassLoader(), station.getClass().getInterfaces(),
                /**
                 proxy ： 代理对象
                 method ： 对应于在代理对象上调用的接口方法的 Method 实例
                 args ： 代理对象调用接口方法时传递的实际参数
                 */
                (Object proxy, Method method, Object[] args) -> {
                    System.out.println("代理点收取一些服务费用(JDK动态代理方式)");
                    Object result = method.invoke(station, args);
                    return result;
                }
                );
        return sellTickets;
    }
}