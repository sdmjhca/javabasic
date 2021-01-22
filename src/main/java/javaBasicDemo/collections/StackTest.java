package javaBasicDemo.collections;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author JHMI on 2017/9/4.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        //stack.
        Iterator iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
        System.out.println();
        for(String s : stack){
            System.out.print(s);
        }
        System.out.println();
        for(int i = 0;i < stack.size();i++){
            System.out.print(stack.peek());
        }
        System.out.println();
        for(int i = 0, j = stack.size();i < j;i++){
            System.out.print(stack.pop());
        }

        System.out.println("---------"+stack.firstElement());

    }
}
