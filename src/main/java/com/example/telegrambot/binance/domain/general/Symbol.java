package com.example.telegrambot.binance.domain.general;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

public class Symbol {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("baseAsset")
    @Expose
    private String baseAsset;
    @SerializedName("baseAssetPrecision")
    @Expose
    private Integer baseAssetPrecision;
    @SerializedName("quoteAsset")
    @Expose
    private String quoteAsset;
    @SerializedName("quotePrecision")
    @Expose
    private Integer quotePrecision;
    @SerializedName("orderTypes")
    @Expose
    private List<String> orderTypes = null;
    @SerializedName("icebergAllowed")
    @Expose
    private Boolean icebergAllowed;
    @SerializedName("filters")
    @Expose
    private List<Filter> filters = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Symbol() {
    }

    /**
     *
     * @param quoteAsset
     * @param icebergAllowed
     * @param baseAsset
     * @param symbol
     * @param status
     * @param quotePrecision
     * @param baseAssetPrecision
     * @param orderTypes
     * @param filters
     */
    public Symbol(String symbol, String status, String baseAsset, Integer baseAssetPrecision, String quoteAsset, Integer quotePrecision, List<String> orderTypes, Boolean icebergAllowed, List<Filter> filters) {
        super();
        this.symbol = symbol;
        this.status = status;
        this.baseAsset = baseAsset;
        this.baseAssetPrecision = baseAssetPrecision;
        this.quoteAsset = quoteAsset;
        this.quotePrecision = quotePrecision;
        this.orderTypes = orderTypes;
        this.icebergAllowed = icebergAllowed;
        this.filters = filters;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public Integer getBaseAssetPrecision() {
        return baseAssetPrecision;
    }

    public void setBaseAssetPrecision(Integer baseAssetPrecision) {
        this.baseAssetPrecision = baseAssetPrecision;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public Integer getQuotePrecision() {
        return quotePrecision;
    }

    public void setQuotePrecision(Integer quotePrecision) {
        this.quotePrecision = quotePrecision;
    }

    public List<String> getOrderTypes() {
        return orderTypes;
    }

    public void setOrderTypes(List<String> orderTypes) {
        this.orderTypes = orderTypes;
    }

    public Boolean getIcebergAllowed() {
        return icebergAllowed;
    }

    public void setIcebergAllowed(Boolean icebergAllowed) {
        this.icebergAllowed = icebergAllowed;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("symbol", symbol).append("status", status).append("baseAsset", baseAsset).append("baseAssetPrecision", baseAssetPrecision).append("quoteAsset", quoteAsset).append("quotePrecision", quotePrecision).append("orderTypes", orderTypes).append("icebergAllowed", icebergAllowed).append("filters", filters).toString();
    }
}
