package javaBasicDemo.abs_interface;

/**
 * @author JHMI on 2020/4/20.
 */
public interface InterB {
    default void hello(){
        System.out.println("hello from b");
    }
}
