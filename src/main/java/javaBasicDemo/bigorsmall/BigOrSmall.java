package javaBasicDemo.bigorsmall;


import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteOrder;

/**
 * @author JHMI on 2020/8/3.
 */
public class BigOrSmall {

    public static void main(String[] args) {

        try {
            //通过反射获取Unsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);
            Long b = unsafe.allocateMemory(8);
            System.out.println(b);
            unsafe.putLong(b, 0x080701);
            System.out.println(b);
            byte c = unsafe.getByte(b);
            if(c == 0x01){
                System.out.println("big");
            }else if(c == 0x08){
                System.out.println("little ");
            }
            System.out.println(c);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        ByteOrder.nativeOrder();
        System.out.println(ByteOrder.nativeOrder());
    }
}
