package javaBasicDemo.duotai;

/**
 * @author JHMI on 2017/8/20 0020.
 */
public class Son  extends Super{

    public Son(){
        System.out.println("-----------转到子类构造方法------");
    }

    /**
     * 重写父类的公有方法
     * @param s
     */
    public void publicMethod(String s){
        System.out.println("---------------重写父类公有方法="+s);
    }
    public void publicMethod(String s,String ss){
        System.out.println("---------------重载父类公有方法="+s+"---"+ss);
    }

    private void privateMethod(String s){
        System.out.println("---------------重写父类私有方法="+s);
    }
    private void privateMethod(String s,String ss){
        System.out.println("---------------重载父类私有方法="+s+"------"+ss);
    }

    /**
     * protected的方法可以被重写 和 重载，但是只对包内部的类可见，对外不可见
     * @param s
     */
    protected void protectedMethod(String s){
        System.out.println("------------重写受保护的父类方法---"+s);
    }
    protected void protectedMethod(String s,String ss){
        System.out.println("------------重载受保护的父类方法---"+s+"---"+ss);

    }
    public static void staticMethod(){
        System.out.println("=-----重写父类静态方法----");
    }

    public  void finalMethod(String ss){
        System.out.println("------------重写父类final方法，直接编译错误，但是可以重载-----");
    }

    public Long getLenght2(){
        return new Long(5);
    }

    public static void main(String[] args) {
        Super fa = new Super();
        Son sub = new Son();
        System.out.println(fa.getLenght() + "===="+sub.getLenght());
    }
}

class Super {
    public Integer getLenght() { return new Integer(4); }
}