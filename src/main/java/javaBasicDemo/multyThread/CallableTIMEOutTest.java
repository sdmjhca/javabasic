package javaBasicDemo.multyThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author JHMI on 2017/9/1.
 * 场景：支付路由根据第三方渠道的权重，调用第三方服务接口
 * 根据第三方接口的响应时间，动态调整支付权重
 *
 * 参考细节可参考http://www.cnblogs.com/xrq730/p/4872722.html
 */
public class CallableTIMEOutTest {
    static  boolean flag = false;//第三方请求，执行结束的标志位
    static final int TIME_OUT = 2000;//超时时间2秒钟
    static final int CALL_SLEEP_TIME = 1000;//调用第三方接口的执行时间
    static Callable callable = new Callable() {
        @Override
        public Object call() throws Exception {
            System.out.println("执行callable方法，进行计算");
            Thread.sleep(CALL_SLEEP_TIME);
            System.out.println("执行时间3秒钟");
            //返回计算结果
            flag = true;//执行结束的标志位
            System.out.println("call返回计算结果");
            return 111;
        }
    };

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        //定义线程池，cached线程池默认空闲时间60秒
        ExecutorService executorService = Executors.newCachedThreadPool();
        //执行call方法
        Future<Integer> future = executorService.submit(callable);
        //关闭线程池
        executorService.shutdown();
        System.out.println("执行main方法和call方法并列执行计算");

        for(;;){
            long end = System.currentTimeMillis();
            if((end -start) >= TIME_OUT){//超时判断
                if(!flag){//第三方执行 状态
                    System.out.println(end -start);
                    System.out.println("执行call方法超时，进行降级处理");
                    //do something...
                }else{
                    System.out.println("调用call方法未超时，不做处理");
                    //do nothing ...
                }
                break;
            }
        }
        int result = future.get();
        System.out.println("获得call执行结果="+result);

        //Future future1 = executorService.submit(callable2);
    }
}
