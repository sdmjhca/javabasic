package javaBasicDemo.duotai;

/**
 * @author JHMI on 2017/8/20 0020.
 * java面向对象的特性之“多态”
 * 特性1、继承
 * 2、子类重写父类方法
 * 3、父类的引用指向子类实例
 * 4、father对象只能访问父类中声明方法，不能调用子类中新增的方法、以及定义为私有的方法
 */
public class Main {
    public static void main(String args[]){
        //Father father = new Son();
        /*father.publicMethod("test");
        father.protectedMethod("test");
        //此处父类对象无法访问子类中的protected修饰的重载方法
        new Son().protectedMethod("test","test2");
        new Son().publicMethod("","");*/
        //father.finalMethod();

    }
}
