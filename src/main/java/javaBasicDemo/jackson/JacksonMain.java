package javaBasicDemo.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JHMI on 2019/6/24.
 */
public class JacksonMain {
    public static void main(String[] args) {
        PayRecordDTO payRecordDTO = new PayRecordDTO();
        payRecordDTO.setOrderNo("123");
        payRecordDTO.setSerialNo("333");
        payRecordDTO.setTradeStatus(10);
        payRecordDTO.setTradeStatusEnum(TradeStatusEnum.TRADE_SUCC);
        List list = new ArrayList();
        list.add(payRecordDTO);

        PayRecordDTO newP = new PayRecordDTO();
        newP.setOrderNo("11111123");
        newP.setSerialNo("33333333");
        newP.setTradeStatus(10);
        newP.setTradeStatusEnum(TradeStatusEnum.TRADE_FAIL);
        list.add(newP);
        try {
            String s = new ObjectMapper().writeValueAsString(list);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("A846A0041F1546273044".substring(0,10));;

        Object o = "3";
        String s = new String("3");
        System.out.println(s.equals(3));
        System.out.println(RandomStringUtils.randomAlphanumeric(32).toLowerCase());
        String ss = "$E6,E61900S10001,15,0,19,2019-07-24 15:24:54\r";

        List list1 = Arrays.asList("sign","as");
        System.out.println(list1);
        System.out.println(ss.replaceAll("\r|\n",""));
        System.out.println("111");
    }
}
