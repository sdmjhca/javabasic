package javaBasicDemo.threadsafe;

import java.util.Map;

/**
 * @author JHMI on 2019/2/23.
 */
public class ThreadSafeTest implements Runnable{
    private Map<String,String> map;
    private String phone;

    private String msg;

    public ThreadSafeTest(Map<String, String> map, String phone) {
        this.map = map;
        this.phone = phone;
    }

    public ThreadSafeTest(Map<String, String> map, String phone, String msg) {
        this.map = map;
        this.phone = phone;
        this.msg = msg;
    }

    @Override
    public void run() {
        System.out.println(map);
        System.out.println("1-------------"+map);
        testThread(map,msg);
    }

    private void testThread(Map map,String msg){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2-------------"+msg);
        //System.out.println("2-------------"+map.get("phone"));
    }
}
