package javaBasicDemo.design.observe;

/**
 * @author JHMI on 2020/4/10.
 */
public class ObserverB implements Observer{
    @Override
    public void observe(String msg) {
        if(msg.contains("b")){
            System.out.println("observer b receive"+msg);
        }else{
            //do nothing
        }
    }
}
