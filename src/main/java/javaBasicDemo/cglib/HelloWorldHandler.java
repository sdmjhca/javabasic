package javaBasicDemo.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author JHMI on 2017/8/15.
 */
public class HelloWorldHandler implements InvocationHandler {
    Object target;
    Class<?> iface;
    public HelloWorldHandler(Object target,Class iface) {
        super();
        this.target = target;
        this.iface = iface;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before"+args[0].toString());
        Object result=method.invoke(target,args);
        System.out.println("after");
        return result;

    }

    public Object getObject(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{iface},this);
    }

}
