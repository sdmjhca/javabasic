package javaBasicDemo.collections;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author JHMI on 2017/8/22.
 */
public class HashMapTest extends Thread{
    private static AtomicInteger ai = new AtomicInteger(0);
    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>(1);
    static Map<String,List<String>> hashMapList = new HashMap<String,List<String>>();

    public void run()
    {
        while (ai.get() < 100000)
        {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        /*HashMapTest hmt0 = new HashMapTest();
        HashMapTest hmt1 = new HashMapTest();
        HashMapTest hmt2 = new HashMapTest();
        HashMapTest hmt3 = new HashMapTest();
        HashMapTest hmt4 = new HashMapTest();
        hmt0.start();
        hmt1.start();
        hmt2.start();
        hmt3.start();
        hmt4.start();*/
        Random ran = new Random();

        for(int i=0;i< 100 ;i++){
            String s = "1234"+ran.nextInt(10000);
            int j = hash(s.hashCode());
            int k = j&15;
            System.out.println(j);
            System.out.println(k+ "------"+s);
        }

        initHashMapList("女装","棉袄");
        initHashMapList("女装","羽绒服");
        Iterator iterator = hashMapList.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            String name = (String) entry.getKey();
            List value = (List) entry.getValue();
            for(int i=0;i<value.size();i++){
                System.out.println(value.get(i).toString());
                value.remove("羽绒服");
            }
        }
        hashMapList.remove("女装","羽绒服");
        hashMapList.remove("女装",new ArrayList<String>().add("羽绒服"));
        System.out.println(hashMapList.toString());

    }
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void initHashMapList(String key,String value){
        List<String> list = hashMapList.get(key);
        if(list == null){
            list = new ArrayList<String>();
            hashMapList.put(key,list);
        }
        list.add(value);
    }
}
