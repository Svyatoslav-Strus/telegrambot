package com.example.telegrambot.binance.impl;

import com.example.telegrambot.binance.BinanceApiCallback;
import com.example.telegrambot.binance.exception.BinanceApiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.io.IOException;

/**
 * Binance API WebSocket listener.
 */
public class BinanceApiWebSocketListener<T> extends WebSocketListener {

  private BinanceApiCallback<T> callback;

  private Class<T> eventClass;

  public BinanceApiWebSocketListener(BinanceApiCallback<T> callback, Class<T> eventClass) {
    this.callback = callback;
    this.eventClass = eventClass;
  }

  @Override
  public void onMessage(WebSocket webSocket, String text) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      T event = mapper.readValue(text, eventClass);
      callback.onResponse(event);
    } catch (IOException e) {
      throw new BinanceApiException(e);
    }
  }

  @Override
  public void onFailure(WebSocket webSocket, Throwable t, Response response) {
    throw new BinanceApiException(t);
  }
}