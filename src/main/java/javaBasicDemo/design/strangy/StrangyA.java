package javaBasicDemo.design.strangy;

/**
 * @author JHMI on 2020/4/10.
 */
public class StrangyA implements StrangyTest{

    public StrangyA() {
    }

    @Override
    public String execute(String content) {
        System.out.println("strangy a");
        return null;
    }
}
