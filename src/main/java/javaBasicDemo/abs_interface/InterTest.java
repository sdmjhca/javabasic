package javaBasicDemo.abs_interface;

/**
 * @author JHMI on 2020/4/20.
 */
public class InterTest extends AbstractTest implements InterfaceTest,InterB{

    public static void main(String[] args) {
        InterTest interTest = new InterTest();
        System.out.println(interTest.aflag);
        interTest.hello();
        InterfaceTest.haha();

    }

    @Override
    public void hello() {
        InterB.super.hello();
    }
}
