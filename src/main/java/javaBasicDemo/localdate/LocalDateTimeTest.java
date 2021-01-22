package javaBasicDemo.localdate;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;

/**
 * @author JHMI on 2020/6/9.
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(localDateTime.format(dateTimeFormatter));
        String time = localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(time);
        String tim = localDateTime.format(DateTimeFormatter.ISO_DATE);
        System.out.println(tim);
        String now = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(now);
        localDateTime = localDateTime.plusWeeks(1L);
        System.out.println(localDateTime);
        localDateTime = localDateTime.plus(1L, ChronoUnit.YEARS);
        System.out.println(localDateTime);
        System.out.println(localDateTime.toString());

        LocalDate localDate = LocalDate.of(1970,1,1);
        System.out.println(localDate.toString());

        int i = 0x00008000;
        System.out.println((i>>14)|0x01);

        LocalDateTime as = LocalDateTime.now();
        LocalDateTime yest = as.minusDays(1L);
        ZonedDateTime zoneOffset = yest.atZone(ZoneOffset.systemDefault());
        Date yes = Date.from(zoneOffset.toInstant());

        BigDecimal bigDecimal = new BigDecimal("123111231.11");
        DecimalFormat df = new DecimalFormat("￥##,##0.00");
        System.out.println(df.format(bigDecimal));
        System.out.println(df.format(bigDecimal).replaceAll(",","\\,"));

        String s = null;
        System.out.println("123_"+s);
        List list = new ArrayList();
        list.add(null);
        list.add(null);
        list.add(1);
        System.out.println(list.toString());
        list.clear();
        System.out.println(list.toString());
        System.out.println(list.size());
        Set set = new HashSet();
        set.add(null);
        System.out.println(set.toString());
    }
}
