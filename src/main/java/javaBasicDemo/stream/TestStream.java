package javaBasicDemo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author JHMI on 2020/3/31.
 */
public class TestStream {
    public static void main(String[] args) {
        //生成20个int stream
        Stream.iterate(new int[]{0,1},//初始元素
                //UnaryOperator t->new t
                 t -> new int[]{t[1],t[0] + t[1]})
                .limit(20)
                .forEach(t->{
                    System.out.println(t[0]+"------"+t[1]);
                });

        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);

        int[] a = new int[]{0,1};
        Stream.generate(()->{
            int t = a[0];
            a[0] = a[1];
            a[1] = t + a[1];
            return a;
        }).limit(20)
                .forEach(b-> System.out.println(b[0]+"--"+b[1]));

        Supplier supplier = new Supplier() {
            @Override
            public Object get() {
                return 1;
            }
        };

        Stream.generate(supplier).limit(5).forEach(System.out::println);

        List<Integer> tes = new ArrayList<>();
        tes.add(3);
        tes.add(1);
        tes.add(5);
        System.out.println(tes.stream().sorted()
                .collect(Collectors.toList()).toString());

    }
}
