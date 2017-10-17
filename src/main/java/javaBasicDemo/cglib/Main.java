package javaBasicDemo.cglib;


import java.lang.reflect.Proxy;

/**
 * @author JHMI on 2017/8/15.
 */
public class Main {
    public static void main(String[] args) {
        HelloWorld helleWorld = new HelloWorldImplements();
        HelloWorldHandler helloWorldHandler = new HelloWorldHandler(helleWorld);
        //HelleWorld proxy =(HelleWorld) Proxy.newProxyInstance(HelleWorld.class.getClassLoader(), HelloWorldImplements.class.getInterfaces(), helloWorldHandler);
        HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(helleWorld.getClass().getClassLoader(), new Class[]{HelloWorld.class}, helloWorldHandler);
        proxy.say("fuck the world");
    }
}
