package javaBasicDemo.multyThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author JHMI on 2017/9/1.
 */
public class CallableTest {
    static transient boolean flag = false;
    static Callable callable = new Callable() {
        @Override
        public Object call() throws Exception {
            System.out.println("执行callable方法，进行计算");
            Thread.sleep(3000);
            System.out.println("执行时间3秒钟");
            flag = true;
            //返回计算结果
            System.out.println("call返回计算结果");
            return 111;
        }
    };

    public static void main(String[] args) throws Exception {
        //callable.call();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(callable);
        executorService.shutdown();
        System.out.println("执行main方法和call方法并列执行计算");
        int i = 222;

        int result =  future.get();
        System.out.println("获得call执行结果="+result);

        System.out.println("计算出最终计算结果："+(i+result));
        //Future future1 = executorService.submit(callable2);
    }
}
