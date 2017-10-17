package javaBasicDemo.collections;

import java.util.ArrayList;

/**
 * @author JHMI on 2017/8/21. JDK1.8
 * 参考文章：http://www.cnblogs.com/xrq730/p/4989451.html
 * 通过以下代码分析，不难得出以下结论：
 * ArrayList的优缺点

ArrayList的优点如下：

1、ArrayList底层以数组实现，是一种随机访问模式，再加上它实现了RandomAccess接口，因此查找也就是get的时候非常快

2、ArrayList在顺序添加一个元素的时候非常方便，只是往数组里面添加了一个元素而已

不过ArrayList的缺点也十分明显：

1、删除元素的时候，涉及到一次元素复制，如果要复制的元素很多，那么就会比较耗费性能

2、插入元素的时候，涉及到一次元素复制，如果要复制的元素很多，那么就会比较耗费性能

因此，ArrayList比较适合顺序添加、随机访问的场景。

 注意：1、扩容是针对Obejct[]数组elementData的大小，用transient修饰elementData意味着我不希望elementData数组被序列化
      2、并不是每次add都会进行扩容和复制元素，只有在扩容的时候会复制，
      3、从源码不难看出第一次add会进行扩容，后的大小为10
      4、以后每次超过上一次扩容的大小后都会进行扩容
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        /**1、跟踪代码发现 Arraylist 是一个Obejct[]数组名为elementData*/
        /**2、使用arrayList.add("123");方法分析 add源码如下：
         * （1）ensureCapacityInternal方法；
         *  担心数组大小不够进行扩容，如果不够的话，会生成计算新的数组大小，第一次生成的数组大小为10 Math.max(DEFAULT_CAPACITY(10), minCapacity(1));
         *  当数组大小超过10以后，新数组大小为int newCapacity = oldCapacity + (oldCapacity >> 1)；原数组大小+原数组大小的一半；且最大为Integer.MAX_VALUE
         *  并使用Arrays.copyOf(elementData, newCapacity)生成一个新数组将原数组copy进去,并返回
         *  （2）elementData方法；扩容后继续将元素顺序放进数组
         *
         *  源码如下：
         *  public boolean add(E e) {
                ensureCapacityInternal(size + 1);
                elementData[size++] = e;
                return true;
            }
         * */
        //Arrays.copyOf();
        //System.arraycopy();
        arrayList.add("123");
        arrayList.add("321");
        arrayList.add(2,"321");
        /**
         * 3、arrayList.add(2,"321");源码如下：
         *
         * public void add(int index, E element) {
                rangeCheckForAdd(index);

                ensureCapacityInternal(size + 1);  // Increments modCount!!
                System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
                elementData[index] = element;
                size++;
         }
         （1）rangeCheckForAdd(index);校验插入元素的位置是否大于当前list的大小
         （2）ensureCapacityInternal(size + 1); 进行扩容
         （3）System.arraycopy(elementData, index, elementData, index + 1,size - index);进行数组的复制，将index后的元素往后挪一位
         （4）elementData[index] = element;将新增的元素，放到index位置
         （5）list的大小加1
         */

        arrayList.remove(1);
        arrayList.remove("123");
        /**
         * 4、arrayList.remove(1);arrayList.remove("123");代码分析
         *
         * public E remove(int index) {
                rangeCheck(index);

                modCount++;
                E oldValue = elementData(index);

                int numMoved = size - index - 1;
                if (numMoved > 0)
                System.arraycopy(elementData, index+1, elementData, index,numMoved);
                elementData[--size] = null; // clear to let GC do its work

                return oldValue;
         }
         arrayList.remove的两个方法的实现原理类似，都是用元素对应的index
         (1)System.arraycopy(elementData, index+1, elementData, index,numMoved);将index后的元素复制，往前挪一位
         (2)elementData[--size] = null; 将原来最后一位的元素置为null，便于gc
         */
        //arrayList.get()
    }

}
