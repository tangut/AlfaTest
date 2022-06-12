package com.services;

public interface CurrencyService {
    Double getCurrentCurrencyRate();

    Double getHistoricalCurrencyRate(String date);
}
