package javaBasicDemo.protectedtest;


import javaBasicDemo.duotai.Father;

/**
 * @author JHMI on 2017/9/1.
 */
public class SonTest extends Father {

    protected void protectedMethod(String s){
        System.out.println("------------受保护的子类类方法---"+s);
    }
}
