package javaBasicDemo.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author JHMI on 2017/8/22.
 * 源码分析treemap
 * 1、初始化private final Comparator<? super K> comparator;为null
 * 2、comparator比较器用来维持这棵树图的顺序，或 为null如果使用其keys的自然顺序。
 * 3、初始化存储单元
 * K key;
V value;
Entry<K,V> left;
Entry<K,V> right;
Entry<K,V> parent;
boolean color = BLACK;
 * 3、put操作
 * （1）初始化根节点 Entry<k,v> root，遍历所有节点
 * （2）compareTo 比较当前key和root key 如果当前key大于root key，则当前节点位于right；小于 则位于left。
 * (3)root根节点 parent 下一级节点 t遍历的节点，如果t!=null 则说明右边还有节点，继续遍历；
 * （4）如果t==null则停止遍历，并生成当前节点e,Entry<K,V> e = new Entry<>(key, value, parent);
 * （5）把当前节点e放在，parent节点后：parent.right = e;
 * （6）把当前节点设置为RED
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("aasd","1");
        treeMap.put("bdsda","2");
        treeMap.put("c","3");
        treeMap.put("Dasd","4");
        treeMap.put("e","9");
        treeMap.put("f","6");
        treeMap.put("g","7");
        treeMap.put("h","8");

        /**
         * 通过遍历treemap可以发现默认情况下，是按照key的顺序排列
         */
        Iterator iterator = treeMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            String name = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("name="+name+",value="+value);
        }


    }
}
