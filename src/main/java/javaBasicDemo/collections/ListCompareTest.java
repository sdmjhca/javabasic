package javaBasicDemo.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JHMI on 2018/3/8.
 */
public class ListCompareTest {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List list2 = new ArrayList();

        list2.add("b");
        list2.add("d");

        System.out.println(list1.toString());
        System.out.println(list2.toString());

        list1 = list2;
        System.out.println(list1);
        list2 = null;
        System.out.println("------------------华丽的分界线------------");
        System.out.println(list1);
        System.out.println(list2);
    }
}
