package javaBasicDemo.jvmtest;

/**
 * @author JHMI on 2017/8/18.
 */
public class SonStatic extends StaticTest{
    public SonStatic(){
        System.out.println("子类构造方法");
    }

    public SonStatic(String s){
        System.out.println("s 子类构造方法"+s);
    }
}
