package javaBasicDemo.design.strangy;

/**
 * @author JHMI on 2020/4/10.
 */
public class StrangyB implements StrangyTest{
    @Override
    public String execute(String content) {
        System.out.println("strangy b");
        return null;
    }
}
