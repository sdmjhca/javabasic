package javaBasicDemo.collections;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author JHMI on 2017/9/4.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        //stack.
        Iterator iterator = stack.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        System.out.println("---------"+stack.firstElement());

    }
}
