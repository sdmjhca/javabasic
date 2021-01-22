package javaBasicDemo.dataStructure.lianbiao;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author JHMI on 2020/8/19.
 */
public class CustomLinkedList<E> {

    Node<E> head;
    Node<E> tail;
    int size = 0;

    /**
     * 头加
     * @param item
     */
    public void add(E item) {
        Node<E> node = new Node<>(item);

        node.pre = null;
        node.next = head;

        if (head != null) {
            head.pre = node;
        } else {
            tail = node;
        }

        size ++;
        head = node;
    }

    private static class Node<E> {
        E item;
        Node<E> pre;
        Node<E> next;
        public Node (E item) {
            this.item = item;
            this.pre = null;
            this.next = null;
        }
    }

    /**
     * 通过交换指针实现链表倒置（推荐）
     */
    public void reverseBySwapPointer() {
        Node<E> temp = null;
        Node<E> current = head;
        head = tail;
        tail = current;
        while (current != null) {
            temp = current.pre;
            current.pre = current.next;
            current.next = temp;
            current = current.pre;
        }

        /*if (temp != null) {
            head = temp.pre;
        }*/
    }

    /**
     * 通过交换数据实现链表倒置
     */
    public void reverseBySwapData() {
        Node<E> headNode = head;
        Node<E> tailNode = tail;
        while (headNode != tailNode) {
            E data = headNode.item;
            headNode.item = tailNode.item;
            tailNode.item = data;
            headNode = headNode.next;
            if (headNode == tailNode) {
                break;
            }
            tailNode = tailNode.pre;
        }
    }

    void printList() {
        Node<E> node = head;
        while (node != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.println();
    }

    public E getFirst() {
        return head != null ? head.item : null;
    }

    public E getLast() {
        return tail != null ? tail.item : null;
    }

    public E get(int index) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index < (size >> 1)) {
            Node<E> node = head;
            for (int i=0; i<index; i++) {
                node = node.next;
            }
            return node != null ? node.item : null;
        } else {
            Node<E> node = tail;
            for (int i=size-1; i>index; i--) {
                node = node.pre;
            }
            return node != null ? node.item : null;
        }
    }

    public static void main (String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        System.out.println(list);
        list.printList();
        list.reverseBySwapPointer();
        System.out.println(list.head.item);
        System.out.println(list.tail.item);
        list.printList();
        list.reverseBySwapData();
        System.out.println(list.head.item);
        System.out.println(list.tail.item);
        list.printList();

        LinkedList linkedList = new LinkedList();
        for(int i = 0;i < 20;i++){
            linkedList.add(i);
        }
        System.out.println(linkedList);

        Collections.reverse(linkedList);
        System.out.println(linkedList);
    }
}
