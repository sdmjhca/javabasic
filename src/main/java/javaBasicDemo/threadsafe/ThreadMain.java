package javaBasicDemo.threadsafe;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author JHMI on 2019/2/23.
 */
public class ThreadMain {
    public static void main(String[] args) {
        Map<String,String> map = new ConcurrentHashMap();
        map.put("content","test");
        for(int i = 0;i<10;i++){
            map.put("phone",i+"p");

            Thread t = new Thread(new ThreadSafeTest(map,i+"p",map.toString()));
            t.start();
        }
    }
}
