package com.vah.let.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author Jiang
 * @Date 2021/8/26 3:50 下午
 **/
public class CgLibDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        Class<MailSendService> aClass = MailSendService.class;
        enhancer.setClassLoader(aClass.getClassLoader());
        enhancer.setSuperclass(aClass);
        enhancer.setCallback(new MailSendProxy());
        MailSendService o = (MailSendService)enhancer.create();
        o.send();
    }
}


class MailSendService {
    public void send() {
        System.out.println("目标类发送邮件");
    }
}

class MailSendProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("代理对象执行方法前");
        Object o = proxy.invokeSuper(obj, args);
        System.out.println("代理对象执行方法后");
        return o;
    }
}
