package com.trade.entity;

import com.trade.entity.enums.ActionEnum;
import com.trade.entity.enums.TradeEnum;

/**
 * @Description:
 * @Author: JiaoXiaoying
 * @Date: 2020/7/14
 */
public class Transactions {

    private Integer transactionID;

    private Integer tradeID;

    private Integer version;

    private String securityCode;

    private Integer quantity;

    private ActionEnum action;

    private TradeEnum tradeCode;

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public Integer getTradeID() {
        return tradeID;
    }

    public void setTradeID(Integer tradeID) {
        this.tradeID = tradeID;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }

    public TradeEnum getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(TradeEnum tradeCode) {
        this.tradeCode = tradeCode;
    }


}
