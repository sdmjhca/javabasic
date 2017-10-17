package javaBasicDemo.serializable;

/**
 * @author JHMI on 2017/8/29.
 */
public class SerializableTestFather {
    public transient String attr = "123";
    public transient int anInt = 123;

    public SerializableTestFather() {
        attr = "123";
        anInt = 123;
    }
}
