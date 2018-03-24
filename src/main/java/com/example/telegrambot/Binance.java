package com.example.telegrambot;


import com.example.telegrambot.binance.BinanceApiClientFactory;
import com.example.telegrambot.binance.BinanceApiRestClient;
import com.example.telegrambot.binance.domain.general.Symbol;

import java.util.List;

class Binance{

    BinanceApiClientFactory factory = BinanceApiClientFactory
                                            .newInstance("vPrut3KCzdLqcqcCSIDXQLxzpNGIqkH3WsOE7R13d2hQxdsgZMKXsRvuiKZu7G3a",
                                                    "pHFGvwGwA0EPoTB2ZrwjXKLmA07PH3ezAhWuq3vxDbqyGDbwa46eFWI31LEoXei9");
    BinanceApiRestClient client = factory.newRestClient();

    List<Symbol> symbolList = client.getExchangeInfo().getSymbols();

    List<Symbol> getSymbolListBinance() {
        return symbolList;
    }
}
