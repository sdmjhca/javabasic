package javaBasicDemo.design.observe;

import java.util.List;

/**
 * @author JHMI on 2020/4/10.
 */
public interface Subject {
    void registerObserver(Observer observer);
    void notify(String msg);
}
