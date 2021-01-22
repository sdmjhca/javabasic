package javaBasicDemo.design.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JHMI on 2020/4/10.
 */
public class ProductA implements Product{


    @Override
    public boolean product() {
        System.out.println("product a");
        return true;
    }

}
