package javaBasicDemo.single;

/**
 * @author JHMI on 2019/1/11.
 */
public class SingleTest {


    private SingleTest(){}

    public static class SingleBuilder{
        private static final SingleTest test = new SingleTest();
        public static SingleTest getInstance(){
            return test;
        }
    }

    public static void main(String[] args) {
        System.out.println(123);
        SingleBuilder.getInstance();
    }
}
