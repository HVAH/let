package com.vah.let.designPattern.proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/7/22 16:53
 * @Version 1.0
 **/
public class CGlibAgent {
    static class MyMethodInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("执行被代理对象方法前的操作");
            Object invoke = methodProxy.invokeSuper(o, objects);
            System.out.println("执行被代理对象方法后的操作");
            return invoke;
        }
    }

    public static Object getProxy(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setCallback(new MyMethodInterceptor());
        return enhancer.create();
    }

    public static void main(String[] args) {
        Apple proxy = (Apple)getProxy(Apple.class);
        proxy.name();
    }

}
