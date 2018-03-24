package com.example.telegrambot.binance.domain.general;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ExchangeInfo {
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("serverTime")
    @Expose
    private Long serverTime;
    @SerializedName("rateLimits")
    @Expose
    private List<RateLimit> rateLimits = null;
    @SerializedName("exchangeFilters")
    @Expose
    private List<Object> exchangeFilters = null;
    @SerializedName("symbols")
    @Expose
    private List<Symbol> symbols = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ExchangeInfo() {
    }

    /**
     * @param timezone
     * @param serverTime
     * @param rateLimits
     * @param exchangeFilters
     * @param symbols
     */
    public ExchangeInfo(String timezone, Long serverTime, List<RateLimit> rateLimits, List<Object> exchangeFilters, List<Symbol> symbols) {
        super();
        this.timezone = timezone;
        this.serverTime = serverTime;
        this.rateLimits = rateLimits;
        this.exchangeFilters = exchangeFilters;
        this.symbols = symbols;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Long getServerTime() {
        return serverTime;
    }

    public void setServerTime(Long serverTime) {
        this.serverTime = serverTime;
    }

    public List<RateLimit> getRateLimits() {
        return rateLimits;
    }

    public void setRateLimits(List<RateLimit> rateLimits) {
        this.rateLimits = rateLimits;
    }

    public List<Object> getExchangeFilters() {
        return exchangeFilters;
    }

    public void setExchangeFilters(List<Object> exchangeFilters) {
        this.exchangeFilters = exchangeFilters;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("timezone", timezone).append("serverTime", serverTime).append("rateLimits", rateLimits).append("exchangeFilters", exchangeFilters).append("symbols", symbols).toString();
    }

}
