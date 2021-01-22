package javaBasicDemo.design.observe;

/**
 * @author JHMI on 2020/4/10.
 */
public class ObserverA implements Observer{

    @Override
    public void observe(String msg) {
        if(msg.contains("a")){
            System.out.println(" observer a receive"+msg);
        }else{
            // do nothing
        }
    }
}
