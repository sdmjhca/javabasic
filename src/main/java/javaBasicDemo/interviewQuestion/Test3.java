package javaBasicDemo.interviewQuestion;

/**
 * @author JHMI on 2017/7/20.
 */
public class Test3 extends Test4{
    //static int i = 0;
    /*public Test3(){
        System.out.println("test3");
    }*/
    public Test3(String s){
        super(s);
        System.out.println("test3 有参构造");
    }
    public static void main(String args[]){
      //  static int i = 0;
        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };
        Thread thread = new Thread(runnable);
        //thread.run();
        thread.start();*/
        /*Test4 test4 = null;
        test4.hello();*/
        //Test3 test3 = new Test3();

        Test3 tt = new Test3("ss");
        Test4 test4 = new Test3("as");
        long l = 0123;
        System.out.println(l);
    }
    int i = 0;
    /*public static class Test5{
        public static void func(){
            i = i +1;
        }
    }
    abstract class Test6{
        public abstract void testt();
    }*/
}

abstract class Test4{
    /*public Test4(){
        System.out.println("test4");
    }*/
    public Test4(String s){
        System.out.println("test4 有参构造");
    }
    public static void hello(){
        System.out.println("123");
    }
}

