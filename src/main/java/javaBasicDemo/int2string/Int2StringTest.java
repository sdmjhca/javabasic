package javaBasicDemo.int2string;

/**
 * @author JHMI on 2017/9/13.
 */
public class Int2StringTest {
    public static void main(String[] args) {
        convert2String(999);
    }

    public static String convert2String(int aInt){
        int size = getIntSize(aInt);
        //首先确认整数是几位数
        char[] buf = new char[size];
        //然后分隔整数，往字符数组赋值
        for(int i = size;i > 0;i--){
            //定义一个数 取商
            int t = (int) (aInt/(Math.pow(10,i-1)));
            //定义一个数 取余
            int yu = (int) (aInt%(Math.pow(10,i-1)));
            aInt = yu;
            System.out.println(aInt);
            buf[size-i] = chars[t];
        }
        //再根据字符数组，进行初始化字符串
        String s = new String(buf);
        System.out.println("转换后的整数为"+s);
        Long l = new Long(4);
        l.toString();
        return s;
    }

    /**
     * 定义整形数组，用于判断输入的整数是几位数
     */
    public static int [] int_size = {9,99,999,9999,99999,999999,9999999,99999999,999999999,Integer.MAX_VALUE};

    /**
     * 定义字符数组，生成整数对应的字符
     */
    public static char[] chars = {'0','1','2','3','4','5','6','7','8','9'};

    /**
     * 获取 输入整数 的位数
     * @param aInt 请求整数
     * @return 位数
     */
    public static int getIntSize(int aInt){
        int aSize = 0;
        for(int i = 0;i < int_size.length;i++){
            if(aInt <= int_size[i]){
                return aSize+1;
            }
            aSize++;
        }
        return 0;
    }
}
