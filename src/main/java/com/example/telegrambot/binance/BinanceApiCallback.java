package com.example.telegrambot.binance;

import com.example.telegrambot.binance.exception.BinanceApiException;

/**
 * BinanceApiCallback is a functional interface used together with the BinanceApiAsyncClient to provide a non-blocking REST binance.
 *
 * @param <T> the return type from the callback
 */
public interface BinanceApiCallback<T> {

    /**
     * Called whenever a response comes back from the Binance API.
     *
     * @param response the expected response object
     * @throws BinanceApiException if it is not possible to obtain the expected response object (e.g. incorrect API-KEY).
     */
    void onResponse(T response) throws BinanceApiException;
}