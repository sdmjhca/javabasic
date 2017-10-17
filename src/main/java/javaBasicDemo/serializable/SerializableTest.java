package javaBasicDemo.serializable;

import java.io.*;

/**
 * @author JHMI on 2017/8/29. jdk1.8
 * 情景1：静态变量序列化
 * static 修饰的变量是类的变量
 * 序列化保存的是对象的状态，所以序列化不会保存静态变量
 *
 * 情景2：transient关键字的作用是控制变量不被序列化，在反序列化后，transient变量的值被设为初始值，String 默认为null int默认为0
 * 父类不实现serializable 父类中的变量也会被序列化(包括transient修饰的变量)
 * 父类实现serializable 父类中的transient变量不被序列化，非transient变量会被子类序列化
 *
 * 情景3：敏感数据加密
 * 定义私有的private void writeObject和private void readObject方法
 * 在Java序列化的时候，对敏感数据password进行加解密操作
 * 客户端将加密后的password序列化后传输给服务端
 * 服务端在反序列化后，使用公钥对password进行解密操作
 *
 * 情景4：序列化的存储规则
 * 序列化同一个对象时，第二次文件大小只增加5个字节，并且反序列化的两个对象==判断相同，是同一个对象。
 * 存储规则：当序列化第二个对象如果和第一个对象相同，则第二次只会存储该对象的引用，极大的节省了存储空间
 *
 * 情景5：单例模式如果可序列化
 * 使用单例模式时，通常希望这个对象是唯一的，但是如果该类是可序列化的，
 * 单例模式初始化的对象 和 反序列化生成的对象不一致，可以通过重写readResolve方法保证单例模式的特性
 */
public class SerializableTest  implements Serializable{

    private static long serialVersionUID = 1L;
    public static int X = 100;
    public String s = "序列化";
    static ObjectOutputStream out;
    static ObjectInputStream in;
    public static void main(String[] args) {
        String path = "C:/read.out";
        try {
            new SerializableTest().modify();
            out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(new SerializableTest());
            //序列化完成后修改静态变量的值
            SerializableTest.serialVersionUID = 2L;
            //执行反序列化
            in = new ObjectInputStream(new FileInputStream(path));
            SerializableTest test = (SerializableTest) in.readObject();
            test.output(test);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out != null ){
                    out.close();
                }
                if(in !=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public  void modify(){
        X = 200;
        s = "反序列化";
    }

    public void output(SerializableTest test){
        System.out.println(test.X);
        System.out.println(test.s);
    }
    //-----------------------------情景2---------------------
    /*public static void main(String[] args) {
        String path = "C:/read.out";
        try {
            new SerializableTest().modify();
            out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(new SerializableTestSon());

            in = new ObjectInputStream(new FileInputStream(path));
            SerializableTestSon test = (SerializableTestSon) in.readObject();
            System.out.println("父类整形变量:"+test.anInt);
            System.out.println("父类字符串类型变量:"+test.attr);
            System.out.println("sonlei="+test.attrSon);
            System.out.println("tranzent="+test.intSon);
            System.out.println("not transint="+test.i);
            System.out.println("not transint="+test.ar);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out != null ){
                    out.close();
                }
                if(in !=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
    //------------------------情景3------------------------
    /*private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private void writeObject(ObjectOutputStream out){
        try {
            ObjectOutputStream.PutField putField = out.putFields();
            password = "entry";
            System.out.println("加密后的密码="+password);
            putField.put("password",password);

            //向流中添加参数
            out.writeFields();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream in){
        try {
            ObjectInputStream.GetField getField = in.readFields();
            password = (String) getField.get("password",null);
            System.out.println("解密前="+password);
            //解密操作
            password= "pass";
            System.out.println("解密后="+password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String path = "C:/read.out";
        try {
            out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(new SerializableTest());

            in = new ObjectInputStream(new FileInputStream(path));
            SerializableTest test = (SerializableTest) in.readObject();
            System.out.println(test.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out != null ){
                    out.close();
                }
                if(in !=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
//------------------------情景4----------------------------------
    /*public static void main(String[] args) {
        String path = "C:/read.out";
        try {
            File file = new File(path);
            SerializableTest outTest = new SerializableTest();
            out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(outTest);
            System.out.println(file.length());

            out.writeObject(new SerializableTest());
            System.out.println(file.length());

            out.writeObject(outTest);
            System.out.println(file.length());

            in = new ObjectInputStream(new FileInputStream(path));
            SerializableTest test = (SerializableTest) in.readObject();
            SerializableTest test2 = (SerializableTest) in.readObject();
            SerializableTest test3 = (SerializableTest) in.readObject();
            System.out.println(test.equals(outTest) );
            System.out.println(test.equals(test3));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out != null ){
                    out.close();
                }
                if(in !=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
    //-----------------------------情景5单例模式----------------------
    /*public static void main(String[] args) {
        String path = "C:/read.out";
        try {
            File file = new File(path);
            Singleton outTest = Singleton.getSingleton();
            out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(outTest);

            SerializableTest.serialVersionUID = 2L;
            in = new ObjectInputStream(new FileInputStream(path));
            Singleton test = (Singleton) in.readObject();
            System.out.println(test.equals(outTest) );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out != null ){
                    out.close();
                }
                if(in !=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
}

class Singleton implements Serializable{
    private Singleton(){}
    private static final Singleton singleton = new Singleton();
    public static Singleton getSingleton(){
        return singleton;
    }

    /**
     * 进行反序列化时返回同一个对象
     * 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，
     * readResolve()方法都会被调用到。实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象，
     * 而被创建的对象则会被垃圾回收掉。
     * @return
     */
    private Object readResolve(){
        return singleton;
    }
}
