package javaBasicDemo.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import javaBasicDemo.jackson.PayRecordDTO;

import java.io.IOException;

/**
 * @author JHMI on 2019/6/24.
 */
public class PayRecordSerializer extends StdSerializer<PayRecordDTO> {

    protected PayRecordSerializer(Class<PayRecordDTO> t) {
        super(t);
    }

    public PayRecordSerializer(){
        this(null);
    }

    @Override
    public void serialize(PayRecordDTO payRecordDTO, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("serialNo",payRecordDTO.getSerialNo());
        jsonGenerator.writeStringField("orderNo",payRecordDTO.getOrderNo());
        jsonGenerator.writeNumberField("trade_status",payRecordDTO.getTradeStatus());
        //jsonGenerator.writeStringField("trade_status_desc",payRecordDTO.getTradeStatusEnum().getTradeMsg(payRecordDTO.getTradeStatus()));
        jsonGenerator.writeEndObject();
    }
}
