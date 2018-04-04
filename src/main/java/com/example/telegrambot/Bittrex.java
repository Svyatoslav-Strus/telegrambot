package com.example.telegrambot;

import com.github.ccob.bittrex4j.BittrexExchange;
import com.github.ccob.bittrex4j.dao.Market;
import com.github.ccob.bittrex4j.dao.Response;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class Bittrex {

    public Response<Market[]> getSymbolListBittrex()  {
        BittrexExchange bittrexExchange = null;
        try {
            bittrexExchange = new BittrexExchange();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bittrexExchange.getMarkets();
    }

    Set<String> getSymbolSetBittrex() {
        Set<String> symbolSet = new LinkedHashSet<>();

        for (Market m : getSymbolListBittrex().getResult()) {
            symbolSet.add(m.getMarketCurrency());
        }

        return symbolSet;
    }

}