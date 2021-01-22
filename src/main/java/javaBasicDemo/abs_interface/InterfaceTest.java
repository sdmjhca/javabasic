package javaBasicDemo.abs_interface;

import javaBasicDemo.duotai.Father;

/**
 * @author JHMI on 2020/4/20.
 */
public interface InterfaceTest {
    public boolean flag = true;
    Father FATHER = new Father();

    default void hello(){
        System.out.println("hello from a");
    }

    static void haha(){
        System.out.println("wtf");
    }
}
