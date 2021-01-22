package javaBasicDemo.design.model;

import java.util.function.Consumer;

/**
 *
 * 模板方法
 * @author JHMI on 2020/4/10.
 */
public abstract class Model {
    public void modelCommon(){
        System.out.println("common model");
        modelAbstract();
    }

    abstract void modelAbstract();

    public void modelCommon(Consumer<String> consumer,String content){
        System.out.println("common model lambda");
        consumer.accept(content);
    }
}
