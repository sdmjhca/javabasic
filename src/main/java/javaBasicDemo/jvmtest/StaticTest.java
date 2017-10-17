package javaBasicDemo.jvmtest;

/**
 * @author JHMI on 2017/8/17.
 */
public class StaticTest {
    public static int X = 100;

    public static final int Y = 200;

    public int z=100;

    public StaticTest()
    {
        System.out.println("Test构造函数执行");
    }
    public StaticTest(String s)
    {
        System.out.println("Test s 构造函数执行"+s);
    }
    static
    {
        System.out.println("static语句块执行");
    }

    public static void display()
    {
        System.out.println("静态方法被执行");
    }

    public void display_1()
    {
        System.out.println("实例方法被执行");
    }
    public static class StaticInner{
        static
        {
            System.out.println("static 内部类语句块执行");
            System.out.println(StaticTest.X);
        }
    }
    public static class Innerasd{
        public static final int A = 200;
    }
}

abstract class InnerStatic{

}


