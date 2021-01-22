package javaBasicDemo.weiyi;

import org.apache.commons.lang.math.NumberUtils;

/**
 * @author JHMI on 2017/8/23.
 */
public class LogicOperatorTest {
    public static void main(String[] args) {
        //左移位 n<<m标识 n*2^m
        int i = 3 <<3;
        System.out.println(i);
        //右移 n >> m = n/(2^m)
        int n  = 16 >> 4;
        System.out.println(n);
        //^异或运算符 1 1 = 0；0 0 =0；else = 1
        //2 0010
        //3 0011
        //j 0001=1
        int j = 2^3;
        System.out.println(j);
        //& 与运算符 1 0 = 0；0 0 =0；0 1 = 0; 1 1 =1;
        //2  0010
        //3  0011
        //yu 0010=2
        int yu = 2 & 3;
        System.out.println(yu);
        //| 或运算符 1 0 = 1；0 0 =0；0 1 = 1; 1 1 =1;
        //2  0010
        //3  0011
        //huo 0011=3
        int huo = 2 | 3;
        System.out.println(huo);
        //~ 非运算符 一元操作 ，1 =0；0=1
        //2  0010
        //huo 1101 反码 0010 补码0011
        //负数计算10进制 反码 在个位加1 取补码就是10进制
        //5   0000 0101
        //huo -    0110
        //11   0000 1011
        //huo -0000 1100 12
        int fei = ~-11;
        System.out.println(fei);
        /**
         * ~非操作符的计算结果 ~n = -（n+1）
         */

        String value="";
        //boolean uselessBool=(value=httpReq.getParameter("param1"))!=null||(value=httpReq.getParameter("param2"))!=null||(value=httpReq.getParameter("param3"))!=null;

        for(int jj =1;jj<16;jj++){

            System.out.println("-------"+ (String.valueOf(jj).hashCode() >>> 16));
            System.out.println("====="+(String.valueOf(jj).hashCode() % 16));
        }

        int mi = (int) (NumberUtils.toLong("18518983654") % 3);
        System.out.println(mi);

        System.out.println("test="+(~1));
        System.out.println("test="+(~0));
    }
}
