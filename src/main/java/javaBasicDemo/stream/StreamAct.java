package javaBasicDemo.stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author JHMI on 2020/4/27.
 */
public class StreamAct {
    public static void main(String[] args) {
        List<ActDto> a = new ArrayList<>();
        List<ActDto> b = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ActDto actDto = new ActDto();
            actDto.setCityCode("a" + i);
            actDto.setNum(i);
            a.add(actDto);
        }

        for (int i = 0; i < 12; i++) {
            ActDto actDto = new ActDto();
            if (i > 9) {
                actDto.setCityCode("b" + i);
            } else {
                if (i == 6) continue;
                actDto.setCityCode("a" + i);
            }

            actDto.setNum(i);
            b.add(actDto);
        }

        System.out.println(a.toString());
        System.out.println(b);

        combine2List(a, b);

        BigDecimal d = new BigDecimal("1.23");
        String s = d + "%";
        System.out.println(s);
    }

    public static void combine2List(List<ActDto> a, List<ActDto> b) {
        Map<String, Result> resultMap = new HashMap<>();

        Map<String,List<ActDto>> group = a.stream().collect(Collectors.groupingBy(ActDto::getCityCode));
        System.out.println(group.toString());
        a.stream().forEach(actDto -> {
            Result result = new Result();
            result.setaNum(actDto.getNum());
            result.setcNum(actDto.getNum());
            result.setCityCode(actDto.getCityCode());
            resultMap.put(actDto.getCityCode(), result);
        });
        b.stream().forEach(actDto -> {
            Result result = resultMap.get(actDto.getCityCode());
            if (result == null) {
                result = new Result();
            }
            result.setbNum(actDto.getNum());
            result.setcNum(result.getaNum() + result.getbNum());
            result.setCityCode(actDto.getCityCode());
            resultMap.put(actDto.getCityCode(), result);
        });
        System.out.println(resultMap.toString());
        List<Result> list = resultMap.values().stream()
//                .sorted((r1, r2) -> Integer.compare(r1.getcNum(), r2.getcNum()))
                .sorted(Comparator.comparingInt(Result::getcNum).reversed())
                .collect(Collectors.toList());
        System.out.println(list.toString());
    }
}
