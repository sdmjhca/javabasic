package javaBasicDemo.interviewQuestion;

/**
 * @author JHMI on 2017/7/20.
 */
public class Test2 {

    private static Test2 test2 = null;

    public static Test2 getTest2(){
        if(test2 == null){
            return new Test2();
        }else {
            return test2;
        }
    }

    public void getStr(String str){
        str = "wo cao";
    }
}
