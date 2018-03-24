package com.example.telegrambot.binance.impl;

import com.example.telegrambot.binance.BinanceApiCallback;
import com.example.telegrambot.binance.BinanceApiWebSocketClient;
import com.example.telegrambot.binance.constant.BinanceApiConstants;
import com.example.telegrambot.binance.domain.event.AggTradeEvent;
import com.example.telegrambot.binance.domain.event.CandlestickEvent;
import com.example.telegrambot.binance.domain.event.DepthEvent;
import com.example.telegrambot.binance.domain.event.UserDataUpdateEvent;
import com.example.telegrambot.binance.domain.market.CandlestickInterval;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.Closeable;
import java.io.IOException;

/**
 * Binance API WebSocket binance implementation using OkHttp.
 */
public class BinanceApiWebSocketClientImpl implements BinanceApiWebSocketClient, Closeable {

  private OkHttpClient client;

  public BinanceApiWebSocketClientImpl() {
    this.client = new OkHttpClient();
  }

  public void onDepthEvent(String symbol, BinanceApiCallback<DepthEvent> callback) {
    final String channel = String.format("%s@depth", symbol);
    createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, DepthEvent.class));
  }

  @Override
  public void onCandlestickEvent(String symbol, CandlestickInterval interval, BinanceApiCallback<CandlestickEvent> callback) {
    final String channel = String.format("%s@kline_%s", symbol, interval.getIntervalId());
    createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, CandlestickEvent.class));
  }

  public void onAggTradeEvent(String symbol, BinanceApiCallback<AggTradeEvent> callback) {
    final String channel = String.format("%s@aggTrade", symbol);
    createNewWebSocket(channel, new BinanceApiWebSocketListener<>(callback, AggTradeEvent.class));
  }

  public void onUserDataUpdateEvent(String listenKey, BinanceApiCallback<UserDataUpdateEvent> callback) {
    createNewWebSocket(listenKey, new BinanceApiWebSocketListener<>(callback, UserDataUpdateEvent.class));
  }

  private void createNewWebSocket(String channel, BinanceApiWebSocketListener<?> listener) {
    String streamingUrl = String.format("%s/%s", BinanceApiConstants.WS_API_BASE_URL, channel);
    Request request = new Request.Builder().url(streamingUrl).build();
    client.newWebSocket(request, listener);
  }

  @Override
  public void close() throws IOException {
    client.dispatcher().executorService().shutdown();
  }
}
