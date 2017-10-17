package javaBasicDemo.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author JHMI on 2017/8/15.
 */
public class HelloWorldHandler implements InvocationHandler {
    Object target;
    public HelloWorldHandler(Object target) {
        super();
        this.target = target;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before"+args[0].toString());
        Object result=method.invoke(target,args);
        System.out.println("after");
        return result;

    }

}
