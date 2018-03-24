package com.example.telegrambot.binance;

import com.example.telegrambot.binance.domain.event.AggTradeEvent;
import com.example.telegrambot.binance.domain.event.CandlestickEvent;
import com.example.telegrambot.binance.domain.event.DepthEvent;
import com.example.telegrambot.binance.domain.event.UserDataUpdateEvent;
import com.example.telegrambot.binance.domain.market.Candlestick;
import com.example.telegrambot.binance.domain.market.CandlestickInterval;

/**
 * Binance API data streaming façade, supporting streaming of events through web sockets.
 */
public interface BinanceApiWebSocketClient {

  void onDepthEvent(String symbol, BinanceApiCallback<DepthEvent> callback);

  void onCandlestickEvent(String symbol, CandlestickInterval interval, BinanceApiCallback<CandlestickEvent> callback);

  void onAggTradeEvent(String symbol, BinanceApiCallback<AggTradeEvent> callback);

  void onUserDataUpdateEvent(String listenKey, BinanceApiCallback<UserDataUpdateEvent> callback);
}
