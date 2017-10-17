package javaBasicDemo.interviewQuestion;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author JHMI on 2017/8/15.
 */
public class OomTest1 {

    int i = 0;

    public static void main(String args[]) throws Exception {
        OomTest1 oomTest = new OomTest1();

        /*try{
            while (true){
                //oomTest.getStackOom();
                new Thread(oomTest).start();
            }
        }catch (Exception e){
            System.out.println("11111111111111111111111111");
            e.printStackTrace();
            Thread.sleep(10000);
        }*/

        //oomTest.getStackStackOverFlow();

        /*int j= 0;
        try{
            while(true){
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(PergenOomTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o,objects);
                    }
                });
                enhancer.create();
                j++;
            }
        }finally {
            System.out.println("执行次数="+j);
        }
*/

        List<String> list = new ArrayList<String>();
        int j= 0;
        try{
            while(true){
                //list.add(UUID.randomUUID().toString().intern());
                UUID.randomUUID().toString().intern();
                j++;
            }
        }finally {
            System.out.println("执行次数="+j);
        }

    }

    public void getStackStackOverFlow() {
        i++;
        System.out.println("-------------how to get stack oom,--------------" + i);
        getStackStackOverFlow();
    }

    public void run() {
        OomTest1.getStackOom();
    }

    public static void getStackOom() {
        while (true) {
            System.out.println("----------------out of memory---------------");
        }
    }

    class StackOomTest {

    }

    static class PergenOomTest {
    }
}
