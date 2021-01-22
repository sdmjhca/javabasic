package javaBasicDemo.collections;

import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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

    public static void main(String[] args) throws ParseException {
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
        for(Map.Entry<String,List<String>> entry : hashMapList.entrySet()){
            entry.getKey();
        }
        hashMapList.forEach(HashMapTest::foreach);
        hashMapList.remove("女装","羽绒服");
        hashMapList.remove("女装",new ArrayList<String>().add("羽绒服"));
        System.out.println(hashMapList.toString());

        System.out.println("=="+LocalDateTime.now());
        System.out.println("---"+Instant.now());
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));

        System.out.println(new Date(System.currentTimeMillis()));

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sf.parse("2018-02-26").compareTo(sf.parse(sf.format(new Date()))));

        System.out.println(sf.parse("2018-02-26").getTime());
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

    public static void foreach(String s, List<String> list){
        System.out.println("key = "+s+" and value = "+list.toString());
    }
}
