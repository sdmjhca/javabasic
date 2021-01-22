package javaBasicDemo.design.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author JHMI on 2020/4/10.
 */
public class ProductFactory {
    static List<Product> pa = new ArrayList<>();

    public static void add(Product p){
        if(p.product()){
            pa.add(p);
        }
    }
    public static Product createProduct(String p){
        if(p.contains("a")){
            return new ProductA();
        }else{
            return new ProductB();
        }
    }
}
