package javaBasicDemo.duotai;

/**
 * @author JHMI on 2017/8/20 0020.
 * 父类中的方法区分
 * 1、public 的方法可以被重写
 * 2、private的方法对子类不可见，不能被重写
 * 3、protected的方法可以被重写，但是对包外不可见
 * 4、static修饰的方法标识这个方法是类方法，不能被重写
 * 5、final修饰的方法，标识这个方法不能被重写，但是可以重载
 */
public  class Father {

    public Father(){
        publicMethod("father");
        privateMethod("ffff");
        protectedMethod("aaaaaaaaa");
        staticMethod();
        finalMethod();
    }

    public void publicMethod(String s){
        System.out.println("-------------公有父类方法---"+s);
    }

    private void privateMethod(String s){
        System.out.println("--------------------私有父类方法---"+s);
    }

    protected void protectedMethod(String s){
        System.out.println("------------受保护的父类方法---"+s);
    }
     //abstract void method();

    public static void staticMethod(){
        System.out.println("=-----父类静态方法----");
    }

    public final void finalMethod(){
        System.out.println("=--------------父类final方法");
    }

    public Integer getLength(){return  new Integer(4);}


}
