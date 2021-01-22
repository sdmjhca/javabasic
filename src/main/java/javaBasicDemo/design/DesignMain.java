package javaBasicDemo.design;

import javaBasicDemo.design.factory.Product;
import javaBasicDemo.design.factory.ProductA;
import javaBasicDemo.design.factory.ProductB;
import javaBasicDemo.design.factory.ProductFactory;
import javaBasicDemo.design.model.Model;
import javaBasicDemo.design.model.ModelA;
import javaBasicDemo.design.model.ModelB;
import javaBasicDemo.design.observe.Observer;
import javaBasicDemo.design.observe.ObserverA;
import javaBasicDemo.design.observe.ObserverB;
import javaBasicDemo.design.observe.SubjectA;
import javaBasicDemo.design.strangy.StrangyA;
import javaBasicDemo.design.strangy.StrangyB;
import javaBasicDemo.design.strangy.StrangyTest;

import java.util.function.Supplier;

/**
 * @author JHMI on 2020/4/10.
 */
public class DesignMain {
    public static void main(String[] args) {
        /**
         * 策略模式
         */
        StrangyTest a = new StrangyA();
        StrangyTest b = new StrangyB();
        a.execute("a ");
        b.execute("b");
        //lambda
        StrangyTest sa = content -> {
            System.out.println("aaaaa" + content);
            return "";
        };

        StrangyTest sb = content -> {
            System.out.println("bbbbb" + content);
            return "";
        };
        sa.execute("lambda a");
        sb.execute("lambda b");

        /**
         * 模板方法
         */

        Model modelA = new ModelA();
        Model modelB = new ModelB();
        modelA.modelCommon();
        modelB.modelCommon();

        //lambda
        modelA.modelCommon(conten-> System.out.println("lambda---"+conten),"adad");
        /**
         * 观察者模式
         */
        SubjectA subjectA = new SubjectA();
        ObserverA observerA = new ObserverA();
        ObserverB observerB = new ObserverB();
        subjectA.registerObserver(observerA);
        subjectA.registerObserver(observerB);
        subjectA.notify("aaaaaa");
        //lambda
        Observer oa = msg -> {
            if(msg.contains("oa")){
                System.out.println("oa lambda receive"+msg);
            }
        };

        Observer ob = msg -> {
            if(msg.contains("ob")){
                System.out.println("ob lambda receive "+msg);
            }
        };
        subjectA.registerObserver(oa);
        subjectA.registerObserver(ob);
        subjectA.notify("aaaaaaoa");

        /**
         * 工厂模式
         */
        Product product = ProductFactory.createProduct("a");
        product.product();
        //lambda

        Supplier<Product> sp = ProductB::new;
        Product pbb = sp.get();

        ProductFactory.add(()-> 1==1);

    }
}
