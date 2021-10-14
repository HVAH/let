package com.vah.let.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author Jiang
 * @Date 2021/8/26 4:10 下午
 **/
public class JdkProxyDemo {
    public static void main(String[] args) {
        MailSendImpl target = new MailSendImpl();
        MailSendInterface o = (MailSendInterface)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new MailSendJdkProxy(target));
        Class<? extends MailSendInterface> aClass = o.getClass();
        Class<?>[] interfaces = aClass.getInterfaces();
        Class<?> superclass = aClass.getSuperclass();
        o.send();
    }
}

class MailSendImpl implements MailSendInterface {
    @Override
    public void send() {
        System.out.println("目标类发送邮件");
    }
}

class MailSendJdkProxy implements InvocationHandler {

    private final Object target;

    MailSendJdkProxy(Object o) {
        this.target = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象执行方法前");
        Object result = method.invoke(target, args);
        System.out.println("代理对象执行方法后");
        return result;
    }
}

