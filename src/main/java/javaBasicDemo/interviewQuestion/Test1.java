package javaBasicDemo.interviewQuestion;

import java.util.Scanner;

/**
 * @author JHMI on 2017/7/20.
 */
public class Test1 {
    private static Test1 test1 = new Test1();

    public static Test1 getTest(){
        return test1;
    }

    public static void main(String args[]){
        String s = "123";
        Test2.getTest2().getStr(s);
        System.out.println(s);
        try {
            Class c1 = Test1.class;
            Class c2 = Class.forName("com.sdmjhca.javaBasicDemo.interviewQuestion.Test1");
            Test1 t1 = new Test1();
            Test1 c3 = t1.getClass().newInstance();
            c3.daoxu();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("done");

    }

    public void daoxu(){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String s = i + "";
        String r = "";
        int len = s.length();
        String rr = "";
        for(int j =0 ;j<s.length();j++){

            char c = s.charAt(j);
            rr += String.valueOf(c);
            r += s.substring(len-(j+1),len-j);
            System.out.println(r);
        }
        System.out.println(rr);
    }
}
