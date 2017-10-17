package javaBasicDemo.serializable;

import java.io.Serializable;

/**
 * @author JHMI on 2017/8/29.
 */
public class SerializableTestSon extends SerializableTestFather implements Serializable {
    private static final long serialVersionUID = 1L;

    transient String attrSon = "woca son";
    transient int intSon = 111;
    int i = 222;
    String ar = "wo son";
}
