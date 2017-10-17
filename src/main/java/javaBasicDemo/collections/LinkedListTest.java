package javaBasicDemo.collections;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author JHMI on 2017/8/22.
 * 通过跟踪分析源码不难发现LinkedList的存储结构是双向链表
 * 存储的内容为 previous（前一个单元的地址） item（当前元素的内容） next（下一个单元的地址）
 * 1、LinkedList的get方法 是通过判断当前的索引和size的一半比较，如果小于，则从前一半数据开始遍历；如果大于，则从后一半数据倒序遍历；所以使用for循环遍历会很慢
 * 2、而通过foreach是通过LinkedList的Iterator进行遍历，只需要初始化表头后，通过节点的next进行向下查找（即通过地址进行遍历）
 * 3、LinkedList的add("asd")方法是直接向链表的末尾添加一个节点；add(0,"0")方法同get方法一样向前或向后遍历
 * 4、linkedList.remove(0);//需要向前或向后遍历链表，然后修改前一个节点的next和后一个节点的previous
 * 5、linkedList.remove("123");//直接从头开始遍历链表如果item相同则找到，所以如果有多个相同的item 先删除的是最先add的
 *
 * 6、总结linkedList和arraylist的add和remove方法
 * linkedList的寻址比较慢需要遍历链表，但是新增和删除操作较快只需变更前后节点的地址
 * arraylist的寻址比较快只需通过数组下标定位元素，但是新增和删除比较慢，需要拷贝数组的元素
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("asd");
        linkedList.add(0,"0");
        linkedList.add(1,"1");
        linkedList.add(3,"3");

        linkedList.get(0);

        linkedList.remove(0);//需要向前或向后遍历链表
        linkedList.remove("123");//直接从头开始遍历链表如果item相同则找到，所以如果有多个相同的item 先删除的是最先add的
        System.out.println("----");
        for (Object s: linkedList ){
            System.out.println(s);
        }
        System.out.println(1 << 30);

        System.out.println(12&5);
        System.out.println("--------------");
        ListIterator listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }

}
