package com.example.telegrambot.binance.domain.general;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RateLimit {
    @SerializedName("rateLimitType")
    @Expose
    private String rateLimitType;
    @SerializedName("interval")
    @Expose
    private String interval;
    @SerializedName("limit")
    @Expose
    private Integer limit;

    /**
     * No args constructor for use in serialization
     *
     */
    public RateLimit() {
    }

    /**
     *
     * @param limit
     * @param interval
     * @param rateLimitType
     */
    public RateLimit(String rateLimitType, String interval, Integer limit) {
        super();
        this.rateLimitType = rateLimitType;
        this.interval = interval;
        this.limit = limit;
    }

    public String getRateLimitType() {
        return rateLimitType;
    }

    public void setRateLimitType(String rateLimitType) {
        this.rateLimitType = rateLimitType;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("rateLimitType", rateLimitType).append("interval", interval).append("limit", limit).toString();
    }
}
