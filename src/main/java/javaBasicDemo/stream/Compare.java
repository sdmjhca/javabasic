package javaBasicDemo.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author JHMI on 2020/4/17.
 */
public class Compare {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,5,2,3,8,6);
        System.out.println(list);
        List newlIST = list.stream().sorted(Comparator.comparing(i->i)).collect(Collectors.toList());
        System.out.println(newlIST);
    }
}
