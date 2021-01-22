package javaBasicDemo.reflect;

import javaBasicDemo.jackson.TradeStatusEnum;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author JHMI on 2020/5/18.
 */
public class ReflectTest {
    public static void main(String[] args) {
        TradeStatusEnum tradeStatusEnum = TradeStatusEnum.TRADE_SUCC;
        ClassWrapper classWrapper = new ClassWrapper(tradeStatusEnum.getClass());
        List<Field> fields = classWrapper.getFieldList();
        System.out.println(fields);
        for(Field field : fields){
            try {
                field.setAccessible(true);
                if(field.getType().equals(TradeStatusEnum.class)){
                    TradeStatusEnum tradeStatusEnum1 = (TradeStatusEnum) field.get("");
                    Annotation annotation = field.getAnnotation(Deprecated.class);
                    if(annotation != null){
                        System.out.println(field.getName()+"--"+tradeStatusEnum1.getCode());
                    }
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
}
