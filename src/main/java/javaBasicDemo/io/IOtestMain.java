package javaBasicDemo.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author JHMI on 2017/9/19.
 */
public class IOtestMain {
    public static void main(String[] args) throws IOException {
        Employee e1 = new Employee("zhangsan", 23);
        Employee e2 = new Employee("lisi", 24);
        Employee e3 = new Employee("wangwu", 25);

        RandomAccessFile raf0 = new RandomAccessFile("D:/employee.txt", "rw");
        raf0.writeBytes(e1.getName());
        raf0.writeInt(e1.getAge());
        raf0.writeBytes(e2.getName());
        raf0.writeInt(e2.getAge());
        raf0.writeBytes(e3.getName());
        raf0.writeInt(e3.getAge());
        raf0.close();

        System.out.println(System.getProperties());
    }
}
