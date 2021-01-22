package javaBasicDemo.jackson;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javaBasicDemo.jackson.serializer.EnumSerializer;

/**
 * @author JHMI on 2019/6/24.
 */
@JsonSerialize(using = EnumSerializer.class)
public enum  TradeStatusEnum implements IEnum<Integer,String>{
    @Deprecated
    TRADE_SUCC(10,"交易成功"),
    TRADE_FAIL(11,"交易失败");

    TradeStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    TradeStatusEnum(int code) {
        this.code = code;
    }

    private int code;
    private String desc;

    public void setCode(int code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public Integer getCode(Integer code) {
        return code;
    }

    @Override
    public String getDesc(Integer code) {
        for(TradeStatusEnum tradeStatus : TradeStatusEnum.values()){
            if(tradeStatus.code == code){
                return tradeStatus.getDesc();
            }
        }
        return "";
    }
}
