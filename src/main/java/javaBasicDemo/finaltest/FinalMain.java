package javaBasicDemo.finaltest;

/**
 * @author JHMI on 2017/8/21.
 *  参考 http://www.cnblogs.com/xrq730/p/4820296.html
 */
public class FinalMain {
    public static void main(String args[]){
        final FinalTest finalTest1 = new FinalTest("test1");
        /**如果用final修饰，可以改变变量的内容*/
        finalTest1.setTest("modify test content");
        System.out.println(finalTest1.getTest());

        final FinalTest finalTest2 = new FinalTest("test2");
        System.out.println(finalTest2.getTest());

        /**如果用final修饰，下列一行直接编译报错，说明不能更改变量的引用*/
        //finalTest1 = finalTest2;
        System.out.println(finalTest1.getTest());

        /**测试final修饰符 修饰数组*/
        final String test1[] = {"1","2","3"};
        final String test2[] = {"3","2","1"};
        /**如果用final修饰，下列一行直接编译报错，说明不能更改变量的引用*/
        //test1 = test2;
        /**如果用final修饰，可以改变变量的内容*/
        test1[0] = test2[0];
        System.out.println(test1[0]);
    }
    public class FinalInner{

    }
}

class FinalTest {
  public final String s = "123";
  private String test;
  public FinalTest(String s1){
      this.test=s1;
  }

  public String getTest() {
      return test;
  }

  public void setTest(String test) {
      this.test = test;
  }
}
