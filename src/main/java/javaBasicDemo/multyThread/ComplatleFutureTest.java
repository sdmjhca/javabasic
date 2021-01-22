package javaBasicDemo.multyThread;

import java.util.concurrent.*;

/**
 * @author JHMI on 2019/3/8.
 */
public class ComplatleFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future future = executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("wtf");
            }
        },"sdmjhca");
        Future<String> future1 = executor.submit(()->{
            System.out.println("call");
            return "sdmjhcaCall";
        });
        System.out.println(future1.get());
        //交由ForkJoinPool池中的某个执行线程（Executor）运行
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(321);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        }).thenCompose(result->CompletableFuture.supplyAsync(()->{
            int i1 = result + 100;
            System.out.println("------------------");
            return i1;
        })).thenApply(r1->{
            System.out.println(r1+100);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return r1+100;
        });
        System.out.println(123);
        int i = (int) completableFuture.get();
        System.out.println(future.get());
        System.out.println(i);
        //交由ForkJoinPool池中的某个执行线程（Executor）运行,无返回值
        CompletableFuture comFuture = CompletableFuture.runAsync(()->{
            System.out.println(" com future");
        });
        System.out.println("1111");
//        System.out.println(comFuture.get());
        comFuture.join();
        System.out.println("--------------------------");

        CompletableFuture combine = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
                System.out.println("44444444444444");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 200;
        })
                .thenCombine(CompletableFuture.supplyAsync(()->{
                    System.out.println("333333333333333333");
                    return 300;
                }),(r1,r2)->r1+r2);
//        System.out.println(combine.get());
        CompletableFuture.allOf(combine,comFuture).join();
        System.out.println("555555555555555555");



        CompletableFuture f1 = CompletableFuture.supplyAsync(()->{
            System.out.println(1);
            return 1;
        }).thenAcceptAsync(r1->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(r1+1);
        });

        CompletableFuture f2 = CompletableFuture.supplyAsync(()->{
            System.out.println(3);
            return 3;
        }).thenApply(r1->{
            System.out.println(r1+1);
            return r1+1;
        });

//        CompletableFuture.allOf(f1,f2).join();
//        System.out.println(5);

        CompletableFuture.allOf(f1,f2).thenApply(r3->{
            System.out.println(5);
            System.out.println(r3);
            return 5;
        });
    }

}
