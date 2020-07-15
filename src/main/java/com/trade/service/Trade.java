package com.trade.service;

import com.trade.entity.Transactions;
import com.trade.entity.enums.ActionEnum;
import com.trade.entity.enums.TradeEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: JiaoXiaoying
 * @Date: 2020/7/14
 */
public class Trade {

    public Map<String, String> getPosition(Set<Transactions> param) {
        Map<String, String> resultMap = new HashMap<>(10);
        StringBuilder quantity = null;
        //code,action
        Map<String, ActionEnum> conMap = new HashMap<>(10);
        for (Transactions transactions : param) {
            quantity = new StringBuilder();
            if (TradeEnum.BUY.equals(transactions.getTradeCode())) {
                quantity.append("+").append(transactions.getQuantity());
            } else {
                quantity.append("-").append(transactions.getQuantity());
            }

            if (resultMap.containsKey(transactions.getSecurityCode())) {
                if(!ActionEnum.INSERT.equals(conMap.get(transactions.getSecurityCode()))){
                    continue;
                }
                switch (transactions.getAction()) {
                    default:
                        resultMap.put(transactions.getSecurityCode(), "0");
                        break;
                    case UPDATE:
                        resultMap.put(transactions.getSecurityCode(), quantity.toString());
                        break;
                    case INSERT:
                        int newQuantity = Integer.parseInt(resultMap.get(transactions.getSecurityCode())) +
                                Integer.parseInt(quantity.toString());
                        StringBuilder sb = new StringBuilder();
                        if (newQuantity > 0) {
                            sb.append("+").append(newQuantity);
                        } else {
                            sb.append(newQuantity);
                        }
                        resultMap.put(transactions.getSecurityCode(), sb.toString());
                        break;
                }
            } else {
                conMap.put(transactions.getSecurityCode(), transactions.getAction());
                switch (transactions.getAction()) {
                    default:
                        resultMap.put(transactions.getSecurityCode(), quantity.toString());
                        break;
                    case CANCEL:
                        resultMap.put(transactions.getSecurityCode(), "0");
                        break;
                }
            }
        }

        return resultMap;
    }
}
