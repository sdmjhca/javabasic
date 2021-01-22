package javaBasicDemo.collections;

import com.google.common.collect.*;

import java.util.*;

/**
 * @author JHMI on 2018/10/24.
 */
public class TableTest {
    public static Table<Object,Object,Object> table = HashBasedTable.create();

    public static void main(String[] args) {
        Map<String,Multimap<String,String>> map = new HashMap<>();
        table.put("a","1","aa");
        table.put("a","1","bb");
        System.out.println(table.row("a").get("1"));
        SetMultimap multimap = MultimapBuilder.hashKeys().hashSetValues().build();
        multimap.put("a","1");
        multimap.put("a","3");
        multimap.put("a","4");
        multimap.put("a","5");
        multimap.put("b","5");
        System.out.println(multimap.get("a"));
        System.out.println(multimap.size());
        System.out.println(multimap.get("b"));
    }

}
