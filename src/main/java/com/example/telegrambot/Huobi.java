package com.example.telegrambot;

import com.example.telegrambot.huobi.api.ApiClient;
import com.example.telegrambot.huobi.api.ApiException;
import com.example.telegrambot.huobi.response.Symbol;

import java.util.List;

public class Huobi {

    static final String API_KEY = "7275e652-b7a266b6-5a0cf25c-0d56d";
    static final String API_SECRET = "cd2184be-4f657455-391b70d9-6e22a";

    ApiClient client = new ApiClient(API_KEY, API_SECRET);

    List<Symbol> symbolList = client.getSymbols();

    List<Symbol> getSymbolListHuobi() {
        return symbolList;
    }

}
