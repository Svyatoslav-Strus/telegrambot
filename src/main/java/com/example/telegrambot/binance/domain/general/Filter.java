package com.example.telegrambot.binance.domain.general;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Filter {
    @SerializedName("filterType")
    @Expose
    private String filterType;
    @SerializedName("minPrice")
    @Expose
    private String minPrice;
    @SerializedName("maxPrice")
    @Expose
    private String maxPrice;
    @SerializedName("tickSize")
    @Expose
    private String tickSize;
    @SerializedName("minQty")
    @Expose
    private String minQty;
    @SerializedName("maxQty")
    @Expose
    private String maxQty;
    @SerializedName("stepSize")
    @Expose
    private String stepSize;
    @SerializedName("minNotional")
    @Expose
    private String minNotional;

    /**
     * No args constructor for use in serialization
     *
     */
    public Filter() {
    }

    /**
     *
     * @param maxQty
     * @param stepSize
     * @param minQty
     * @param minNotional
     * @param maxPrice
     * @param filterType
     * @param tickSize
     * @param minPrice
     */
    public Filter(String filterType, String minPrice, String maxPrice, String tickSize, String minQty, String maxQty, String stepSize, String minNotional) {
        super();
        this.filterType = filterType;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.tickSize = tickSize;
        this.minQty = minQty;
        this.maxQty = maxQty;
        this.stepSize = stepSize;
        this.minNotional = minNotional;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getTickSize() {
        return tickSize;
    }

    public void setTickSize(String tickSize) {
        this.tickSize = tickSize;
    }

    public String getMinQty() {
        return minQty;
    }

    public void setMinQty(String minQty) {
        this.minQty = minQty;
    }

    public String getMaxQty() {
        return maxQty;
    }

    public void setMaxQty(String maxQty) {
        this.maxQty = maxQty;
    }

    public String getStepSize() {
        return stepSize;
    }

    public void setStepSize(String stepSize) {
        this.stepSize = stepSize;
    }

    public String getMinNotional() {
        return minNotional;
    }

    public void setMinNotional(String minNotional) {
        this.minNotional = minNotional;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("filterType", filterType).append("minPrice", minPrice).append("maxPrice", maxPrice).append("tickSize", tickSize).append("minQty", minQty).append("maxQty", maxQty).append("stepSize", stepSize).append("minNotional", minNotional).toString();
    }
}
