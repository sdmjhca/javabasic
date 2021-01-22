package javaBasicDemo.jackson;

/**
 * @author JHMI on 2019/6/25.
 */
public interface IEnum<C,D> {

    /**
     * 获取对应编码
     * @return
     */
    C getCode(C code);

    /**
     * 获取对应描述
     * @return
     */
    D getDesc(C code);


}
