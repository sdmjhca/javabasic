package javaBasicDemo.dataStructure.lianbiao;


/**
 * @author JHMI on 2017/9/1.
 * 如何实现一个双向链表
 */
public class NodeTest<E> {

    private static Node first;
    private static Node last;

    public static int size;

    private static class Node<E> {
        E item;
        NodeTest.Node<E> next;
        NodeTest.Node<E> prev;

        Node(NodeTest.Node<E> prev, E element, NodeTest.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    public void linkLast(E e){
        Node temp = last;
        Node element = new Node(temp,e,null);//首先将该对象放在last后
        last = element;
        if(temp == null){
            //则当前链表是一个空链表，当前节点设置成头结点和尾节点
            first = element;
        }else{
            //将当前节点放在最后，并将当前节点和头节点相连
            temp.next = element;
            //element.next = first;//or first.pre = element;
        }
        size++;
    }

    public E get(int index){
        Node<E> node;
        if(index <= (size >> 1)){
            node = first;
            for(int i = 0;i < index;i++)
                node = node.next;
        }else {
            node = last;
            for(int i = size-1;i > index;i--)
                node = node.prev;
        }
        return node.item;
    }
}
