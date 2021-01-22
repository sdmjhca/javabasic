package javaBasicDemo.localdate;

import com.google.gson.JsonObject;
import org.apache.commons.lang.StringUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author JHMI on 2020/7/17.
 */
public class LocalTest {

    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String time = "2020-07-01 15:40:21";

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime offTime = LocalDateTime.parse(time,dateTimeFormatter);
        System.out.println(offTime);
        Duration duration = Duration.between(offTime,now);
        long seconds = duration.getSeconds();
        String wifiOffline = getTimeDiff(seconds);
        System.out.println(wifiOffline);

        List<String> list = new ArrayList<>();
        list.add("2020-07-24 10:00:01");
        list.add("2020-07-23 10:00:01");
        list.add("");
        Collections.sort(list);
        System.out.println(list);

        System.out.println(getMinTime("",""));

        String a = new String("b");
        String b = "b";
        System.out.println(a == b);

        String white = "1,2,181,185,183";
        System.out.println(white.contains("188"));

        String s = null;
        s = "";
        System.out.println(s.hashCode());
        s="1,2123123123123123,444444444121241";
        System.out.println(s.hashCode());
        System.out.println(String.valueOf(s.hashCode()>>2));
        System.out.println(String.valueOf(s.hashCode()%2));
    }
    public static String getTimeDiff(long durations) {
        StringBuilder sb = new StringBuilder();
        int[] units = {86400, 3600, 60, 1};
        String[] devided = {"天", "小时", "分", "秒"};
        for (int i = 0; i < units.length; i++) {
            if (durations >= units[i]) {
                sb.append(durations / (units[i]));
                sb.append(devided[i]);
                durations = durations % (units[i]);
            }
        }
        return sb.toString();
    }

    public static String getMinTime(String time1,String time2){
        String minTime = "";
        LocalDateTime localDateTime1 = null;
        LocalDateTime localDateTime2 = null;
        if(StringUtils.isBlank(time1) && StringUtils.isBlank(time2)){
            return minTime;
        }
        if(StringUtils.isBlank(time1)){
            localDateTime1 = LocalDateTime.MAX;
        }else{
            localDateTime1 = LocalDateTime.parse(time1,dateTimeFormatter);
        }
        if(StringUtils.isBlank(time2)){
            localDateTime2 = LocalDateTime.MAX;
        }else {
            localDateTime2 = LocalDateTime.parse(time2,dateTimeFormatter);
        }
        Duration duration = Duration.between(localDateTime1,localDateTime2);
        if(duration.isNegative()){
            minTime = time2;
        }else{
            minTime = time1;
        }

        return minTime;
    }
}
