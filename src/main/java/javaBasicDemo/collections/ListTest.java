package javaBasicDemo.collections;

import java.util.ArrayList;

/**
 * @author JHMI on 2018/9/21.
 */
public class ListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("abc");
        new Thread(new Runnable() {
            @Override
            public void run() {
               ListTest.modify(list);
            }
        }).start();
        //list.clear();
        System.out.println("main-----------"+list.get(0));
    }
    public static void modify(ArrayList list){
        try {
            Thread.sleep(1000);
            throw  new RuntimeException("eeeeeeeeeeee");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("thread-----------"+list.get(0));
    }
}
