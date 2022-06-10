package com.services;

public interface CurrencyService {
    Double getCurrentCurrencyRate(String code);

    Double getYesterdayCurrencyRate(String code);

    String checkRatesAndGetGiphyLink(String code);
}
