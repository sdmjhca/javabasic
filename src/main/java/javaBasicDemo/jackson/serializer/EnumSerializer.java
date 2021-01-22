package javaBasicDemo.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import javaBasicDemo.jackson.IEnum;

import java.io.IOException;

/**
 * @author JHMI on 2019/6/25.
 */
public class EnumSerializer extends StdSerializer<IEnum> {
    public EnumSerializer(){
        this(null);
    }

    public EnumSerializer(Class<IEnum> t) {
        super(t);
    }

    @Override
    public void serialize(IEnum value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        String name = value.getClass().getSimpleName();
        gen.writeString(value.getCode("")+"");
        //gen.writeStringField(name + "desc",value.getDesc()+"");
        //gen.writeEndObject();
    }
}
