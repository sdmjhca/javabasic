package javaBasicDemo;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author JHMI on 2018/5/16.
 */
public class test {
    public static void main(String[] args) {
        String aa="s@@@#◆◆◆  $d ad中国,.ss，.。；;";
        double countCn = 0;
        char[] charArray = aa.toCharArray();
        for (char c : charArray) {

            int cnorEn = isCnorEn(c);
            System.out.println(c+":"+cnorEn);
            countCn += cnorEn;
        }
        System.out.println(countCn);
        System.out.println(charArray.length);
        double i = countCn/charArray.length;
        System.out.println(i);

        System.out.println("------------------------");
        System.out.println(isContainChinese("chingese。我查"));

        List list = null;
        System.out.println(list.isEmpty());
    }
    static int isCnorEn(char c){
        if(c >= 0x0391 && c <= 0xFFE5) //中文字符
            return 1;
        if(c>=0x0000 && c<=0x00FF){ //英文字符
            return 0;
        }
        return 3;
    }

    public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
