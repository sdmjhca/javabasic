package javaBasicDemo.design.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JHMI on 2020/4/10.
 */
public class SubjectA implements Subject {
    List<Observer> list = new ArrayList<>();
    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void notify(String msg) {
        list.stream().forEach(o->o.observe(msg));
    }
}
