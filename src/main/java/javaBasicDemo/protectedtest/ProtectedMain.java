package javaBasicDemo.protectedtest;


import javaBasicDemo.duotai.Father;

/**
 * @author JHMI on 2017/8/20 0020.
 */
public class ProtectedMain {
    public static void main(String args[]){
        Father father = new SonTest();
        //此处无法访问子类当中的protected修饰的方法
        new SonTest().protectedMethod("asd");
    }
}
