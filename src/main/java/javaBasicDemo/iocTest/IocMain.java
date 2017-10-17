package javaBasicDemo.iocTest;

/**
 * @author JHMI on 2017/8/25.
 */
public class IocMain {
    private IOCtest ioCtest;

    /**
     * 依赖注入的两种方式：
     * 1、构造函数
     * @param ioCtest
     */
    public IocMain(IOCtest ioCtest) {
        this.ioCtest = ioCtest;
    }

    /**
     * 2、setter方法
     * @param ioCtest
     */
    public void setIoCtest(IOCtest ioCtest) {
        this.ioCtest = ioCtest;
    }
}
