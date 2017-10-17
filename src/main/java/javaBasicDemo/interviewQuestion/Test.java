package javaBasicDemo.interviewQuestion;

/**
 * @author JHMI on 2017/7/20.
 * 笔试题
 */
public class Test implements Runnable{

    int x=0;
    int y=0;
    public static void main(String args[]){

        Test test1 = new Test();
        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test1);
        t1.start();
        t2.start();
    }

    @Override
    public synchronized  void run() {

        for (;;){
            x++;
            y++;
            System.out.println("x="+x+"y="+y);
        }
    }
}
