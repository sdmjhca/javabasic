package javaBasicDemo.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *  acquire 获取一个令牌获取不到进行阻塞
 *  tryAcquire 尝试获取令牌获取不到 直接返回失败
 * @author JHMI on 2018/11/29.
 */
public class RateLimiterTest {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(sf.format(new Date()));
        RateLimiter rateLimiter = RateLimiter.create(1);
        for(int i = 0;i < 100;i++){
            double d = rateLimiter.acquire(1);
            System.out.println(d);
            System.out.println(sf.format(new Date())+"------------succ");
            /*if(rateLimiter.tryAcquire(1)){
                System.out.println(sf.format(new Date())+"------------succ");
                Thread.sleep(100);
            }else{
                Thread.sleep(100);
                System.out.println(sf.format(new Date())+"------------fail");
            }*/
        }
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
    }
}
