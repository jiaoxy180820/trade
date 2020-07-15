package com.trade.service;

import com.trade.entity.Transactions;
import com.trade.entity.enums.ActionEnum;
import com.trade.entity.enums.TradeEnum;
import org.apache.http.util.Asserts;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: JiaoXiaoying
 * @Date: 2020/7/14
 */
public class TradeTest {

    Set<Transactions> param=null;

    @Before
    public void inputData() {
        param=new HashSet<>();
        Transactions transactions=new Transactions();
        transactions.setTransactionID(1);
        transactions.setTradeID(1);
        transactions.setVersion(1);
        transactions.setSecurityCode("REL");
        transactions.setQuantity(50);
        transactions.setAction(ActionEnum.INSERT);
        transactions.setTradeCode(TradeEnum.BUY);
        param.add(transactions);
        transactions=new Transactions();
        transactions.setTransactionID(2);
        transactions.setTradeID(2);
        transactions.setVersion(1);
        transactions.setSecurityCode("ITC");
        transactions.setQuantity(40);
        transactions.setAction(ActionEnum.INSERT);
        transactions.setTradeCode(TradeEnum.SELL);
        param.add(transactions);
        transactions=new Transactions();
        transactions.setTransactionID(3);
        transactions.setTradeID(3);
        transactions.setVersion(1);
        transactions.setSecurityCode("INF");
        transactions.setQuantity(70);
        transactions.setAction(ActionEnum.INSERT);
        transactions.setTradeCode(TradeEnum.BUY);
        param.add(transactions);
        transactions=new Transactions();
        transactions.setTransactionID(4);
        transactions.setTradeID(1);
        transactions.setVersion(2);
        transactions.setSecurityCode("REL");
        transactions.setQuantity(60);
        transactions.setAction(ActionEnum.UPDATE);
        transactions.setTradeCode(TradeEnum.BUY);
        param.add(transactions);
        transactions=new Transactions();
        transactions.setTransactionID(5);
        transactions.setTradeID(2);
        transactions.setVersion(2);
        transactions.setSecurityCode("ITC");
        transactions.setQuantity(30);
        transactions.setAction(ActionEnum.CANCEL);
        transactions.setTradeCode(TradeEnum.BUY);
        param.add(transactions);
        transactions=new Transactions();
        transactions.setTransactionID(6);
        transactions.setTradeID(4);
        transactions.setVersion(1);
        transactions.setSecurityCode("INF");
        transactions.setQuantity(20);
        transactions.setAction(ActionEnum.INSERT);
        transactions.setTradeCode(TradeEnum.SELL);
        param.add(transactions);
    }

    @Test
    public void getPosition() {

        Trade trade=new Trade();
        Map<String, String> resultMap =trade.getPosition(param);

        for(String key:resultMap.keySet()){
            System.out.println(key+":"+resultMap.get(key));
        }
    }
}
