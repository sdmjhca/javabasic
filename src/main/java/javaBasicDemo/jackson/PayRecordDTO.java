package javaBasicDemo.jackson;

/**
 * @author JHMI on 2019/6/24.
 */
public class PayRecordDTO {
    private String serialNo;
    private String orderNo;
    private Integer tradeStatus;

    private TradeStatusEnum tradeStatusEnum;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(Integer tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public TradeStatusEnum getTradeStatusEnum() {
        return tradeStatusEnum;
    }

    public void setTradeStatusEnum(TradeStatusEnum tradeStatusEnum) {
        this.tradeStatusEnum = tradeStatusEnum;
    }
}
